package br.com.gda.business.storeWorkTimeConflict.dao;

import java.util.List;

import br.com.gda.business.storeWorkTimeConflict.info.StoreCoInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.DaoWhereCondition;
import br.com.gda.dao.DaoWhereOperator;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class StoreCoWhere implements DaoStmtWhere {
	private String whereClause;	
	private DaoWhereBuilder builderKey;
	private DaoWhereBuilder builderBeginTime;
	private DaoWhereBuilder builderEndTime;
	
	
	public StoreCoWhere(DaoWhereBuilderOption whereOption, String tableName, StoreCoInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, StoreCoInfo recordInfo) {
		builderKey = DaoWhereBuilder.factory(whereOption);		
		builderBeginTime = DaoWhereBuilder.factory(whereOption);
		builderEndTime = DaoWhereBuilder.factory(whereOption);		
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			generateKey(eachColumn, recordInfo);
			generateBeginTime(eachColumn, recordInfo);
			generateEndTime(eachColumn, recordInfo);
		}
		
		
		builderBeginTime.mergeBuilder(builderEndTime, DaoWhereOperator.OR);
		builderKey.mergeBuilder(builderBeginTime, DaoWhereOperator.AND);
		
		whereClause = builderKey.generateClause();
	}
	
	
	
	private void generateKey(DaoColumn column, StoreCoInfo recordInfo) {
		switch(column.columnName) {
		case "cod_owner" :
			builderKey.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codOwner));
			break;
			
		case "cod_store" :
			builderKey.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codStore));
			break;
			
		case "weekday" :
			builderKey.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codWeekday));
			break;
			
		case "record_mode" :
			builderKey.addClauseEqualAnd(column, recordInfo.recordMode);
			break;
		}
	}
	
	
	
	private void generateBeginTime(DaoColumn column, StoreCoInfo recordInfo) {
		switch(column.columnName) {
		case "begin_time" :
			builderBeginTime.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.LESS_OR_EQUAL);
			break;
			
		case "end_time" :
			builderBeginTime.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.GREATER_OR_EQUAL);
			break;
		}
	}	
	
	
	
	private void generateEndTime(DaoColumn column, StoreCoInfo recordInfo) {
		switch(column.columnName) {
		case "begin_time" :
			builderEndTime.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.LESS_OR_EQUAL);
			break;
			
		case "end_time" :
			builderEndTime.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.GREATER_OR_EQUAL);
			break;
		}
	}	
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
