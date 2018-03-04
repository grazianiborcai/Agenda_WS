package br.com.gda.sql;

final class SqlWhereBuilderEqual extends SqlWhereBuilderAbstract {
	SqlWhereBuilderEqual() {
		super();
	}
	
	
	SqlWhereBuilderEqual(boolean ignoreNullCondition) {
		super(ignoreNullCondition);
	}
	
	
	@Override protected String buildWhereClauseHook(String columnName, String conditionValue) {				
		if (conditionValue == null)
			return buildWhereClauseIsNull(columnName);
		
		StringBuilder resultClause = new StringBuilder();
		resultClause.append(columnName);
		resultClause.append(SqlDictionary.SPACE);
		resultClause.append(SqlOperator.EQUAL.toString());
		resultClause.append(SqlDictionary.SPACE);
		resultClause.append(SqlDictionary.QUOTE);
		resultClause.append(conditionValue);
		resultClause.append(SqlDictionary.QUOTE);
		
		return resultClause.toString();
	}
}