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
		builderOption.columns = buildColumns();

		buildStatementOptionHook();
	}
	
	
	
	protected void buildStatementOptionHook() {
		//Template method: to be overridden by subclasses
	}
	
	
	
	private List<String> buildColumns() {
		return buildColumnsHook();
	}
	
	
	
	protected List<String> buildColumnsHook() {
		//Template method: to be overridden by subclasses
		return new ArrayList<String>();
	}
	
	
	
	private void buildStatement() {
		buildStatementHook();
	}
	
	
	
	protected void buildStatementHook() {		
		//Template method: to be overridden by subclasses
	}
	
	
	
	public boolean checkStatementGeneration() {
		return builder.checkStatementGeneration();
	}
	
	
	
	public String generateStatement() {
		String resultStatement = builder.generateStatement();
		return resultStatement;
	}
}