package br.com.mind5.security.otpUserPassword.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;

public final class OtperasDaoInsertSingle extends DaoStmtTemplate<OtperasInfo> {
	private final String MAIN_TABLE = DaoDbTable.OTP_USER_PASSWORD_TABLE;
	
	
	public OtperasDaoInsertSingle(Connection conn, OtperasInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<OtperasInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<OtperasInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, OtperasInfo recordInfo) throws SQLException {
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codUser);
				stmt.setLong(i++, recordInfo.codOwner);				
				stmt = DaoFormatter.base64ToStmt(stmt, i++, recordInfo.hash);
				stmt = DaoFormatter.base64ToStmt(stmt, i++, recordInfo.salt);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.validUntil);
				
				return stmt;
			}		
		};
	}
}
