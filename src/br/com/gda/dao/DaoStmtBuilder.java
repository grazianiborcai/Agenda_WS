package br.com.gda.dao;

public interface DaoStmtBuilder {
	public static DaoStmtBuilder factory(DaoOperation operation, DaoStmtBuilderOption option) {
		return operation.factorySqlStmtBuilder(option);
	}	
	
	
	public boolean checkStmtBuild();	
	
	public String buildStmt();
}
