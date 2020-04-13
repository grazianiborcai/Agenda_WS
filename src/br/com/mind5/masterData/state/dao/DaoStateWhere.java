package br.com.mind5.masterData.state.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.masterData.state.info.StateInfo;

final class DaoStateWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public DaoStateWhere(DaoWhereBuilderOption whereOption, String tableName, StateInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, StateInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case DaoStateDbTableColumn.COL_COD_COUNTRY :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codCountry);
					break;
					
				case DaoStateDbTableColumn.COL_STATE_PROVINCE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codState);
					break;
					
				case DaoStateDbTableColumn.COL_COD_LANGUAGE :
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
