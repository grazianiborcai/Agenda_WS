package br.com.gda.business.storeLeaveDate.dao;

import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.sql.SqlColumn;
import br.com.gda.sql.SqlDbTableColumnAll;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilder;
import br.com.gda.sql.SqlWhereBuilderOption;

public final class StoreLDateWhere implements SqlStmtWhere {
	private String whereClause;	
	
	
	public StoreLDateWhere(SqlWhereBuilderOption whereOption, String tableName, StoreLDateInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(SqlWhereBuilderOption whereOption, String tableName, StoreLDateInfo recordInfo) {
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
					
				case "date_valid_from" :
					builder.addClause(eachColumn, SqlFormatterNumber.dateToString(recordInfo.dateValidFrom));
					break;
					
				case "time_valid_from" :
					builder.addClause(eachColumn, SqlFormatterNumber.timeToString(recordInfo.timeValidFrom));
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
