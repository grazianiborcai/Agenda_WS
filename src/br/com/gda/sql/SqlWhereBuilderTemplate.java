package br.com.gda.sql;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.gda.common.SystemMessage;

abstract class SqlWhereBuilderTemplate implements SqlWhereBuilder {	
	private final boolean OK = true;
	private final boolean SKIP = true;
	private final boolean NO_COLUMN_ADDED = false;
	
	private SqlWhereBuilderOption option;
	private List<DataClause> dataClauses = new ArrayList<>();
	
	
	
	public SqlWhereBuilderTemplate() {
		this(new SqlWhereBuilderOption());
	}
	
	
	
	public SqlWhereBuilderTemplate(SqlWhereBuilderOption option) {
		this.option = option;
	}
	
		
	
	public void appendClauseWithAnd(String tableName, String columnName, String conditionValue) {
		appendClause(tableName, columnName, conditionValue, SqlDictionary.AND);
	}
		
	
	
	public void appendClauseWithOr(String tableName, String columnName, String conditionValue) {
		appendClause(tableName, columnName, conditionValue, SqlDictionary.OR);
	}
	
	
	
	private void appendClause(String tableName, String columnName, String conditionValue, String logicalOperator) {
		if (shouldSkipColumn(columnName, conditionValue) == SKIP)
			return;

		DataClause clause = new DataClause();
		clause.tableName = tableName;
		clause.columnName = columnName;
		clause.conditionValue = conditionValue;
		clause.logicalOperator = logicalOperator;
		this.dataClauses.add(clause);
	}
	
	
	
	private boolean shouldSkipColumn(String columnName, String conditionValue) {
		if (conditionValue == null && this.option.isIgnoringNull)
			return true;
		
		if (columnName.equals("record_mode")  && this.option.isIgnoringRecordMode)
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
		if (checkClauseGeneration() == NO_COLUMN_ADDED)
			throw new IllegalStateException(SystemMessage.SQL_WHERE_CLAUSE_HAS_NO_COLUMN);
		
		
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
		if (this.dataClauses == null || this.dataClauses.isEmpty())
			return NO_COLUMN_ADDED;
		
		return OK;
	}
	
	
	
	private String buildWhereClause(String tableName, String columnName, String conditionValue) {		
		return buildWhereClauseHook(tableName, columnName, conditionValue);
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