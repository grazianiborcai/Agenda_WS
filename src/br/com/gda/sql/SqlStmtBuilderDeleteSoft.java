package br.com.gda.sql;

import br.com.gda.common.SystemMessage;
import br.com.gda.helper.RecordMode;

final class SqlStmtBuilderDeleteSoft extends SqlStmtBuilderAbstract {

	SqlStmtBuilderDeleteSoft(SqlStmtBuilderOption option) {
		super(option);
	}
	
	
	
	@Override protected void tryToCheckStatementGenerationHook() {			
		if (this.whereClause == null)
			throw new NullPointerException(SystemMessage.NULL_WHERE_CLAUSE);
	}
	
	
	
	@Override protected String generateStatementHook() {
		StringBuilder resultStatement = new StringBuilder();
		
		resultStatement.append(SqlOperation.UPDATE.toString());
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(this.schemaName);
		resultStatement.append(SqlDictionary.PERIOD);
		resultStatement.append(this.tableName);
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
		resultStatement.append(this.whereClause);
		resultStatement.append(SqlDictionary.END_STATEMENT);		
		
		return resultStatement.toString();
	}
}
