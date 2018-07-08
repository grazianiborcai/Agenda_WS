package br.com.gda.sql;

import java.util.Iterator;
import java.util.List;

import br.com.gda.common.SystemMessage;

final class SqlStmtBuilderSelect extends SqlStmtBuilderTemplate {

	SqlStmtBuilderSelect(SqlStmtBuilderOption option) {
		super(option);
	}
	
	
	
	@Override protected void tryToCheckStatementGenerationHook(String whereClause, List<SqlColumn> columns) {		
		if (columns == null)
			throw new NullPointerException(SystemMessage.NULL_COLUMNS);
		
		if (columns.isEmpty())
			throw new IllegalArgumentException(SystemMessage.EMPTY_COLUMNS);
		
		if (whereClause == null)
			throw new NullPointerException(SystemMessage.NULL_WHERE_CLAUSE);
	}
	
	
	
	@Override protected String generateStatementHook(String schemaName, String tableName, String whereClause, List<SqlColumn> columns, List<SqlJoin> joins) {
		StringBuilder resultStatement = new StringBuilder();
		
		resultStatement.append(SqlOperation.SELECT.toString());
		resultStatement.append(SqlDictionary.SPACE);
		
		Iterator<SqlColumn> columnItr = columns.iterator();
		
		while (columnItr.hasNext()) {
			SqlColumn eachColumn = columnItr.next();
			resultStatement.append(eachColumn.tableName);
			resultStatement.append(SqlDictionary.PERIOD);
			resultStatement.append(eachColumn.columnName);
			
			if (columnItr.hasNext()) {
				resultStatement.append(SqlDictionary.COMMA);
				resultStatement.append(SqlDictionary.SPACE);
			}
		}
		
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(SqlDictionary.FROM);
		resultStatement.append(SqlDictionary.SPACE);		
		resultStatement.append(schemaName);
		resultStatement.append(SqlDictionary.PERIOD);
		resultStatement.append(tableName);
		resultStatement.append(SqlDictionary.SPACE);
		
		//### join
		//TODO: organizar esse código em métodos
		if (joins != null) {		
			for (SqlJoin eachJoin : joins) {
				resultStatement.append(eachJoin.joinType.toString());
				resultStatement.append(SqlDictionary.SPACE);
				resultStatement.append(schemaName);
				resultStatement.append(SqlDictionary.PERIOD);
				resultStatement.append(eachJoin.rightTableName);
				resultStatement.append(SqlDictionary.SPACE);
				resultStatement.append(SqlDictionary.ON);
				resultStatement.append(SqlDictionary.SPACE);
				
				Iterator<SqlJoinColumn> joinColumnItr = eachJoin.joinColumns.iterator();				
				
				while (joinColumnItr.hasNext()) {
					SqlJoinColumn eachJoinColumn = joinColumnItr.next();
					resultStatement.append(eachJoinColumn.leftTableName);
					resultStatement.append(SqlDictionary.PERIOD);
					resultStatement.append(eachJoinColumn.leftColumnName);
					resultStatement.append(SqlDictionary.SPACE);
					resultStatement.append(eachJoinColumn.condition);
					resultStatement.append(SqlDictionary.SPACE);
					resultStatement.append(eachJoin.rightTableName);
					resultStatement.append(SqlDictionary.PERIOD);
					resultStatement.append(eachJoinColumn.rightColumnName);
					resultStatement.append(SqlDictionary.SPACE);
					
					if (joinColumnItr.hasNext()) {
						resultStatement.append(SqlDictionary.AND);
						resultStatement.append(SqlDictionary.SPACE);
					}
				}
				
				
				if (eachJoin.constraintClause != null) {
					if (!eachJoin.joinColumns.isEmpty()) {
						resultStatement.append(SqlDictionary.AND);
						resultStatement.append(SqlDictionary.SPACE);
					}
					resultStatement.append(eachJoin.constraintClause);
					resultStatement.append(SqlDictionary.SPACE);
				}
			}
		}
		
		resultStatement.append(SqlDictionary.WHERE);
		resultStatement.append(SqlDictionary.SPACE);
		resultStatement.append(whereClause);
		resultStatement.append(SqlDictionary.END_STATEMENT);
		
		return resultStatement.toString();
	}
}
