package br.com.mind5.dao;

public enum DaoOperation {
	INSERT("INSERT", true) {
		@Override protected DaoStmtBuilder factorySqlStmtBuilder(DaoStmtBuilderOption option, Class<?> clazz) {
			return new DaoStmtBuilderInsert(option, clazz);
		}
	}, 
	
	HARD_DELETE("DELETE", true) {
		@Override protected DaoStmtBuilder factorySqlStmtBuilder(DaoStmtBuilderOption option, Class<?> clazz) {
			return new DaoStmtBuilderDeleteHard(option, clazz);
		}
	}, 
	
	SOFT_DELETE("DELETE", true) {
		@Override protected DaoStmtBuilder factorySqlStmtBuilder(DaoStmtBuilderOption option, Class<?> clazz) {
			return new DaoStmtBuilderDeleteSoft(option, clazz);
		}
	}, 
	
	UPDATE("UPDATE", true) {
		@Override protected DaoStmtBuilder factorySqlStmtBuilder(DaoStmtBuilderOption option, Class<?> clazz) {
			return new DaoStmtBuilderUpdate(option, clazz);
		}
	}, 
	
	SELECT("SELECT", false) {
		@Override protected DaoStmtBuilder factorySqlStmtBuilder(DaoStmtBuilderOption option, Class<?> clazz) {
			return new DaoStmtBuilderSelect(option, clazz);
		}
	},
	
	SELECT_DISTINCT("SELECT DISTINCT", false) {
		@Override protected DaoStmtBuilder factorySqlStmtBuilder(DaoStmtBuilderOption option, Class<?> clazz) {
			return new DaoStmtBuilderSelectDistinct(option, clazz);
		}
	},	
	
	LOCK("LOCK", false) {
		@Override protected DaoStmtBuilder factorySqlStmtBuilder(DaoStmtBuilderOption option, Class<?> clazz) {
			return new DaoStmtBuilderLock(option, clazz);
		}
	};
	
	
	private final String operationSymbol;
	private final boolean isWritable;
	
	
	
	private DaoOperation(String symbol, boolean writable) {
		operationSymbol = symbol;
		isWritable = writable;
	}
	
	
	
	public boolean isWritable() {
		return isWritable;
	}
	
	
	
	@Override public String toString() {
		return operationSymbol;
	}
	
	
	protected abstract DaoStmtBuilder factorySqlStmtBuilder(DaoStmtBuilderOption option, Class<?> clazz);
}
