package br.com.mind5.business.scheduleMoviment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public class SchedovmInsertSingle extends DaoStmtTemplate<SchedovmInfo> {
	private final String MAIN_TABLE = DaoDbTable.SCHEDULE_MOVIMENT_TABLE;
	
	
	public SchedovmInsertSingle(Connection conn, SchedovmInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<SchedovmInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<SchedovmInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, SchedovmInfo recordInfo) throws SQLException {	
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codMat);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployee);
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.date);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.day);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.month);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.year);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.confirmed);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.waiting);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.counter);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codWeekday);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.weekMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.weekYear);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
				
				return stmt;
			}		
		};
	}
}
