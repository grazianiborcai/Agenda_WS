package br.com.gda.sql;

public interface SqlStmtBuilder {
	public static SqlStmtBuilder factory(SqlOperation operation, SqlStmtBuilderOption option) {
		return operation.factorySqlStatementBuilder(option);
	}
	
	
	
	public boolean checkStatementGeneration();
	
	
	
	public String generateStatement();
}
