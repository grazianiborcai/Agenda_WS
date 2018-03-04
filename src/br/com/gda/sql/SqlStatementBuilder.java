package br.com.gda.sql;

public interface SqlStatementBuilder {
	public static SqlStatementBuilder factory(SqlOperation operation, SqlStatementBuilderOption option) {
		return operation.factorySqlStatementBuilder(option);
	}
	
	
	
	public boolean checkStatementGeneration();
	
	
	
	public String generateStatement();
}
