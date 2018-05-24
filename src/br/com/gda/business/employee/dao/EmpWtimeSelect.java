package br.com.gda.business.employee.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpWTimeInfo;
import br.com.gda.sql.DbTable;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlResultParser;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtHelper;
import br.com.gda.sql.SqlStmtOption;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilderOption;


final class EmpWtimeSelect implements SqlStmt<EmpWTimeInfo> {
	private SqlStmt<EmpWTimeInfo> stmtSql;
	private SqlStmtOption<EmpWTimeInfo> stmtOption;
	
	
	
	public EmpWtimeSelect(Connection conn, EmpWTimeInfo recordInfo, String schemaName) {
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
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		SqlWhereBuilderOption whereOption = new SqlWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		SqlStmtWhere whereClause = new EmpWtimeWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new SqlStmtHelper<>(SqlOperation.SELECT, this.stmtOption);
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
		return new EmpWtimeSelect(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements SqlResultParser<EmpWTimeInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<EmpWTimeInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<EmpWTimeInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
				return finalResult;
		
			do {				
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
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}