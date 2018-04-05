package br.com.gda.sql;

public interface SqlStmtBuilder {
	public static SqlStmtBuilder factory(SqlOperation operation, SqlStmtBuilderOption option) {
		return operation.factorySqlStmtBuilder(option);
	}	
	
	
	public boolean checkStatementGeneration();	
	
	public String generatedStatement();
}
