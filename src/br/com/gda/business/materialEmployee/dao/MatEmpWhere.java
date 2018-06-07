package br.com.gda.business.materialEmployee.dao;

import java.util.List;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.sql.SqlColumn;
import br.com.gda.sql.SqlDbTableColumnAll;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilder;
import br.com.gda.sql.SqlWhereBuilderOption;

public final class MatEmpWhere implements SqlStmtWhere {
	private String whereClause;	
	
	
	public MatEmpWhere(SqlWhereBuilderOption whereOption, String tableName, MatEmpInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(SqlWhereBuilderOption whereOption, String tableName, MatEmpInfo recordInfo) {
		SqlWhereBuilder builder = SqlWhereBuilder.factory(whereOption);
		
		List<SqlColumn> columns = SqlDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (SqlColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case "Cod_owner" :
					builder.addClauseEqualAnd(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codOwner));
					break;
					
				case "Cod_store" :
					builder.addClauseEqualAnd(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codStore));
					break;
					
				case "Cod_employee" :
					builder.addClauseEqualAnd(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codEmployee));
					break;
					
				case "Cod_material" :
					builder.addClauseEqualAnd(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codMat));
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
