package br.com.gda.sql;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.gda.common.SystemMessage;

class SqlWhereBuilderConcrete implements SqlWhereBuilder {	
	private final boolean OK = true;
	private final boolean FAIL = false;
	private final boolean SKIP = true;
	private final boolean DONT_SKIP = false;
	private final boolean NOT_PRIMARY_KEY = false;
	private final boolean IS_EMPTY = true;
	private final boolean HAS_COLUMN_ADDED = false;
	private final boolean NO_DUMMY_CLAUSE = false;
	private final boolean DUMMY_CLAUSE_REQUESTED = true;
	
	private SqlWhereBuilderOption option;
	private List<DataClause> dataClauses = new ArrayList<>();
	
	
	
	public SqlWhereBuilderConcrete() {
		this(new SqlWhereBuilderOption());
	}
	
	
	
	public SqlWhereBuilderConcrete(SqlWhereBuilderOption option) {
		if (option == null)
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);
		
		this.option = option;
	}
	
	
	
	public void addClause(SqlColumn column, String value) {
		appendClause(column, value, SqlDictionary.AND);
	}
	
	
	
	private void appendClause(SqlColumn column, String value, String operator) {
		if (shouldSkipColumn(column, value) == SKIP)
			return;

		DataClause clause = new DataClause();
		clause.tableName = column.tableName;
		clause.columnName = column.columnName;
		clause.columnValue = value;
		clause.operator = operator;
		this.dataClauses.add(clause);
	}
	
	
	
	private boolean shouldSkipColumn(SqlColumn column, String value) {
		if (value == null && option.ignoreNull)
			return SKIP;
		
		if (column.isPK == NOT_PRIMARY_KEY && option.ignoreNonPrimaryKey)
			return SKIP;
		
		if (column.columnName.equals("record_mode")  && option.ignoreRecordMode)
			return SKIP;
		
		return DONT_SKIP;
	}	
	
	
	
	public String generateClause() {		
		tryToCheckBeforeGeneration();		
		
		if (isDataClauseEmpty() == IS_EMPTY && option.dummyClauseWhenEmpty == DUMMY_CLAUSE_REQUESTED)
			return dummyClause();
		
		
		StringBuilder resultClause = new StringBuilder();
		Iterator<DataClause> dataClauseItr = this.dataClauses.iterator();
		
		while (dataClauseItr.hasNext()) {
			DataClause eachData = dataClauseItr.next();
			String clause = buildWhereClause(eachData.tableName, eachData.columnName, eachData.columnValue);
			
			resultClause.append(clause);
			
			if (dataClauseItr.hasNext()) {
				resultClause.append(SqlDictionary.SPACE);
				resultClause.append(eachData.operator);
				resultClause.append(SqlDictionary.SPACE);
			}
		}
		
		return resultClause.toString();
	}
	
	
	
	public boolean checkBeforeGeneration() {
		try {
			tryToCheckBeforeGeneration();
			return OK;
			
		} catch (Exception e) {
			return FAIL;
		}
	}
	
	
	
	private void tryToCheckBeforeGeneration() {
		if (isDataClauseEmpty() == IS_EMPTY && option.dummyClauseWhenEmpty == NO_DUMMY_CLAUSE)
			throw new IllegalStateException(SystemMessage.SQL_WHERE_CLAUSE_HAS_NO_COLUMN);
	}
	
	
	
	private boolean isDataClauseEmpty() {
		if (this.dataClauses == null || this.dataClauses.isEmpty())
			return IS_EMPTY;
		
		return HAS_COLUMN_ADDED;
	}
	
	
	
	private String dummyClause() {
		return "1 = 1";
	}
	
	
	
	private String buildWhereClause(String tableName, String columnName, String value) {		
		if (value == null)
			return buildClauseIsNull(tableName, columnName);
		
		StringBuilder resultClause = new StringBuilder();
		resultClause.append(tableName);
		resultClause.append(SqlDictionary.PERIOD);
		resultClause.append(columnName);
		resultClause.append(SqlDictionary.SPACE);
		resultClause.append(SqlDictionary.EQUAL);
		resultClause.append(SqlDictionary.SPACE);
		resultClause.append(SqlDictionary.QUOTE);
		resultClause.append(value);
		resultClause.append(SqlDictionary.QUOTE);
		
		return resultClause.toString();
	}
	
	
	
	private String buildClauseIsNull(String tableName, String columnName) {				
		StringBuilder resultClause = new StringBuilder();
		resultClause.append(tableName);
		resultClause.append(SqlDictionary.PERIOD);
		resultClause.append(columnName);
		resultClause.append(SqlDictionary.SPACE);
		resultClause.append(SqlDictionary.IS_NULL);
		
		return resultClause.toString();
	}
	
	
	

	
		
	private static class DataClause {
		private String tableName;
		private String columnName; 
		private String columnValue; 
		private String operator;		
	}
}