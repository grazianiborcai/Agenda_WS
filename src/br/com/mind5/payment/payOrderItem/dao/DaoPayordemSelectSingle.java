package br.com.mind5.payment.payOrderItem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class DaoPayordemSelectSingle extends DaoStmtTemplate<PayordemInfo> {	
	private final String MAIN_TABLE = DaoDbTable.PAY_ORDER_ITM_TABLE;	
	
	
	public DaoPayordemSelectSingle(Connection conn, PayordemInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PayordemInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoPayordemWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<PayordemInfo> getResultParserHook() {
		return new DaoResultParser<PayordemInfo>() {
			@Override public List<PayordemInfo> parseResult(PayordemInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {				
				List<PayordemInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PayordemInfo dataInfo = new PayordemInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoPayordemDbTableColumn.COL_COD_OWNER);	
					dataInfo.codPayOrder = stmtResult.getLong(DaoPayordemDbTableColumn.COL_COD_PAY_ORDER);
					dataInfo.codPayOrderItem = stmtResult.getInt(DaoPayordemDbTableColumn.COL_COD_PAY_ORDER_ITEM);
					dataInfo.quantity = stmtResult.getInt(DaoPayordemDbTableColumn.COL_QUANTITY);
					dataInfo.codCurr = stmtResult.getString(DaoPayordemDbTableColumn.COL_COD_CURRENCY);
					dataInfo.itemReceiver = stmtResult.getString(DaoPayordemDbTableColumn.COL_ITEM_RECEIVER);
					dataInfo.ownId = stmtResult.getString(DaoPayordemDbTableColumn.COL_OWN_ID);
					dataInfo.idOrderPartner = stmtResult.getString(DaoPayordemDbTableColumn.COL_ID_ORDER_PARTNER);
					dataInfo.statusOrderPartner = stmtResult.getString(DaoPayordemDbTableColumn.COL_STATUS_ORDER_PARTNER);
					dataInfo.idPaymentPartner = stmtResult.getString(DaoPayordemDbTableColumn.COL_ID_PAYMENT_PARTNER);
					dataInfo.statusPaymentPartner = stmtResult.getString(DaoPayordemDbTableColumn.COL_STATUS_PAYMENT_PARTNER);
					dataInfo.idRefundPartner = stmtResult.getString(DaoPayordemDbTableColumn.COL_ID_REFUND_PARTNER);
					dataInfo.statusRefundPartner = stmtResult.getString(DaoPayordemDbTableColumn.COL_STATUS_REFUND_PARTNER);
					dataInfo.codFeeCateg = DaoFormatter.sqlToChar(stmtResult, DaoPayordemDbTableColumn.COL_COD_FEE_CATEG);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoPayordemDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, DaoPayordemDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, DaoPayordemDbTableColumn.COL_COD_MATERIAL);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, DaoPayordemDbTableColumn.COL_DATE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoPayordemDbTableColumn.COL_BEGIN_TIME);
					dataInfo.price = DaoFormatter.sqlToDouble(stmtResult, DaoPayordemDbTableColumn.COL_PRICE);
					dataInfo.totitem = DaoFormatter.sqlToDouble(stmtResult, DaoPayordemDbTableColumn.COL_TOTAL_ITEM);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoPayordemDbTableColumn.COL_BEGIN_TIME);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoPayordemDbTableColumn.COL_LAST_CHANGED);	
					dataInfo.codOrder = DaoFormatter.sqlToLong(stmtResult, DaoPayordemDbTableColumn.COL_COD_ORDER);
					dataInfo.codOrderItem = DaoFormatter.sqlToInt(stmtResult, DaoPayordemDbTableColumn.COL_COD_ORDER_ITEM);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
