package br.com.mind5.payment.payOrder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class DaoPayordUpdateSingle extends DaoStmtTemplate<PayordInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_ORDER_HDR_TABLE;
	
	
	public DaoPayordUpdateSingle(Connection conn, PayordInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PayordInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new DaoPayordWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<PayordInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<PayordInfo>() {	
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PayordInfo recordInfo) throws SQLException {	
				int i = 1;		
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOrder);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPayCustomer);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCreditCard);
				stmt.setString(i++, recordInfo.idOrderPartner);
				stmt.setString(i++, recordInfo.statusOrderPartner);
				stmt.setString(i++, recordInfo.amountTotalPartner);
				stmt.setString(i++, recordInfo.amountCurrencyPartner);
				stmt.setString(i++, recordInfo.idPaymentPartner);
				stmt.setString(i++, recordInfo.statusPaymentPartner);	
				stmt.setString(i++, recordInfo.ownId);	
				
				return stmt;
			}		
		};
	}
}
