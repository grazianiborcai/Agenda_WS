package br.com.gda.dao;

import br.com.gda.common.SystemMessage;

public final class DaoStmtBuilderHelper implements DaoStmtBuilder {
	DaoStmtBuilder builder;
	
	public DaoStmtBuilderHelper(DaoOperation operation, DaoStmtBuilderOption option) {
		if (operation == null)
			throw new NullPointerException(operation + SystemMessage.NULL_ARGUMENT);
		
		builder = operation.factorySqlStmtBuilder(option);
	}

		
	
	@Override public boolean checkStatementGeneration() {
		return builder.checkStatementGeneration();
	}

	
	
	@Override public String generatedStatement() {
		return builder.generatedStatement();
	}



}
