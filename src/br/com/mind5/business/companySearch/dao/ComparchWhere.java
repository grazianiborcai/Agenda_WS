package br.com.mind5.business.companySearch.dao;

import java.util.List;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

public final class ComparchWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public ComparchWhere(DaoWhereBuilderOption whereOption, String tableName, ComparchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, ComparchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case ComparchDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case ComparchDbTableColumn.COL_COD_COMPANY :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codCompany));
					break;
					
				case ComparchDbTableColumn.COL_CNPJ :
					builder.addClauseEqualAnd(eachColumn, recordInfo.cnpj);
					break;
					
				case ComparchDbTableColumn.COL_COD_ENTITY_CATEG :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codEntityCateg);
					break;
					
				case ComparchDbTableColumn.COL_RECORD_MODE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.recordMode);
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
