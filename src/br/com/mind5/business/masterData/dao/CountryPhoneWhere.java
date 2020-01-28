package br.com.mind5.business.masterData.dao;

import java.util.List;

import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class CountryPhoneWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public CountryPhoneWhere(DaoWhereBuilderOption whereOption, String tableName, CountryPhoneInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, CountryPhoneInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case MasterDataDbTableColumn.COL_COD_COUNTRY_PHONE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codCountryPhone));
					break;
					
				case MasterDataDbTableColumn.COL_COD_COUNTRY :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codCountry);
					break;
					
				case MasterDataDbTableColumn.COL_COD_LANGUAGE :
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
