package br.com.gda.sql;

public enum SqlOperation {
	INSERT("INSERT", true) {
		@Override protected SqlStmtBuilder factorySqlStmtBuilder(SqlStmtBuilderOption option) {
			return new SqlStmtBuilderInsert(option);
		}
	}, 
	
	HARD_DELETE("HARD_DELETE", true) {
		@Override protected SqlStmtBuilder factorySqlStmtBuilder(SqlStmtBuilderOption option) {
			return new SqlStmtBuilderDeleteHard(option);
		}
	}, 
	
	SOFT_DELETE("SOFT_DELETE", true) {
		@Override protected SqlStmtBuilder factorySqlStmtBuilder(SqlStmtBuilderOption option) {
			return new SqlStmtBuilderDeleteSoft(option);
		}
	}, 
	
	UPDATE("UPDATE", true) {
		@Override protected SqlStmtBuilder factorySqlStmtBuilder(SqlStmtBuilderOption option) {
			return new SqlStmtBuilderUpdate(option);
		}
	}, 
	
	SELECT("SELECT", false) {
		@Override protected SqlStmtBuilder factorySqlStmtBuilder(SqlStmtBuilderOption option) {
			return new SqlStmtBuilderSelect(option);
		}
	};
	
	
	private final String operationSymbol;
	private final boolean isWrittable;
	
	
	
	private SqlOperation(String operationSymbol, boolean isWrittable) {
		this.operationSymbol = operationSymbol;
		this.isWrittable = isWrittable;
	}
	
	
	
	public boolean isWrittable() {
		return isWrittable;
	}
	
	
	
	@Override public String toString() {
		return this.operationSymbol;
	}
	
	
	protected abstract SqlStmtBuilder factorySqlStmtBuilder(SqlStmtBuilderOption option);
}
