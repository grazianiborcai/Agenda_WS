package br.com.gda.dao;

public enum DaoOperation {
	INSERT("INSERT", true) {
		@Override protected DaoStmtBuilder factorySqlStmtBuilder(DaoStmtBuilderOption option, Class<?> clazz) {
			return new DaoStmtBuilderInsert(option);
		}
	}, 
	
	HARD_DELETE("DELETE", true) {
		@Override protected DaoStmtBuilder factorySqlStmtBuilder(DaoStmtBuilderOption option, Class<?> clazz) {
			return new DaoStmtBuilderDeleteHard(option);
		}
	}, 
	
	SOFT_DELETE("DELETE", true) {
		@Override protected DaoStmtBuilder factorySqlStmtBuilder(DaoStmtBuilderOption option, Class<?> clazz) {
			return new DaoStmtBuilderDeleteSoft(option);
		}
	}, 
	
	UPDATE("UPDATE", true) {
		@Override protected DaoStmtBuilder factorySqlStmtBuilder(DaoStmtBuilderOption option, Class<?> clazz) {
			return new DaoStmtBuilderUpdate(option);
		}
	}, 
	
	SELECT("SELECT", false) {
		@Override protected DaoStmtBuilder factorySqlStmtBuilder(DaoStmtBuilderOption option, Class<?> clazz) {
			return new DaoStmtBuilderSelect(option);
		}
	};
	
	
	private final String operationSymbol;
	private final boolean isWrittable;
	
	
	
	private DaoOperation(String operationSymbol, boolean isWrittable) {
		this.operationSymbol = operationSymbol;
		this.isWrittable = isWrittable;
	}
	
	
	
	public boolean isWrittable() {
		return isWrittable;
	}
	
	
	
	@Override public String toString() {
		return this.operationSymbol;
	}
	
	
	protected abstract DaoStmtBuilder factorySqlStmtBuilder(DaoStmtBuilderOption option, Class<?> clazz);
}
