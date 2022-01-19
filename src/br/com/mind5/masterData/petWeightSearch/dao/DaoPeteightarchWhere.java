package br.com.mind5.masterData.petWeightSearch.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.masterData.petWeightSearch.info.PeteightarchInfo;

final class DaoPeteightarchWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public DaoPeteightarchWhere(DaoWhereBuilderOption whereOption, String tableName, PeteightarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, PeteightarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case DaoPeteightarchDbTableColumn.COL_COD_PET_WEIGHT :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codPeteight));
					break;
					
					
				case DaoPeteightarchDbTableColumn.COL_COD_LANGUAGE :
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
