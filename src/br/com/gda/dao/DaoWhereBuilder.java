package br.com.gda.dao;

public interface DaoWhereBuilder {	
	public static DaoWhereBuilder factory() {
		DaoWhereBuilderOption defaultOption = new DaoWhereBuilderOption();
		return factory(defaultOption);
	}
	
	
	
	public static DaoWhereBuilder factory(DaoWhereBuilderOption option) {
		return new DaoWhereBuilderConcrete(option);
	}
	
	
	public void addClauseEqualAnd(DaoColumn column, String value);
	
	
	public void addClauseAnd(DaoColumn column, String value, DaoWhereCondition condition);
	
	
	public void addClauseOr(DaoColumn column, String value, DaoWhereCondition condition);

	
	public void mergeBuilder(DaoWhereBuilder builder, DaoWhereOperator operator);
	
	
	public String generateClause();

	
	public boolean checkBeforeGeneration();
}
