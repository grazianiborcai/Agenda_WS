package br.com.gda.business.order.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.orderSnapshot.dao.OrdnapDbTableColumn;
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

public final class OrderSelectSingle implements DaoStmt<OrderInfo> {
	private final String LT_HDR = DaoDbTable.ORDER_HDR_TABLE;
	
	private DaoStmt<OrderInfo> stmtSql;
	private DaoStmtOption<OrderInfo> stmtOption;
	
	
	
	public OrderSelectSingle(Connection conn, OrderInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, OrderInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_HDR;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_HDR);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new OrderWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption);
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

	
	
	@Override public List<OrderInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<OrderInfo> getNewInstance() {
		return new OrderSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<OrderInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<OrderInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			
			List<OrderInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				OrderInfo dataInfo = new OrderInfo();
				dataInfo.codOwner = stmtResult.getLong(OrderDbTableColumn.COL_COD_OWNER);	
				dataInfo.codOrder = stmtResult.getLong(OrderDbTableColumn.COL_COD_ORDER);
				dataInfo.codSnapshot = stmtResult.getLong(OrdnapDbTableColumn.COL_COD_SNAPSHOT);	
				dataInfo.codUser = stmtResult.getLong(OrderDbTableColumn.COL_COD_USER);	
				dataInfo.codOrderExt = stmtResult.getString(OrderDbTableColumn.COL_COD_ORDER_EXTERNAL);	
				dataInfo.codOrderStatus = stmtResult.getString(OrderDbTableColumn.COL_COD_ORDER_STATUS);
				dataInfo.codCurr = stmtResult.getString(OrderDbTableColumn.COL_COD_CURRENCY);
				dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, OrderDbTableColumn.COL_COD_CUSTOMER);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, OrderDbTableColumn.COL_LAST_CHANGED);
				dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, OrderDbTableColumn.COL_CREATED_ON);
				dataInfo.itemTotal = DaoFormatter.sqlToDouble(stmtResult, OrderDbTableColumn.COL_ITEM_TOTAL);
				dataInfo.feeService = DaoFormatter.sqlToDouble(stmtResult, OrderDbTableColumn.COL_FEE_SERVICE);
				dataInfo.grandTotal = DaoFormatter.sqlToDouble(stmtResult, OrderDbTableColumn.COL_GRAND_TOTAL);
				dataInfo.codAddressShip = DaoFormatter.sqlToLong(stmtResult, OrderDbTableColumn.COL_COD_ADDRESS_SHIP);
				dataInfo.codAddressInvoice = DaoFormatter.sqlToLong(stmtResult, OrderDbTableColumn.COL_COD_ADDRESS_INVOICE);
				dataInfo.codPhoneShip = DaoFormatter.sqlToLong(stmtResult, OrderDbTableColumn.COL_COD_PHONE_SHIP);
				dataInfo.codPhoneInvoice = DaoFormatter.sqlToLong(stmtResult, OrderDbTableColumn.COL_COD_PHONE_INVOICE);
				dataInfo.codPayOrder = DaoFormatter.sqlToLong(stmtResult, OrderDbTableColumn.COL_COD_PAY_ORDER);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, OrdnapDbTableColumn.COL_LAST_CHANGED_BY);
				dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, OrdnapDbTableColumn.COL_CREATED_BY);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
