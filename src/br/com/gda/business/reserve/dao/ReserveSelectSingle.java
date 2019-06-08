package br.com.gda.business.reserve.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.reserve.info.ReserveInfo;
import br.com.gda.dao.DaoJoin;
import br.com.gda.dao.DaoJoinColumn;
import br.com.gda.dao.DaoJoinType;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class ReserveSelectSingle implements DaoStmt<ReserveInfo> {
	private final String LT_CART_ITM = DaoDbTable.CART_ITM_TABLE;	
	private final String RT_CART_HDR = DaoDbTable.CART_HDR_TABLE;
	
	private DaoStmt<ReserveInfo> stmtSql;
	private DaoStmtOption<ReserveInfo> stmtOption;
	
	
	
	public ReserveSelectSingle(Connection conn, ReserveInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, ReserveInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_CART_ITM;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.RESERVE_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new ReserveWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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
		oneColumn.leftColumnName = ReserveDbTableColumn.COL_COD_OWNER;
		oneColumn.rightColumnName = ReserveDbTableColumn.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_CART_ITM;
		oneColumn.leftColumnName = ReserveDbTableColumn.COL_COD_CUSTOMER;
		oneColumn.rightColumnName = ReserveDbTableColumn.COL_COD_CUSTOMER;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_CART_HDR;
		join.joinType = DaoJoinType.INNER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption);
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

	
	
	@Override public List<ReserveInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<ReserveInfo> getNewInstance() {
		return new ReserveSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<ReserveInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<ReserveInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<ReserveInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				ReserveInfo dataInfo = new ReserveInfo();
				dataInfo.codOwner = stmtResult.getLong(ReserveDbTableColumn.COL_COD_OWNER);
				dataInfo.codCustomer = stmtResult.getLong(ReserveDbTableColumn.COL_COD_CUSTOMER);
				dataInfo.itemNumber = stmtResult.getInt(ReserveDbTableColumn.COL_ITEM_NUMBER);
				dataInfo.codStore = stmtResult.getLong(ReserveDbTableColumn.COL_COD_STORE);
				dataInfo.codEmployee = stmtResult.getLong(ReserveDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codMat = stmtResult.getLong(ReserveDbTableColumn.COL_COD_MATERIAL);


				Date date = stmtResult.getDate(ReserveDbTableColumn.COL_DATE);
				if (date != null)
					dataInfo.date = date.toLocalDate();
				
				Time beginTime = stmtResult.getTime(ReserveDbTableColumn.COL_BEGIN_TIME);
				if (beginTime != null)
					dataInfo.beginTime = beginTime.toLocalTime();
				
				Time endTime = stmtResult.getTime(ReserveDbTableColumn.COL_END_TIME);
				if (endTime != null)
					dataInfo.endTime = endTime.toLocalTime();
				
				Timestamp lastChanged = stmtResult.getTimestamp(ReserveDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				dataInfo.computeValidTime();
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
