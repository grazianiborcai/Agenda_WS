package br.com.mind5.payment.payOrderItemSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

public final class DaoPayormarchSelectSingle extends DaoStmtTemplate<PayormarchInfo> {	
	private final String MAIN_TABLE = DaoDbTable.PAY_ORDER_ITM_TABLE;	
	
	
	public DaoPayormarchSelectSingle(Connection conn, PayormarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PAY_ORDER_ITM_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PayormarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoPayormarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<PayormarchInfo> getResultParserHook() {
		return new DaoResultParser<PayormarchInfo>() {
			@Override public List<PayormarchInfo> parseResult(PayormarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {				
				List<PayormarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PayormarchInfo dataInfo = new PayormarchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoPayormarchDbTableColumn.COL_COD_OWNER);	
					dataInfo.codPayOrder = stmtResult.getLong(DaoPayormarchDbTableColumn.COL_COD_PAY_ORDER);
					dataInfo.codPayOrderItem = stmtResult.getInt(DaoPayormarchDbTableColumn.COL_COD_PAY_ORDER_ITEM);					
					dataInfo.codOrder = stmtResult.getLong(DaoPayormarchDbTableColumn.COL_COD_ORDER);
					dataInfo.codOrderItem = stmtResult.getInt(DaoPayormarchDbTableColumn.COL_COD_ORDER_ITEM);					
					dataInfo.ownId = stmtResult.getString(DaoPayormarchDbTableColumn.COL_OWN_ID);
					dataInfo.idOrderPartner = stmtResult.getString(DaoPayormarchDbTableColumn.COL_ID_ORDER_PARTNER);
					dataInfo.statusOrderPartner = stmtResult.getString(DaoPayormarchDbTableColumn.COL_STATUS_ORDER_PARTNER);
					dataInfo.idPaymentPartner = stmtResult.getString(DaoPayormarchDbTableColumn.COL_ID_PAYMENT_PARTNER);
					dataInfo.statusPaymentPartner = stmtResult.getString(DaoPayormarchDbTableColumn.COL_STATUS_PAYMENT_PARTNER);
					dataInfo.idRefundPartner = stmtResult.getString(DaoPayormarchDbTableColumn.COL_ID_REFUND_PARTNER);
					dataInfo.statusRefundPartner = stmtResult.getString(DaoPayormarchDbTableColumn.COL_STATUS_REFUND_PARTNER);	
					dataInfo.itemReceiver = stmtResult.getString(DaoPayormarchDbTableColumn.COL_ITEM_RECEIVER);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
