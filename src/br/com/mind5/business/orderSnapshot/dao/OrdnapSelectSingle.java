package br.com.mind5.business.orderSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class OrdnapSelectSingle extends DaoStmtTemplate<OrdnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.ORDER_HDR_SNAPSHOT_TABLE;
	
	
	public OrdnapSelectSingle(Connection conn, OrdnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OrdnapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new OrdnapWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<OrdnapInfo> getResultParserHook() {
		return new DaoResultParserV2<OrdnapInfo>() {
			@Override public List<OrdnapInfo> parseResult(OrdnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OrdnapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
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
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, OrdnapDbTableColumn.COL_CREATED_ON);
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
					dataInfo.postingDate = DaoFormatter.sqlToLocalDate(stmtResult, OrdnapDbTableColumn.COL_POSTING_DATE);
					dataInfo.postingYear = DaoFormatter.sqlToInt(stmtResult, OrdnapDbTableColumn.COL_POSTING_YEAR);
					dataInfo.postingYearMonth = DaoFormatter.sqlToInt(stmtResult, OrdnapDbTableColumn.COL_POSTING_YEAR_MONTH);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
