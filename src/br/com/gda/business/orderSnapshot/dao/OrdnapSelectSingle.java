package br.com.gda.business.orderSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.dao.OrderDbTableColumn;
import br.com.gda.business.orderSnapshot.info.OrdnapInfo;
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

public final class OrdnapSelectSingle implements DaoStmt<OrdnapInfo> {
	private final String LT_HDR = DaoDbTable.ORDER_HDR_SNAPSHOT_TABLE;
	
	private DaoStmt<OrdnapInfo> stmtSql;
	private DaoStmtOption<OrdnapInfo> stmtOption;
	
	
	
	public OrdnapSelectSingle(Connection conn, OrdnapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, OrdnapInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new OrdnapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<OrdnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<OrdnapInfo> getNewInstance() {
		return new OrdnapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<OrdnapInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<OrdnapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			
			List<OrdnapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				OrdnapInfo dataInfo = new OrdnapInfo();
				dataInfo.codOwner = stmtResult.getLong(OrdnapDbTableColumn.COL_COD_OWNER);	
				dataInfo.codSnapshot = stmtResult.getLong(OrdnapDbTableColumn.COL_COD_SNAPSHOT);	
				dataInfo.codOrder = stmtResult.getLong(OrdnapDbTableColumn.COL_COD_ORDER);
				dataInfo.codUser = stmtResult.getLong(OrdnapDbTableColumn.COL_COD_USER);	
				dataInfo.codOrderExt = stmtResult.getString(OrdnapDbTableColumn.COL_COD_ORDER_EXTERNAL);	
				dataInfo.codOrderStatus = stmtResult.getString(OrdnapDbTableColumn.COL_COD_ORDER_STATUS);
				dataInfo.codCurr = stmtResult.getString(OrdnapDbTableColumn.COL_COD_CURRENCY);
				dataInfo.codUserSnapshot = DaoFormatter.sqlToLong(stmtResult, OrdnapDbTableColumn.COL_COD_USER_SNAPSHOT);
				dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, OrdnapDbTableColumn.COL_COD_CUSTOMER);
				dataInfo.codCustomerSnapshot = DaoFormatter.sqlToLong(stmtResult, OrdnapDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, OrdnapDbTableColumn.COL_LAST_CHANGED);
				dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, OrderDbTableColumn.COL_CREATED_ON);
				dataInfo.itemTotal = DaoFormatter.sqlToDouble(stmtResult, OrdnapDbTableColumn.COL_ITEM_TOTAL);
				dataInfo.feeService = DaoFormatter.sqlToDouble(stmtResult, OrdnapDbTableColumn.COL_FEE_SERVICE);
				dataInfo.grandTotal = DaoFormatter.sqlToDouble(stmtResult, OrdnapDbTableColumn.COL_GRAND_TOTAL);
				dataInfo.codAddressShip = DaoFormatter.sqlToLong(stmtResult, OrdnapDbTableColumn.COL_COD_ADDRESS_SHIP);
				dataInfo.codAddressShipSnapshot = DaoFormatter.sqlToLong(stmtResult, OrdnapDbTableColumn.COL_COD_ADDRESS_SHIP_SNAPSHOT);
				dataInfo.codAddressInvoice = DaoFormatter.sqlToLong(stmtResult, OrdnapDbTableColumn.COL_COD_ADDRESS_INVOICE);
				dataInfo.codAddressInvoiceSnapshot = DaoFormatter.sqlToLong(stmtResult, OrdnapDbTableColumn.COL_COD_ADDRESS_INVOICE_SNAPSHOT);
				dataInfo.codPhoneShip = DaoFormatter.sqlToLong(stmtResult, OrdnapDbTableColumn.COL_COD_PHONE_SHIP);
				dataInfo.codPhoneShipSnapshot = DaoFormatter.sqlToLong(stmtResult, OrdnapDbTableColumn.COL_COD_PHONE_SHIP_SNAPSHOT);
				dataInfo.codPhoneInvoice = DaoFormatter.sqlToLong(stmtResult, OrdnapDbTableColumn.COL_COD_PHONE_INVOICE);
				dataInfo.codPhoneInvoiceSnapshot = DaoFormatter.sqlToLong(stmtResult, OrdnapDbTableColumn.COL_COD_PHONE_INVOICE_SNAPSHOT);
				dataInfo.codPayOrder = DaoFormatter.sqlToLong(stmtResult, OrdnapDbTableColumn.COL_COD_PAY_ORDER);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, OrdnapDbTableColumn.COL_LAST_CHANGED_BY);
				dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, OrdnapDbTableColumn.COL_CREATED_BY);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
