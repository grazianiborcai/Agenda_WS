package br.com.mind5.payment.payOrderSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

public final class PayordarchDaoSelectSingle extends DaoStmtTemplate<PayordarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_ORDER_HDR_TABLE;
	
	
	public PayordarchDaoSelectSingle(Connection conn, PayordarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PAY_ORDER_HDR_SEARCH_VIEW;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PayordarchInfo recordInfo) {	
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull       = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PayordarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(PayordarchInfo recordInfo) {
		DaoJoinBuilder joinCuspar = new PayordarchDaoJoinCuspar(MAIN_TABLE);		
		return joinCuspar.build();
	}	
	
	
	
	@Override protected DaoResultParser<PayordarchInfo> getResultParserHook() {
		return new DaoResultParser<PayordarchInfo>() {
			@Override public List<PayordarchInfo> parseResult(PayordarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PayordarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PayordarchInfo dataInfo = new PayordarchInfo();
					
					dataInfo.codOwner 				= stmtResult.getLong(PayordarchDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codPayOrder 			= stmtResult.getLong(PayordarchDaoDbTableColumn.COL_COD_PAY_ORDER);				
					dataInfo.idOrderPartner 		= stmtResult.getString(PayordarchDaoDbTableColumn.COL_ID_ORDER_PARTNER);
					dataInfo.statusOrderPartner 	= stmtResult.getString(PayordarchDaoDbTableColumn.COL_STATUS_ORDER_PARTNER);
					dataInfo.amountTotalPartner 	= stmtResult.getString(PayordarchDaoDbTableColumn.COL_AMOUNT_TOTAL_PARTNER);
					dataInfo.amountCurrencyPartner 	= stmtResult.getString(PayordarchDaoDbTableColumn.COL_AMOUNT_CURRENCY_PARTNER);
					dataInfo.idPaymentPartner 		= stmtResult.getString(PayordarchDaoDbTableColumn.COL_ID_PAYMENT_PARTNER);
					dataInfo.statusPaymentPartner	= stmtResult.getString(PayordarchDaoDbTableColumn.COL_STATUS_PAYMENT_PARTNER);
					dataInfo.codOrder 				= DaoFormatter.sqlToLong(stmtResult, PayordarchDaoDbTableColumn.COL_COD_ORDER);
					dataInfo.codCreditCard 			= DaoFormatter.sqlToLong(stmtResult, PayordarchDaoDbTableColumn.COL_COD_CREDIT_CARD);
					dataInfo.codPayCustomer 		= DaoFormatter.sqlToLong(stmtResult, PayordarchDaoDbTableColumn.COL_COD_PAY_CUSTOMER);
					dataInfo.lastChanged 			= DaoFormatter.sqlToLocalDateTime(stmtResult, PayordarchDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.createdOn 				= DaoFormatter.sqlToLocalDateTime(stmtResult, PayordarchDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.codUser 				= DaoFormatter.sqlToLong(stmtResult, PayordarchDaoDbTableColumn.COL_COD_USER);
					dataInfo.codPayPartner 			= DaoFormatter.sqlToInt(stmtResult, PayordarchDaoDbTableColumn.COL_COD_PAY_PARTNER);
					dataInfo.hasWebhookEvent       	= stmtResult.getBoolean(PayordarchDaoDbTableColumn.COL_HAS_WEBHOOK_EVENT);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
