package br.com.gda.employee.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.sql.SqlStmtBuilder;
import br.com.gda.sql.SqlStmtBuilderOption;

abstract class EmpStmtBuilderAbstract<T> {
	protected SqlStmtBuilder builder;
	protected SqlStmtBuilderOption builderOption;
	protected T infoRecord;
	protected String schemaName;
	
	
	
	protected EmpStmtBuilderAbstract(String schemaName, T infoRecord) {
		this.infoRecord = infoRecord;
		this.schemaName = schemaName;
		
		checkArgument();
		buildStatementOption();
		buildStatement();
	}
	
	
	
	private void checkArgument() {
		if (this.infoRecord == null)
			throw new NullPointerException("infoRecord aegument is null");
		
		if (this.schemaName == null)
			throw new NullPointerException("schemaName aegument is null");
	}
	
	
	
	private void buildStatementOption() {
		builderOption = new SqlStmtBuilderOption();		
		builderOption.schemaName = this.schemaName;		
		builderOption.tableName = buildTableNameHook();
		builderOption.columns = buildColumnsHook();
		builderOption.whereClause = buildWhereClauseHook();
	}
	
	
	
	protected String buildTableNameHook() {
		//Template method: to be overridden by subclasses
		return null;
	}
	
	
	
	protected List<String> buildColumnsHook() {
		//Template method: to be overridden by subclasses
		return new ArrayList<String>();
	}
	
	
	
	protected String buildWhereClauseHook() {
		//Template method: to be overridden by subclasses
		return null;
	}
	
	
	
	private void buildStatement() {		
		builder = buildStatementHook();
	}
	
	
	
	protected SqlStmtBuilder buildStatementHook() {		
		//Template method: to be overridden by subclasses
		return null;
	}
	
	
	
	public boolean checkStatementGeneration() {
		return builder.checkStatementGeneration();
	}
	
	
	
	public String generateStatement() {
		String resultStatement = builder.generateStatement();
		return resultStatement;
	}
}