package br.com.gda.business.position.dao;

import java.util.List;

import br.com.gda.business.position.info.PositionInfo;
import br.com.gda.sql.SqlColumn;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlWhereBuilder;
import br.com.gda.sql.SqlWhereBuilderOption;

public final class PositionStmtWhere {
	private String whereClause;	
	
	
	public PositionStmtWhere(SqlWhereBuilderOption whereOption, String tableName, PositionInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(SqlWhereBuilderOption whereOption, String tableName, PositionInfo recordInfo) {
		SqlWhereBuilder builder = SqlWhereBuilder.factory(whereOption);		
		List<SqlColumn> columns = PositionDbTableColumn.getTableColumnsAsList(tableName);
		
		for (SqlColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case "Cod_position" :
					builder.appendClauseWithAnd(eachColumn, SqlFormatterNumber.numberToString(recordInfo.codPosition));
					break;
			}
		}
		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
