package br.com.mind5.security.otpProspectStore.dao;

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
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;

public final class DaoOtporeUpdateSingle extends DaoStmtTemplate<OtporeInfo> {
	private final String MAIN_TABLE = DaoDbTable.OTP_PROSPECT_STORE_TABLE;
	
	
	public DaoOtporeUpdateSingle(Connection conn, OtporeInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OtporeInfo recordInfo) {	
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoOtporeWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<OtporeInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<OtporeInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, OtporeInfo recordInfo) throws SQLException {				
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
