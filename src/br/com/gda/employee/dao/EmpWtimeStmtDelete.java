package br.com.gda.employee.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtConcrete;
import br.com.gda.sql.SqlStmtOption;

final class EmpWtimeStmtDelete implements SqlStmt<EmpWTimeInfo> {
	private SqlStmt<EmpWTimeInfo> stmtSql;
	private SqlStmtOption<EmpWTimeInfo> stmtOption;
	
	
	public EmpWtimeStmtDelete(SqlStmtOption<EmpWTimeInfo> option) {
		this(option.conn, option.recordInfo, option.schemaName);
	}
	
	
	
	public EmpWtimeStmtDelete(Connection conn, EmpWTimeInfo recordInfo, String schemaName) {
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
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = null;
		this.stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		final boolean DONT_IGNORE_NULL = false;
		EmpWtimeStmtWhere whereClause = new EmpWtimeStmtWhere(DONT_IGNORE_NULL, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new SqlStmtConcrete<>(SqlOperation.DELETE, this.stmtOption);
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
	
	
	/*
	public EmpWtimeStmtDelete(SqlStmtOption<EmpWTimeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected String buildStmtSkeletonHook() {
		EmpWtimeBuilderDelete builder = new EmpWtimeBuilderDelete(option.schemaName, option.recordInfo);
		return builder.generateStatement();
	}
	
	
	
	@Override protected ResultSet executeStmtHook() throws SQLException {
		this.stmt.executeUpdate();
		return null;
	}
	*/
}
