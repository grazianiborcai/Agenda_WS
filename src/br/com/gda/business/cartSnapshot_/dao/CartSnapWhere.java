package br.com.gda.business.cartSnapshot_.dao;

import java.util.List;

import br.com.gda.business.cartSnapshot_.info.CartSnapInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class CartSnapWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public CartSnapWhere(DaoWhereBuilderOption whereOption, String tableName, CartSnapInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, CartSnapInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case CartSnapDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case CartSnapDbTableColumn.COL_COD_SNAPSHOT :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codSnapshot));
					break;
					
				case CartSnapDbTableColumn.COL_ITEM_NUMBER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.itemNumber));
					break;
					
				case CartSnapDbTableColumn.COL_COD_MATERIAL :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codMat));
					break;
					
				case CartSnapDbTableColumn.COL_COD_LANGUAGE :
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
