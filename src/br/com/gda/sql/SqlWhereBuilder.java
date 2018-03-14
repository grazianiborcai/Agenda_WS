package br.com.gda.sql;

public interface SqlWhereBuilder {	
	public static SqlWhereBuilder factory() {
		SqlWhereBuilderOption defaultOption = new SqlWhereBuilderOption();
		return factory(defaultOption);
	}
	
	
	
	public static SqlWhereBuilder factory(SqlWhereBuilderOption option) {
		return new SqlWhereBuilderEqual(option);
	}
	
	
	
	public boolean isIgnoringNullCondition();
	

	public void appendClauseWithAnd(String columnName, String conditionValue);

	
	public void appendClauseWithOr(String columnName, String conditionValue);

	
	public String generateClause();
	
	
	public String generateClauseWithoutParentheses();

	
	public boolean checkClauseGeneration();
}
