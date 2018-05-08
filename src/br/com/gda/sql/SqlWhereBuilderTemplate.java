package br.com.gda.sql;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.gda.common.SystemMessage;

abstract class SqlWhereBuilderTemplate implements SqlWhereBuilder {	
	private final boolean OK = true;
	private final boolean FAIL = false;
	private final boolean SKIP = true;
	private final boolean NOT_PRIMARY_KEY = false;
	private final boolean NO_COLUMN_ADDED = false;
	private final boolean HAS_COLUMN_ADDED = true;
	private final boolean NO_DUMMY_CLAUSE = false;
	private final boolean DUMMY_CLAUSE_REQUESTED = true;
	
	private SqlWhereBuilderOption option;
	private List<DataClause> dataClauses = new ArrayList<>();
	
	
	
	public SqlWhereBuilderTemplate() {
		this(new SqlWhereBuilderOption());
	}
	
	
	
	public SqlWhereBuilderTemplate(SqlWhereBuilderOption option) {
		this.option = option;
	}
	
	
	
	public void appendClauseWithAnd(SqlColumn column, String conditionValue) {
		appendClause(column, conditionValue, SqlDictionary.AND);
	}
	
	
	
	public void appendClauseWithOr(SqlColumn column, String conditionValue) {
		appendClause(column, conditionValue, SqlDictionary.OR);
	}
	
	
	
	private void appendClause(SqlColumn column, String conditionValue, String logicalOperator) {
		if (shouldSkipColumn(column, conditionValue) == SKIP)
			return;

		DataClause clause = new DataClause();
		clause.tableName = column.tableName;
		clause.columnName = column.columnName;
		clause.conditionValue = conditionValue;
		clause.logicalOperator = logicalOperator;
		this.dataClauses.add(clause);
	}
	
	
	
	private boolean shouldSkipColumn(SqlColumn column, String conditionValue) {
		if (conditionValue == null && this.option.ignoreNull)
			return true;
		
		if (column.isPK == NOT_PRIMARY_KEY && this.option.ignoreNonPrimaryKey)
			return true;
		
		if (column.columnName.equals("record_mode")  && this.option.ignoreRecordMode)
			return true;
		
		return false;
	}	
	
	
	
	public String generateClause() {		
		StringBuilder resultClause = new StringBuilder();
		
		resultClause.append(SqlDictionary.PARENTHESIS_OPENING);
		resultClause.append(generateClauseWithoutParentheses());
		resultClause.append(SqlDictionary.PARENTHESIS_CLOSING);
		
		return resultClause.toString();
	}
	
	
	
	public String generateClauseWithoutParentheses() {
		if (checkClauseGeneration() == FAIL)
			throw new IllegalStateException(SystemMessage.SQL_WHERE_CLAUSE_HAS_NO_COLUMN);
		
		if (hasColumnAdded() == NO_COLUMN_ADDED && option.dummyClauseWhenEmpty == DUMMY_CLAUSE_REQUESTED)
			return dummyClause();
		
		
		StringBuilder resultClause = new StringBuilder();
		Iterator<DataClause> dataClauseItr = this.dataClauses.iterator();
		
		while (dataClauseItr.hasNext()) {
			DataClause eachDataClause = dataClauseItr.next();
			String clause = buildWhereClause(eachDataClause.tableName, eachDataClause.columnName, eachDataClause.conditionValue);
			
			resultClause.append(clause);
			
			if (dataClauseItr.hasNext()) {
				resultClause.append(SqlDictionary.SPACE);
				resultClause.append(eachDataClause.logicalOperator);
				resultClause.append(SqlDictionary.SPACE);
			}
		}
		
		return resultClause.toString();
	}
	
	
	
	public boolean checkClauseGeneration() {
		if (hasColumnAdded() == NO_COLUMN_ADDED && option.dummyClauseWhenEmpty == NO_DUMMY_CLAUSE)
			return FAIL;
		
		return OK;
	}
	
	
	
	private boolean hasColumnAdded() {
		if (this.dataClauses == null || this.dataClauses.isEmpty())
			return NO_COLUMN_ADDED;
		
		return HAS_COLUMN_ADDED;
	}
	
	
	
	private String dummyClause() {
		return "1 = 1";
	}
	
	
	
	private String buildWhereClause(String tableName, String columnName, String conditionValue) {		
		if (conditionValue == null)
			return buildClauseIsNull(tableName, columnName);
		
		return buildWhereClauseHook(tableName, columnName, conditionValue);
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
		
	
	
	protected String buildWhereClauseHook(String tableName, String columnName, String conditionValue) {		
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	

	
		
	private static class DataClause {
		private String tableName;
		private String columnName; 
		private String conditionValue; 
		private String logicalOperator;		
	}
}