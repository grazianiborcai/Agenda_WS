package br.com.gda.business.masterData.dao;

import java.util.List;

import br.com.gda.business.masterData.info.LanguInfo;
import br.com.gda.sql.SqlColumn;
import br.com.gda.sql.SqlDbTableColumnAll;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilder;
import br.com.gda.sql.SqlWhereBuilderOption;

public final class LanguWhere implements SqlStmtWhere {
	private String whereClause;	
	
	
	public LanguWhere(SqlWhereBuilderOption whereOption, String tableName, LanguInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(SqlWhereBuilderOption whereOption, String tableName, LanguInfo recordInfo) {
		SqlWhereBuilder builder = SqlWhereBuilder.factory(whereOption);		
		List<SqlColumn> columns = SqlDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (SqlColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case "Language" :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codLanguage);
					break;
			}
		}		
			
		whereClause = builder.generateClause();

	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
