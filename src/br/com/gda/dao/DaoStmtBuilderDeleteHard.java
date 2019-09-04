package br.com.gda.dao;

import java.util.List;

final class DaoStmtBuilderDeleteHard extends DaoStmtBuilderTemplate {

	DaoStmtBuilderDeleteHard(DaoStmtBuilderOption option, Class<?> clazz) {
		super(option, clazz);
	}
	
	
	
	@Override protected void checkStmtBuildHook() {
		super.checkWhereClause();
	}
	
	
	
	@Override protected String buildStmtHook(String schemaName, String tableName, String whereClause, List<DaoColumn> columns, List<DaoJoin> joins, boolean lockWrite) {
		StringBuilder resultStatement = new StringBuilder();
		
		resultStatement = appendOperation(resultStatement);
		resultStatement = appendTable(resultStatement, schemaName, tableName);
		resultStatement = appendWhere(resultStatement, whereClause);
		
		return resultStatement.toString();
	}
	
	
	
	private StringBuilder appendOperation(StringBuilder statement) {
		statement.append(DaoOperation.HARD_DELETE.toString());
		statement.append(DaoDictionary.SPACE);
		
		return statement;		
	}
	
	
	
	private StringBuilder appendTable(StringBuilder statement, String schemaName, String tableName) {
		statement.append(DaoDictionary.FROM);
		statement.append(DaoDictionary.SPACE);	
		statement.append(schemaName);
		statement.append(DaoDictionary.PERIOD);
		statement.append(tableName);
		statement.append(DaoDictionary.SPACE);
		
		return statement;		
	}
	
	
	
	private StringBuilder appendWhere(StringBuilder statement, String whereClause) {
		statement.append(DaoDictionary.WHERE);
		statement.append(DaoDictionary.SPACE);	
		statement.append(whereClause);
		statement.append(DaoDictionary.END_STATEMENT);
		
		return statement;		
	}
}
