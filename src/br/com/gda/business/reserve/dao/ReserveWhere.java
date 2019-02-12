package br.com.gda.business.reserve.dao;

import java.util.List;

import br.com.gda.business.reserve.info.ReserveInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.DaoWhereCondition;
import br.com.gda.dao.DaoWhereOperator;
import br.com.gda.dao.common.DaoDbTableColumnAll;

final class ReserveWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public ReserveWhere(DaoWhereBuilderOption whereOption, String tableName, ReserveInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, ReserveInfo recordInfo) {		
		DaoWhereBuilder builderOne = whereClausePartOne(whereOption, tableName, recordInfo);
		DaoWhereBuilder builderTwo = whereClausePartTwo(whereOption, tableName, recordInfo);
		DaoWhereBuilder builderThree = whereClausePartThree(whereOption, tableName, recordInfo);
		DaoWhereBuilder builderFour = whereClausePartFour(whereOption, tableName, recordInfo);
		DaoWhereBuilder builderFive = whereClausePartFive(whereOption, tableName, recordInfo);
		
		builderOne.mergeBuilder(builderTwo, DaoWhereOperator.AND);
		builderTwo.mergeBuilder(builderThree, DaoWhereOperator.OR);
		builderOne.mergeBuilder(builderFour, DaoWhereOperator.AND);
		builderOne.mergeBuilder(builderFive, DaoWhereOperator.AND);
		whereClause = builderOne.generateClause();
	}
	
	
	
	private DaoWhereBuilder whereClausePartOne(DaoWhereBuilderOption whereOption, String tableName, ReserveInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case ReserveDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case ReserveDbTableColumn.COL_COD_MATERIAL :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codMat));
					break;
					
				case ReserveDbTableColumn.COL_LAST_CHANGED :
					builder.addClauseAnd(eachColumn, DaoFormatter.dateTimeToString(recordInfo.timeValidFrom), DaoWhereCondition.GREATER_OR_EQUAL);
					break;
			}
		}		
		
		return builder;
	}
	
	
	
	private DaoWhereBuilder whereClausePartTwo(DaoWhereBuilderOption whereOption, String tableName, ReserveInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case ReserveDbTableColumn.COL_BEGIN_TIME :
					builder.addClauseNullOr(eachColumn);
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.GREATER_OR_EQUAL);					
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.LESS_OR_EQUAL);
					break;
			}
		}		
		
		return builder;
	}
	
	
	
	private DaoWhereBuilder whereClausePartThree(DaoWhereBuilderOption whereOption, String tableName, ReserveInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case ReserveDbTableColumn.COL_END_TIME :
					builder.addClauseNullOr(eachColumn);
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.GREATER_OR_EQUAL);					
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.LESS_OR_EQUAL);
					break;
			}
		}		
		
		return builder;
	}
	
	
	
	private DaoWhereBuilder whereClausePartFour(DaoWhereBuilderOption whereOption, String tableName, ReserveInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case ReserveDbTableColumn.COL_COD_EMPLOYEE :
					builder.addClauseNullOr(eachColumn);
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codEmployee));
					break;
			}
		}		
		
		return builder;
	}
	
	
	
	private DaoWhereBuilder whereClausePartFive(DaoWhereBuilderOption whereOption, String tableName, ReserveInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case ReserveDbTableColumn.COL_DATE :
					builder.addClauseNullOr(eachColumn);
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.dateToString(recordInfo.date));
					break;
			}
		}		
		
		return builder;
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
