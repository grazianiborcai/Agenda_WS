package br.com.mind5.business.scheduleRange.dao;

import java.util.List;

import br.com.mind5.business.masterData.info.common.ScheduleStatus;
import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.DaoWhereCondition;
import br.com.mind5.dao.DaoWhereOperator;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

public final class SchedageWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public SchedageWhere(DaoWhereBuilderOption whereOption, String tableName, SchedageInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, SchedageInfo recordInfo) {
		DaoWhereBuilder builderKey = DaoWhereBuilder.factory(whereOption);		
		DaoWhereBuilder builderBeginTime = DaoWhereBuilder.factory(whereOption);
		DaoWhereBuilder builderEndTime = DaoWhereBuilder.factory(whereOption);	
		DaoWhereBuilder builderBeginDate = DaoWhereBuilder.factory(whereOption);
		DaoWhereBuilder builderEndDate = DaoWhereBuilder.factory(whereOption);		
		DaoWhereBuilder builderBeginDay = DaoWhereBuilder.factory(whereOption);
		DaoWhereBuilder builderEndDay = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			builderKey = generateKey(eachColumn, recordInfo, builderKey);
			builderBeginTime = generateBeginTime(eachColumn, recordInfo, builderBeginTime);
			builderEndTime = generateEndTime(eachColumn, recordInfo, builderEndTime);
			builderBeginDate = generateBeginDate(eachColumn, recordInfo, builderBeginDate);
			builderEndDate = generateEndDate(eachColumn, recordInfo, builderEndDate);			
			builderBeginDay = generateBeginDay(eachColumn, recordInfo, builderBeginDay);
			builderEndDay = generateEndDay(eachColumn, recordInfo, builderEndDay);
		}
		
		
		builderBeginDate.mergeBuilder(builderBeginDay, DaoWhereOperator.OR);
		builderBeginDate.mergeBuilder(builderEndDay, DaoWhereOperator.OR);		
		builderBeginDate.mergeBuilder(builderEndTime, DaoWhereOperator.OR);
		builderBeginDate.mergeBuilder(builderBeginTime, DaoWhereOperator.OR);
		builderBeginDate.mergeBuilder(builderEndDate, DaoWhereOperator.OR);		
		builderKey.mergeBuilder(builderBeginDate, DaoWhereOperator.AND);
		
		whereClause = builderKey.generateClause();
	}
	
	
	
	private DaoWhereBuilder generateKey(DaoColumn column, SchedageInfo recordInfo, DaoWhereBuilder builderKey) {
		switch(column.columnName) {
		case SchedageDbTableColumn.COL_COD_OWNER :
			builderKey.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codOwner));
			break;
			
		case SchedageDbTableColumn.COL_COD_STORE :
			builderKey.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codStore));
			break;
			
		case SchedageDbTableColumn.COL_COD_EMPLOYEE :
			builderKey.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codEmployee));
			break;
			
		case SchedageDbTableColumn.COL_DATE :
			builderKey.addClauseAnd(column, DaoFormatter.dateToString(recordInfo.dateValidFrom), DaoWhereCondition.GREATER_OR_EQUAL);
			builderKey.addClauseAnd(column, DaoFormatter.dateToString(recordInfo.dateValidTo), DaoWhereCondition.LESS_OR_EQUAL);
			break;
			
		case SchedageDbTableColumn.COL_COD_SCHEDULE_STATUS :
			builderKey.addClauseAnd(column, ScheduleStatus.CANCELLED.getCodStatus(), DaoWhereCondition.NOT_EQUAL);
			break;
		}
		
		
		return builderKey;
	}
	
	
	
	private DaoWhereBuilder generateBeginTime(DaoColumn column, SchedageInfo recordInfo, DaoWhereBuilder builderBeginTime) {
		switch(column.columnName) {
		case SchedageDbTableColumn.COL_DATE :
			builderBeginTime.addClauseEqualAnd(column, DaoFormatter.dateToString(recordInfo.dateValidFrom));
			builderBeginTime.addClauseAnd(column, DaoFormatter.dateToString(recordInfo.dateValidTo), DaoWhereCondition.NOT_EQUAL);
			break;
				
		
		case SchedageDbTableColumn.COL_END_TIME :
			builderBeginTime.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.timeValidFrom), DaoWhereCondition.GREATER_OR_EQUAL);
			break;
		}	
		
		return builderBeginTime;
	}	
	
	
	
	private DaoWhereBuilder generateEndTime(DaoColumn column, SchedageInfo recordInfo, DaoWhereBuilder builderEndTime) {
		switch(column.columnName) {		
		case SchedageDbTableColumn.COL_DATE :
			builderEndTime.addClauseEqualAnd(column, DaoFormatter.dateToString(recordInfo.dateValidTo));
			builderEndTime.addClauseAnd(column, DaoFormatter.dateToString(recordInfo.dateValidFrom), DaoWhereCondition.NOT_EQUAL);
			break;
			
		case SchedageDbTableColumn.COL_BEGIN_TIME :
			builderEndTime.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.timeValidTo), DaoWhereCondition.LESS_OR_EQUAL);
			break;
		}		
		
		return builderEndTime;
	}	
	
	
	
	private DaoWhereBuilder generateBeginDate(DaoColumn column, SchedageInfo recordInfo, DaoWhereBuilder builderBeginDate) {
		switch(column.columnName) {		
		case SchedageDbTableColumn.COL_DATE :
			builderBeginDate.addClauseAnd(column, DaoFormatter.dateToString(recordInfo.dateValidFrom), DaoWhereCondition.GREATER);
			builderBeginDate.addClauseAnd(column, DaoFormatter.dateToString(recordInfo.dateValidTo), DaoWhereCondition.NOT_EQUAL);
			break;
		}		
		
		return builderBeginDate;
	}	
	
	
	
	private DaoWhereBuilder generateEndDate(DaoColumn column, SchedageInfo recordInfo, DaoWhereBuilder builderEndDate) {
		switch(column.columnName) {		
		case SchedageDbTableColumn.COL_DATE :
			builderEndDate.addClauseAnd(column, DaoFormatter.dateToString(recordInfo.dateValidFrom), DaoWhereCondition.NOT_EQUAL);
			builderEndDate.addClauseAnd(column, DaoFormatter.dateToString(recordInfo.dateValidTo), DaoWhereCondition.LESS);
			break;
		}		
		
		return builderEndDate;
	}		
	
	
	
	private DaoWhereBuilder generateBeginDay(DaoColumn column, SchedageInfo recordInfo, DaoWhereBuilder builderBeginDay) {
		switch(column.columnName) {		
		case SchedageDbTableColumn.COL_DATE :
			builderBeginDay.addClauseEqualAnd(column, DaoFormatter.dateToString(recordInfo.dateValidFrom));
			builderBeginDay.addClauseEqualAnd(column, DaoFormatter.dateToString(recordInfo.dateValidTo));
			break;
			
		case SchedageDbTableColumn.COL_BEGIN_TIME :
			builderBeginDay.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.timeValidFrom), DaoWhereCondition.GREATER_OR_EQUAL);	
			builderBeginDay.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.timeValidTo), DaoWhereCondition.LESS_OR_EQUAL);
			break;
		}		
		
		return builderBeginDay;
	}	
	
	
	
	private DaoWhereBuilder generateEndDay(DaoColumn column, SchedageInfo recordInfo, DaoWhereBuilder builderEndDay) {
		switch(column.columnName) {		
		case SchedageDbTableColumn.COL_DATE :
			builderEndDay.addClauseEqualAnd(column, DaoFormatter.dateToString(recordInfo.dateValidFrom));
			builderEndDay.addClauseEqualAnd(column, DaoFormatter.dateToString(recordInfo.dateValidTo));
			break;
			
		case SchedageDbTableColumn.COL_END_TIME :
			builderEndDay.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.timeValidFrom), DaoWhereCondition.GREATER_OR_EQUAL);
			builderEndDay.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.timeValidTo), DaoWhereCondition.LESS_OR_EQUAL);
			break;
		}		
		
		return builderEndDay;
	}	
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
