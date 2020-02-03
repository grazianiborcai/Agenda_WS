package br.com.mind5.payment.partnerMoip.permissionMoip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class PeresmoipInsertSingle extends DaoStmtTemplate<PeresmoipInfo> {
	private final String MAIN_TABLE = DaoDbTable.MOIP_PERMISSION_RESPONSE_TABLE;
	
	
	public PeresmoipInsertSingle(Connection conn, PeresmoipInfo recordInfo, String schemaName) {
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
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt.setBoolean(i++, recordInfo.isExpected);
				stmt.setString(i++, recordInfo.username);				
				
				return stmt;
			}		
		};
	}
}
