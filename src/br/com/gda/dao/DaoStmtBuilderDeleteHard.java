package br.com.gda.dao;

import java.util.List;

final class DaoStmtBuilderDeleteHard extends DaoStmtBuilderTemplate {

	DaoStmtBuilderDeleteHard(DaoStmtBuilderOption option) {
		super(option, DaoStmtBuilderDeleteHard.class);
	}
	
	
	
	@Override protected void checkStmtBuildHook() {
		super.checkWhereClause();
	}
	
	
	
	@Override protected String buildStmtHook(String schemaName, String tableName, String whereClause, List<DaoColumn> columns, List<DaoJoin> joins) {
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
