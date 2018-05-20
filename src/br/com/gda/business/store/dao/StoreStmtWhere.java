package br.com.gda.business.store.dao;

import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.sql.SqlColumn;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilder;
import br.com.gda.sql.SqlWhereBuilderOption;

final class StoreStmtWhere implements SqlStmtWhere {
	private String whereClause;	
	
	
	public StoreStmtWhere(SqlWhereBuilderOption whereOption, String tableName, StoreInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(SqlWhereBuilderOption whereOption, String tableName, StoreInfo recordInfo) {
		SqlWhereBuilder builder = SqlWhereBuilder.factory(whereOption);
		
		List<SqlColumn> columns = StoreDbTableColumn.getTableColumnsAsList(tableName);
		
		for (SqlColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case "Cod_owner" :
					builder.appendClauseWithAnd(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codOwner));
					break;
					
				case "Cod_store" :
					builder.appendClauseWithAnd(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codStore));
					break;
					
				case "CNPJ" :
					builder.appendClauseWithAnd(eachColumn, recordInfo.cnpj);
					break;
					
				case "record_mode" :
					builder.appendClauseWithAnd(eachColumn, recordInfo.recordMode);
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
