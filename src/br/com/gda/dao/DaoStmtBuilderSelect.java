package br.com.gda.dao;

import java.util.Iterator;
import java.util.List;

import br.com.gda.common.SystemMessage;

final class DaoStmtBuilderSelect extends DaoStmtBuilderTemplate {

	DaoStmtBuilderSelect(DaoStmtBuilderOption option) {
		super(option);
	}
	
	
	
	@Override protected void tryToCheckStatementGenerationHook(String whereClause, List<DaoColumn> columns) {		
		if (columns == null)
			throw new NullPointerException(SystemMessage.NULL_COLUMNS);
		
		if (columns.isEmpty())
			throw new IllegalArgumentException(SystemMessage.EMPTY_COLUMNS);
		
		if (whereClause == null)
			throw new NullPointerException(SystemMessage.NULL_WHERE_CLAUSE);
	}
	
	
	
	@Override protected String generateStatementHook(String schemaName, String tableName, String whereClause, List<DaoColumn> columns, List<DaoJoin> joins) {
		StringBuilder resultStatement = new StringBuilder();
		
		resultStatement.append(DaoOperation.SELECT.toString());
		resultStatement.append(DaoDictionary.SPACE);
		
		Iterator<DaoColumn> columnItr = columns.iterator();
		
		while (columnItr.hasNext()) {
			DaoColumn eachColumn = columnItr.next();
			resultStatement.append(eachColumn.tableName);
			resultStatement.append(DaoDictionary.PERIOD);
			resultStatement.append(eachColumn.columnName);
			
			if (columnItr.hasNext()) {
				resultStatement.append(DaoDictionary.COMMA);
				resultStatement.append(DaoDictionary.SPACE);
			}
		}
		
		resultStatement.append(DaoDictionary.SPACE);
		resultStatement.append(DaoDictionary.FROM);
		resultStatement.append(DaoDictionary.SPACE);		
		resultStatement.append(schemaName);
		resultStatement.append(DaoDictionary.PERIOD);
		resultStatement.append(tableName);
		resultStatement.append(DaoDictionary.SPACE);
		
		//### join
		//TODO: organizar esse código em métodos
		if (joins != null) {		
			for (DaoJoin eachJoin : joins) {
				resultStatement.append(eachJoin.joinType.toString());
				resultStatement.append(DaoDictionary.SPACE);
				resultStatement.append(schemaName);
				resultStatement.append(DaoDictionary.PERIOD);
				resultStatement.append(eachJoin.rightTableName);
				resultStatement.append(DaoDictionary.SPACE);
				resultStatement.append(DaoDictionary.ON);
				resultStatement.append(DaoDictionary.SPACE);
				
				Iterator<DaoJoinColumn> joinColumnItr = eachJoin.joinColumns.iterator();				
				
				while (joinColumnItr.hasNext()) {
					DaoJoinColumn eachJoinColumn = joinColumnItr.next();
					resultStatement.append(eachJoinColumn.leftTableName);
					resultStatement.append(DaoDictionary.PERIOD);
					resultStatement.append(eachJoinColumn.leftColumnName);
					resultStatement.append(DaoDictionary.SPACE);
					resultStatement.append(eachJoinColumn.condition);
					resultStatement.append(DaoDictionary.SPACE);
					resultStatement.append(eachJoin.rightTableName);
					resultStatement.append(DaoDictionary.PERIOD);
					resultStatement.append(eachJoinColumn.rightColumnName);
					resultStatement.append(DaoDictionary.SPACE);
					
					if (joinColumnItr.hasNext()) {
						resultStatement.append(DaoDictionary.AND);
						resultStatement.append(DaoDictionary.SPACE);
					}
				}
				
				
				if (eachJoin.constraintClause != null) {
					if (!eachJoin.joinColumns.isEmpty()) {
						resultStatement.append(DaoDictionary.AND);
						resultStatement.append(DaoDictionary.SPACE);
					}
					resultStatement.append(eachJoin.constraintClause);
					resultStatement.append(DaoDictionary.SPACE);
				}
			}
		}
		
		resultStatement.append(DaoDictionary.WHERE);
		resultStatement.append(DaoDictionary.SPACE);
		resultStatement.append(whereClause);
		resultStatement.append(DaoDictionary.END_STATEMENT);
		
		return resultStatement.toString();
	}
}
