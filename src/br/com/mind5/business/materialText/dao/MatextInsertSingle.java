package br.com.mind5.business.materialText.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class MatextInsertSingle extends DaoStmtTemplate<MatextInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_TEXT_TABLE;	
	
	
	public MatextInsertSingle(Connection conn, MatextInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<MatextInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<MatextInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, MatextInfo recordInfo) throws SQLException {
				int i = 1;
				stmt.setLong(i++, recordInfo.codMat);
				stmt.setLong(i++, recordInfo.codOwner);			
				stmt.setString(i++, recordInfo.codLanguage);
				stmt.setString(i++, recordInfo.txtMat);
				stmt.setString(i++, recordInfo.description);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);			
				stmt.setBoolean(i++, recordInfo.isDefault);
				stmt.setString(i++, recordInfo.recordMode);
				
				return stmt;
			}		
		};
	}
}
