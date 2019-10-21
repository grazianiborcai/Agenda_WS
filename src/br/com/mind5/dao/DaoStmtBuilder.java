package br.com.mind5.dao;

public interface DaoStmtBuilder {
	public static DaoStmtBuilder factory(DaoOperation operation, DaoStmtBuilderOption option, Class<?> clazz) {
		return operation.factorySqlStmtBuilder(option, clazz);
	}	
	
	
	public boolean checkStmtBuild();	
	
	public String buildStmt();
}
