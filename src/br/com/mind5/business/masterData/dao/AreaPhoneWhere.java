package br.com.mind5.business.masterData.dao;

import java.util.List;

import br.com.mind5.business.masterData.info.AreaPhoneInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class AreaPhoneWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public AreaPhoneWhere(DaoWhereBuilderOption whereOption, String tableName, AreaPhoneInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, AreaPhoneInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case MasterDataDbTableColumn.COL_COD_COUNTRY_PHONE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codCountryPhone));
					break;
					
				case MasterDataDbTableColumn.COL_COD_AREA_PHONE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codArea);
					break;
			}
		}		
			
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
