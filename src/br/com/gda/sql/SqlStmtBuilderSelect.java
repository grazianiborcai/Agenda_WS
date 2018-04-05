package br.com.gda.sql;

import java.util.Iterator;

import br.com.gda.common.SystemMessage;

final class SqlStmtBuilderSelect extends SqlStmtBuilderAbstract {

	SqlStmtBuilderSelect(SqlStmtBuilderOption option) {
		super(option);
	}
	
	
	
	@Override protected void tryToCheckStatementGenerationHook() {		
		if (this.columns == null)
			throw new NullPointerException(SystemMessage.NULL_COLUMNS);
		
		if (this.columns.isEmpty())
			throw new IllegalArgumentException(SystemMessage.EMPTY_COLUMNS);
		
		if (this.whereClause == null)
			throw new NullPointerException(SystemMessage.NULL_WHERE_CLAUSE);
	}
	
	
	
	@Override protected String generateStatementHook() {
		StringBuilder resultStatement = new StringBuilder();
		
		resultStatement.append(SqlOperation.SELECT.toString());
		resultStatement.append(SqlDictionary.SPACE);
		
		Iterator<SqlColumn> columnItr = this.columns.iterator();
		
		while (columnItr.hasNext()) {
			SqlColumn eachColumn = columnItr.next();
			resultStatement.append(eachColumn.columnName);
			
			if (columnItr.hasNext()) {
				resultStatement.append(SqlDictionary.COMMA);
				resultStatement.append(SqlDictionary.SPACE);
			}
		}
		
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(SqlDictionary.FROM);
		resultStatement.append(SqlDictionary.SPACE);		
		resultStatement.append(this.schemaName);
		resultStatement.append(SqlDictionary.PERIOD);
		resultStatement.append(this.tableName);
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(SqlDictionary.WHERE);
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(this.whereClause);
		resultStatement.append(SqlDictionary.END_STATEMENT);
		
		return resultStatement.toString();
	}
}
