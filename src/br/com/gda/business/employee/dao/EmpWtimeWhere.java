package br.com.gda.business.employee.dao;

import java.util.List;

import br.com.gda.business.employee.info.EmpWTimeInfo;
import br.com.gda.sql.SqlColumn;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilder;
import br.com.gda.sql.SqlWhereBuilderOption;

final class EmpWtimeWhere implements SqlStmtWhere {
	private String whereClause;	
	
	
	public EmpWtimeWhere(SqlWhereBuilderOption whereOption, String tableName, EmpWTimeInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(SqlWhereBuilderOption whereOption, String tableName, EmpWTimeInfo recordInfo) {
		SqlWhereBuilder builder = SqlWhereBuilder.factory(whereOption);		
		List<SqlColumn> columns = EmpDbTableColumn.getTableColumnsAsList(tableName);
		
		for (SqlColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case "cod_owner" :
					builder.addClauseEqualAnd(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codOwner));
					break;
				
				case "cod_store" :
					builder.addClauseEqualAnd(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codStore));
					break;
					
				case "cod_employee" :
					builder.addClauseEqualAnd(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codEmployee));
					break;
					
				case "weekday" :
					builder.addClauseEqualAnd(eachColumn, SqlFormatterNumber.numberToString(recordInfo.weekday));
					break;
					
				case "record_mode" :
					builder.addClauseEqualAnd(eachColumn, recordInfo.recordMode);
					break;
			}
		}
		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
