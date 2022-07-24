package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class PeresmoipDaoInsertSingle extends DaoStmtTemplate<PeresmoipInfo> {
	private final String MAIN_TABLE = DaoDbTable.MOIP_PERMISSION_RESPONSE_TABLE;
	
	
	public PeresmoipDaoInsertSingle(Connection conn, PeresmoipInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<PeresmoipInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<PeresmoipInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PeresmoipInfo recordInfo) throws SQLException {					
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt.setLong(i++, recordInfo.codOwner);				
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt.setBoolean(i++, recordInfo.isExpected);
				stmt.setString(i++, recordInfo.username);				
				
				return stmt;
			}		
		};
	}
}
