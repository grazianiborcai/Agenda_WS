package br.com.mind5.business.order.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoOrderSelectSingle extends DaoStmtTemplate<OrderInfo> {
	private final String MAIN_TABLE = DaoDbTable.ORDER_HDR_TABLE;
	
	
	public DaoOrderSelectSingle(Connection conn, OrderInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OrderInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoOrderWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<OrderInfo> getResultParserHook() {
		return new DaoResultParser<OrderInfo>() {
			@Override public List<OrderInfo> parseResult(OrderInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {				
				List<OrderInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					OrderInfo dataInfo = new OrderInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoOrderDbTableColumn.COL_COD_OWNER);	
					dataInfo.codOrder = stmtResult.getLong(DaoOrderDbTableColumn.COL_COD_ORDER);
					dataInfo.codSnapshot = stmtResult.getLong(DaoOrderDbTableColumn.COL_COD_SNAPSHOT);	
					dataInfo.codUser = stmtResult.getLong(DaoOrderDbTableColumn.COL_COD_USER);	
					dataInfo.codOrderExt = stmtResult.getString(DaoOrderDbTableColumn.COL_COD_ORDER_EXTERNAL);	
					dataInfo.codOrderStatus = stmtResult.getString(DaoOrderDbTableColumn.COL_COD_ORDER_STATUS);
					dataInfo.codCurr = stmtResult.getString(DaoOrderDbTableColumn.COL_COD_CURRENCY);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoOrderDbTableColumn.COL_LAST_CHANGED);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoOrderDbTableColumn.COL_CREATED_ON);
					dataInfo.itemTotal = DaoFormatter.sqlToDouble(stmtResult, DaoOrderDbTableColumn.COL_ITEM_TOTAL);
					dataInfo.feeService = DaoFormatter.sqlToDouble(stmtResult, DaoOrderDbTableColumn.COL_FEE_SERVICE);
					dataInfo.grandTotal = DaoFormatter.sqlToDouble(stmtResult, DaoOrderDbTableColumn.COL_GRAND_TOTAL);
					dataInfo.codAddressShip = DaoFormatter.sqlToLong(stmtResult, DaoOrderDbTableColumn.COL_COD_ADDRESS_SHIP);
					dataInfo.codAddressInvoice = DaoFormatter.sqlToLong(stmtResult, DaoOrderDbTableColumn.COL_COD_ADDRESS_INVOICE);
					dataInfo.codPhoneShip = DaoFormatter.sqlToLong(stmtResult, DaoOrderDbTableColumn.COL_COD_PHONE_SHIP);
					dataInfo.codPhoneInvoice = DaoFormatter.sqlToLong(stmtResult, DaoOrderDbTableColumn.COL_COD_PHONE_INVOICE);
					dataInfo.codPayOrder = DaoFormatter.sqlToLong(stmtResult, DaoOrderDbTableColumn.COL_COD_PAY_ORDER);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoOrderDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, DaoOrderDbTableColumn.COL_CREATED_BY);	
					dataInfo.postingDate = DaoFormatter.sqlToLocalDate(stmtResult, DaoOrderDbTableColumn.COL_POSTING_DATE);
					dataInfo.postingYear = DaoFormatter.sqlToInt(stmtResult, DaoOrderDbTableColumn.COL_POSTING_YEAR);
					dataInfo.postingYearMonth = DaoFormatter.sqlToInt(stmtResult, DaoOrderDbTableColumn.COL_POSTING_YEAR_MONTH);
					dataInfo.codRefundPolicyGroup = DaoFormatter.sqlToInt(stmtResult, DaoOrderDbTableColumn.COL_COD_REFUND_POLICY_GROUP);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
