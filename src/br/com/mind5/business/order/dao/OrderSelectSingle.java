package br.com.mind5.business.order.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.orderSnapshot.dao.OrdnapDbTableColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class OrderSelectSingle extends DaoStmtTemplate<OrderInfo> {
	private final String MAIN_TABLE = DaoDbTable.ORDER_HDR_TABLE;
	
	
	public OrderSelectSingle(Connection conn, OrderInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new OrderWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<OrderInfo> getResultParserHook() {
		return new DaoResultParserV2<OrderInfo>() {
			@Override public List<OrderInfo> parseResult(OrderInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {				
				List<OrderInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
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
		};
	}
}
