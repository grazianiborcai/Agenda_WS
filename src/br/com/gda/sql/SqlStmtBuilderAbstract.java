package br.com.gda.sql;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;

abstract class SqlStmtBuilderAbstract implements SqlStmtBuilder {
	protected String schemaName;
	protected String tableName;
	protected String whereClause;
	protected List<SqlColumn> columns = new ArrayList<>();
	
	
	SqlStmtBuilderAbstract(SqlStmtBuilderOption option) {
		if (option == null)
			throw new NullPointerException(SystemMessage.NULL_SQL_BUILDER_OPTION);		
		
		this.schemaName = option.schemaName;
		this.tableName = option.tableName;
		this.columns = option.columns;
		this.whereClause = option.whereClause;
	}
	
	
	
	public boolean checkStatementGeneration() {
		try {
			tryToCheckStatementGeneration();
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	private void tryToCheckStatementGeneration() {
		if (this.schemaName == null)
			throw new NullPointerException(SystemMessage.NULL_SCHEMA);
		
		if (this.tableName == null)
			throw new NullPointerException(SystemMessage.NULL_TABLE_NAME);
		
		tryToCheckStatementGenerationHook();
	}
	
	
	
	protected void tryToCheckStatementGenerationHook() {
		//Template method to be overridden by subclasses
	}
	
	
	
	public String generateStatement() {
		tryToCheckStatementGeneration();
		return generateStatementHook();
	}
	
	
	
	protected String generateStatementHook() {
		//Template method to be overridden by subclasses
		return null;
	}
}
