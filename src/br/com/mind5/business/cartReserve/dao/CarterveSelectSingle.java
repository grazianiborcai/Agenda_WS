package br.com.mind5.business.cartReserve.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinColumn;
import br.com.mind5.dao.DaoJoinType;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.common.DaoOptionValue;

public final class CarterveSelectSingle implements DaoStmt<CarterveInfo> {
	private final String LT_CART_ITM = DaoDbTable.CART_ITM_TABLE;	
	private final String RT_CART_HDR = DaoDbTable.CART_HDR_TABLE;
	
	private DaoStmt<CarterveInfo> stmtSql;
	private DaoStmtOption<CarterveInfo> stmtOption;
	
	
	
	public CarterveSelectSingle(Connection conn, CarterveInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, CarterveInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_CART_ITM;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.CART_RESERVE_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new CarterveWhere(whereOption, DaoDbTable.CART_RESERVE_VIEW, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();		
		joins.add(buildJoinCartItm());
		return joins;
	}
	
	
	
	private DaoJoin buildJoinCartItm() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_CART_ITM;
		oneColumn.leftColumnName = CarterveDbTableColumn.COL_COD_OWNER;
		oneColumn.rightColumnName = CarterveDbTableColumn.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_CART_ITM;
		oneColumn.leftColumnName = CarterveDbTableColumn.COL_COD_USER;
		oneColumn.rightColumnName = CarterveDbTableColumn.COL_COD_USER;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_CART_HDR;
		join.joinType = DaoJoinType.INNER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
	}
	
	

	@Override public void generateStmt() throws SQLException {
		stmtSql.generateStmt();		
	}

	
	
	@Override public boolean checkStmtGeneration() {
		return stmtSql.checkStmtGeneration();
	}

	
	
	@Override public void executeStmt() throws SQLException {
		stmtSql.executeStmt();
	}

	
	
	@Override public List<CarterveInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<CarterveInfo> getNewInstance() {
		return new CarterveSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<CarterveInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<CarterveInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<CarterveInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				CarterveInfo dataInfo = new CarterveInfo();
				dataInfo.codOwner = stmtResult.getLong(CarterveDbTableColumn.COL_COD_OWNER);
				dataInfo.codCustomer = stmtResult.getLong(CarterveDbTableColumn.COL_COD_CUSTOMER);
				dataInfo.codUser = stmtResult.getLong(CarterveDbTableColumn.COL_COD_USER);
				dataInfo.codStore = stmtResult.getLong(CarterveDbTableColumn.COL_COD_STORE);
				dataInfo.codEmployee = stmtResult.getLong(CarterveDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codMat = stmtResult.getLong(CarterveDbTableColumn.COL_COD_MATERIAL);


				Date date = stmtResult.getDate(CarterveDbTableColumn.COL_DATE);
				if (date != null)
					dataInfo.date = date.toLocalDate();
				
				Time beginTime = stmtResult.getTime(CarterveDbTableColumn.COL_BEGIN_TIME);
				if (beginTime != null)
					dataInfo.beginTime = beginTime.toLocalTime();
				
				Time endTime = stmtResult.getTime(CarterveDbTableColumn.COL_END_TIME);
				if (endTime != null)
					dataInfo.endTime = endTime.toLocalTime();
				
				Timestamp lastChanged = stmtResult.getTimestamp(CarterveDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
	
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
