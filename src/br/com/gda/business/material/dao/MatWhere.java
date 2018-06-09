package br.com.gda.business.material.dao;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.sql.SqlDbTable;
import br.com.gda.sql.SqlDbTableColumnAll;
import br.com.gda.sql.SqlColumn;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilder;
import br.com.gda.sql.SqlWhereBuilderOption;

public final class MatWhere implements SqlStmtWhere {
	private String whereClause;	
	
	
	public MatWhere(SqlWhereBuilderOption whereOption, String tableName, MatInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(SqlWhereBuilderOption whereOption, String tableName, MatInfo recordInfo) {
		SqlWhereBuilder builder = SqlWhereBuilder.factory(whereOption);
		
		List<SqlColumn> columns = SqlDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (SqlColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case "Cod_owner" :
					builder.addClause(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codOwner));
					break;
					
				case "Cod_material" :
					builder.addClause(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codMat));
					break;
					
				case "Cod_type" :
					builder.addClause(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codType));
					break;
					
				case "Cod_group" :
					builder.addClause(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codGroup));
					break;
					
				case "Language":
					if (tableName == SqlDbTable.MATERIAL_TEXT_TABLE)
						builder.addClause(eachColumn, recordInfo.codLanguage);
					break;
					
				case "record_mode" :
					builder.addClause(eachColumn, recordInfo.recordMode);
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
