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

final class EmpwocoDaoWhere implements DaoStmtWhere {
	private String whereClause;
	
	
	public EmpwocoDaoWhere(DaoWhereBuilderOption whereOption, String tableName, EmpwocoInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, EmpwocoInfo recordInfo) {
		DaoWhereBuilder builderKey = whereClauseKey(whereOption, tableName, recordInfo);
		DaoWhereBuilder builderBeginTime = whereClauseBeginTime(whereOption, tableName, recordInfo);
		DaoWhereBuilder builderEndTime = whereClauseEndTime(whereOption, tableName, recordInfo);		
		DaoWhereBuilder builderBeginEndTime = whereClauseBeginEndTime(whereOption, tableName, recordInfo);	
		
		builderKey.mergeBuilder(builderBeginTime, DaoWhereOperator.AND);		
		builderBeginTime.mergeBuilder(builderEndTime, DaoWhereOperator.OR);
		builderBeginTime.mergeBuilder(builderBeginEndTime, DaoWhereOperator.OR);		
		
		whereClause = builderKey.generateClause();
	}
	
	
	
	private DaoWhereBuilder whereClauseKey(DaoWhereBuilderOption whereOption, String tableName, EmpwocoInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case EmpwocoDaoDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case EmpwocoDaoDbTableColumn.COL_COD_STORE :
					builder.addClauseAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore), DaoWhereCondition.NOT_EQUAL);
					break;			
		
				case EmpwocoDaoDbTableColumn.COL_COD_EMPLOYEE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codEmployee));
					break;
					
				case EmpwocoDaoDbTableColumn.COL_COD_WEEKDAY :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codWeekday));
					break;
					
				case EmpwocoDaoDbTableColumn.COL_RECORD_MODE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.recordMode);
					break;
			}
		}
		
		return builder;
	}
	
	
	
	private DaoWhereBuilder whereClauseBeginTime(DaoWhereBuilderOption whereOption, String tableName, EmpwocoInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case EmpwocoDaoDbTableColumn.COL_BEGIN_TIME :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.LESS_OR_EQUAL);
					break;
					
				case EmpwocoDaoDbTableColumn.COL_END_TIME :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.GREATER_OR_EQUAL);
					break;
			}
		}
		
		return builder;
	}	
	
	
	
	private DaoWhereBuilder whereClauseEndTime(DaoWhereBuilderOption whereOption, String tableName, EmpwocoInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case EmpwocoDaoDbTableColumn.COL_BEGIN_TIME :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.LESS_OR_EQUAL);
					break;
					
				case EmpwocoDaoDbTableColumn.COL_END_TIME :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.GREATER_OR_EQUAL);
					break;
				}
		}
		
		return builder;
	}	
	
	
	
	private DaoWhereBuilder whereClauseBeginEndTime(DaoWhereBuilderOption whereOption, String tableName, EmpwocoInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case EmpwocoDaoDbTableColumn.COL_BEGIN_TIME :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.GREATER_OR_EQUAL);
					break;
					
				case EmpwocoDaoDbTableColumn.COL_END_TIME :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.LESS_OR_EQUAL);
					break;
				}
		}
		
		return builder;
	}	
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
