package br.com.mind5.masterData.materialGroupOwner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;

public final class MatoupowDaoInsertSingle extends DaoStmtTemplate<MatoupowInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_GROUP_OWNER_TABLE;		
	
	
	public MatoupowDaoInsertSingle(Connection conn, MatoupowInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<MatoupowInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<MatoupowInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, MatoupowInfo recordInfo) throws SQLException {				
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codGroup);
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setBoolean(i++, recordInfo.isLocked);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.rgbDecBlue);	
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.rgbDecGreen);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.rgbDecRed);
				stmt.setString(i++, recordInfo.rgbHex);
				
				return stmt;
			}		
		};
	}
}
