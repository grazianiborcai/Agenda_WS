package br.com.mind5.masterData.moonPhaseSearch.dao;

import java.util.List;

import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class MoonasarchDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public MoonasarchDaoWhere(DaoWhereBuilderOption whereOption, String tableName, MoonasarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, MoonasarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case MoonasarchDaoDbTableColumn.COL_COD_MOON_PHASE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codMoonPhase));
					break;
					
				case MoonasarchDaoDbTableColumn.COL_COD_LANGUAGE :
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
