package br.com.mind5.masterData.moonPhase.dao;

import java.util.List;

import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class MoonaseDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public MoonaseDaoWhere(DaoWhereBuilderOption whereOption, String tableName, MoonaseInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, MoonaseInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case MoonaseDaoDbTableColumn.COL_COD_MOON_PHASE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codMoonPhase));
					break;
					
				case MoonaseDaoDbTableColumn.COL_COD_LANGUAGE :
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
