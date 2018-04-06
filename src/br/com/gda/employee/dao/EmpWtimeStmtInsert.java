package br.com.gda.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.sql.SqlStmtOption;
import br.com.gda.sql.SqlStmtParamTranslator;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtHelper;



final class EmpWtimeStmtInsert implements SqlStmt<EmpWTimeInfo> {
	private SqlStmt<EmpWTimeInfo> stmtSql;
	private SqlStmtOption<EmpWTimeInfo> stmtOption;
	
	
	
	public EmpWtimeStmtInsert(Connection conn, EmpWTimeInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
		
	}
	
	
	
	private void buildStmtOption(Connection conn, EmpWTimeInfo recordInfo, String schemaName) {
		this.stmtOption = new SqlStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = EmpDbTable.EMPLOYEE_WORKING_TIME_TABLE;
		this.stmtOption.columns = EmpDbTableColumn.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = null;
		this.stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		final boolean DONT_IGNORE_NULL = false;
		EmpWtimeStmtWhere whereClause = new EmpWtimeStmtWhere(DONT_IGNORE_NULL, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new SqlStmtHelper<>(SqlOperation.INSERT, this.stmtOption);
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

	
	
	@Override public List<EmpWTimeInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements SqlStmtParamTranslator<EmpWTimeInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, EmpWTimeInfo recordInfo) throws SQLException {
			Time beginTime = SqlFormatterNumber.localToSqlTime(recordInfo.beginTime);
			Time endTime = SqlFormatterNumber.localToSqlTime(recordInfo.endTime);				
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codStore);
			stmt.setLong(i++, recordInfo.codEmployee);
			stmt.setInt(i++, recordInfo.weekday);
			stmt.setTime(i++, beginTime);
			stmt.setTime(i++, endTime);
			stmt.setString(i++, recordInfo.recordMode);
			
			return stmt;
		}		
	}
	
	
	@Override public SqlStmt<EmpWTimeInfo> getNewInstance() {
		return new EmpWtimeStmtInsert(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
