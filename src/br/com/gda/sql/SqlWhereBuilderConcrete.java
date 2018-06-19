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
	private List<BuilderToMerger> builders = new ArrayList<>();
	
	
	
	public SqlWhereBuilderConcrete() {
		this(new SqlWhereBuilderOption());
	}
	
	
	
	public SqlWhereBuilderConcrete(SqlWhereBuilderOption option) {
		checkArgument(option);		
		this.option = option;
	}
	
	
	
	private void checkArgument(SqlWhereBuilderOption option) {
		if (option == null)
			throw new NullPointerException("option" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	public void addClauseEqualAnd(SqlColumn column, String value) {
		addClauseAnd(column, value, SqlWhereCondition.EQUAL);
	}
	
	
	
	public void addClauseAnd(SqlColumn column, String value, SqlWhereCondition condition) {
		appendClause(column, value, SqlWhereOperator.AND.getSymbol(), condition);
	}
	
	
	
	public void addClauseOr(SqlColumn column, String value, SqlWhereCondition condition) {
		appendClause(column, value, SqlWhereOperator.OR.getSymbol(), condition);
	}
	
	
	
	private void appendClause(SqlColumn column, String value, String operator, SqlWhereCondition condition) {
		if (shouldSkipColumn(column, value))
			return;

		DataClause clause = new DataClause();
		clause.tableName = column.tableName;
		clause.columnName = column.columnName;
		clause.columnValue = value;
		clause.operator = operator;
		clause.condition = condition.getSymbol();
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
	
	
	
	public void mergeBuilder(SqlWhereBuilder builder, SqlWhereOperator operator) {
		checkArgument(builder, operator);
		
		BuilderToMerger builderToMerge = new BuilderToMerger();
		builderToMerge.builder = builder;
		builderToMerge.operator = operator;
		
		builders.add(builderToMerge);
	}
	
	
	
	private void checkArgument(SqlWhereBuilder builder, SqlWhereOperator operator) {
		if (builder == null)
			throw new NullPointerException("builder" + SystemMessage.NULL_ARGUMENT);
		
		if (operator == null)
			throw new NullPointerException("operator" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	public String generateClause() {		
		tryToCheckBeforeGeneration();		
		
		if (shouldReturnDummy())
			return dummyClause();
		
		return generate();
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
	
	
	
	private boolean shouldReturnDummy() {
		if (isDataClauseEmpty() == IS_EMPTY && option.dummyClauseWhenEmpty == DUMMY_CLAUSE_REQUESTED)
			return true;
		
		return false;
	}
	
	
	
	private boolean isDataClauseEmpty() {
		if (this.dataClauses == null || this.dataClauses.isEmpty())
			return IS_EMPTY;
		
		return HAS_COLUMN_ADDED;
	}
	
	
	
	private String dummyClause() {
		return "1 = 1";
	}
	
	
	
	private String generate() {	
		StringBuilder resultClause = new StringBuilder();
		Iterator<DataClause> dataClauseItr = this.dataClauses.iterator();
		
		while (dataClauseItr.hasNext()) {
			DataClause eachData = dataClauseItr.next();
			String clause = buildWhereClause(eachData.tableName, eachData.columnName, eachData.columnValue, eachData.condition);
			
			resultClause.append(clause);
			
			if (dataClauseItr.hasNext()) {
				resultClause.append(SqlDictionary.SPACE);
				resultClause.append(eachData.operator);
				resultClause.append(SqlDictionary.SPACE);
			}
		}
		
		
		return mergeResult(resultClause.toString());
	}
	
	
	
	private String mergeResult(String resultToMerge) {
		if (builders.isEmpty())
			return resultToMerge;
		
		StringBuilder result = new StringBuilder();
		result.append(SqlDictionary.PARENTHESIS_OPENING);
		result.append(resultToMerge);
		result.append(SqlDictionary.PARENTHESIS_CLOSING);
		
		
		for (BuilderToMerger eachBuilder : builders) {
			result.append(SqlDictionary.SPACE);
			result.append(eachBuilder.operator.getSymbol());
			result.append(SqlDictionary.SPACE);
			result.append(SqlDictionary.PARENTHESIS_OPENING);
			result.append(eachBuilder.builder.generateClause());
			result.append(SqlDictionary.PARENTHESIS_CLOSING);
		}
		
		
		return result.toString();
	}
	
	
	
	private String buildWhereClause(String tableName, String columnName, String value, String condition) {		
		if (value == null)
			return buildClauseIsNull(tableName, columnName);
		
		StringBuilder resultClause = new StringBuilder();
		resultClause.append(tableName);
		resultClause.append(SqlDictionary.PERIOD);
		resultClause.append(columnName);
		resultClause.append(SqlDictionary.SPACE);
		resultClause.append(condition);
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
		private String condition;
	}
	
	
	
	
	private static class BuilderToMerger {
		private SqlWhereBuilder builder;
		private SqlWhereOperator operator;		
	}
}