package br.com.gda.business.storeWorkTime.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
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
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilderOption;

public final class StoreWTimeSelectSingle implements SqlStmt<StoreWTimeInfo> {	
	private final String LEFT_TABLE_STORE_WORK_TIME = SqlDbTable.STORE_WORK_TIME_TABLE;	
	private final String RIGHT_TABLE_WEEKDAY_TEXT = SqlDbTable.WEEKDAY_TEXT_TABLE;
	
	private SqlStmt<StoreWTimeInfo> stmtSql;
	private SqlStmtOption<StoreWTimeInfo> stmtOption;
	
	
	
	public StoreWTimeSelectSingle(Connection conn, StoreWTimeInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, StoreWTimeInfo recordInfo, String schemaName) {
		this.stmtOption = new SqlStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LEFT_TABLE_STORE_WORK_TIME;
		this.stmtOption.columns = SqlDbTableColumnAll.getTableColumnsAsList(LEFT_TABLE_STORE_WORK_TIME);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		SqlWhereBuilderOption whereOption = new SqlWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		SqlStmtWhere whereClause = new StoreWTimeWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<SqlJoin> buildJoins() {
		List<SqlJoin> joins = new ArrayList<>();		
		joins.add(buildJoinWeekdayText());
		return joins;
	}
	
	
	
	private SqlJoin buildJoinWeekdayText() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		
		SqlJoinColumn oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LEFT_TABLE_STORE_WORK_TIME;
		oneColumn.leftColumnName = "weekday";
		oneColumn.rightColumnName = "Weekday";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		join.rightTableName = RIGHT_TABLE_WEEKDAY_TEXT;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RIGHT_TABLE_WEEKDAY_TEXT);
		
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

	
	
	@Override public List<StoreWTimeInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public SqlStmt<StoreWTimeInfo> getNewInstance() {
		return new StoreWTimeSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements SqlResultParser<StoreWTimeInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final String WEEKDAY_TEXT_COL = SqlDbTable.WEEKDAY_TEXT_TABLE + "." + "Name";
		
		@Override public List<StoreWTimeInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StoreWTimeInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				StoreWTimeInfo dataInfo = new StoreWTimeInfo();
				dataInfo.codOwner = stmtResult.getLong("cod_owner");
				dataInfo.codStore = stmtResult.getLong("cod_store");
				dataInfo.codWeekday = stmtResult.getInt("weekday");
				dataInfo.txtWeekday = stmtResult.getString(WEEKDAY_TEXT_COL);
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
