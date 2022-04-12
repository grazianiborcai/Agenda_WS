package br.com.mind5.business.storeTextSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class StorextsnapDaoInsertSingle extends DaoStmtTemplate<StorextsnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_TEXT_SNAPSHOT_TABLE;	
	
	
	public StorextsnapDaoInsertSingle(Connection conn, StorextsnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<StorextsnapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<StorextsnapInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StorextsnapInfo recordInfo) throws SQLException {
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codStore);
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setString(i++, recordInfo.codLanguage);
				stmt.setLong(i++, recordInfo.codSnapshot);
				stmt.setString(i++, recordInfo.description);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);				
				stmt.setBoolean(i++, recordInfo.isDefault);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				
				return stmt;
			}		
		};
	}
}
