package br.com.gda.sql;

import java.util.Iterator;

public final class SqlStmtBuilderSelect extends SqlStmtBuilderAbstract {

	SqlStmtBuilderSelect(SqlStmtBuilderOption option) {
		super(option);
	}
	
	
	
	@Override protected void tryToCheckStatementGenerationHook() {		
		if (this.columns == null)
			throw new NullPointerException("Columns for this given builder were passed null");
		
		if (this.columns.isEmpty())
			throw new IllegalArgumentException("No columns for this given builder were passed");
		
		if (this.whereClause == null)
			throw new NullPointerException("where clause is null");
	}
	
	
	
	@Override protected String generateStatementHook() {
		StringBuilder resultStatement = new StringBuilder();
		
		resultStatement.append(SqlOperation.SELECT.toString());
		resultStatement.append(SqlDictionary.SPACE);
		
		Iterator<String> columnItr = this.columns.iterator();
		
		while (columnItr.hasNext()) {
			String eachColumn = columnItr.next();
			resultStatement.append(eachColumn);
			
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
