package br.com.gda.dao;

import java.util.Iterator;
import java.util.List;

final class DaoStmtBuilderUpdate extends DaoStmtBuilderTemplate {

	DaoStmtBuilderUpdate(DaoStmtBuilderOption option, Class<?> clazz) {
		super(enforceOption(option), clazz);
	}
	
	
	
	static private DaoStmtBuilderOption enforceOption(DaoStmtBuilderOption option) {
		option.ignoreLookUpColumn = true;
		return option;
	}
	
	
	
	@Override protected void checkStmtBuildHook() {	
		super.checkWhereClause();
		super.checkColumns();
	}
	
	
	
	@Override protected String buildStmtHook(String schemaName, String tableName, String whereClause, List<DaoColumn> columns, List<DaoJoin> joins) {
		StringBuilder resultStatement = new StringBuilder();
		
		resultStatement = appendOperation(resultStatement);
		resultStatement = appendTable(resultStatement, schemaName, tableName);
		resultStatement = appendColumn(resultStatement, columns);
		resultStatement = appendWhere(resultStatement, whereClause);
		
		return resultStatement.toString();
	}
	
	
	
	private StringBuilder appendOperation(StringBuilder statement) {
		statement.append(DaoOperation.UPDATE.toString());
		statement.append(DaoDictionary.SPACE);
		
		return statement;
	}
	
	
	
	private StringBuilder appendTable(StringBuilder statement, String schemaName, String tableName) {
		statement.append(schemaName);
		statement.append(DaoDictionary.PERIOD);
		statement.append(tableName);
		statement.append(DaoDictionary.SPACE);
		statement.append(DaoDictionary.SET);
		statement.append(DaoDictionary.SPACE);
		
		return statement;		
	}	
	
	
	
	private StringBuilder appendColumn(StringBuilder statement, List<DaoColumn> columns) {
		Iterator<DaoColumn> columnItr = columns.iterator();
		
		while (columnItr.hasNext()) {
			DaoColumn eachColumn = columnItr.next();
			
			if (eachColumn.isPK)
				continue;			
			
			statement.append(eachColumn.columnName);			
			statement.append(DaoDictionary.SPACE);
			statement.append(DaoDictionary.EQUAL);
			statement.append(DaoDictionary.SPACE);
			statement.append(DaoDictionary.WILDCARD);
			
			if (columnItr.hasNext()) 
				statement.append(DaoDictionary.COMMA);
			
			statement.append(DaoDictionary.SPACE);
		}
		
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
