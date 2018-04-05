package br.com.gda.sql;

import br.com.gda.common.SystemMessage;

final class SqlStmtBuilderDelete extends SqlStmtBuilderAbstract {

	SqlStmtBuilderDelete(SqlStmtBuilderOption option) {
		super(option);
	}
	
	
	
	@Override protected void tryToCheckStatementGenerationHook() {
		if (this.whereClause == null)
			throw new NullPointerException(SystemMessage.NULL_WHERE_CLAUSE);
	}
	
	
	
	@Override protected String generateStatementHook() {
		StringBuilder resultStatement = new StringBuilder();
		
		resultStatement.append(SqlOperation.DELETE.toString());
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(SqlDictionary.FROM);
		resultStatement.append(SqlDictionary.SPACE);		
		resultStatement.append(this.schemaName);
		resultStatement.append(SqlDictionary.PERIOD);
		resultStatement.append(this.tableName);
		resultStatement.append(SqlDictionary.SPACE);	
		resultStatement.append(SqlDictionary.WHERE);
		resultStatement.append(SqlDictionary.SPACE);	
		resultStatement.append(this.whereClause);
		resultStatement.append(SqlDictionary.END_STATEMENT);
		
		return resultStatement.toString();
	}
}
