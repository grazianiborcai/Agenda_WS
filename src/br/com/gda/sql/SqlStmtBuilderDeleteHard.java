package br.com.gda.sql;

import java.util.List;

import br.com.gda.common.SystemMessage;

final class SqlStmtBuilderDeleteHard extends SqlStmtBuilderTemplate {

	SqlStmtBuilderDeleteHard(SqlStmtBuilderOption option) {
		super(option);
	}
	
	
	
	@Override protected void tryToCheckStatementGenerationHook(String whereClause, List<SqlColumn> columns) {
		if (whereClause == null)
			throw new NullPointerException(SystemMessage.NULL_WHERE_CLAUSE);
	}
	
	
	
	@Override protected String generateStatementHook(String schemaName, String tableName, String whereClause, List<SqlColumn> columns, List<SqlJoin> joins) {
		StringBuilder resultStatement = new StringBuilder();
		
		resultStatement.append(SqlOperation.HARD_DELETE.toString());
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(SqlDictionary.FROM);
		resultStatement.append(SqlDictionary.SPACE);		
		resultStatement.append(schemaName);
		resultStatement.append(SqlDictionary.PERIOD);
		resultStatement.append(tableName);
		resultStatement.append(SqlDictionary.SPACE);	
		resultStatement.append(SqlDictionary.WHERE);
		resultStatement.append(SqlDictionary.SPACE);	
		resultStatement.append(whereClause);
		resultStatement.append(SqlDictionary.END_STATEMENT);
		
		return resultStatement.toString();
	}
}
