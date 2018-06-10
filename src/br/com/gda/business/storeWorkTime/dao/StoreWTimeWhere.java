package br.com.gda.business.storeWorkTime.dao;

import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.sql.SqlColumn;
import br.com.gda.sql.SqlDbTableColumnAll;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilder;
import br.com.gda.sql.SqlWhereBuilderOption;

public final class StoreWTimeWhere implements SqlStmtWhere {
	private String whereClause;	
	
	
	public StoreWTimeWhere(SqlWhereBuilderOption whereOption, String tableName, StoreWTimeInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(SqlWhereBuilderOption whereOption, String tableName, StoreWTimeInfo recordInfo) {
		SqlWhereBuilder builder = SqlWhereBuilder.factory(whereOption);
		
		List<SqlColumn> columns = SqlDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (SqlColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case "cod_owner" :
					builder.addClause(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codOwner));
					break;
					
				case "cod_store" :
					builder.addClause(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codStore));
					break;
					
				case "weekday" :
					builder.addClause(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codWeekday));
					break;
					
				case "record_mode" :
					builder.addClause(eachColumn,recordInfo.recordMode);
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
