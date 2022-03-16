package br.com.mind5.payment.storePartner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class StoparDaoInsertSingle extends DaoStmtTemplate<StoparInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_PARTNER_STORE_TABLE;	
	
	
	public StoparDaoInsertSingle(Connection conn, StoparInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<StoparInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<StoparInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StoparInfo recordInfo) throws SQLException {					
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt.setLong(i++, recordInfo.codOwner);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPayPartner);
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
