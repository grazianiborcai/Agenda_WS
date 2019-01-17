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
		
		resultStatement = appendOperation(resultStatement);
		resultStatement = appendColumn(resultStatement, columns);
		resultStatement = appendTable(resultStatement, schemaName, tableName);
		resultStatement = appendJoin(resultStatement, schemaName, joins);
		resultStatement = appendWhere(resultStatement, whereClause);
		
		return resultStatement.toString();
	}
	
	
	
	private StringBuilder appendOperation(StringBuilder statement) {
		statement.append(DaoOperation.SELECT.toString());
		statement.append(DaoDictionary.SPACE);
		
		return statement;		
	}
	
	
	
	private StringBuilder appendColumn(StringBuilder statement, List<DaoColumn> columns) {
		Iterator<DaoColumn> columnItr = columns.iterator();
		
		while (columnItr.hasNext()) {
			DaoColumn eachColumn = columnItr.next();
			statement.append(eachColumn.tableName);
			statement.append(DaoDictionary.PERIOD);
			statement.append(eachColumn.columnName);
			
			if (columnItr.hasNext()) {
				statement.append(DaoDictionary.COMMA);
				statement.append(DaoDictionary.SPACE);
			}
		}
		
		return statement;		
	}
	
	
	
	private StringBuilder appendTable(StringBuilder statement, String schemaName, String tableName) {
		statement.append(DaoDictionary.SPACE);
		statement.append(DaoDictionary.FROM);
		statement.append(DaoDictionary.SPACE);		
		statement.append(schemaName);
		statement.append(DaoDictionary.PERIOD);
		statement.append(tableName);
		statement.append(DaoDictionary.SPACE);
		
		return statement;		
	}
	
	
	
	private StringBuilder appendJoin(StringBuilder statement, String schemaName, List<DaoJoin> joins) {
		if (shouldAppendJoin(joins) == false)
			return statement;
		
	
		for (DaoJoin eachJoin : joins) {
			statement = appendJoinTable(statement, schemaName, eachJoin);
			
			if (shouldAppendJoinColumn(eachJoin.joinType))
				statement = appendJoinColumn(statement, eachJoin);				
			
			if (shouldAppendJoinConstraint(eachJoin.constraintClause)) 
				statement = appendJoinConstraint(statement, eachJoin);				
		}

		
		return statement;		
	}
	
	
	
	private boolean shouldAppendJoin(List<DaoJoin> joins) {
		if (joins == null)
			return false;
		
		if (joins.isEmpty())
			return false;
		
		 return true;
	}
	
	
	
	private StringBuilder appendJoinTable(StringBuilder statement, String schemaName, DaoJoin join) {
		statement.append(join.joinType.toString());
		statement.append(DaoDictionary.SPACE);
		statement.append(schemaName);
		statement.append(DaoDictionary.PERIOD);
		statement.append(join.rightTableName);
		statement.append(DaoDictionary.SPACE);
		
		return statement;
	}
	
	
	
	private boolean shouldAppendJoinColumn(DaoJoinType joinType) {
		if (joinType == DaoJoinType.CROSS_JOIN)
			return false;
		
		 return true;
	}
	
	
	
	private StringBuilder appendJoinColumn(StringBuilder statement, DaoJoin join) {
		statement.append(DaoDictionary.ON);
		statement.append(DaoDictionary.SPACE);
		
		Iterator<DaoJoinColumn> joinColumnItr = join.joinColumns.iterator();				
		
		while (joinColumnItr.hasNext()) {
			DaoJoinColumn eachJoinColumn = joinColumnItr.next();
			statement.append(eachJoinColumn.leftTableName);
			statement.append(DaoDictionary.PERIOD);
			statement.append(eachJoinColumn.leftColumnName);
			statement.append(DaoDictionary.SPACE);
			statement.append(eachJoinColumn.condition);
			statement.append(DaoDictionary.SPACE);
			statement.append(join.rightTableName);
			statement.append(DaoDictionary.PERIOD);
			statement.append(eachJoinColumn.rightColumnName);
			statement.append(DaoDictionary.SPACE);
			
			if (joinColumnItr.hasNext()) {
				statement.append(DaoDictionary.AND);
				statement.append(DaoDictionary.SPACE);
			}
		}
		
		return statement;		
	}
	
	
	
	private boolean shouldAppendJoinConstraint(String constraintClause) {
		if (constraintClause == null)
			return false;
		
		 return true;
	}
	
	
	
	private StringBuilder appendJoinConstraint(StringBuilder statement, DaoJoin join) {
		if (join.joinColumns.isEmpty() == false) {
			statement.append(DaoDictionary.AND);
			statement.append(DaoDictionary.SPACE);
		}
		
		statement.append(join.constraintClause);
		statement.append(DaoDictionary.SPACE);
		
		return statement;		
	}
	
	
	
	private StringBuilder appendWhere(StringBuilder statement, String whereClause) {
		statement.append(DaoDictionary.WHERE);
		statement.append(DaoDictionary.SPACE);
		statement.append(whereClause);
		statement.append(DaoDictionary.END_STATEMENT);
		
		return statement;		
	}
}
