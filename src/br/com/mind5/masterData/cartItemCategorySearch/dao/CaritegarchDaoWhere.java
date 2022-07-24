package br.com.mind5.masterData.cartItemCategorySearch.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.masterData.cartItemCategorySearch.info.CaritegarchInfo;

final class CaritegarchDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public CaritegarchDaoWhere(DaoWhereBuilderOption whereOption, String tableName, CaritegarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, CaritegarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case CaritegarchDaoDbTableColumn.COL_COD_ITEM_CATEG :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.charToString(recordInfo.codItemCateg));
					break;
					
				case CaritegarchDaoDbTableColumn.COL_COD_LANGUAGE :
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
