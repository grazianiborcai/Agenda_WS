package br.com.mind5.security.otpUserPassword.dao;

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
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;

public final class OtperasDaoUpdateSingle extends DaoStmtTemplate<OtperasInfo> {
	private final String MAIN_TABLE = DaoDbTable.OTP_USER_PASSWORD_TABLE;
	
	
	public OtperasDaoUpdateSingle(Connection conn, OtperasInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OtperasInfo recordInfo) {	
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new OtperasDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<OtperasInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<OtperasInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, OtperasInfo recordInfo) throws SQLException {				
				int i = 1;			
				
				stmt = DaoFormatter.base64ToStmt(stmt, i++, recordInfo.hash);
				stmt = DaoFormatter.base64ToStmt(stmt, i++, recordInfo.salt);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.validUntil);
				
				return stmt;
			}	
		};
	}
}
