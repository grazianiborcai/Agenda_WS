package br.com.gda.business.orderReserve.dao;

import java.util.List;

import br.com.gda.business.orderReserve.info.OrderveInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.DaoWhereCondition;
import br.com.gda.dao.DaoWhereOperator;
import br.com.gda.dao.common.DaoDbTableColumnAll;

final class OrderveWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public OrderveWhere(DaoWhereBuilderOption whereOption, String tableName, OrderveInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, OrderveInfo recordInfo) {	
		DaoWhereBuilder builderItem = whereClauseAttr(whereOption, tableName, recordInfo);
		DaoWhereBuilder builderBeginTime = whereClauseBeginTime(whereOption, tableName, recordInfo);
		DaoWhereBuilder builderEndTime = whereClauseEndTime(whereOption, tableName, recordInfo);
		DaoWhereBuilder builderInBetween = whereClauseInBetween(whereOption, tableName, recordInfo);
		
		builderItem.mergeBuilder(builderBeginTime, DaoWhereOperator.AND);
		builderBeginTime.mergeBuilder(builderEndTime, DaoWhereOperator.OR);
		builderBeginTime.mergeBuilder(builderInBetween, DaoWhereOperator.OR);
		whereClause = builderItem.generateClause();
	}
	
	
	
	private DaoWhereBuilder whereClauseAttr(DaoWhereBuilderOption whereOption, String tableName, OrderveInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case OrderveDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case OrderveDbTableColumn.COL_COD_MATERIAL :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codMat));
					break;
					
				case OrderveDbTableColumn.COL_COD_EMPLOYEE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codEmployee));
					break;
					
				case OrderveDbTableColumn.COL_DATE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.dateToString(recordInfo.date));
					break;
					
				case OrderveDbTableColumn.COL_COD_ORDER_STATUS :
					builder.addClauseAnd(eachColumn, recordInfo.codOrderStatus, DaoWhereCondition.NOT_EQUAL);
					break;
			}
		}		
		
		return builder;
	}
	
	
	
	private DaoWhereBuilder whereClauseBeginTime(DaoWhereBuilderOption whereOption, String tableName, OrderveInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case OrderveDbTableColumn.COL_BEGIN_TIME :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.GREATER_OR_EQUAL);					
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.LESS_OR_EQUAL);
					break;
			}
		}		
		
		return builder;
	}
	
	
	
	private DaoWhereBuilder whereClauseEndTime(DaoWhereBuilderOption whereOption, String tableName, OrderveInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case OrderveDbTableColumn.COL_END_TIME :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.GREATER_OR_EQUAL);					
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.LESS_OR_EQUAL);
					break;
			}
		}		
		
		return builder;
	}
	
	
	
	private DaoWhereBuilder whereClauseInBetween(DaoWhereBuilderOption whereOption, String tableName, OrderveInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case OrderveDbTableColumn.COL_BEGIN_TIME :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.LESS_OR_EQUAL);	
					break;
					
				case OrderveDbTableColumn.COL_END_TIME :
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
