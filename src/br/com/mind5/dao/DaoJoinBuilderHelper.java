package br.com.mind5.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;

public final class DaoJoinBuilderHelper implements DaoJoinBuilder {
	private String leftTable;
	private String rightTable;
	private List<DaoDataClause> constraints;
	private List<String> columns;
	private DaoJoinType joinType;
	private final Class<?> childClazz;
	
	
	public DaoJoinBuilderHelper(Class<?> childClass) {
		checkArgument(childClass);
		
		childClazz = childClass;
		constraints = new ArrayList<>();
		columns = new ArrayList<>();
	}
	
	
	
	public DaoJoinBuilderHelper addLeftTable(String tableName) {
		leftTable = tableName;
		return this;
	}
	
	
	
	public DaoJoinBuilderHelper addRightTable(String tableName) {
		rightTable = tableName;
		return this;
	}
	
	
	
	public DaoJoinBuilderHelper addJoinType(DaoJoinType type) {
		joinType = type;
		return this;
	}
	
	
	
	public DaoJoinBuilderHelper addColumn(String columnName) {
		columns.add(columnName);
		return this;
	}
	
	
	
	public DaoJoinBuilderHelper addConstraint(String columnName, String columnValue, DaoWhereCondition condition) {
		DaoDataClause oneConstraint = new DaoDataClause();
		
		oneConstraint.columnName = columnName;
		oneConstraint.columnValue = columnValue;
		oneConstraint.condition = condition.getSymbol();
		
		constraints.add(oneConstraint);
		return this;
	}
	
	
	
	public DaoJoinBuilderHelper addConstraintEqual(String columnName, String columnValue) {
		DaoDataClause oneConstraint = new DaoDataClause();
		
		oneConstraint.columnName = columnName;
		oneConstraint.columnValue = columnValue;
		oneConstraint.condition = DaoWhereCondition.EQUAL.getSymbol();
		
		constraints.add(oneConstraint);
		return this;
	}
	
	
	
	public boolean check() {
		try {
			checkBeforeBuild(leftTable, rightTable, columns, joinType, constraints);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	@Override public DaoJoin build() {
		checkBeforeBuild(leftTable, rightTable, columns, joinType, constraints);
		
		DaoJoin join = new DaoJoin();
		
		join.rightTableName = rightTable;
		join.joinType = joinType;
		join.joinColumns = getJoinColumns(leftTable, columns);
		join.constraintClause = getConstraint(constraints, rightTable);
		
		return join;
	}
	
	
	
	private List<DaoJoinColumn> getJoinColumns(String leftTableName, List<String> columnNames) {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();		
		
		for (String eachColumn : columnNames) {
			DaoJoinColumn oneColumn = new DaoJoinColumn();	
			
			oneColumn.leftTableName = leftTableName;
			oneColumn.leftColumnName = eachColumn;
			oneColumn.rightColumnName = eachColumn;		
			
			joinColumns.add(oneColumn);
		}		

		
		return joinColumns;
	}
	
	
	
	private String getConstraint(List<DaoDataClause> allConstraints, String rightTableName) {		
		if (shouldSkipConstraint(allConstraints))
			return null;	
		
		
		StringBuilder constrainClause = new StringBuilder(); 		
		Iterator<DaoDataClause> itr = allConstraints.iterator();
		
		while (itr.hasNext()) {		
			DaoDataClause eachConstraint = itr.next();
			
			constrainClause.append(rightTableName);
			constrainClause.append(DaoDictionary.PERIOD);
			constrainClause.append(eachConstraint.columnName);
			constrainClause.append(DaoDictionary.SPACE);
			constrainClause.append(DaoDictionary.EQUAL);
			constrainClause.append(DaoDictionary.SPACE);
			constrainClause.append(DaoDictionary.QUOTE);
			constrainClause.append(eachConstraint.columnValue);
			constrainClause.append(DaoDictionary.QUOTE);
			
			if (itr.hasNext())
				constrainClause.append(DaoDictionary.SPACE);
		};
		
		
		return constrainClause.toString();		
	}
	
	
	
	private void checkArgument(Class<?> childClass) {
		if (childClass == null) {
			logException(new NullPointerException("childClass" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("childClass" + SystemMessage.NULL_ARGUMENT);	
		};
	}
	
	
	
	private void checkBeforeBuild(String leftTableName, String rightTableName, List<String> columnNames, DaoJoinType join, List<DaoDataClause> allConstraints) {
		if (leftTableName == null) {
			logException(new NullPointerException("leftTableName" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("leftTableName" + SystemMessage.NULL_ARGUMENT);	
		};
		
		
		if (rightTableName == null) {
			logException(new NullPointerException("rightTableName" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("rightTableName" + SystemMessage.NULL_ARGUMENT);	
		};
		
		
		if (columnNames == null) {
			logException(new NullPointerException("columnNames" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("columnNames" + SystemMessage.NULL_ARGUMENT);	
		};
		
		
		if (columnNames.isEmpty()) {
			logException(new NullPointerException("columnNames" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("columnNames" + SystemMessage.NULL_ARGUMENT);	
		};
		
		
		if (join == null) {
			logException(new NullPointerException("joinType" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("joinType" + SystemMessage.NULL_ARGUMENT);	
		};
		
		
		checkConstraint(allConstraints);
	}
	
	
	
	private void checkConstraint(List<DaoDataClause> allConstraints) {
		if (shouldSkipConstraint(allConstraints))
			return;
		
		for (DaoDataClause eachConstraint : allConstraints) {
			if (eachConstraint.columnName == null) {
				logException(new NullPointerException("constraint.columnName" + SystemMessage.NULL_ARGUMENT));
				throw new NullPointerException("constraint.columnName" + SystemMessage.NULL_ARGUMENT);	
			};
			
			
			if (eachConstraint.columnValue == null) {
				logException(new NullPointerException("constraint.columnValue" + SystemMessage.NULL_ARGUMENT));
				throw new NullPointerException("constraint.columnValue" + SystemMessage.NULL_ARGUMENT);	
			};
			
			
			if (eachConstraint.condition == null) {
				logException(new NullPointerException("constraint.condition" + SystemMessage.NULL_ARGUMENT));
				throw new NullPointerException("constraint.condition" + SystemMessage.NULL_ARGUMENT);	
			};
		}
	}
	
	
	
	private boolean shouldSkipConstraint(List<DaoDataClause> allConstraints) {
		if (allConstraints == null)
			return true;		
		
		if (allConstraints.isEmpty())
			return true;
		
		return false;
	}
	
	
	
	private void logException(Exception e) {		
		Logger logger = LogManager.getLogger(childClazz);
		logger.error(e.getMessage(), e);
	}	
}
