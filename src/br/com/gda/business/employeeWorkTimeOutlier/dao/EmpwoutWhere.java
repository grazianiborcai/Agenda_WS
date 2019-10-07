package br.com.gda.business.employeeWorkTimeOutlier.dao;

import java.util.List;

import br.com.gda.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.DaoWhereCondition;
import br.com.gda.dao.DaoWhereOperator;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class EmpwoutWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public EmpwoutWhere(DaoWhereBuilderOption whereOption, String tableName, EmpwoutInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, EmpwoutInfo recordInfo) {
		DaoWhereBuilder builderKey = DaoWhereBuilder.factory(whereOption);		
		DaoWhereBuilder builderBeginTime = DaoWhereBuilder.factory(whereOption);
		DaoWhereBuilder builderEndTime = DaoWhereBuilder.factory(whereOption);		
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			builderKey = generateKey(eachColumn, recordInfo, builderKey);
			builderBeginTime = generateBeginTime(eachColumn, recordInfo, builderBeginTime);
			builderEndTime = generateEndTime(eachColumn, recordInfo, builderEndTime);
		}
		
		
		builderBeginTime.mergeBuilder(builderEndTime, DaoWhereOperator.OR);
		builderKey.mergeBuilder(builderBeginTime, DaoWhereOperator.AND);
		
		whereClause = builderKey.generateClause();
	}
	
	
	
	private DaoWhereBuilder generateKey(DaoColumn column, EmpwoutInfo recordInfo, DaoWhereBuilder builderKey) {
		switch(column.columnName) {
		case EmpwoutDbTableColumn.COL_COD_OWNER :
			builderKey.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codOwner));
			break;
			
		case EmpwoutDbTableColumn.COL_COD_STORE :
			builderKey.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codStore));
			break;
			
		case EmpwoutDbTableColumn.COL_COD_WEEKDAY :
			builderKey.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codWeekday));
			break;
			
		case EmpwoutDbTableColumn.COL_RECORD_MODE :
			builderKey.addClauseEqualAnd(column, recordInfo.recordMode);
			break;
		}
		
		
		return builderKey;
	}
	
	
	
	private DaoWhereBuilder generateBeginTime(DaoColumn column, EmpwoutInfo recordInfo, DaoWhereBuilder builderBeginTime) {
		switch(column.columnName) {
		case EmpwoutDbTableColumn.COL_BEGIN_TIME :
			builderBeginTime.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.LESS);
			break;
		}		
		
		return builderBeginTime;
	}	
	
	
	
	private DaoWhereBuilder generateEndTime(DaoColumn column, EmpwoutInfo recordInfo, DaoWhereBuilder builderEndTime) {
		switch(column.columnName) {			
		case EmpwoutDbTableColumn.COL_END_TIME :
			builderEndTime.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.GREATER);
			break;
		}		
		
		return builderEndTime;
	}	
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
