package br.com.mind5.business.employeePosition.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class EmposDaoInsertSingle extends DaoStmtTemplate<EmposInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMPOS_TABLE;	
	
	
	public EmposDaoInsertSingle(Connection conn, EmposInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}	
	
	
	
	@Override protected DaoStmtParamTranslator<EmposInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<EmposInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, EmposInfo recordInfo) throws SQLException {
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setLong(i++, recordInfo.codStore);
				stmt.setLong(i++, recordInfo.codEmployee);
				stmt.setInt(i++, recordInfo.codPosition);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);			
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
