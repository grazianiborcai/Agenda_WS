package br.com.gda.dao;

import java.util.Iterator;
import java.util.List;

import br.com.gda.common.SystemMessage;

final class DaoStmtBuilderInsert extends DaoStmtBuilderTemplate {	
	
	DaoStmtBuilderInsert(DaoStmtBuilderOption option) {
		super(enforcePolicy(option));
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
	
	
	
	@Override protected void tryToCheckStatementGenerationHook(String whereClause, List<DaoColumn> columns) {		
		if (columns == null)
			throw new NullPointerException(SystemMessage.NULL_COLUMNS);
		
		if (columns.isEmpty())
			throw new IllegalArgumentException(SystemMessage.EMPTY_COLUMNS);
	}
	
	
	
	@Override protected String generateStatementHook(String schemaName, String tableName, String whereClause, List<DaoColumn> columns, List<DaoJoin> joins) {
		StringBuilder resultStatement = new StringBuilder();
		
		resultStatement.append(DaoOperation.INSERT.toString());
		resultStatement.append(DaoDictionary.SPACE);
		resultStatement.append(DaoDictionary.INTO);
		resultStatement.append(DaoDictionary.SPACE);
		resultStatement.append(schemaName);
		resultStatement.append(DaoDictionary.PERIOD);
		resultStatement.append(tableName);
		resultStatement.append(DaoDictionary.SPACE);
		resultStatement.append(DaoDictionary.PARENTHESIS_OPENING);
		
		
		Iterator<DaoColumn> columnItr = columns.iterator();
		
		while (columnItr.hasNext()) {
			DaoColumn eachColumn = columnItr.next();
			resultStatement.append(eachColumn.columnName);
			
			if (columnItr.hasNext()) {
				resultStatement.append(DaoDictionary.COMMA);
				resultStatement.append(DaoDictionary.SPACE);
			}
		}
		
		
		resultStatement.append(DaoDictionary.PARENTHESIS_CLOSING);
		resultStatement.append(DaoDictionary.SPACE);
		resultStatement.append(DaoDictionary.VALUES);
		resultStatement.append(DaoDictionary.SPACE);
		resultStatement.append(DaoDictionary.PARENTHESIS_OPENING);
		
		
		for (int i=0; i<columns.size(); i++) {
			resultStatement.append(DaoDictionary.WILDCARD);
			
			int nextColumnIndex = i + 1;
			if (nextColumnIndex < columns.size()) {
				resultStatement.append(DaoDictionary.COMMA);
				resultStatement.append(DaoDictionary.SPACE);
			}
		}
		
		
		resultStatement.append(DaoDictionary.PARENTHESIS_CLOSING);
		resultStatement.append(DaoDictionary.END_STATEMENT);		
		
		
		return resultStatement.toString();
	}
}
