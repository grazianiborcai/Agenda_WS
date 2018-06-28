package br.com.gda.business.storeLeaveDate.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.sql.SqlDbTable;
import br.com.gda.sql.SqlDbTableColumnAll;
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

public final class StoreLDateSelectSingle implements SqlStmt<StoreLDateInfo> {	
	private final String LT_STORE_LEAVE_DATE = SqlDbTable.STORE_LD_TABLE;
	private final String RT_STORE = SqlDbTable.STORE_TABLE;
	
	private SqlStmt<StoreLDateInfo> stmtSql;
	private SqlStmtOption<StoreLDateInfo> stmtOption;
	
	
	
	public StoreLDateSelectSingle(Connection conn, StoreLDateInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, StoreLDateInfo recordInfo, String schemaName) {
		this.stmtOption = new SqlStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_STORE_LEAVE_DATE;
		this.stmtOption.columns = SqlDbTableColumnAll.getTableColumnsAsList(LT_STORE_LEAVE_DATE);
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
		
		SqlStmtWhere whereClause = new StoreLDateWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<SqlJoin> buildJoins() {
		List<SqlJoin> joins = new ArrayList<>();		
		joins.add(buildJoinStore());
		return joins;
	}
	
	
	
	private SqlJoin buildJoinStore() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		
		SqlJoinColumn oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LT_STORE_LEAVE_DATE;
		oneColumn.leftColumnName = "Cod_store";
		oneColumn.rightColumnName = "Cod_store";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		join.rightTableName = RT_STORE;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
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

	
	
	@Override public List<StoreLDateInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public SqlStmt<StoreLDateInfo> getNewInstance() {
		return new StoreLDateSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements SqlResultParser<StoreLDateInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final String TIMEZONE_COL = SqlDbTable.STORE_TABLE + "." + "Cod_timezone";
		
		@Override public List<StoreLDateInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StoreLDateInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				StoreLDateInfo dataInfo = new StoreLDateInfo();
				dataInfo.codOwner = stmtResult.getLong("cod_owner");
				dataInfo.codStore = stmtResult.getLong("cod_store");
				dataInfo.description = stmtResult.getString("description");	
				dataInfo.codTimezone = stmtResult.getString(TIMEZONE_COL);
				dataInfo.recordMode = stmtResult.getString("record_mode");		
				
				Time tempTime = stmtResult.getTime("time_valid_from");
				if (tempTime != null)
					dataInfo.timeValidFrom = tempTime.toLocalTime();
				
				tempTime = stmtResult.getTime("time_valid_to");
				if (tempTime != null)
					dataInfo.timeValidTo = tempTime.toLocalTime();	
				
				Date tempDate = stmtResult.getDate("date_valid_from");
				if (tempDate != null)
					dataInfo.dateValidFrom = tempDate.toLocalDate();
				
				tempDate = stmtResult.getDate("date_valid_to");
				if (tempDate != null)
					dataInfo.dateValidTo = tempDate.toLocalDate();
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
