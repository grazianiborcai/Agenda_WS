package br.com.gda.message.emailBody.dao;

import java.util.List;

import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTableColumnAll;
import br.com.gda.message.emailBody.info.EmabodyInfo;

final class EmabodyWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public EmabodyWhere(DaoWhereBuilderOption whereOption, String tableName, EmabodyInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, EmabodyInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case EmabodyDbTableColumn.COL_COD_BODY :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codBody);
					break;
					
				case EmabodyDbTableColumn.COL_COD_LANGUAGE :
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
