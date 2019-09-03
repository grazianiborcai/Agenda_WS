package br.com.gda.business.orderReserve.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.orderReserve.info.OrderveInfo;
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

public final class OrderveSelectSingle implements DaoStmt<OrderveInfo> {
	private final String LT_ORDER_ITM = DaoDbTable.ORDER_ITM_TABLE;	
	private final String RT_ORDER_HDR = DaoDbTable.ORDER_HDR_TABLE;
	
	private DaoStmt<OrderveInfo> stmtSql;
	private DaoStmtOption<OrderveInfo> stmtOption;
	
	
	
	public OrderveSelectSingle(Connection conn, OrderveInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, OrderveInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_ORDER_ITM;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.ORDER_RESERVE_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new OrderveWhere(whereOption, DaoDbTable.ORDER_RESERVE_VIEW, stmtOption.recordInfo);
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
		oneColumn.leftTableName = LT_ORDER_ITM;
		oneColumn.leftColumnName = OrderveDbTableColumn.COL_COD_OWNER;
		oneColumn.rightColumnName = OrderveDbTableColumn.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_ORDER_ITM;
		oneColumn.leftColumnName = OrderveDbTableColumn.COL_COD_ORDER;
		oneColumn.rightColumnName = OrderveDbTableColumn.COL_COD_ORDER;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_ORDER_HDR;
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

	
	
	@Override public List<OrderveInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<OrderveInfo> getNewInstance() {
		return new OrderveSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<OrderveInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<OrderveInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<OrderveInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				OrderveInfo dataInfo = new OrderveInfo();
				dataInfo.codOwner = stmtResult.getLong(OrderveDbTableColumn.COL_COD_OWNER);
				dataInfo.codOrder = stmtResult.getLong(OrderveDbTableColumn.COL_COD_ORDER);
				dataInfo.codCustomer = stmtResult.getLong(OrderveDbTableColumn.COL_COD_CUSTOMER);
				dataInfo.codUser = stmtResult.getLong(OrderveDbTableColumn.COL_COD_USER);
				dataInfo.codStore = stmtResult.getLong(OrderveDbTableColumn.COL_COD_STORE);
				dataInfo.codEmployee = stmtResult.getLong(OrderveDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codMat = stmtResult.getLong(OrderveDbTableColumn.COL_COD_MATERIAL);
				dataInfo.codOrderStatus = stmtResult.getString(OrderveDbTableColumn.COL_COD_ORDER_STATUS);


				Date date = stmtResult.getDate(OrderveDbTableColumn.COL_DATE);
				if (date != null)
					dataInfo.date = date.toLocalDate();
				
				Time beginTime = stmtResult.getTime(OrderveDbTableColumn.COL_BEGIN_TIME);
				if (beginTime != null)
					dataInfo.beginTime = beginTime.toLocalTime();
				
				Time endTime = stmtResult.getTime(OrderveDbTableColumn.COL_END_TIME);
				if (endTime != null)
					dataInfo.endTime = endTime.toLocalTime();
	
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
