package br.com.mind5.security.otpProspectStore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;

public final class DaoUpswdInsertSingle extends DaoStmtTemplate<OtporeInfo> {
	private final String MAIN_TABLE = DaoDbTable.USER_PASSWORD_TABLE;
	
	
	public DaoUpswdInsertSingle(Connection conn, OtporeInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<OtporeInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<OtporeInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, OtporeInfo recordInfo) throws SQLException {
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setLong(i++, recordInfo.prospectEmail);
				stmt = DaoFormatter.base64ToStmt(stmt, i++, recordInfo.hash);
				stmt = DaoFormatter.base64ToStmt(stmt, i++, recordInfo.salt);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				
				return stmt;
			}		
		};
	}
}
