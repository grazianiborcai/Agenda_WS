package br.com.mind5.business.storeText.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class DaoStorextInsertSingle extends DaoStmtTemplate<StorextInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_TEXT_TABLE;	
	
	
	public DaoStorextInsertSingle(Connection conn, StorextInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<StorextInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<StorextInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StorextInfo recordInfo) throws SQLException {
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codStore);
				stmt.setLong(i++, recordInfo.codOwner);			
				stmt.setString(i++, recordInfo.codLanguage);
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
