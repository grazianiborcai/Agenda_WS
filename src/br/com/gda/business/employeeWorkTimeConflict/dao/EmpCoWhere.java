package br.com.gda.business.employeeWorkTimeConflict.dao;

import java.util.List;

import br.com.gda.business.employeeWorkTimeConflict.info.EmpCoInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.DaoWhereCondition;
import br.com.gda.dao.DaoWhereOperator;
import br.com.gda.dao.common.DaoDbTableColumnAll;

final class EmpCoWhere implements DaoStmtWhere {
	private String whereClause;	
	private DaoWhereBuilder builderKey;
	private DaoWhereBuilder builderBeginTime;
	private DaoWhereBuilder builderEndTime;
	private DaoWhereBuilder builderBeginEndTime;
	
	
	public EmpCoWhere(DaoWhereBuilderOption whereOption, String tableName, EmpCoInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, EmpCoInfo recordInfo) {
		builderKey = DaoWhereBuilder.factory(whereOption);		
		builderBeginTime = DaoWhereBuilder.factory(whereOption);
		builderEndTime = DaoWhereBuilder.factory(whereOption);		
		builderBeginEndTime = DaoWhereBuilder.factory(whereOption);	
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			generateKey(eachColumn, recordInfo);
			generateBeginTime(eachColumn, recordInfo);
			generateEndTime(eachColumn, recordInfo);
			generateBeginEndTime(eachColumn, recordInfo);
		}
		
		
		builderBeginEndTime.mergeBuilder(builderBeginTime, DaoWhereOperator.OR);
		builderBeginEndTime.mergeBuilder(builderEndTime, DaoWhereOperator.OR);
		builderKey.mergeBuilder(builderBeginEndTime, DaoWhereOperator.AND);
		
		whereClause = builderKey.generateClause();
	}
	
	
	
	private void generateKey(DaoColumn column, EmpCoInfo recordInfo) {
		switch(column.columnName) {
		case "cod_owner" :
			builderKey.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codOwner));
			break;
			
		case "cod_store" :
			builderKey.addClauseAnd(column, DaoFormatter.numberToString(recordInfo.codStore), DaoWhereCondition.NOT_EQUAL);
			break;			

		case "cod_employee" :
			builderKey.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codEmployee));
			break;
			
		case "weekday" :
			builderKey.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codWeekday));
			break;
			
		case "record_mode" :
			builderKey.addClauseEqualAnd(column, recordInfo.recordMode);
			break;
		}
	}
	
	
	
	private void generateBeginTime(DaoColumn column, EmpCoInfo recordInfo) {
		switch(column.columnName) {
		case "begin_time" :
			builderBeginTime.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.LESS_OR_EQUAL);
			break;
			
		case "end_time" :
			builderBeginTime.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.GREATER_OR_EQUAL);
			break;
		}
	}	
	
	
	
	private void generateEndTime(DaoColumn column, EmpCoInfo recordInfo) {
		switch(column.columnName) {
		case "begin_time" :
			builderEndTime.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.LESS_OR_EQUAL);
			break;
			
		case "end_time" :
			builderEndTime.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.GREATER_OR_EQUAL);
			break;
		}
	}	
	
	
	
	private void generateBeginEndTime(DaoColumn column, EmpCoInfo recordInfo) {
		switch(column.columnName) {
		case "begin_time" :
			builderBeginEndTime.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.GREATER_OR_EQUAL);
			break;
			
		case "end_time" :
			builderBeginEndTime.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.LESS_OR_EQUAL);
			break;
		}
	}	
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
