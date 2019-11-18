package br.com.mind5.business.employeeLeaveDate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class EmplateInsertSingle extends DaoStmtTemplate<EmplateInfo> {
	private final String LT_MAIN = DaoDbTable.EMP_LD_TABLE;	
	
	
	public EmplateInsertSingle(Connection conn, EmplateInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	

	
	@Override protected String getTableNameHook() {
		return LT_MAIN;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<EmplateInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<EmplateInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, EmplateInfo recordInfo) throws SQLException {				
				int i = 1;
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setLong(i++, recordInfo.codStore);
				stmt.setLong(i++, recordInfo.codEmployee);
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.dateValidFrom);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.timeValidFrom);
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.dateValidTo);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.timeValidTo);
				stmt.setString(i++, recordInfo.description);
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
