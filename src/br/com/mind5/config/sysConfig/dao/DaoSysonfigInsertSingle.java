package br.com.mind5.config.sysConfig.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.config.sysConfig.info.SysonfigInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class DaoSysonfigInsertSingle extends DaoStmtTemplate<SysonfigInfo> {
	private final String MAIN_TABLE = DaoDbTable.SYS_CONFIG_TABLE;		
	
	
	public DaoSysonfigInsertSingle(Connection conn, SysonfigInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<SysonfigInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<SysonfigInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, SysonfigInfo recordInfo) throws SQLException {		
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setString(i++, recordInfo.ownerSignup);
				stmt.setString(i++, recordInfo.storePartitioning);
				
				return stmt;
			}		
		};
	}
}
