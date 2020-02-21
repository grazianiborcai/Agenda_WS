package br.com.mind5.payment.payOrderList.dao;

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
import br.com.mind5.payment.payOrderList.info.PayordistInfo;

public final class PayordistSelectSingle extends DaoStmtTemplate<PayordistInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_ORDER_HDR_TABLE;	
	
	
	public PayordistSelectSingle(Connection conn, PayordistInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PAY_ORDER_HDR_LIST_VIEW;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PayordistInfo recordInfo) {	
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PayordistWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
		
	
	
	@Override protected DaoResultParser<PayordistInfo> getResultParserHook() {
		return new DaoResultParser<PayordistInfo>() {
			@Override public List<PayordistInfo> parseResult(PayordistInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PayordistInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PayordistInfo dataInfo = new PayordistInfo();
					
					dataInfo.codOwner = stmtResult.getLong(PayordistDbTableColumn.COL_COD_OWNER);
					dataInfo.codPayOrder = stmtResult.getLong(PayordistDbTableColumn.COL_COD_PAY_ORDER);				
					dataInfo.idOrderPartner = stmtResult.getString(PayordistDbTableColumn.COL_ID_ORDER_PARTNER);
					dataInfo.statusOrderPartner = stmtResult.getString(PayordistDbTableColumn.COL_STATUS_ORDER_PARTNER);
					dataInfo.amountTotalPartner = stmtResult.getString(PayordistDbTableColumn.COL_AMOUNT_TOTAL_PARTNER);
					dataInfo.amountCurrencyPartner = stmtResult.getString(PayordistDbTableColumn.COL_AMOUNT_CURRENCY_PARTNER);
					dataInfo.idPaymentPartner = stmtResult.getString(PayordistDbTableColumn.COL_ID_PAYMENT_PARTNER);
					dataInfo.statusPaymentPartner = stmtResult.getString(PayordistDbTableColumn.COL_STATUS_PAYMENT_PARTNER);
					dataInfo.codOrder = DaoFormatter.sqlToLong(stmtResult, PayordistDbTableColumn.COL_COD_ORDER);
					dataInfo.codCreditCard = DaoFormatter.sqlToLong(stmtResult, PayordistDbTableColumn.COL_COD_CREDIT_CARD);
					dataInfo.codPayCustomer = DaoFormatter.sqlToLong(stmtResult, PayordistDbTableColumn.COL_COD_PAY_CUSTOMER);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
