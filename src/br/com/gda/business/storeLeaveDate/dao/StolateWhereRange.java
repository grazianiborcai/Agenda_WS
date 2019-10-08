package br.com.gda.business.storeLeaveDate.dao;

import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.DaoWhereCondition;
import br.com.gda.dao.DaoWhereOperator;
import br.com.gda.dao.common.DaoDbTableColumnAll;

final class StolateWhereRange implements DaoStmtWhere {
	private String whereClause;	
	
	
	public StolateWhereRange(DaoWhereBuilderOption whereOption, String tableName, StolateInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, StolateInfo recordInfo) {		
		DaoWhereBuilder builderOne = whereClausePartOne(whereOption, tableName, recordInfo);
		DaoWhereBuilder builderTwo = whereClausePartTwo(whereOption, tableName, recordInfo);
		
		builderOne.mergeBuilder(builderTwo, DaoWhereOperator.OR);
		whereClause = builderOne.generateClause();
	}
	
	
	
	private DaoWhereBuilder whereClausePartOne(DaoWhereBuilderOption whereOption, String tableName, StolateInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case StolateDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case StolateDbTableColumn.COL_COD_STORE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
					break;
					
				case StolateDbTableColumn.COL_DT_VALID_FROM :
					builder.addClauseAnd(eachColumn, DaoFormatter.dateToString(recordInfo.dateValidFrom), DaoWhereCondition.LESS_OR_EQUAL);
					break;
					
				case StolateDbTableColumn.COL_DT_VALID_TO :
					builder.addClauseAnd(eachColumn, DaoFormatter.dateToString(recordInfo.dateValidFrom), DaoWhereCondition.GREATER_OR_EQUAL);
					break;
					
				case StolateDbTableColumn.COL_TM_VALID_FROM :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.timeValidFrom), DaoWhereCondition.LESS_OR_EQUAL);
					break;
					
				case StolateDbTableColumn.COL_TM_VALID_TO :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.timeValidFrom), DaoWhereCondition.GREATER_OR_EQUAL);
					break;
					
				case StolateDbTableColumn.COL_RECORD_MODE :
					builder.addClauseEqualAnd(eachColumn,recordInfo.recordMode);
					break;
			}
		}		
		
		return builder;
	}
	
	
	
	private DaoWhereBuilder whereClausePartTwo(DaoWhereBuilderOption whereOption, String tableName, StolateInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case StolateDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case StolateDbTableColumn.COL_COD_STORE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
					break;
					
				case StolateDbTableColumn.COL_DT_VALID_FROM :
					builder.addClauseAnd(eachColumn, DaoFormatter.dateToString(recordInfo.dateValidTo), DaoWhereCondition.LESS_OR_EQUAL);
					break;
					
				case StolateDbTableColumn.COL_DT_VALID_TO :
					builder.addClauseAnd(eachColumn, DaoFormatter.dateToString(recordInfo.dateValidTo), DaoWhereCondition.GREATER_OR_EQUAL);
					break;
					
				case StolateDbTableColumn.COL_TM_VALID_FROM :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.timeValidTo), DaoWhereCondition.LESS_OR_EQUAL);
					break;
					
				case StolateDbTableColumn.COL_TM_VALID_TO :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.timeValidTo), DaoWhereCondition.GREATER_OR_EQUAL);
					break;
					
				case StolateDbTableColumn.COL_RECORD_MODE :
					builder.addClauseEqualAnd(eachColumn,recordInfo.recordMode);
					break;
			}
		}		
		
		return builder;
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
