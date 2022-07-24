package br.com.mind5.masterData.areaPhoneSearch.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.masterData.areaPhoneSearch.info.AreanarchInfo;

final class AreanarchDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public AreanarchDaoWhere(DaoWhereBuilderOption whereOption, String tableName, AreanarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, AreanarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case AreanarchDaoDbTableColumn.COL_COD_COUNTRY_PHONE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codCountryPhone));
					break;
					
				case AreanarchDaoDbTableColumn.COL_COD_AREA_PHONE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codArea);
					break;
					
				case AreanarchDaoDbTableColumn.COL_COD_LANGUAGE :
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
