package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info.SowotarchInfo;

public final class SowotarchDaoWhere implements DaoStmtWhere {
	private String whereClause;
	
	
	public SowotarchDaoWhere(DaoWhereBuilderOption whereOption, String tableName, SowotarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, SowotarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case SowotarchDaoDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case SowotarchDaoDbTableColumn.COL_CALMONTH :
					builder.addClauseEqualAnd(eachColumn, recordInfo.calmonth);
					break;
					
				case SowotarchDaoDbTableColumn.COL_COD_COUNTRY :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codCountry);
					break;
					
				case SowotarchDaoDbTableColumn.COL_STATE_PROVINCE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codState);
					break;
					
				case SowotarchDaoDbTableColumn.COL_CITY :
					builder.addClauseEqualAnd(eachColumn, recordInfo.city);
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
