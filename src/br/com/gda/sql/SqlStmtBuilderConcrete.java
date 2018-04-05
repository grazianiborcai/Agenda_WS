package br.com.gda.sql;

import br.com.gda.common.SystemMessage;

public final class SqlStmtBuilderConcrete implements SqlStmtBuilder {
	SqlStmtBuilder builder;
	
	public SqlStmtBuilderConcrete(SqlOperation operation, SqlStmtBuilderOption option) {
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
