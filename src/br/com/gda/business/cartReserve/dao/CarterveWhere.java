package br.com.gda.business.cartReserve.dao;

import java.util.List;

import br.com.gda.business.cartReserve.info.CarterveInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.DaoWhereCondition;
import br.com.gda.dao.DaoWhereOperator;
import br.com.gda.dao.common.DaoDbTableColumnAll;

final class CarterveWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public CarterveWhere(DaoWhereBuilderOption whereOption, String tableName, CarterveInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, CarterveInfo recordInfo) {	
		DaoWhereBuilder builderItem = whereClauseAttr(whereOption, tableName, recordInfo);
		DaoWhereBuilder builderBeginTime = whereClauseBeginTime(whereOption, tableName, recordInfo);
		DaoWhereBuilder builderEndTime = whereClauseEndTime(whereOption, tableName, recordInfo);
		DaoWhereBuilder builderInBetween = whereClauseInBetween(whereOption, tableName, recordInfo);
		
		builderItem.mergeBuilder(builderBeginTime, DaoWhereOperator.AND);
		builderBeginTime.mergeBuilder(builderEndTime, DaoWhereOperator.OR);
		builderBeginTime.mergeBuilder(builderInBetween, DaoWhereOperator.OR);
		whereClause = builderItem.generateClause();
	}
	
	
	
	private DaoWhereBuilder whereClauseAttr(DaoWhereBuilderOption whereOption, String tableName, CarterveInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case CarterveDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case CarterveDbTableColumn.COL_COD_MATERIAL :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codMat));
					break;
					
				case CarterveDbTableColumn.COL_COD_EMPLOYEE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codEmployee));
					break;
					
				case CarterveDbTableColumn.COL_DATE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.dateToString(recordInfo.date));
					break;
					
				case CarterveDbTableColumn.COL_LAST_CHANGED :
					builder.addClauseAnd(eachColumn, DaoFormatter.dateTimeToString(recordInfo.lastChanged), DaoWhereCondition.GREATER_OR_EQUAL);
					break;
			}
		}		
		
		return builder;
	}
	
	
	
	private DaoWhereBuilder whereClauseBeginTime(DaoWhereBuilderOption whereOption, String tableName, CarterveInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case CarterveDbTableColumn.COL_BEGIN_TIME :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.GREATER_OR_EQUAL);					
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.LESS_OR_EQUAL);
					break;
			}
		}		
		
		return builder;
	}
	
	
	
	private DaoWhereBuilder whereClauseEndTime(DaoWhereBuilderOption whereOption, String tableName, CarterveInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case CarterveDbTableColumn.COL_END_TIME :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.GREATER_OR_EQUAL);					
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.LESS_OR_EQUAL);
					break;
			}
		}		
		
		return builder;
	}
	
	
	
	private DaoWhereBuilder whereClauseInBetween(DaoWhereBuilderOption whereOption, String tableName, CarterveInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case CarterveDbTableColumn.COL_BEGIN_TIME :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.LESS_OR_EQUAL);	
					break;
					
				case CarterveDbTableColumn.COL_END_TIME :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.GREATER_OR_EQUAL);	
					break;
			}
		}		
		
		return builder;
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
