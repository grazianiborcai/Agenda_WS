package br.com.gda.business.masterData.dao;

import java.util.List;

import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.sql.SqlColumn;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilder;
import br.com.gda.sql.SqlWhereBuilderOption;

public final class MatGroupWhere implements SqlStmtWhere {
	private String whereClause;	
	
	
	public MatGroupWhere(SqlWhereBuilderOption whereOption, String tableName, MatGroupInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(SqlWhereBuilderOption whereOption, String tableName, MatGroupInfo recordInfo) {
		SqlWhereBuilder builder = SqlWhereBuilder.factory(whereOption);		
		List<SqlColumn> columns = MasterDataDbTableColumn.getTableColumnsAsList(tableName);
		
		for (SqlColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case "Cod_group" :
					builder.addClauseEqualAnd(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codGroup));
					break;
					
				case "Cod_business" :
					builder.addClauseEqualAnd(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codBusiness));
					break;
			}
		}		
			
		whereClause = builder.generateClause();

	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
