package br.com.mind5.business.employeeWorkTimeConflict.dao;

import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.DaoWhereCondition;
import br.com.mind5.dao.DaoWhereOperator;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class EmpwocoWhere implements DaoStmtWhere {
	private String whereClause;
	
	
	public EmpwocoWhere(DaoWhereBuilderOption whereOption, String tableName, EmpwocoInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, EmpwocoInfo recordInfo) {
		DaoWhereBuilder builderKey = DaoWhereBuilder.factory(whereOption);		
		DaoWhereBuilder builderBeginTime = DaoWhereBuilder.factory(whereOption);
		DaoWhereBuilder builderEndTime = DaoWhereBuilder.factory(whereOption);		
		DaoWhereBuilder builderBeginEndTime = DaoWhereBuilder.factory(whereOption);	
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			builderKey = generateKey(eachColumn, recordInfo, builderKey);
			builderBeginTime = generateBeginTime(eachColumn, recordInfo, builderBeginTime);
			builderEndTime = generateEndTime(eachColumn, recordInfo, builderEndTime);
			builderBeginEndTime = generateBeginEndTime(eachColumn, recordInfo, builderBeginEndTime);
		}
		
		
		builderBeginEndTime.mergeBuilder(builderBeginTime, DaoWhereOperator.OR);
		builderBeginEndTime.mergeBuilder(builderEndTime, DaoWhereOperator.OR);
		builderKey.mergeBuilder(builderBeginEndTime, DaoWhereOperator.AND);
		
		whereClause = builderKey.generateClause();
	}
	
	
	
	private DaoWhereBuilder generateKey(DaoColumn column, EmpwocoInfo recordInfo, DaoWhereBuilder builder) {
		switch(column.columnName) {
		case EmpwocoDbTableColumn.COL_COD_OWNER :
			builder.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codOwner));
			break;
			
		case EmpwocoDbTableColumn.COL_COD_STORE :
			builder.addClauseAnd(column, DaoFormatter.numberToString(recordInfo.codStore), DaoWhereCondition.NOT_EQUAL);
			break;			

		case EmpwocoDbTableColumn.COL_COD_EMPLOYEE :
			builder.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codEmployee));
			break;
			
		case EmpwocoDbTableColumn.COL_COD_WEEKDAY :
			builder.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codWeekday));
			break;
			
		case EmpwocoDbTableColumn.COL_RECORD_MODE :
			builder.addClauseEqualAnd(column, recordInfo.recordMode);
			break;
		}
		
		return builder;
	}
	
	
	
	private DaoWhereBuilder generateBeginTime(DaoColumn column, EmpwocoInfo recordInfo, DaoWhereBuilder builder) {
		switch(column.columnName) {
		case EmpwocoDbTableColumn.COL_BEGIN_TIME :
			builder.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.LESS_OR_EQUAL);
			break;
			
		case EmpwocoDbTableColumn.COL_END_TIME :
			builder.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.GREATER_OR_EQUAL);
			break;
		}
		
		return builder;
	}	
	
	
	
	private DaoWhereBuilder generateEndTime(DaoColumn column, EmpwocoInfo recordInfo, DaoWhereBuilder builder) {
		switch(column.columnName) {
		case EmpwocoDbTableColumn.COL_BEGIN_TIME :
			builder.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.LESS_OR_EQUAL);
			break;
			
		case EmpwocoDbTableColumn.COL_END_TIME :
			builder.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.GREATER_OR_EQUAL);
			break;
		}
		
		return builder;
	}	
	
	
	
	private DaoWhereBuilder generateBeginEndTime(DaoColumn column, EmpwocoInfo recordInfo, DaoWhereBuilder builder) {
		switch(column.columnName) {
		case EmpwocoDbTableColumn.COL_BEGIN_TIME :
			builder.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.GREATER_OR_EQUAL);
			break;
			
		case EmpwocoDbTableColumn.COL_END_TIME :
			builder.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.LESS_OR_EQUAL);
			break;
		}
		
		return builder;
	}	
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
