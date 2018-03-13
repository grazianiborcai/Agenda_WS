package br.com.gda.sql;

public interface SqlWhereBuilder {	
	public static SqlWhereBuilder factory() {
		boolean DO_IGNORE_NULL_CONDITION = true;
		return factory(DO_IGNORE_NULL_CONDITION);
	}
	
	
	
	public static SqlWhereBuilder factory(boolean ignoreNullCondition) {
		return new SqlWhereBuilderEqual(ignoreNullCondition);
	}
	
	
	
	public boolean isIgnoringNullCondition();
	

	public void appendClauseWithAnd(String columnName, String conditionValue);

	
	public void appendClauseWithOr(String columnName, String conditionValue);

	
	public String generateClause();
	
	
	public String generateClauseWithoutParentheses();

	
	public boolean checkClauseGeneration();
}
