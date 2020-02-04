package br.com.mind5.payment.payOrder.dao;

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
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordSelectSingle extends DaoStmtTemplate<PayordInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_ORDER_HDR_TABLE;	
	
	
	public PayordSelectSingle(Connection conn, PayordInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PayordInfo recordInfo) {	
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PayordWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
		
	
	
	@Override protected DaoResultParser<PayordInfo> getResultParserHook() {
		return new DaoResultParser<PayordInfo>() {
			@Override public List<PayordInfo> parseResult(PayordInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PayordInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PayordInfo dataInfo = new PayordInfo();
					
					dataInfo.codOwner = stmtResult.getLong(PayordDbTableColumn.COL_COD_OWNER);
					dataInfo.codPayOrder = stmtResult.getLong(PayordDbTableColumn.COL_COD_PAY_ORDER);				
					dataInfo.idOrderPartner = stmtResult.getString(PayordDbTableColumn.COL_ID_ORDER_PARTNER);
					dataInfo.statusOrderPartner = stmtResult.getString(PayordDbTableColumn.COL_STATUS_ORDER_PARTNER);
					dataInfo.amountTotalPartner = stmtResult.getString(PayordDbTableColumn.COL_AMOUNT_TOTAL_PARTNER);
					dataInfo.amountCurrencyPartner = stmtResult.getString(PayordDbTableColumn.COL_AMOUNT_CURRENCY_PARTNER);
					dataInfo.idPaymentPartner = stmtResult.getString(PayordDbTableColumn.COL_ID_PAYMENT_PARTNER);
					dataInfo.statusPaymentPartner = stmtResult.getString(PayordDbTableColumn.COL_STATUS_PAYMENT_PARTNER);
					dataInfo.codOrder = DaoFormatter.sqlToLong(stmtResult, PayordDbTableColumn.COL_COD_ORDER);
					dataInfo.codCreditCard = DaoFormatter.sqlToLong(stmtResult, PayordDbTableColumn.COL_COD_CREDIT_CARD);
					dataInfo.codPayCustomer = DaoFormatter.sqlToLong(stmtResult, PayordDbTableColumn.COL_COD_PAY_CUSTOMER);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, PayordDbTableColumn.COL_LAST_CHANGED);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, PayordDbTableColumn.COL_CREATED_ON);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
