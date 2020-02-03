package br.com.mind5.payment.payOrderSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

public final class PayordarchSelectSingle extends DaoStmtTemplate<PayordarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_ORDER_HDR_TABLE;
	
	
	public PayordarchSelectSingle(Connection conn, PayordarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PayordarchInfo recordInfo) {	
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PayordarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<PayordarchInfo> getResultParserHook() {
		return new DaoResultParserV2<PayordarchInfo>() {
			@Override public List<PayordarchInfo> parseResult(PayordarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PayordarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PayordarchInfo dataInfo = new PayordarchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(PayordarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codPayOrder = stmtResult.getLong(PayordarchDbTableColumn.COL_COD_PAY_ORDER);				
					dataInfo.idOrderPartner = stmtResult.getString(PayordarchDbTableColumn.COL_ID_ORDER_PARTNER);
					dataInfo.statusOrderPartner = stmtResult.getString(PayordarchDbTableColumn.COL_STATUS_ORDER_PARTNER);
					dataInfo.amountTotalPartner = stmtResult.getString(PayordarchDbTableColumn.COL_AMOUNT_TOTAL_PARTNER);
					dataInfo.amountCurrencyPartner = stmtResult.getString(PayordarchDbTableColumn.COL_AMOUNT_CURRENCY_PARTNER);
					dataInfo.idPaymentPartner = stmtResult.getString(PayordarchDbTableColumn.COL_ID_PAYMENT_PARTNER);
					dataInfo.statusPaymentPartner = stmtResult.getString(PayordarchDbTableColumn.COL_STATUS_PAYMENT_PARTNER);
					dataInfo.codOrder = DaoFormatter.sqlToLong(stmtResult, PayordarchDbTableColumn.COL_COD_ORDER);
					dataInfo.codCreditCard = DaoFormatter.sqlToLong(stmtResult, PayordarchDbTableColumn.COL_COD_CREDIT_CARD);
					dataInfo.codPayCustomer = DaoFormatter.sqlToLong(stmtResult, PayordarchDbTableColumn.COL_COD_PAY_CUSTOMER);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, PayordarchDbTableColumn.COL_LAST_CHANGED);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, PayordarchDbTableColumn.COL_CREATED_ON);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
