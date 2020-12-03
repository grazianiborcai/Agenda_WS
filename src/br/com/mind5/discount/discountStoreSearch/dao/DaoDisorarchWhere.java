package br.com.mind5.discount.discountStoreSearch.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.DaoWhereCondition;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;

public final class DaoDisorarchWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public DaoDisorarchWhere(DaoWhereBuilderOption whereOption, String tableName, DisorarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, DisorarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case DaoDisorarchDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case DaoDisorarchDbTableColumn.COL_COD_STORE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
					break;
					
				case DaoDisorarchDbTableColumn.COL_COD_DISCOUNT :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codDiscount));
					break;
					
				case DaoDisorarchDbTableColumn.COL_COD_DISCOUNT_STRATEGY :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codDiscountStrategy));
					break;
					
				case DaoDisorarchDbTableColumn.COL_IS_ACTIVE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.booleanToString(recordInfo.isActive));
					break;
					
				case DaoDisorarchDbTableColumn.COL_VALID_FROM :
					builder.addClauseAnd(eachColumn, DaoFormatter.dateTimeToString(recordInfo.validFrom), DaoWhereCondition.LESS_OR_EQUAL);
					break;
					
				case DaoDisorarchDbTableColumn.COL_VALID_TO :
					builder.addClauseAnd(eachColumn, DaoFormatter.dateTimeToString(recordInfo.validFrom), DaoWhereCondition.GREATER_OR_EQUAL);
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
