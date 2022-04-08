package br.com.mind5.business.materialTextSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class MatextsnapDaoInsertSingle extends DaoStmtTemplate<MatextsnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_TEXT_SNAPSHOT_TABLE;	
	
	
	public MatextsnapDaoInsertSingle(Connection conn, MatextsnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<MatextsnapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<MatextsnapInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, MatextsnapInfo recordInfo) throws SQLException {
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codMat);
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setString(i++, recordInfo.codLanguage);
				stmt.setLong(i++, recordInfo.codSnapshot);
				stmt.setString(i++, recordInfo.txtMat);
				stmt.setString(i++, recordInfo.description);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);				
				stmt.setBoolean(i++, recordInfo.isDefault);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt.setString(i++, recordInfo.txtMatSearch);
				
				return stmt;
			}		
		};
	}
}
