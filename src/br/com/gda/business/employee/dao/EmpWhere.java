package br.com.gda.business.employee.dao;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.sql.SqlColumn;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilder;
import br.com.gda.sql.SqlWhereBuilderOption;

final class EmpWhere implements SqlStmtWhere {	
	private String whereClause;	
	
	
	public EmpWhere(SqlWhereBuilderOption whereOption, String tableName, EmpInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(SqlWhereBuilderOption whereOption, String tableName, EmpInfo recordInfo) {
		SqlWhereBuilder builder = SqlWhereBuilder.factory(whereOption);
		
		List<SqlColumn> columns = EmpDbTableColumn.getTableColumnsAsList(tableName);
		
		for (SqlColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case "cod_owner" :
					builder.addClauseEqualAnd(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codOwner));
					break;
					
				case "cod_employee" :
					builder.addClauseEqualAnd(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codEmployee));
					break;
					
				case "CPF" :
					builder.addClauseEqualAnd(eachColumn, recordInfo.cpf);
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
