package br.com.gda.sql;

public enum SqlOperation {
	INSERT("INSERT") {
		@Override protected SqlStatementBuilder factorySqlStatementBuilder(SqlStatementBuilderOption option) {
			return new SqlStatementBuilderInsert(option);
		}
	}, 
	
	DELETE("DELETE") {
		@Override protected SqlStatementBuilder factorySqlStatementBuilder(SqlStatementBuilderOption option) {
			return null;
		}
	}, 
	
	UPDATE("UPDATE") {
		@Override protected SqlStatementBuilder factorySqlStatementBuilder(SqlStatementBuilderOption option) {
			return null;
		}
	}, 
	
	SELECT("SELECT") {
		@Override protected SqlStatementBuilder factorySqlStatementBuilder(SqlStatementBuilderOption option) {
			return null;
		}
	};
	
	
	private final String operationSymbol;
	
	
	
	private SqlOperation(String operationSymbol) {
		this.operationSymbol = operationSymbol;
	}
	
	
	
	@Override public String toString() {
		return this.operationSymbol;
	}
	
	
	protected abstract SqlStatementBuilder factorySqlStatementBuilder(SqlStatementBuilderOption option);
}
