package br.com.mind5.business.employeeLunchTime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class EmplutmDaoInsertSingle extends DaoStmtTemplate<EmplutmInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMP_LT_TABLE;		
	
	
	public EmplutmDaoInsertSingle(Connection conn, EmplutmInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<EmplutmInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<EmplutmInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, EmplutmInfo recordInfo) throws SQLException {				
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setLong(i++, recordInfo.codStore);
				stmt.setLong(i++, recordInfo.codEmployee);
				stmt.setInt(i++, recordInfo.codWeekday);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.beginTime);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.endTime);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
				
				return stmt;
			}		
		};
	}
}
