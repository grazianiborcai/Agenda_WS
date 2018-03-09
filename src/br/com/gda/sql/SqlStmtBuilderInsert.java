package br.com.gda.sql;

import java.util.Iterator;

final class SqlStmtBuilderInsert extends SqlStmtBuilderAbstract {

	SqlStmtBuilderInsert(SqlStmtBuilderOption option) {
		super(option);
	}
	
	
	
	@Override protected void initializationHook(SqlStmtBuilderOption option) {		
		this.schemaName = option.schemaName;
		this.tableName = option.tableName;
		this.columns = option.columns;
	}
	
	
	
	@Override protected void tryToCheckStatementGenerationHook() {		
		if (this.columns == null)
			throw new NullPointerException("Columns for this given builder were passed null");
		
		if (this.columns.isEmpty())
			throw new IllegalArgumentException("No columns for this given builder were passed");
	}
	
	
	
	@Override protected String generateStatementHook() {
		StringBuilder resultStatement = new StringBuilder();
		
		resultStatement.append(SqlOperation.INSERT.toString());
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(SqlDictionary.INTO);
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(this.schemaName);
		resultStatement.append(SqlDictionary.PERIOD);
		resultStatement.append(this.tableName);
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(SqlDictionary.PARENTHESIS_OPENING);
		
		
		Iterator<String> columnItr = this.columns.iterator();
		
		while (columnItr.hasNext()) {
			String eachColumn = columnItr.next();
			resultStatement.append(eachColumn);
			
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
		
		
		for (int i=0; i<this.columns.size(); i++) {
			resultStatement.append(SqlDictionary.WILDCARD);
			
			int nextColumnIndex = i + 1;
			if (nextColumnIndex < this.columns.size()) {
				resultStatement.append(SqlDictionary.COMMA);
				resultStatement.append(SqlDictionary.SPACE);
			}
		}
		
		
		resultStatement.append(SqlDictionary.PARENTHESIS_CLOSING);
		resultStatement.append(SqlDictionary.END_STATEMENT);		
		
		
		return resultStatement.toString();
	}
}
