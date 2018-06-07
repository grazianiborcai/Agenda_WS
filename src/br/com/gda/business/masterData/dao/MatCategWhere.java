package br.com.gda.business.masterData.dao;

import java.util.List;

import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.sql.SqlColumn;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilder;
import br.com.gda.sql.SqlWhereBuilderOption;

public final class MatCategWhere implements SqlStmtWhere {
	private String whereClause;	
	
	
	public MatCategWhere(SqlWhereBuilderOption whereOption, String tableName, MatCategInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(SqlWhereBuilderOption whereOption, String tableName, MatCategInfo recordInfo) {
		SqlWhereBuilder builder = SqlWhereBuilder.factory(whereOption);		
		List<SqlColumn> columns = MasterDataDbTableColumn.getTableColumnsAsList(tableName);
		
		for (SqlColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case "Cod_category" :
					builder.addClauseEqualAnd(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codCategory));
					break;
			}
		}		
			
		whereClause = builder.generateClause();

	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
