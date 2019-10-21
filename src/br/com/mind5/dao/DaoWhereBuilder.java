package br.com.mind5.dao;

public interface DaoWhereBuilder {
	public static DaoWhereBuilder factory(DaoWhereBuilderOption option) {
		return new DaoWhereBuilderConcrete(option);
	}
	
	
	public void addClauseEqualAnd(DaoColumn column, String value);
	
	
	public void addClauseNullAnd(DaoColumn column);
	
	
	public void addClauseNullOr(DaoColumn column);
	
	
	public void addClauseAnd(DaoColumn column, String value, DaoWhereCondition condition);
	
	
	public void addClauseOr(DaoColumn column, String value, DaoWhereCondition condition);

	
	public void mergeBuilder(DaoWhereBuilder builder, DaoWhereOperator operator);
	
	
	public String generateClause();

	
	public boolean checkBeforeGeneration();
}
