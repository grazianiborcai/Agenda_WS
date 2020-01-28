package br.com.mind5.business.masterData.dao;

import java.util.List;

import br.com.mind5.business.masterData.info.CountryLegalInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class CountryLegalWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public CountryLegalWhere(DaoWhereBuilderOption whereOption, String tableName, CountryLegalInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, CountryLegalInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case MasterDataDbTableColumn.COL_COD_COUNTRY :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codCountry);
					break;					
					
				case MasterDataDbTableColumn.COL_COD_LANGUAGE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codLanguage);
					break;
					
				case MasterDataDbTableColumn.COL_RECORD_MODE :
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
