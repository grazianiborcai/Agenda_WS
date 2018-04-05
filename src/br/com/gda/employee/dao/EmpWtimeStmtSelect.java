package br.com.gda.employee.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlResultParser;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtConcrete;
import br.com.gda.sql.SqlStmtOption;
import br.com.gda.sql.SqlWhereBuilder;
import br.com.gda.sql.SqlWhereBuilderOption;


final class EmpWtimeStmtSelect implements SqlStmt<EmpWTimeInfo> {
	private SqlStmt<EmpWTimeInfo> stmtSql;
	private SqlStmtOption<EmpWTimeInfo> stmtOption;
	
	public EmpWtimeStmtSelect(SqlStmtOption<EmpWTimeInfo> option) {
		this(option.conn, option.recordInfo, option.schemaName);
	}
	
	
	
	public EmpWtimeStmtSelect(Connection conn, EmpWTimeInfo recordInfo, String schemaName) {
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
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		SqlWhereBuilder builder = SqlWhereBuilder.factory(new SqlWhereBuilderOption());
		
		builder.appendClauseWithAnd("cod_owner", SqlFormatterNumber.numberToString(stmtOption.recordInfo.codOwner));
		builder.appendClauseWithAnd("cod_store", SqlFormatterNumber.numberToString(stmtOption.recordInfo.codStore));
		builder.appendClauseWithAnd("cod_employee", SqlFormatterNumber.numberToString(stmtOption.recordInfo.codEmployee));
		builder.appendClauseWithAnd("weekday", SqlFormatterNumber.numberToString(stmtOption.recordInfo.weekday));
		builder.appendClauseWithAnd("record_mode", RecordMode.RECORD_OK);
		
		return builder.generateClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new SqlStmtConcrete<>(SqlOperation.SELECT, this.stmtOption);
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
	
	
	
	private class ResultParser implements SqlResultParser<EmpWTimeInfo> {
		@Override public List<EmpWTimeInfo> parseResult(ResultSet stmtResult) throws SQLException {
			List<EmpWTimeInfo> finalResult = new ArrayList<>();
			
			while (stmtResult.next()) {
				if (stmtResult.getLong("cod_employee") <= 0)
					return finalResult;
				
				EmpWTimeInfo dataInfo = new EmpWTimeInfo();
				dataInfo.codOwner = stmtResult.getLong("cod_owner");
				dataInfo.codStore = stmtResult.getLong("cod_store");
				dataInfo.codEmployee = stmtResult.getLong("cod_employee");
				dataInfo.weekday = stmtResult.getInt("weekday");
				dataInfo.recordMode = stmtResult.getString("record_mode");
				
				Time tempTime = stmtResult.getTime("begin_time");
				if (tempTime != null)
					dataInfo.beginTime = tempTime.toLocalTime();
				
				tempTime = stmtResult.getTime("end_time");
				if (tempTime != null)
					dataInfo.endTime = tempTime.toLocalTime();
				
				
				finalResult.add(dataInfo);
			}
			
			return finalResult;
		}
	}
}