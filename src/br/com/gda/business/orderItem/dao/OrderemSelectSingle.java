package br.com.gda.business.orderItem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;
import br.com.gda.dao.common.DaoOptionValue;

public final class OrderemSelectSingle implements DaoStmt<OrderemInfo> {	
	private final String LT_ITM = DaoDbTable.ORDER_ITM_TABLE;
	
	private DaoStmt<OrderemInfo> stmtSql;
	private DaoStmtOption<OrderemInfo> stmtOption;
	
	
	
	public OrderemSelectSingle(Connection conn, OrderemInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, OrderemInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_ITM;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_ITM);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new OrderemWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<OrderemInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<OrderemInfo> getNewInstance() {
		return new OrderemSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<OrderemInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<OrderemInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			
			List<OrderemInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				OrderemInfo dataInfo = new OrderemInfo();
				dataInfo.codOwner = stmtResult.getLong(OrderemDbTableColumn.COL_COD_OWNER);	
				dataInfo.codOrder = stmtResult.getLong(OrderemDbTableColumn.COL_COD_ORDER);
				dataInfo.codOrderItem = DaoFormatter.sqlToInt(stmtResult, OrderemDbTableColumn.COL_COD_ORDER_ITEM);
				dataInfo.quantity = stmtResult.getInt(OrderemDbTableColumn.COL_QUANTITY);
				dataInfo.codCurr = stmtResult.getString(OrderemDbTableColumn.COL_COD_CURRENCY);
				dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, OrderemDbTableColumn.COL_COD_STORE);
				dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, OrderemDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, OrderemDbTableColumn.COL_COD_MATERIAL);
				dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, OrderemDbTableColumn.COL_DATE);
				dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, OrderemDbTableColumn.COL_BEGIN_TIME);
				dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, OrderemDbTableColumn.COL_END_TIME);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, OrderemDbTableColumn.COL_LAST_CHANGED);
				dataInfo.lastChangedBy = stmtResult.getLong(OrderemDbTableColumn.COL_LAST_CHANGED_BY);
				dataInfo.price = DaoFormatter.sqlToDouble(stmtResult, OrderemDbTableColumn.COL_PRICE);
				dataInfo.totitem = DaoFormatter.sqlToDouble(stmtResult, OrderemDbTableColumn.COL_TOTAL_ITEM);
				dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, OrderemDbTableColumn.COL_COD_SNAPSHOT);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
