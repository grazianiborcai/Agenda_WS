package br.com.gda.sql;

public enum SqlOperation {
	INSERT("INSERT") {
		@Override protected SqlStmtBuilder factorySqlStatementBuilder(SqlStmtBuilderOption option) {
			return new SqlStmtBuilderInsert(option);
		}
	}, 
	
	DELETE("DELETE") {
		@Override protected SqlStmtBuilder factorySqlStatementBuilder(SqlStmtBuilderOption option) {
			return null;
		}
	}, 
	
	UPDATE("UPDATE") {
		@Override protected SqlStmtBuilder factorySqlStatementBuilder(SqlStmtBuilderOption option) {
			return null;
		}
	}, 
	
	SELECT("SELECT") {
		@Override protected SqlStmtBuilder factorySqlStatementBuilder(SqlStmtBuilderOption option) {
			return new SqlStmtBuilderSelect(option);
		}
	};
	
	
	private final String operationSymbol;
	
	
	
	private SqlOperation(String operationSymbol) {
		this.operationSymbol = operationSymbol;
	}
	
	
	
	@Override public String toString() {
		return this.operationSymbol;
	}
	
	
	protected abstract SqlStmtBuilder factorySqlStatementBuilder(SqlStmtBuilderOption option);
}
