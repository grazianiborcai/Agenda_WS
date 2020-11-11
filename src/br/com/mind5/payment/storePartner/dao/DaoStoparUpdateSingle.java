package br.com.mind5.payment.storePartner.dao;

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
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class DaoStoparUpdateSingle extends DaoStmtTemplate<StoparInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_PARTNER_STORE_TABLE;	
	
	
	public DaoStoparUpdateSingle(Connection conn, StoparInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StoparInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new DaoStoparWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<StoparInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<StoparInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StoparInfo recordInfo) throws SQLException {					
				int i = 1;
				
				stmt.setString(i++, recordInfo.recordMode);			
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt.setString(i++, recordInfo.codePayPartnerStore);
				stmt.setString(i++, recordInfo.idPayPartnerStore);			
				stmt.setString(i++, recordInfo.accessToken);
				stmt.setString(i++, recordInfo.refreshToken);
				stmt.setString(i++, recordInfo.scope);
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.tokenExpiresIn);				
				
				return stmt;
			}	
		};
	}
}
