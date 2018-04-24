package br.com.gda.sql;

import java.util.Iterator;
import java.util.List;

import br.com.gda.common.SystemMessage;

final class SqlStmtBuilderInsert extends SqlStmtBuilderTemplate {	
	
	SqlStmtBuilderInsert(SqlStmtBuilderOption option) {
		super(enforcePolicy(option));
	}
	
	
	
	static private SqlStmtBuilderOption enforcePolicy(SqlStmtBuilderOption option) {
		SqlStmtBuilderOption resultOption = option;
		
		resultOption = enforceIgnoreLookup(resultOption);
		resultOption = enforceIgnoreAutoIncremented(resultOption);
		
		return option;
	}
	
	
	
	static private SqlStmtBuilderOption enforceIgnoreLookup(SqlStmtBuilderOption option) {
		option.ignoreLookUpColumn = true;
		return option;
	}
	
	
	
	static private SqlStmtBuilderOption enforceIgnoreAutoIncremented(SqlStmtBuilderOption option) {
		option.ignoreAutoIncrementedColumn = true;
		return option;
	}
	
	
	
	@Override protected void tryToCheckStatementGenerationHook(String whereClause, List<SqlColumn> columns) {		
		if (columns == null)
			throw new NullPointerException(SystemMessage.NULL_COLUMNS);
		
		if (columns.isEmpty())
			throw new IllegalArgumentException(SystemMessage.EMPTY_COLUMNS);
	}
	
	
	
	@Override protected String generateStatementHook(String schemaName, String tableName, String whereClause, List<SqlColumn> columns, List<SqlJoin> joins) {
		StringBuilder resultStatement = new StringBuilder();
		
		resultStatement.append(SqlOperation.INSERT.toString());
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(SqlDictionary.INTO);
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(schemaName);
		resultStatement.append(SqlDictionary.PERIOD);
		resultStatement.append(tableName);
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(SqlDictionary.PARENTHESIS_OPENING);
		
		
		Iterator<SqlColumn> columnItr = columns.iterator();
		
		while (columnItr.hasNext()) {
			SqlColumn eachColumn = columnItr.next();
			resultStatement.append(eachColumn.columnName);
			
			if (columnItr.hasNext()) {
				resultStatement.append(SqlDictionary.COMMA);
				resultStatement.append(SqlDictionary.SPACE);
			}
		}
		
		
		resultStatement.append(SqlDictionary.PARENTHESIS_CLOSING);
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(SqlDictionary.VALUES);
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(SqlDictionary.PARENTHESIS_OPENING);
		
		
		for (int i=0; i<columns.size(); i++) {
			resultStatement.append(SqlDictionary.WILDCARD);
			
			int nextColumnIndex = i + 1;
			if (nextColumnIndex < columns.size()) {
				resultStatement.append(SqlDictionary.COMMA);
				resultStatement.append(SqlDictionary.SPACE);
			}
		}
		
		
		resultStatement.append(SqlDictionary.PARENTHESIS_CLOSING);
		resultStatement.append(SqlDictionary.END_STATEMENT);		
		
		
		return resultStatement.toString();
	}
}
