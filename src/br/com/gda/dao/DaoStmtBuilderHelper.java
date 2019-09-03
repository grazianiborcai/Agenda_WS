package br.com.gda.dao;

import br.com.gda.common.SystemMessage;

public final class DaoStmtBuilderHelper implements DaoStmtBuilder {
	DaoStmtBuilder builder;
	
	public DaoStmtBuilderHelper(DaoOperation operation, DaoStmtBuilderOption option, Class<?> clazz) {
		if (operation == null)
			throw new NullPointerException(operation + SystemMessage.NULL_ARGUMENT);
		
		builder = operation.factorySqlStmtBuilder(option, clazz);
	}

		
	
	@Override public boolean checkStmtBuild() {
		return builder.checkStmtBuild();
	}

	
	
	@Override public String buildStmt() {
		return builder.buildStmt();
	}



}
