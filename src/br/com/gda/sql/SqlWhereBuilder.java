package br.com.gda.sql;

public interface SqlWhereBuilder {	
	public static SqlWhereBuilder factory() {
		SqlWhereBuilderOption defaultOption = new SqlWhereBuilderOption();
		return factory(defaultOption);
	}
	
	
	
	public static SqlWhereBuilder factory(SqlWhereBuilderOption option) {
		return new SqlWhereBuilderConcrete(option);
	}
	
	
	public void addClause(SqlColumn column, String value);

	
	public String generateClause();

	
	public boolean checkBeforeGeneration();
}
