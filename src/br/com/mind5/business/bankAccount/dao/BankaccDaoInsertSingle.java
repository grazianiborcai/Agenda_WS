package br.com.mind5.business.bankAccount.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class BankaccDaoInsertSingle extends DaoStmtTemplate<BankaccInfo> {
	private final String MAIN_TABLE = DaoDbTable.BANK_ACCOUNT_TABLE;	
	
	
	public BankaccDaoInsertSingle(Connection conn, BankaccInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<BankaccInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<BankaccInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, BankaccInfo recordInfo) throws SQLException {
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);	
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt.setString(i++, recordInfo.accountNumber);
				stmt.setString(i++, recordInfo.branchCheckDigit);
				stmt.setInt(i++, recordInfo.codBankHolderType);
				stmt.setInt(i++, recordInfo.codBankAccountType);
				stmt.setString(i++, recordInfo.branchNumber);
				stmt.setString(i++, recordInfo.accountCheckDigit);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codBank);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt.setString(i++, recordInfo.holderName);
				stmt.setString(i++, recordInfo.holderDocument);
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<BankaccInfo> getResultParserHook() {
		return new DaoResultParser<BankaccInfo>() {		
			@Override public List<BankaccInfo> parseResult(BankaccInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<BankaccInfo> finalResult = new ArrayList<>();
				recordInfo.codBankAccount = lastId;

				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
