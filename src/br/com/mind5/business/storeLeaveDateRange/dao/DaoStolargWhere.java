package br.com.mind5.business.storeLeaveDateRange.dao;

import java.util.List;

import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.DaoWhereCondition;
import br.com.mind5.dao.DaoWhereOperator;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

public final class DaoStolargWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public DaoStolargWhere(DaoWhereBuilderOption whereOption, String tableName, StolargInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, StolargInfo recordInfo) {
		DaoWhereBuilder builderKey = DaoWhereBuilder.factory(whereOption);	
		DaoWhereBuilder builderValidFrom = DaoWhereBuilder.factory(whereOption);		
		DaoWhereBuilder builderValidTo = DaoWhereBuilder.factory(whereOption);	
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			builderKey = generateKey(eachColumn, recordInfo, builderKey);
			builderValidFrom = generateValidFrom(eachColumn, recordInfo, builderValidFrom);
			builderValidTo = generateValidTo(eachColumn, recordInfo, builderValidTo);
		}
		
		builderValidTo.mergeBuilder(builderValidFrom, DaoWhereOperator.OR);
		builderKey.mergeBuilder(builderValidTo, DaoWhereOperator.AND);
		
		whereClause = builderKey.generateClause();
	}
	
	
	
	private DaoWhereBuilder generateKey(DaoColumn column, StolargInfo recordInfo, DaoWhereBuilder builder) {
		switch(column.columnName) {
			case DaoStolargDbTableColumn.COL_COD_OWNER :
				builder.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codOwner));
				break;
			
			case DaoStolargDbTableColumn.COL_COD_STORE :
				builder.addClauseEqualAnd(column, DaoFormatter.numberToString(recordInfo.codStore));
				break;
				
			case DaoStolargDbTableColumn.COL_RECORD_MODE :
				builder.addClauseEqualAnd(column, recordInfo.recordMode);
				break;
		}
		
		return builder;
	}
	
	
	
	private DaoWhereBuilder generateValidFrom(DaoColumn column, StolargInfo recordInfo, DaoWhereBuilder builder) {
		switch(column.columnName) {
			case DaoStolargDbTableColumn.COL_DATE_TIME_VALID_FROM :
				builder.addClauseAnd(column, DaoFormatter.dateTimeToString(recordInfo.validFrom), DaoWhereCondition.LESS_OR_EQUAL);
				break;
				
			case DaoStolargDbTableColumn.COL_DATE_TIME_VALID_TO :
				builder.addClauseAnd(column, DaoFormatter.dateTimeToString(recordInfo.validFrom), DaoWhereCondition.GREATER_OR_EQUAL);
				break;
		}
		
		return builder;
	}	
	
	
	
	private DaoWhereBuilder generateValidTo(DaoColumn column, StolargInfo recordInfo, DaoWhereBuilder builder) {
		switch(column.columnName) {
			case DaoStolargDbTableColumn.COL_DATE_TIME_VALID_FROM :
				builder.addClauseAnd(column, DaoFormatter.dateTimeToString(recordInfo.validTo), DaoWhereCondition.LESS_OR_EQUAL);
				break;
				
			case DaoStolargDbTableColumn.COL_DATE_TIME_VALID_TO :
				builder.addClauseAnd(column, DaoFormatter.dateTimeToString(recordInfo.validTo), DaoWhereCondition.GREATER_OR_EQUAL);
				break;
		}
	
		return builder;
	}	
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
