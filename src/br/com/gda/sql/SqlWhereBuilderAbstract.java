package br.com.gda.sql;

import java.util.ArrayList;
import java.util.List;

abstract class SqlWhereBuilderAbstract implements SqlWhereBuilder {	
	protected SqlWhereBuilderOption option;
	protected String whereClause;
	protected List<DataClause> dataClauses = new ArrayList<>();
	
	
	
	public SqlWhereBuilderAbstract() {
		this(new SqlWhereBuilderOption());
	}
	
	
	
	public SqlWhereBuilderAbstract(SqlWhereBuilderOption option) {
		this.option = option;
	}
	
	
		
	public boolean isIgnoringNullCondition() {
		return option.isIgnoringNull;
	}
	
		
	
	public void appendClauseWithAnd(String columnName, String conditionValue) {
		appendClause(columnName, conditionValue, SqlDictionary.AND);
	}
		
	
	
	public void appendClauseWithOr(String columnName, String conditionValue) {
		appendClause(columnName, conditionValue, SqlDictionary.OR);
	}
	
	
	
	protected void appendClause(String columnName, String conditionValue, String logicalOperator) {
		if (isSkipBuilding(columnName, conditionValue))
			return;
		
		if (this.whereClause == null) {
			insertClause(columnName, conditionValue);
			return;
		}

		DataClause clause = new DataClause();
		clause.columnName = columnName;
		clause.conditionValue = conditionValue;
		clause.logicalOperator = logicalOperator;
		this.dataClauses.add(clause);
	}
	
	
	
	protected boolean isSkipBuilding(String columnName, String conditionValue) {
		if (conditionValue == null && this.option.isIgnoringNull)
			return true;
		
		if (columnName.equals("record_mode")  && this.option.isIgnoringRecordMode)
			return true;
		
		return false;
	}	
	
	
	
	protected void insertClause(String columnName, String conditionValue) {
		if (isSkipBuilding(columnName, conditionValue))
			return;
		
		this.whereClause = buildWhereClause(columnName, conditionValue);
	}
	
	
	
	public String generateClause() {		
		StringBuilder resultClause = new StringBuilder();
		resultClause.append(SqlDictionary.PARENTHESIS_OPENING);
		resultClause.append(generateClauseWithoutParentheses());
		resultClause.append(SqlDictionary.PARENTHESIS_CLOSING);
		return resultClause.toString();
	}
	
	
	
	public String generateClauseWithoutParentheses() {
		if (! checkClauseGeneration())
			throw new IllegalStateException();
		
		StringBuilder resultClause = new StringBuilder();
		resultClause.append(this.whereClause);
		
		for (DataClause eachDataClause : this.dataClauses) {
			String clause = buildWhereClause(eachDataClause.columnName, eachDataClause.conditionValue);
			
			resultClause.append(SqlDictionary.SPACE);
			resultClause.append(eachDataClause.logicalOperator);
			resultClause.append(SqlDictionary.SPACE);
			resultClause.append(clause);
		}
		
		return resultClause.toString();
	}
	
	
	
	public boolean checkClauseGeneration() {
		if (this.whereClause == null)
			return false;
		
		return true;
	}
	
	
	
	protected String buildWhereClause(String columnName, String conditionValue) {		
		return buildWhereClauseHook(columnName, conditionValue);
	}
		
	
	
	protected String buildWhereClauseHook(String columnName, String conditionValue) {		
		//Template method to be overridden by subclasses
		return null;
	}
	
	
	protected String buildWhereClauseIsNull(String columnName) {		
		SqlWhereBuilder isNullBuilder = new SqlWhereBuilderIsNull();
		isNullBuilder.appendClauseWithAnd(columnName, null);
		return isNullBuilder.generateClauseWithoutParentheses();
	}
	
	
	
	private static class DataClause {
		protected String columnName; 
		protected String conditionValue; 
		protected String logicalOperator;
	}
}