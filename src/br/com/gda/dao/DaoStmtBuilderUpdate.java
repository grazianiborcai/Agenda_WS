package br.com.gda.dao;

import java.util.Iterator;
import java.util.List;

import br.com.gda.common.SystemMessage;

final class DaoStmtBuilderUpdate extends DaoStmtBuilderTemplate {

	DaoStmtBuilderUpdate(DaoStmtBuilderOption option) {
		super(enforceIgnoreLookup(option));
	}
	
	
	
	static private DaoStmtBuilderOption enforceIgnoreLookup(DaoStmtBuilderOption option) {
		option.ignoreLookUpColumn = true;
		return option;
	}
	
	
	
	@Override protected void tryToCheckStatementGenerationHook(String whereClause, List<DaoColumn> columns) {		
		if (columns == null)
			throw new NullPointerException(SystemMessage.NULL_COLUMNS);
		
		if (columns.isEmpty())
			throw new IllegalArgumentException(SystemMessage.EMPTY_COLUMNS);
		
		if (whereClause == null)
			throw new NullPointerException(SystemMessage.NULL_WHERE_CLAUSE);
	}
	
	
	
	@Override protected String generateStatementHook(String schemaName, String tableName, String whereClause, List<DaoColumn> columns, List<DaoJoin> joins) {
		StringBuilder resultStatement = new StringBuilder();
		
		resultStatement.append(DaoOperation.UPDATE.toString());
		resultStatement.append(DaoDictionary.SPACE);
		resultStatement.append(schemaName);
		resultStatement.append(DaoDictionary.PERIOD);
		resultStatement.append(tableName);
		resultStatement.append(DaoDictionary.SPACE);
		resultStatement.append(DaoDictionary.SET);
		resultStatement.append(DaoDictionary.SPACE);
		
		
		Iterator<DaoColumn> columnItr = columns.iterator();
		
		while (columnItr.hasNext()) {
			DaoColumn eachColumn = columnItr.next();
			
			if (eachColumn.isPK)
				continue;
			
			resultStatement.append(eachColumn.columnName);			
			resultStatement.append(DaoDictionary.SPACE);
			resultStatement.append(DaoDictionary.EQUAL);
			resultStatement.append(DaoDictionary.SPACE);
			resultStatement.append(DaoDictionary.WILDCARD);
			
			if (columnItr.hasNext()) 
				resultStatement.append(DaoDictionary.COMMA);
			
			resultStatement.append(DaoDictionary.SPACE);
		}
		
		
		resultStatement.append(DaoDictionary.WHERE);
		resultStatement.append(DaoDictionary.SPACE);
		resultStatement.append(whereClause);
		resultStatement.append(DaoDictionary.END_STATEMENT);		
		
		return resultStatement.toString();
	}
}
