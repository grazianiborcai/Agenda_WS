package br.com.gda.sql;

public interface SqlWhereBuilder {	
	public static SqlWhereBuilder factory(SqlOperator operator) {
		boolean DO_IGNORE_NULL_CONDITION = true;
		return operator.factoryWhereBuilder(DO_IGNORE_NULL_CONDITION);
	}
	
	
	public boolean isIgnoringNullCondition();
	

	public void appendClauseWithAnd(String columnName, String conditionValue);

	
	public void appendClauseWithOr(String columnName, String conditionValue);

	
	public String generateClause();
	
	
	public String generateClauseWithoutParentheses();

	
	public boolean checkClauseGeneration();
}
