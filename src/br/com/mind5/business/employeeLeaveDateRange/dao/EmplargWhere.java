package br.com.mind5.business.employeeLeaveDateRange.dao;

import java.util.List;

import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.DaoWhereCondition;
import br.com.mind5.dao.DaoWhereOperator;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

public final class EmplargWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public EmplargWhere(DaoWhereBuilderOption whereOption, String tableName, EmplargInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, EmplargInfo recordInfo) {
		DaoWhereBuilder builderKey = DaoWhereBuilder.factory(whereOption);		
		DaoWhereBuilder builderDate = DaoWhereBuilder.factory(whereOption);
		DaoWhereBuilder builderValidFrom = DaoWhereBuilder.factory(whereOption);		
		DaoWhereBuilder builderValidTo = DaoWhereBuilder.factory(whereOption);	
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			builderKey = generateKey(eachColumn, recordInfo, builderKey);
			builderDate = generateDate(eachColumn, recordInfo, builderDate);
			builderValidFrom = generateValidFrom(eachColumn, recordInfo, builderValidFrom);
			builderValidTo = generateValidTo(eachColumn, recordInfo, builderValidTo);
		}
		
		
		builderValidTo.mergeBuilder(builderValidFrom, DaoWhereOperator.OR);
		builderValidTo.mergeBuilder(builderDate, DaoWhereOperator.OR);
		builderKey.mergeBuilder(builderValidTo, DaoWhereOperator.AND);
		
		whereClause = builderKey.generateClause();
	}
	
	
	
	private DaoWhereBuilder generateKey(DaoColumn column, EmplargInfo recordInfo, DaoWhereBuilder builder) {
		switch(column.columnName) {
			case EmplargDbTableColumn.COL_COD_OWNER :
				builder.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codOwner));
				break;
			
			case EmplargDbTableColumn.COL_COD_STORE :
				builder.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codStore));
				break;
				
			case EmplargDbTableColumn.COL_COD_EMPLOYEE :
				builder.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codEmployee));
				break;
				
			case EmplargDbTableColumn.COL_RECORD_MODE :
				builder.addClauseEqualAnd(column, recordInfo.recordMode);
				break;
		}
		
		return builder;
	}
	
	
	
	private DaoWhereBuilder generateDate(DaoColumn column, EmplargInfo recordInfo, DaoWhereBuilder builder) {
		switch(column.columnName) {
			case EmplargDbTableColumn.COL_DT_VALID_FROM :
				builder.addClauseAnd(column, DaoFormatter.dateToString(recordInfo.dateValidFrom), DaoWhereCondition.LESS);
				break;
				
			case EmplargDbTableColumn.COL_DT_VALID_TO :
				builder.addClauseAnd(column, DaoFormatter.dateToString(recordInfo.dateValidTo), DaoWhereCondition.GREATER);
				break;
		}
		
		return builder;
	}	
	
	
	
	private DaoWhereBuilder generateValidFrom(DaoColumn column, EmplargInfo recordInfo, DaoWhereBuilder builder) {
		switch(column.columnName) {
			case EmplargDbTableColumn.COL_DT_VALID_FROM :
				builder.addClauseEqualAnd(column, DaoFormatter.dateToString(recordInfo.dateValidFrom));
				break;
				
			case EmplargDbTableColumn.COL_TM_VALID_FROM :
				builder.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.timeValidFrom), DaoWhereCondition.LESS_OR_EQUAL);
				break;
				
			case EmplargDbTableColumn.COL_DT_VALID_TO :
				builder.addClauseAnd(column, DaoFormatter.dateToString(recordInfo.dateValidTo), DaoWhereCondition.NOT_EQUAL);
				break;
		}
		
		return builder;
	}	
	
	
	
	private DaoWhereBuilder generateValidTo(DaoColumn column, EmplargInfo recordInfo, DaoWhereBuilder builder) {
		switch(column.columnName) {
		case EmplargDbTableColumn.COL_DT_VALID_TO :
			builder.addClauseEqualAnd(column, DaoFormatter.dateToString(recordInfo.dateValidTo));
			break;
			
		case EmplargDbTableColumn.COL_TM_VALID_TO :
			builder.addClauseAnd(column, DaoFormatter.timeToString(recordInfo.timeValidTo), DaoWhereCondition.GREATER_OR_EQUAL);
			break;
			
		case EmplargDbTableColumn.COL_DT_VALID_FROM :
			builder.addClauseAnd(column, DaoFormatter.dateToString(recordInfo.dateValidFrom), DaoWhereCondition.NOT_EQUAL);
			break;
		}
		
		return builder;
	}		
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
