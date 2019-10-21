package br.com.mind5.business.employeeLeaveDate.dao;

import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.DaoWhereCondition;
import br.com.mind5.dao.DaoWhereOperator;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class EmplevateWhereRange implements DaoStmtWhere {
	private String whereClause;	
	
	
	public EmplevateWhereRange(DaoWhereBuilderOption whereOption, String tableName, EmplevateInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, EmplevateInfo recordInfo) {		
		DaoWhereBuilder builderOne = whereClausePartOne(whereOption, tableName, recordInfo);
		DaoWhereBuilder builderTwo = whereClausePartTwo(whereOption, tableName, recordInfo);
		
		builderOne.mergeBuilder(builderTwo, DaoWhereOperator.OR);
		whereClause = builderOne.generateClause();
	}
	
	
	
	private DaoWhereBuilder whereClausePartOne(DaoWhereBuilderOption whereOption, String tableName, EmplevateInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case EmplevateDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case EmplevateDbTableColumn.COL_COD_STORE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
					break;
					
				case EmplevateDbTableColumn.COL_COD_EMPLOYEE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codEmployee));
					break;
					
				case EmplevateDbTableColumn.COL_DT_VALID_FROM :
					builder.addClauseAnd(eachColumn, DaoFormatter.dateToString(recordInfo.dateValidFrom), DaoWhereCondition.LESS_OR_EQUAL);
					break;
					
				case EmplevateDbTableColumn.COL_DT_VALID_TO :
					builder.addClauseAnd(eachColumn, DaoFormatter.dateToString(recordInfo.dateValidFrom), DaoWhereCondition.GREATER_OR_EQUAL);
					break;
					
				case EmplevateDbTableColumn.COL_TM_VALID_FROM :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.timeValidFrom), DaoWhereCondition.LESS_OR_EQUAL);
					break;
					
				case EmplevateDbTableColumn.COL_TM_VALID_TO :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.timeValidFrom), DaoWhereCondition.GREATER_OR_EQUAL);
					break;
					
				case EmplevateDbTableColumn.COL_RECORD_MODE :
					builder.addClauseEqualAnd(eachColumn,recordInfo.recordMode);
					break;
					
				case EmplevateDbTableColumn.COL_COD_LANGUAGE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codLanguage);
					break;
			}
		}		
		
		return builder;
	}
	
	
	
	private DaoWhereBuilder whereClausePartTwo(DaoWhereBuilderOption whereOption, String tableName, EmplevateInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case EmplevateDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case EmplevateDbTableColumn.COL_COD_STORE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
					break;
					
				case EmplevateDbTableColumn.COL_COD_EMPLOYEE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codEmployee));
					break;
					
				case EmplevateDbTableColumn.COL_DT_VALID_FROM :
					builder.addClauseAnd(eachColumn, DaoFormatter.dateToString(recordInfo.dateValidTo), DaoWhereCondition.LESS_OR_EQUAL);
					break;
					
				case EmplevateDbTableColumn.COL_DT_VALID_TO :
					builder.addClauseAnd(eachColumn, DaoFormatter.dateToString(recordInfo.dateValidTo), DaoWhereCondition.GREATER_OR_EQUAL);
					break;
					
				case EmplevateDbTableColumn.COL_TM_VALID_FROM :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.timeValidTo), DaoWhereCondition.LESS_OR_EQUAL);
					break;
					
				case EmplevateDbTableColumn.COL_TM_VALID_TO :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.timeValidTo), DaoWhereCondition.GREATER_OR_EQUAL);
					break;
					
				case EmplevateDbTableColumn.COL_RECORD_MODE :
					builder.addClauseEqualAnd(eachColumn,recordInfo.recordMode);
					break;
					
				case EmplevateDbTableColumn.COL_COD_LANGUAGE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codLanguage);
					break;
			}
		}		
		
		return builder;
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
