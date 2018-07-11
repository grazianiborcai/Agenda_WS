package br.com.gda.business.storeWorkTime.dao;

import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.sql.SqlColumn;
import br.com.gda.sql.SqlDbTableColumnAll;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilder;
import br.com.gda.sql.SqlWhereBuilderOption;
import br.com.gda.sql.SqlWhereCondition;

public final class StoreWTimeWhereRange implements SqlStmtWhere {
	private String whereClause;	
	
	
	public StoreWTimeWhereRange(SqlWhereBuilderOption whereOption, String tableName, StoreWTimeInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(SqlWhereBuilderOption whereOption, String tableName, StoreWTimeInfo recordInfo) {
		SqlWhereBuilder builder = SqlWhereBuilder.factory(whereOption);
		
		List<SqlColumn> columns = SqlDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (SqlColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case "cod_owner" :
					builder.addClauseEqualAnd(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codOwner));
					break;
					
				case "cod_store" :
					builder.addClauseEqualAnd(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codStore));
					break;
					
				case "weekday" :
					builder.addClauseEqualAnd(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codWeekday));
					break;
					
				case "begin_time" :
					builder.addClauseAnd(eachColumn, SqlFormatterNumber.timeToString(recordInfo.beginTime), SqlWhereCondition.LESS_OR_EQUAL);
					break;
					
				case "end_time" :
					builder.addClauseAnd(eachColumn, SqlFormatterNumber.timeToString(recordInfo.endTime), SqlWhereCondition.GREATER_OR_EQUAL);
					break;
					
				case "record_mode" :
					builder.addClauseEqualAnd(eachColumn,recordInfo.recordMode);
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
