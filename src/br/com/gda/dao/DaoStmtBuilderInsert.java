package br.com.gda.dao;

import java.util.Iterator;
import java.util.List;

final class DaoStmtBuilderInsert extends DaoStmtBuilderTemplate {	
	
	DaoStmtBuilderInsert(DaoStmtBuilderOption option) {
		super(enforcePolicy(option), DaoStmtBuilderInsert.class);
	}
	
	
	
	static private DaoStmtBuilderOption enforcePolicy(DaoStmtBuilderOption option) {
		DaoStmtBuilderOption resultOption = option;
		
		resultOption = enforceIgnoreLookup(resultOption);
		resultOption = enforceIgnoreAutoIncremented(resultOption);
		
		return option;
	}
	
	
	
	static private DaoStmtBuilderOption enforceIgnoreLookup(DaoStmtBuilderOption option) {
		option.ignoreLookUpColumn = true;
		return option;
	}
	
	
	
	static private DaoStmtBuilderOption enforceIgnoreAutoIncremented(DaoStmtBuilderOption option) {
		option.ignoreAutoIncrementedColumn = true;
		return option;
	}
	
	
	
	@Override protected void checkStmtBuildHook() {		
		super.checkColumns();
	}
	
	
	
	@Override protected String buildStmtHook(String schemaName, String tableName, String whereClause, List<DaoColumn> columns, List<DaoJoin> joins) {
		StringBuilder resultStatement = new StringBuilder();
		
		resultStatement = appendOperation(resultStatement);
		resultStatement = appendTable(resultStatement, schemaName, tableName);
		resultStatement = appendColumn(resultStatement, columns);		
		
		return resultStatement.toString();
	}
	
	
	
	private StringBuilder appendOperation(StringBuilder statement) {
		statement.append(DaoOperation.INSERT.toString());
		statement.append(DaoDictionary.SPACE);
		statement.append(DaoDictionary.INTO);
		statement.append(DaoDictionary.SPACE);
		
		return statement;		
	}
	
	
	
	private StringBuilder appendTable(StringBuilder statement, String schemaName, String tableName) {
		statement.append(schemaName);
		statement.append(DaoDictionary.PERIOD);
		statement.append(tableName);
		statement.append(DaoDictionary.SPACE);
		
		return statement;		
	}
	
	
	
	private StringBuilder appendColumn(StringBuilder statement, List<DaoColumn> columns) {
		statement.append(DaoDictionary.PARENTHESIS_OPENING);		
		
		Iterator<DaoColumn> columnItr = columns.iterator();
		
		while (columnItr.hasNext()) {
			DaoColumn eachColumn = columnItr.next();
			statement.append(eachColumn.columnName);
			
			if (columnItr.hasNext()) {
				statement.append(DaoDictionary.COMMA);
				statement.append(DaoDictionary.SPACE);
			}
		}
		
		
		statement.append(DaoDictionary.PARENTHESIS_CLOSING);
		statement.append(DaoDictionary.SPACE);
		statement.append(DaoDictionary.VALUES);
		statement.append(DaoDictionary.SPACE);
		statement.append(DaoDictionary.PARENTHESIS_OPENING);
		
		
		for (int i=0; i<columns.size(); i++) {
			statement.append(DaoDictionary.WILDCARD);
			
			int nextColumnIndex = i + 1;
			if (nextColumnIndex < columns.size()) {
				statement.append(DaoDictionary.COMMA);
				statement.append(DaoDictionary.SPACE);
			}
		}
		
		
		statement.append(DaoDictionary.PARENTHESIS_CLOSING);
		statement.append(DaoDictionary.END_STATEMENT);	
		
		return statement;		
	}
}
