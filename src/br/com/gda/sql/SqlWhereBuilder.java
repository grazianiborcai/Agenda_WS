package br.com.gda.sql;

public interface SqlWhereBuilder {	
	public static SqlWhereBuilder factory() {
		SqlWhereBuilderOption defaultOption = new SqlWhereBuilderOption();
		return factory(defaultOption);
	}
	
	
	
	public static SqlWhereBuilder factory(SqlWhereBuilderOption option) {
		return new SqlWhereBuilderConcrete(option);
	}
	
	
	public void addClauseEqualAnd(SqlColumn column, String value);
	
	
	public void addClauseAnd(SqlColumn column, String value, SqlWhereCondition condition);
	
	
	public void addClauseOr(SqlColumn column, String value, SqlWhereCondition condition);

	
	public void mergeBuilder(SqlWhereBuilder builder, SqlWhereOperator operator);
	
	
	public String generateClause();

	
	public boolean checkBeforeGeneration();
}
