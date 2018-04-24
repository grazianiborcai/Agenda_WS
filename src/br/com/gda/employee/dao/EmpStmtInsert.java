package br.com.gda.employee.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.info.EmpInfo;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlResultParser;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtHelper;
import br.com.gda.sql.SqlStmtOption;
import br.com.gda.sql.SqlStmtParamTranslator;
import br.com.gda.sql.SqlWhereBuilderOption;

final class EmpStmtInsert implements SqlStmt<EmpInfo> {	
	private SqlStmt<EmpInfo> stmtSql;
	private SqlStmtOption<EmpInfo> stmtOption;
	
	
	
	public EmpStmtInsert(Connection conn, EmpInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
		
	}
	
	
	
	private void buildStmtOption(Connection conn, EmpInfo recordInfo, String schemaName) {
		this.stmtOption = new SqlStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = EmpDbTable.EMPLOYEE_TABLE;
		this.stmtOption.columns = EmpDbTableColumn.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		final boolean DONT_IGNORE_NULL = false;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		SqlWhereBuilderOption whereOption = new SqlWhereBuilderOption();
		whereOption.isIgnoringNull = DONT_IGNORE_NULL;
		whereOption.isIgnoringRecordMode = DONT_IGNORE_RECORD_MODE;
		
		EmpStmtWhere whereClause = new EmpStmtWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<EmpInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements SqlStmtParamTranslator<EmpInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, EmpInfo recordInfo) throws SQLException {
			Time beginTime = SqlFormatterNumber.localToSqlTime(recordInfo.beginTime);
			Time endTime = SqlFormatterNumber.localToSqlTime(recordInfo.endTime);	
			Date birthDate = SqlFormatterNumber.localToSqlDate(recordInfo.birthDate);
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setString(i++, recordInfo.cpf);
			stmt.setString(i++, recordInfo.name);
			stmt.setInt(i++, recordInfo.codGender);
			stmt.setDate(i++, birthDate);
			stmt.setString(i++, recordInfo.email);
			stmt.setString(i++, recordInfo.address1);
			stmt.setString(i++, recordInfo.address2);
			stmt.setLong(i++, recordInfo.postalCode);
			stmt.setString(i++, recordInfo.city);
			stmt.setString(i++, recordInfo.codCountry);
			stmt.setString(i++, recordInfo.stateProvince);
			stmt.setString(i++, recordInfo.phone);			
			stmt.setTime(i++, beginTime);
			stmt.setTime(i++, endTime);
			stmt.setLong(i++, recordInfo.codPosition);
			stmt.setString(i++, recordInfo.recordMode);
			
			return stmt;
		}		
	}
	
	
	
	@Override public SqlStmt<EmpInfo> getNewInstance() {
		return new EmpStmtInsert(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements SqlResultParser<EmpInfo> {
		@Override public List<EmpInfo> parseResult(ResultSet stmtResult) throws SQLException {
			List<EmpInfo> finalResult = new ArrayList<>();
			EmpInfo emptyInfo = new EmpInfo();
			finalResult.add(emptyInfo);			
			return finalResult;
		}
	}
}
