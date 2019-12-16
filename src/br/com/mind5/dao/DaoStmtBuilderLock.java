package br.com.mind5.dao;

import java.util.List;

final class DaoStmtBuilderLock extends DaoStmtBuilderTemplate {

	DaoStmtBuilderLock(DaoStmtBuilderOption option, Class<?> clazz) {
		super(option, clazz);
	}
	
	
	
	@Override protected void checkStmtBuildHook() {
		super.checkColumns();
	}
	
	
	
	@Override protected String buildStmtHook(String schemaName, String tableName, String whereClause, List<DaoColumn> columns, List<DaoJoin> joins) {
		StringBuilder resultStatement = new StringBuilder();
		
		resultStatement = appendOperation(resultStatement);
		resultStatement = appendColumn(resultStatement);
		resultStatement = appendTable(resultStatement, schemaName, tableName);
		resultStatement = appendWhere(resultStatement, whereClause);
		resultStatement = appendLockWrite(resultStatement);
		resultStatement = appendEndStatement(resultStatement);
		
		return resultStatement.toString();
	}
	
	
	
	private StringBuilder appendOperation(StringBuilder statement) {
		statement.append(DaoOperation.SELECT.toString());
		statement.append(DaoDictionary.SPACE);
		
		return statement;		
	}
	
	
	
	private StringBuilder appendColumn(StringBuilder statement) {
		statement.append(DaoDictionary.ALL_COLUMNS);
		statement.append(DaoDictionary.SPACE);
		
		return statement;		
	}
	
	
	
	private StringBuilder appendTable(StringBuilder statement, String schemaName, String tableName) {
		statement.append(DaoDictionary.SPACE);
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
		
		return statement;		
	}
	
	
	
	private StringBuilder appendLockWrite(StringBuilder statement) {
		statement.append(DaoDictionary.SPACE);
		statement.append(DaoDictionary.LOCK_WRITE);
		
		return statement;		
	}
	
	
	
	private StringBuilder appendEndStatement(StringBuilder statement) {
		statement.append(DaoDictionary.END_STATEMENT);
		
		return statement;		
	}	
}
