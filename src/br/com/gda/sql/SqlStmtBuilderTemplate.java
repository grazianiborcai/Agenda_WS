package br.com.gda.sql;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemMessage;

abstract class SqlStmtBuilderTemplate implements SqlStmtBuilder {
	private final boolean IGNORE = true;
	private final boolean IS_LOOKUP_COLUMN = true;
	private final boolean IS_AUTO_INCREMENTED_COLUMN = true;
	
	private String schemaName;
	private String tableName;
	private String whereClause;
	private List<SqlColumn> columns;
	private List<SqlJoin> joins;
	private boolean ignoreLookUpColumn;
	private boolean ignoreAutoIncrementedColumn;
	
	
	SqlStmtBuilderTemplate(SqlStmtBuilderOption option) {
		if (option == null)
			throw new NullPointerException(SystemMessage.NULL_SQL_BUILDER_OPTION);		
		
		this.schemaName = option.schemaName;
		this.tableName = option.tableName;
		this.ignoreLookUpColumn = option.ignoreLookUpColumn;
		this.ignoreAutoIncrementedColumn = option.ignoreAutoIncrementedColumn;
		this.columns = buildColumns(option.columns);
		this.whereClause = option.whereClause;
		this.joins = option.joins;
	}
	
	
	
	private List<SqlColumn> buildColumns(List<SqlColumn> columns) {
		List<SqlColumn> resultColumns = new ArrayList<>();
		
		for (SqlColumn eachColumn : columns) {
			if (ignoreLookUpColumn == IGNORE && eachColumn.isLookUp == IS_LOOKUP_COLUMN)
				continue;
			
			if (ignoreAutoIncrementedColumn == IGNORE && eachColumn.isAutoIncremented == IS_AUTO_INCREMENTED_COLUMN)
				continue;
			
			resultColumns.add(eachColumn);
		}
		
		return resultColumns;
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
		
		tryToCheckStatementGenerationHook(this.whereClause, this.columns);
	}
	
	
	
	protected void tryToCheckStatementGenerationHook(String whereClause, List<SqlColumn> columns) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	public String generatedStatement() {
		tryToCheckStatementGeneration();
		return generateStatementHook(this.schemaName, this.tableName, this.whereClause, this.columns, this.joins);
	}
	
	
	
	protected String generateStatementHook(String schemaName, String tableName, String whereClause, List<SqlColumn> columns, List<SqlJoin> joins) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
}
