package br.com.gda.sql;

import java.util.Iterator;
import java.util.List;

import br.com.gda.common.SystemMessage;

final class SqlStmtBuilderUpdate extends SqlStmtBuilderTemplate {

	SqlStmtBuilderUpdate(SqlStmtBuilderOption option) {
		super(enforceIgnoreLookup(option));
	}
	
	
	
	static private SqlStmtBuilderOption enforceIgnoreLookup(SqlStmtBuilderOption option) {
		option.ignoreLookUpColumn = true;
		return option;
	}
	
	
	
	@Override protected void tryToCheckStatementGenerationHook(String whereClause, List<SqlColumn> columns) {		
		if (columns == null)
			throw new NullPointerException(SystemMessage.NULL_COLUMNS);
		
		if (columns.isEmpty())
			throw new IllegalArgumentException(SystemMessage.EMPTY_COLUMNS);
		
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
		
		
		Iterator<SqlColumn> columnItr = columns.iterator();
		
		while (columnItr.hasNext()) {
			SqlColumn eachColumn = columnItr.next();
			
			if (eachColumn.isPK)
				continue;
			
			resultStatement.append(eachColumn.columnName);			
			resultStatement.append(SqlDictionary.SPACE);
			resultStatement.append(SqlDictionary.EQUAL);
			resultStatement.append(SqlDictionary.SPACE);
			resultStatement.append(SqlDictionary.WILDCARD);
			
			if (columnItr.hasNext()) 
				resultStatement.append(SqlDictionary.COMMA);
			
			resultStatement.append(SqlDictionary.SPACE);
		}
		
		
		resultStatement.append(SqlDictionary.WHERE);
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(whereClause);
		resultStatement.append(SqlDictionary.END_STATEMENT);		
		
		return resultStatement.toString();
	}
}
