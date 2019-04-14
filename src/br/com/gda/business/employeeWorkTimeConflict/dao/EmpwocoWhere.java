package br.com.gda.business.employeeWorkTimeConflict.dao;

import java.util.List;

import br.com.gda.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.DaoWhereCondition;
import br.com.gda.dao.DaoWhereOperator;
import br.com.gda.dao.common.DaoDbTableColumnAll;

final class EmpwocoWhere implements DaoStmtWhere {
	private String whereClause;	
	private DaoWhereBuilder builderKey;
	private DaoWhereBuilder builderBeginTime;
	private DaoWhereBuilder builderEndTime;
	private DaoWhereBuilder builderBeginEndTime;
	
	
	public EmpwocoWhere(DaoWhereBuilderOption whereOption, String tableName, EmpwocoInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, EmpwocoInfo recordInfo) {
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
	
	
	
	private void generateKey(DaoColumn column, EmpwocoInfo recordInfo) {
		switch(column.columnName) {
		case EmpwocoDbTableColumn.COL_COD_OWNER :
			builderKey.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codOwner));
			break;
			
		case EmpwocoDbTableColumn.COL_COD_STORE :
			builderKey.addClauseAnd(column, DaoFormatter.numberToString(recordInfo.codStore), DaoWhereCondition.NOT_EQUAL);
			break;			

		case EmpwocoDbTableColumn.COL_COD_EMPLOYEE :
			builderKey.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codEmployee));
			break;
			
		case EmpwocoDbTableColumn.COL_WEEKDAY :
			builderKey.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codWeekday));
			break;
			
		case EmpwocoDbTableColumn.COL_RECORD_MODE :
			builderKey.addClauseEqualAnd(column, recordInfo.recordMode);
			break;
			
		case EmpwocoDbTableColumn.COL_COD_LANGUAGE :
			builderKey.addClauseEqualAnd(column, recordInfo.codLanguage);
			break;
		}
	}
	
	
	
	private void generateBeginTime(DaoColumn column, EmpwocoInfo recordInfo) {
		switch(column.columnName) {
		case EmpwocoDbTableColumn.COL_BEGIN_TIME :
			builderBeginTime.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.LESS_OR_EQUAL);
			break;
			
		case EmpwocoDbTableColumn.COL_END_TIME :
			builderBeginTime.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.GREATER_OR_EQUAL);
			break;
		}
	}	
	
	
	
	private void generateEndTime(DaoColumn column, EmpwocoInfo recordInfo) {
		switch(column.columnName) {
		case EmpwocoDbTableColumn.COL_BEGIN_TIME :
			builderEndTime.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.LESS_OR_EQUAL);
			break;
			
		case EmpwocoDbTableColumn.COL_END_TIME :
			builderEndTime.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.GREATER_OR_EQUAL);
			break;
		}
	}	
	
	
	
	private void generateBeginEndTime(DaoColumn column, EmpwocoInfo recordInfo) {
		switch(column.columnName) {
		case EmpwocoDbTableColumn.COL_BEGIN_TIME :
			builderBeginEndTime.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.GREATER_OR_EQUAL);
			break;
			
		case EmpwocoDbTableColumn.COL_END_TIME :
			builderBeginEndTime.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.LESS_OR_EQUAL);
			break;
		}
	}	
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
