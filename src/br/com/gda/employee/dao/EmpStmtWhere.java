package br.com.gda.employee.dao;

import java.util.List;

import br.com.gda.employee.info.EmpInfo;
import br.com.gda.sql.SqlColumn;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlWhereBuilder;
import br.com.gda.sql.SqlWhereBuilderOption;

final class EmpStmtWhere {
	private String whereClause;	
	
	
	public EmpStmtWhere(SqlWhereBuilderOption whereOption, String tableName, EmpInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(SqlWhereBuilderOption whereOption, String tableName, EmpInfo recordInfo) {
		SqlWhereBuilder builder = SqlWhereBuilder.factory(whereOption);
		
		List<SqlColumn> columns = EmpDbTableColumn.getTableColumnsAsList(tableName);
		
		for (SqlColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case "cod_owner" :
					builder.appendClauseWithAnd(eachColumn.tableName, eachColumn.columnName, SqlFormatterNumber.numberToString(recordInfo.codOwner));
					break;
					
				case "cod_employee" :
					builder.appendClauseWithAnd(eachColumn.tableName, eachColumn.columnName, SqlFormatterNumber.numberToString(recordInfo.codEmployee));
					break;
					
				case "CPF" :
					builder.appendClauseWithAnd(eachColumn.tableName, eachColumn.columnName, recordInfo.cpf);
					break;
					
				case "record_mode" :
					builder.appendClauseWithAnd(eachColumn.tableName, eachColumn.columnName, recordInfo.recordMode);
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
