package br.com.gda.sql;

final class SqlWhereBuilderEqual extends SqlWhereBuilderTemplate {
	SqlWhereBuilderEqual() {
		super();
	}
	
	
	
	SqlWhereBuilderEqual(SqlWhereBuilderOption option) {
		super(option);
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, String columnName, String conditionValue) {				
		if (conditionValue == null)
			return buildWhereClauseIsNull(tableName, columnName);
		
		StringBuilder resultClause = new StringBuilder();
		resultClause.append(tableName);
		resultClause.append(SqlDictionary.PERIOD);
		resultClause.append(columnName);
		resultClause.append(SqlDictionary.SPACE);
		resultClause.append(SqlDictionary.EQUAL);
		resultClause.append(SqlDictionary.SPACE);
		resultClause.append(SqlDictionary.QUOTE);
		resultClause.append(conditionValue);
		resultClause.append(SqlDictionary.QUOTE);
		
		return resultClause.toString();
	}
	
	
	
	private String buildWhereClauseIsNull(String tableName, String columnName) {		
		SqlWhereBuilder isNullBuilder = new SqlWhereBuilderIsNull();
		isNullBuilder.appendClauseWithAnd(tableName, columnName, null);
		return isNullBuilder.generateClauseWithoutParentheses();
	}
}