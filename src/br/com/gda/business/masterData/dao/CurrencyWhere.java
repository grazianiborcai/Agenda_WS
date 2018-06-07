package br.com.gda.business.masterData.dao;

import java.util.List;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.sql.SqlColumn;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilder;
import br.com.gda.sql.SqlWhereBuilderOption;

public final class CurrencyWhere implements SqlStmtWhere {
	private String whereClause;	
	
	
	public CurrencyWhere(SqlWhereBuilderOption whereOption, String tableName, CurrencyInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(SqlWhereBuilderOption whereOption, String tableName, CurrencyInfo recordInfo) {
		SqlWhereBuilder builder = SqlWhereBuilder.factory(whereOption);		
		List<SqlColumn> columns = MasterDataDbTableColumn.getTableColumnsAsList(tableName);
		
		for (SqlColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case "Cod_curr" :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codCurr);
					break;
			}
		}		
			
		whereClause = builder.generateClause();

	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
