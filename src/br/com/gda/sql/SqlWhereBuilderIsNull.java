package br.com.gda.sql;

final class SqlWhereBuilderIsNull extends SqlWhereBuilderAbstract {
	SqlWhereBuilderIsNull() {
		super(false);
	}
	
	
	SqlWhereBuilderIsNull(boolean ignoreNullCondition) {
		super(false);
	}
	
	
	@Override protected String buildWhereClauseHook(String columnName, String conditionValue) {				
		StringBuilder resultClause = new StringBuilder();
		resultClause.append(columnName);
		resultClause.append(SqlDictionary.SPACE);
		resultClause.append(SqlOperator.IS_NULL.toString());
		
		return resultClause.toString();
	}
}
