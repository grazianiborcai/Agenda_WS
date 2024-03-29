package br.com.mind5.business.storeLeaveDateSearch.dao;

import java.util.List;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

public final class StolarchDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public StolarchDaoWhere(DaoWhereBuilderOption whereOption, String tableName, StolarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, StolarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case StolarchDaoDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case StolarchDaoDbTableColumn.COL_COD_STORE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
					break;
					
				case StolarchDaoDbTableColumn.COL_YEAR_VALID_FROM :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.yearValidFrom));
					break;
					
				case StolarchDaoDbTableColumn.COL_MONTH_VALID_FROM :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.monthValidFrom));
					break;
					
				case StolarchDaoDbTableColumn.COL_RECORD_MODE :
					builder.addClauseEqualAnd(eachColumn,recordInfo.recordMode);
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
