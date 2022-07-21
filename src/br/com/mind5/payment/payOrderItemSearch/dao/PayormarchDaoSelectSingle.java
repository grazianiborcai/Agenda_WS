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

public final class PayormarchDaoSelectSingle extends DaoStmtTemplate<PayormarchInfo> {	
	private final String MAIN_TABLE = DaoDbTable.PAY_ORDER_ITM_TABLE;	
	
	
	public PayormarchDaoSelectSingle(Connection conn, PayormarchInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new PayormarchDaoWhere(whereOption, tableName, recordInfo);
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
					
					dataInfo.codOwner = stmtResult.getLong(PayormarchDaoDbTableColumn.COL_COD_OWNER);	
					dataInfo.codPayOrder = stmtResult.getLong(PayormarchDaoDbTableColumn.COL_COD_PAY_ORDER);
					dataInfo.codPayOrderItem = stmtResult.getInt(PayormarchDaoDbTableColumn.COL_COD_PAY_ORDER_ITEM);					
					dataInfo.codOrder = stmtResult.getLong(PayormarchDaoDbTableColumn.COL_COD_ORDER);
					dataInfo.codOrderItem = stmtResult.getInt(PayormarchDaoDbTableColumn.COL_COD_ORDER_ITEM);					
					dataInfo.ownId = stmtResult.getString(PayormarchDaoDbTableColumn.COL_OWN_ID);
					dataInfo.idOrderPartner = stmtResult.getString(PayormarchDaoDbTableColumn.COL_ID_ORDER_PARTNER);
					dataInfo.statusOrderPartner = stmtResult.getString(PayormarchDaoDbTableColumn.COL_STATUS_ORDER_PARTNER);
					dataInfo.idPaymentPartner = stmtResult.getString(PayormarchDaoDbTableColumn.COL_ID_PAYMENT_PARTNER);
					dataInfo.statusPaymentPartner = stmtResult.getString(PayormarchDaoDbTableColumn.COL_STATUS_PAYMENT_PARTNER);
					dataInfo.idRefundPartner = stmtResult.getString(PayormarchDaoDbTableColumn.COL_ID_REFUND_PARTNER);
					dataInfo.statusRefundPartner = stmtResult.getString(PayormarchDaoDbTableColumn.COL_STATUS_REFUND_PARTNER);	
					dataInfo.itemReceiver = stmtResult.getString(PayormarchDaoDbTableColumn.COL_ITEM_RECEIVER);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
