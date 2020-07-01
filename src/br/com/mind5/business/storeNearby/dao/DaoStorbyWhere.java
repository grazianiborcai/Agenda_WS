package br.com.mind5.business.storeNearby.dao;

import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class DaoStorbyWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public DaoStorbyWhere(DaoWhereBuilderOption whereOption, String tableName, StorbyInfo recordInfo) {
		whereClause = generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private String generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, StorbyInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case DaoStorbyDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case DaoStorbyDbTableColumn.COL_COD_ADDRESS :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codAddress));
					break;

				case DaoStorbyDbTableColumn.COL_RECORD_MODE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.recordMode);
					break;
			}
		}		
		
		return builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
