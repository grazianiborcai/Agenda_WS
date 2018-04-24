package br.com.gda.sql;

import java.util.List;

import br.com.gda.common.SystemMessage;
import br.com.gda.helper.RecordMode;

final class SqlStmtBuilderDeleteSoft extends SqlStmtBuilderTemplate {

	SqlStmtBuilderDeleteSoft(SqlStmtBuilderOption option) {
		super(option);
	}
	
	
	
	@Override protected void tryToCheckStatementGenerationHook(String whereClause, List<SqlColumn> columns) {			
		if (whereClause == null)
			throw new NullPointerException(SystemMessage.NULL_WHERE_CLAUSE);
	}
	
	
	
	@Override protected String generateStatementHook(String schemaName, String tableName, String whereClause, List<SqlColumn> columns, List<SqlJoin> joins) {
		StringBuilder resultStatement = new StringBuilder();
		
		resultStatement.append(SqlOperation.UPDATE.toString());
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(schemaName);
		resultStatement.append(SqlDictionary.PERIOD);
		resultStatement.append(tableName);
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(SqlDictionary.SET);
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(SqlDictionary.RECORD_MODE);
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(SqlDictionary.EQUAL);
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(SqlDictionary.QUOTE);
		resultStatement.append(RecordMode.RECORD_DELETED);
		resultStatement.append(SqlDictionary.QUOTE);
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(SqlDictionary.WHERE);
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(whereClause);
		resultStatement.append(SqlDictionary.END_STATEMENT);		
		
		return resultStatement.toString();
	}
}
