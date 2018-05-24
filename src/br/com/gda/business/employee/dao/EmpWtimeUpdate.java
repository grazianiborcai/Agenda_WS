package br.com.gda.business.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.sql.SqlStmtOption;
import br.com.gda.sql.SqlStmtParamTranslator;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilderOption;
import br.com.gda.business.employee.info.EmpWTimeInfo;
import br.com.gda.sql.DbTable;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlResultParser;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtHelper;

final class EmpWtimeUpdate implements SqlStmt<EmpWTimeInfo> {
	private SqlStmt<EmpWTimeInfo> stmtSql;
	private SqlStmtOption<EmpWTimeInfo> stmtOption;
	
	
	public EmpWtimeUpdate(Connection conn, EmpWTimeInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, EmpWTimeInfo recordInfo, String schemaName) {
		this.stmtOption = new SqlStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DbTable.EMPLOYEE_WORKING_TIME_TABLE;
		this.stmtOption.columns = EmpDbTableColumn.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		final boolean DONT_IGNORE_NULL = false;
		final boolean IGNORE_RECORD_MODE = true;
		
		SqlWhereBuilderOption whereOption = new SqlWhereBuilderOption();
		whereOption.ignoreNull = DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = IGNORE_RECORD_MODE;
		
		SqlStmtWhere whereClause = new EmpWtimeWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new SqlStmtHelper<>(SqlOperation.UPDATE, this.stmtOption);
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
	
	
	
	@Override public SqlStmt<EmpWTimeInfo> getNewInstance() {
		return new EmpWtimeUpdate(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ParamTranslator implements SqlStmtParamTranslator<EmpWTimeInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, EmpWTimeInfo recordInfo) throws SQLException {
			Time beginTime = SqlFormatterNumber.localToSqlTime(recordInfo.beginTime);
			Time endTime = SqlFormatterNumber.localToSqlTime(recordInfo.endTime);				
			
			int i = 1;
			stmt.setTime(i++, beginTime);
			stmt.setTime(i++, endTime);
			stmt.setString(i++, recordInfo.recordMode);
			
			return stmt;
		}		
	}
	
	
	
	private class ResultParser implements SqlResultParser<EmpWTimeInfo> {
		@Override public List<EmpWTimeInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<EmpWTimeInfo> finalResult = new ArrayList<>();
			EmpWTimeInfo emptyInfo = new EmpWTimeInfo();
			finalResult.add(emptyInfo);			
			return finalResult;
		}
	}
}
