package br.com.gda.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;

abstract class DaoStmtBuilderTemplate implements DaoStmtBuilder {
	private final boolean POSITIVE = true;
	
	private String schemaName;
	private String tableName;
	private String whereClause;
	private List<DaoColumn> columns;
	private List<DaoJoin> joins;
	private Class<?> childClass;
	
	
	DaoStmtBuilderTemplate(DaoStmtBuilderOption option, Class<?> clazz) {
		checkArgument(option, clazz);		
		
		schemaName = option.schemaName;
		tableName = option.tableName;
		columns = buildColumns(option.columns, option.ignoreLookUpColumn, option.ignoreAutoIncrementedColumn);
		whereClause = option.whereClause;
		joins = option.joins;
		childClass = clazz;
	}
	
	
	
	private List<DaoColumn> buildColumns(List<DaoColumn> columns, boolean skipLookUp, boolean skipAutoIncremented) {
		List<DaoColumn> resultColumns = new ArrayList<>();
		
		for (DaoColumn eachColumn : columns) {
			if (shouldSkip(eachColumn, skipLookUp, skipAutoIncremented))
				continue;
			
			resultColumns.add(eachColumn);
		}
		
		return resultColumns;
	}
	
	
	
	private boolean shouldSkip(DaoColumn column, boolean skipLookUp, boolean skipAutoIncremented) {
		if (skipLookUp == POSITIVE && column.isLookUp == POSITIVE)
			return true;
		
		if (skipAutoIncremented == POSITIVE && column.isAutoIncremented == POSITIVE)
			return true;
		
		return false;
	}
	
	
	
	@Override public boolean checkStmtBuild() {
		try {
			checkStmtBuildDefault();
			checkStmtBuildHook();
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	protected void checkStmtBuildHook() {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	public String buildStmt() {
		checkStmtBuild();
		return buildStmtHook(schemaName, tableName, whereClause, columns, joins);	//TODO: Defensive Copy ?
	}
	
	
	
	protected String buildStmtHook(String schemaName, String tableName, String whereClause, List<DaoColumn> columns, List<DaoJoin> joins) {
		//Template method to be overridden by subclasses
		logException(new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION));
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private void checkStmtBuildDefault() {
		if (schemaName == null) {
			logException(new NullPointerException(SystemMessage.NULL_SCHEMA));
			throw new NullPointerException(SystemMessage.NULL_SCHEMA);	
		}
		
		
		if (tableName == null) {
			logException(new NullPointerException(SystemMessage.NULL_TABLE_NAME));
			throw new NullPointerException(SystemMessage.NULL_TABLE_NAME);	
		}
	}
	
	
	
	protected void checkWhereClause() {
		if (whereClause == null) {
			logException(new NullPointerException(SystemMessage.NULL_WHERE_CLAUSE));
			throw new NullPointerException(SystemMessage.NULL_WHERE_CLAUSE);	
		}
	}
	
	
	
	protected void checkColumns() {
		if (columns == null) {
			logException(new NullPointerException(SystemMessage.NULL_COLUMNS));
			throw new NullPointerException(SystemMessage.NULL_COLUMNS);
		}
		
		
		if (columns.isEmpty()) {
			logException(new IllegalArgumentException(SystemMessage.EMPTY_COLUMNS));
			throw new IllegalArgumentException(SystemMessage.EMPTY_COLUMNS);
		}
	}
	
	
	
	private void checkArgument(DaoStmtBuilderOption option, Class<?> clazz) {
		if (clazz == null) {
			logException(new NullPointerException("clazz" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("clazz" + SystemMessage.NULL_ARGUMENT);	
		}
		
		
		if (option == null) {
			logException(new NullPointerException(SystemMessage.NULL_SQL_BUILDER_OPTION));
			throw new NullPointerException(SystemMessage.NULL_SQL_BUILDER_OPTION);	
		}	
	}
	
	
	
	protected void logException(Exception e) {
		Class<?> clazz = childClass;
		
		if (clazz == null)
			clazz = this.getClass();
		
		Logger logger = LogManager.getLogger(clazz);
		logger.error(e.getMessage(), e);
	}	
}
