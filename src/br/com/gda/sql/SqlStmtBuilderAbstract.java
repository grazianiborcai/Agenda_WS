package br.com.gda.sql;

import java.util.ArrayList;
import java.util.List;

abstract class SqlStmtBuilderAbstract implements SqlStmtBuilder {
	protected String schemaName;
	protected String tableName;
	protected String whereClause;
	protected List<String> columns = new ArrayList<>();
	
	
	SqlStmtBuilderAbstract(SqlStmtBuilderOption option) {
		if (option == null)
			throw new NullPointerException("option argument is null");		
		
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
			throw new NullPointerException("Schema name is null");
		
		if (this.tableName == null)
			throw new NullPointerException("Table name is null");
		
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
