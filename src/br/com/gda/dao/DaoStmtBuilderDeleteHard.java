package br.com.gda.dao;

import java.util.List;

import br.com.gda.common.SystemMessage;

final class DaoStmtBuilderDeleteHard extends DaoStmtBuilderTemplate {

	DaoStmtBuilderDeleteHard(DaoStmtBuilderOption option) {
		super(option);
	}
	
	
	
	@Override protected void tryToCheckStatementGenerationHook(String whereClause, List<DaoColumn> columns) {
		if (whereClause == null)
			throw new NullPointerException(SystemMessage.NULL_WHERE_CLAUSE);
	}
	
	
	
	@Override protected String generateStatementHook(String schemaName, String tableName, String whereClause, List<DaoColumn> columns, List<DaoJoin> joins) {
		StringBuilder resultStatement = new StringBuilder();
		
		resultStatement.append(DaoOperation.HARD_DELETE.toString());
		resultStatement.append(DaoDictionary.SPACE);
		resultStatement.append(DaoDictionary.FROM);
		resultStatement.append(DaoDictionary.SPACE);		
		resultStatement.append(schemaName);
		resultStatement.append(DaoDictionary.PERIOD);
		resultStatement.append(tableName);
		resultStatement.append(DaoDictionary.SPACE);	
		resultStatement.append(DaoDictionary.WHERE);
		resultStatement.append(DaoDictionary.SPACE);	
		resultStatement.append(whereClause);
		resultStatement.append(DaoDictionary.END_STATEMENT);
		
		return resultStatement.toString();
	}
}
