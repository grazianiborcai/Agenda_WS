package br.com.gda.business.scheduleMoviment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.scheduleMoviment.info.SchedovmInfo;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public class SchedovmInsertSingle implements DaoStmt<SchedovmInfo> {
	private DaoStmt<SchedovmInfo> stmtSql;
	private DaoStmtOption<SchedovmInfo> stmtOption;
	
	
	
	public SchedovmInsertSingle(Connection conn, SchedovmInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, SchedovmInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = DaoDbTable.SCHEDULE_MOVIMENT_TABLE;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(stmtOption.tableName);
		stmtOption.stmtParamTranslator = new ParamTranslator();
		stmtOption.resultParser = null;
		stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper<>(DaoOperation.INSERT, stmtOption, this.getClass());
	}
		
	
	
	@Override public void generateStmt() throws SQLException {
		stmtSql.generateStmt();		
	}

	
	
	@Override public boolean checkStmtGeneration() {
		return stmtSql.checkStmtGeneration();
	}

	
	
	@Override public void executeStmt() throws SQLException {
		stmtSql.executeStmt();
	}

	
	
	@Override public List<SchedovmInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<SchedovmInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, SchedovmInfo recordInfo) throws SQLException {			
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codMat);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployee);
			stmt.setDate(i++, DaoFormatter.localToSqlDate(recordInfo.date));
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.day);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.month);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.year);
			stmt.setInt(i++, recordInfo.confirmed);
			stmt.setInt(i++, recordInfo.waiting);
			stmt.setInt(i++, recordInfo.counter);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codWeekday);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.weekMonth);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.weekYear);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<SchedovmInfo> getNewInstance() {
		return new SchedovmInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
