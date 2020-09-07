package br.com.mind5.business.phone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class DaoPhoneInsertSingle extends DaoStmtTemplate<PhoneInfo> {
	private final String MAIN_TABLE = DaoDbTable.PHONE_TABLE;
	
	
	public DaoPhoneInsertSingle(Connection conn, PhoneInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<PhoneInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<PhoneInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PhoneInfo recordInfo) throws SQLException {					
				int i = 1;				
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployee);
				stmt.setInt(i++, recordInfo.codCountryPhone);
				stmt.setString(i++, recordInfo.fullNumber);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt.setString(i++, recordInfo.complement);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwnerRef);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
				stmt.setString(i++, recordInfo.number);
				stmt.setString(i++, recordInfo.codArea);		
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);	
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);				
				stmt.setBoolean(i++, recordInfo.isDefault);
				stmt.setString(i++, recordInfo.phoneName);
	
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<PhoneInfo> getResultParserHook() {
		return new DaoResultParser<PhoneInfo>() {		
			@Override public List<PhoneInfo> parseResult(PhoneInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PhoneInfo> finalResult = new ArrayList<>();
				recordInfo.codPhone = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
