package br.com.gda.sql;

final class SqlWhereBuilderIsNull extends SqlWhereBuilderTemplate {
	SqlWhereBuilderIsNull() {
		this(new SqlWhereBuilderOption());
	}
	
	
	
	SqlWhereBuilderIsNull(SqlWhereBuilderOption option) {		
		super(enforceOption(option));
	}
	
	
	
	private static SqlWhereBuilderOption enforceOption(SqlWhereBuilderOption option) {
		option.isIgnoringNull = false;
		return option;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, String columnName, String conditionValue) {				
		StringBuilder resultClause = new StringBuilder();
		resultClause.append(tableName);
		resultClause.append(SqlDictionary.PERIOD);
		resultClause.append(columnName);
		resultClause.append(SqlDictionary.SPACE);
		resultClause.append(SqlDictionary.IS_NULL);
		
		return resultClause.toString();
	}
}
