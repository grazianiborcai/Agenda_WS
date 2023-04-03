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

public final class PayordemDaoSelectSingle extends DaoStmtTemplate<PayordemInfo> {	
	private final String MAIN_TABLE = DaoDbTable.PAY_ORDER_ITM_TABLE;	
	
	
	public PayordemDaoSelectSingle(Connection conn, PayordemInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new PayordemDaoWhere(whereOption, tableName, recordInfo);
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
					
					dataInfo.date                 = DaoFormatter.sqlToLocalDate(stmtResult, PayordemDaoDbTableColumn.COL_DATE);
					dataInfo.price                = DaoFormatter.sqlToDouble(stmtResult, PayordemDaoDbTableColumn.COL_PRICE);
					dataInfo.ownId                = stmtResult.getString(PayordemDaoDbTableColumn.COL_OWN_ID);
					dataInfo.codMat               = DaoFormatter.sqlToLong(stmtResult, PayordemDaoDbTableColumn.COL_COD_MATERIAL);
					dataInfo.codCurr              = stmtResult.getString(PayordemDaoDbTableColumn.COL_COD_CURRENCY);
					dataInfo.totitem              = DaoFormatter.sqlToDouble(stmtResult, PayordemDaoDbTableColumn.COL_TOTAL_ITEM);
					dataInfo.quantity             = stmtResult.getInt(PayordemDaoDbTableColumn.COL_QUANTITY);
					dataInfo.codStore             = DaoFormatter.sqlToLong(stmtResult, PayordemDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codOrder             = DaoFormatter.sqlToLong(stmtResult, PayordemDaoDbTableColumn.COL_COD_ORDER);
					dataInfo.codOwner             = stmtResult.getLong(PayordemDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.beginTime            = DaoFormatter.sqlToLocalTime(stmtResult, PayordemDaoDbTableColumn.COL_BEGIN_TIME);
					dataInfo.codPayOrder          = stmtResult.getLong(PayordemDaoDbTableColumn.COL_COD_PAY_ORDER);
					dataInfo.codFeeCateg          = DaoFormatter.sqlToChar(stmtResult, PayordemDaoDbTableColumn.COL_COD_FEE_CATEG);
					dataInfo.codEmployee          = DaoFormatter.sqlToLong(stmtResult, PayordemDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.lastChanged          = DaoFormatter.sqlToLocalDateTime(stmtResult, PayordemDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.codOrderItem         = DaoFormatter.sqlToInt(stmtResult, PayordemDaoDbTableColumn.COL_COD_ORDER_ITEM);
					dataInfo.itemReceiver         = stmtResult.getString(PayordemDaoDbTableColumn.COL_ITEM_RECEIVER);					
					dataInfo.idItemPartner        = stmtResult.getString(PayordemDaoDbTableColumn.COL_ID_ITEM_PARTNER);
					dataInfo.idOrderPartner       = stmtResult.getString(PayordemDaoDbTableColumn.COL_ID_ORDER_PARTNER);
					dataInfo.idRefundPartner      = stmtResult.getString(PayordemDaoDbTableColumn.COL_ID_REFUND_PARTNER);
					dataInfo.codPayOrderItem      = stmtResult.getInt(PayordemDaoDbTableColumn.COL_COD_PAY_ORDER_ITEM);
					dataInfo.idPaymentPartner     = stmtResult.getString(PayordemDaoDbTableColumn.COL_ID_PAYMENT_PARTNER);					
					dataInfo.statusOrderPartner   = stmtResult.getString(PayordemDaoDbTableColumn.COL_STATUS_ORDER_PARTNER);
					dataInfo.statusRefundPartner  = stmtResult.getString(PayordemDaoDbTableColumn.COL_STATUS_REFUND_PARTNER);
					dataInfo.statusPaymentPartner = stmtResult.getString(PayordemDaoDbTableColumn.COL_STATUS_PAYMENT_PARTNER);					
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
