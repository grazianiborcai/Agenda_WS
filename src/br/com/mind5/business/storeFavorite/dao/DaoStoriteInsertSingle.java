package br.com.mind5.business.storeFavorite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class DaoStoriteInsertSingle extends DaoStmtTemplate<StoriteInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_FAVORITE_TABLE;
	
	
	public DaoStoriteInsertSingle(Connection conn, StoriteInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<StoriteInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<StoriteInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StoriteInfo recordInfo) throws SQLException {
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codStore);
				stmt.setLong(i++, recordInfo.codOwner);	
				stmt.setLong(i++, recordInfo.codUser);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				
				return stmt;
			}		
		};
	}
}
