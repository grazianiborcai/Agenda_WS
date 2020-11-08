package br.com.mind5.payment.payOrderItemList.dao;

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
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;

public final class DaoPayordemistSelectSingle extends DaoStmtTemplate<PayordemistInfo> {	
	private final String MAIN_TABLE = DaoDbTable.PAY_ORDER_ITM_TABLE;	
	
	
	public DaoPayordemistSelectSingle(Connection conn, PayordemistInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PAY_ORDER_ITM_LIST_VIEW;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PayordemistInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoPayordemistWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<PayordemistInfo> getResultParserHook() {
		return new DaoResultParser<PayordemistInfo>() {
			@Override public List<PayordemistInfo> parseResult(PayordemistInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {				
				List<PayordemistInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PayordemistInfo dataInfo = new PayordemistInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoPayordemistDbTableColumn.COL_COD_OWNER);	
					dataInfo.codPayOrder = stmtResult.getLong(DaoPayordemistDbTableColumn.COL_COD_PAY_ORDER);
					dataInfo.codPayOrderItem = stmtResult.getInt(DaoPayordemistDbTableColumn.COL_COD_PAY_ORDER_ITEM);
					dataInfo.ownId = stmtResult.getString(DaoPayordemistDbTableColumn.COL_OWN_ID);
					dataInfo.idOrderPartner = stmtResult.getString(DaoPayordemistDbTableColumn.COL_ID_ORDER_PARTNER);
					dataInfo.statusOrderPartner = stmtResult.getString(DaoPayordemistDbTableColumn.COL_STATUS_ORDER_PARTNER);
					dataInfo.idPaymentPartner = stmtResult.getString(DaoPayordemistDbTableColumn.COL_ID_PAYMENT_PARTNER);
					dataInfo.statusPaymentPartner = stmtResult.getString(DaoPayordemistDbTableColumn.COL_STATUS_PAYMENT_PARTNER);
					dataInfo.idRefundPartner = stmtResult.getString(DaoPayordemistDbTableColumn.COL_ID_REFUND_PARTNER);
					dataInfo.statusRefundPartner = stmtResult.getString(DaoPayordemistDbTableColumn.COL_STATUS_REFUND_PARTNER);	
					dataInfo.itemReceiver = stmtResult.getString(DaoPayordemistDbTableColumn.COL_ITEM_RECEIVER);	
					dataInfo.codStore = stmtResult.getLong(DaoPayordemistDbTableColumn.COL_COD_STORE);	
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
