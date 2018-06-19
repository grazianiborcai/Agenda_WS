package br.com.gda.business.employeeWorkTime.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.sql.SqlDbTable;
import br.com.gda.sql.SqlDbTableColumnAll;
import br.com.gda.sql.SqlDictionary;
import br.com.gda.sql.SqlJoin;
import br.com.gda.sql.SqlJoinColumn;
import br.com.gda.sql.SqlJoinType;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlResultParser;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtHelper;
import br.com.gda.sql.SqlStmtOption;

class EmpWTimeSelectTemplate implements SqlStmt<EmpWTimeInfo> {
	private final String LT_EMPLOYEE_WORK_TIME = SqlDbTable.EMPLOYEE_WORKING_TIME_TABLE;	
	private final String RT_WEEKDAY_TEXT = SqlDbTable.WEEKDAY_TEXT_TABLE;
	private final String RT_STORE = SqlDbTable.STORE_TABLE;
	
	private SqlStmt<EmpWTimeInfo> stmtSql;
	private SqlStmtOption<EmpWTimeInfo> stmtOption;
	
	
	
	public EmpWTimeSelectTemplate(Connection conn, EmpWTimeInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, EmpWTimeInfo recordInfo, String schemaName) {
		this.stmtOption = new SqlStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_EMPLOYEE_WORK_TIME;
		this.stmtOption.columns = SqlDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClauseHook(stmtOption.tableName, stmtOption.recordInfo);
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	protected String buildWhereClauseHook(String tableName, EmpWTimeInfo recordInfo) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
		/*
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		SqlWhereBuilderOption whereOption = new SqlWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		SqlStmtWhere whereClause = new EmpWTimeWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
		*/
	}
	
	
	
	private List<SqlJoin> buildJoins() {
		List<SqlJoin> joins = new ArrayList<>();		
		joins.add(buildJoinStore());
		joins.add(buildJoinWeekdayText());		
		return joins;
	}
	
	
	
	private SqlJoin buildJoinStore() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		
		SqlJoinColumn oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LT_EMPLOYEE_WORK_TIME;
		oneColumn.leftColumnName = "cod_store";
		oneColumn.rightColumnName = "Cod_store";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		join.rightTableName = RT_STORE;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
	}
	
	
	
	private SqlJoin buildJoinWeekdayText() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		
		SqlJoinColumn oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LT_EMPLOYEE_WORK_TIME;
		oneColumn.leftColumnName = "weekday";
		oneColumn.rightColumnName = "Weekday";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		join.rightTableName = RT_WEEKDAY_TEXT;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RT_WEEKDAY_TEXT);
		
		return join;
	}
	
	
	
	private String buildJoinConstraintText(String rightTableName) {
		StringBuilder constrainClause = new StringBuilder(); 
		
		constrainClause.append(rightTableName);
		constrainClause.append(SqlDictionary.PERIOD);
		constrainClause.append("Language");
		constrainClause.append(SqlDictionary.SPACE);
		constrainClause.append(SqlDictionary.EQUAL);
		constrainClause.append(SqlDictionary.SPACE);
		constrainClause.append(SqlDictionary.QUOTE);
		constrainClause.append(this.stmtOption.recordInfo.codLanguage);
		constrainClause.append(SqlDictionary.QUOTE);
		
		return constrainClause.toString();
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
		return new EmpWTimeSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements SqlResultParser<EmpWTimeInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final String WEEKDAY_TEXT_COL = SqlDbTable.WEEKDAY_TEXT_TABLE + "." + "Name";
		private final String TIMEZONE_COL = SqlDbTable.STORE_TABLE + "." + "Cod_timezone";
		
		@Override public List<EmpWTimeInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<EmpWTimeInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
				return finalResult;
		
			do {				
				EmpWTimeInfo dataInfo = new EmpWTimeInfo();
				dataInfo.codOwner = stmtResult.getLong("cod_owner");
				dataInfo.codStore = stmtResult.getLong("cod_store");
				dataInfo.codEmployee = stmtResult.getLong("cod_employee");
				dataInfo.codWeekday = stmtResult.getInt("weekday");
				dataInfo.txtWeekday = stmtResult.getString(WEEKDAY_TEXT_COL);
				dataInfo.recordMode = stmtResult.getString("record_mode");
				dataInfo.codTimezone = stmtResult.getString(TIMEZONE_COL);
				
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
