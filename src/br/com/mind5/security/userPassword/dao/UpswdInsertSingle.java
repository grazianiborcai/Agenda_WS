package br.com.mind5.security.userPassword.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class UpswdInsertSingle extends DaoStmtTemplate<UpswdInfo> {
	private final String MAIN_TABLE = DaoDbTable.USER_PASSWORD_TABLE;
	
	
	public UpswdInsertSingle(Connection conn, UpswdInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<UpswdInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<UpswdInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, UpswdInfo recordInfo) throws SQLException {
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setLong(i++, recordInfo.codUser);
				stmt = DaoFormatter.base64ToStmt(stmt, i++, recordInfo.hash);
				stmt = DaoFormatter.base64ToStmt(stmt, i++, recordInfo.salt);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				
				return stmt;
			}		
		};
	}
}
