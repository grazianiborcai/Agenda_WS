package br.com.mind5.payment.payOrder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordDaoInsertSingle extends DaoStmtTemplate<PayordInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_ORDER_HDR_TABLE;
	
	
	public PayordDaoInsertSingle(Connection conn, PayordInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<PayordInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<PayordInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PayordInfo recordInfo) throws SQLException {		
				int i = 1;		
				
				stmt.setLong(i++, recordInfo.codOwner);
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
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPayPartner);
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<PayordInfo> getResultParserHook() {
		return new DaoResultParser<PayordInfo>() {	
			@Override public List<PayordInfo> parseResult(PayordInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PayordInfo> finalResult = new ArrayList<>();
				recordInfo.codPayOrder = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
