package br.com.gda.business.store.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.sql.DbTable;
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

public final class StoreEmpSelect implements SqlStmt<StoreEmpInfo> {	
	private final String LEFT_TABLE_STORE_EMPLOYEE = DbTable.STORE_EMPLOYEE_TABLE;	
	private final String RIGHT_TABLE_EMPLOYEE = DbTable.EMPLOYEE_TABLE;	
	private final String RIGHT_TABLE_STORE = DbTable.STORE_TABLE;	
	private final String RIGHT_TABLE_POSITION_TEXT = DbTable.POSITION_TEXT_TABLE;
	
	private SqlStmt<StoreEmpInfo> stmtSql;
	private SqlStmtOption<StoreEmpInfo> stmtOption;
	
	
	
	public StoreEmpSelect(Connection conn, StoreEmpInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, StoreEmpInfo recordInfo, String schemaName) {
		this.stmtOption = new SqlStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LEFT_TABLE_STORE_EMPLOYEE;
		this.stmtOption.columns = StoreDbTableColumn.getTableColumnsAsList(LEFT_TABLE_STORE_EMPLOYEE);
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
		
		SqlStmtWhere whereClause = new StoreEmpWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<SqlJoin> buildJoins() {
		List<SqlJoin> joins = new ArrayList<>();		
		joins.add(buildJoinPositionText());		
		joins.add(buildJoinStore());	
		joins.add(buildJoinEmployee());
		return joins;
	}
	
	
	
	private SqlJoin buildJoinPositionText() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		
		SqlJoinColumn oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LEFT_TABLE_STORE_EMPLOYEE;
		oneColumn.leftColumnName = "Cod_position_store";
		oneColumn.rightColumnName = "Cod_position";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		join.rightTableName = RIGHT_TABLE_POSITION_TEXT;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RIGHT_TABLE_POSITION_TEXT);
		
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
	
	
	
	private SqlJoin buildJoinStore() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		SqlJoinColumn oneColumn;
		
		oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LEFT_TABLE_STORE_EMPLOYEE;
		oneColumn.leftColumnName = "Cod_owner";
		oneColumn.rightColumnName = "Cod_owner";
		joinColumns.add(oneColumn);
		
		oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LEFT_TABLE_STORE_EMPLOYEE;
		oneColumn.leftColumnName = "Cod_store";
		oneColumn.rightColumnName = "Cod_store";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		join.rightTableName = RIGHT_TABLE_STORE;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
	}
	
	
	private SqlJoin buildJoinEmployee() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		SqlJoinColumn oneColumn;
		
		oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LEFT_TABLE_STORE_EMPLOYEE;
		oneColumn.leftColumnName = "Cod_owner";
		oneColumn.rightColumnName = "Cod_owner";
		joinColumns.add(oneColumn);
		
		oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LEFT_TABLE_STORE_EMPLOYEE;
		oneColumn.leftColumnName = "Cod_employee";
		oneColumn.rightColumnName = "Cod_employee";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		join.rightTableName = RIGHT_TABLE_EMPLOYEE;
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

	
	
	@Override public List<StoreEmpInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public SqlStmt<StoreEmpInfo> getNewInstance() {
		return new StoreEmpSelect(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements SqlResultParser<StoreEmpInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final String POSITION_TEXT_COLUMN = DbTable.POSITION_TEXT_TABLE + "." + "Name";
		private final String STORE_NAME_COLUMN = DbTable.STORE_TABLE + "." + "Name";
		private final String EMPLOYEE_NAME_COLUMN = DbTable.EMPLOYEE_TABLE + "." + "Name";
		
		@Override public List<StoreEmpInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StoreEmpInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				StoreEmpInfo dataInfo = new StoreEmpInfo();
				dataInfo.codOwner = stmtResult.getLong("cod_owner");
				dataInfo.codStore = stmtResult.getLong("Cod_store");
				dataInfo.codEmployee = stmtResult.getLong("Cod_employee");
				dataInfo.codPositionStore = stmtResult.getLong("Cod_position_store");
				dataInfo.txtPositionStore = stmtResult.getString(POSITION_TEXT_COLUMN);
				dataInfo.nameStore = stmtResult.getString(STORE_NAME_COLUMN);	
				dataInfo.nameEmployee = stmtResult.getString(EMPLOYEE_NAME_COLUMN);	
				dataInfo.recordMode = stmtResult.getString("record_mode");							
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
