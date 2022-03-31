package br.com.mind5.business.storeNearby.dao;

import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.DaoWhereCondition;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class StorbyDaoWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public StorbyDaoWhere(DaoWhereBuilderOption whereOption, String tableName, StorbyInfo recordInfo) {
		whereClause = generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private String generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, StorbyInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case StorbyDaoDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case StorbyDaoDbTableColumn.COL_DISTRICT_SEARCH:
					builder.addClauseAnd(eachColumn, recordInfo.districtSearch, DaoWhereCondition.LIKE);
					break;
					
				case StorbyDaoDbTableColumn.COL_NAME_SEARCH:
					builder.addClauseAnd(eachColumn, recordInfo.nameSearch, DaoWhereCondition.LIKE);
					break;
					
				case StorbyDaoDbTableColumn.COL_GEO_HASH_01:
					builder.addClauseEqualAnd(eachColumn, recordInfo.geoHash01);
					break;
					
				case StorbyDaoDbTableColumn.COL_GEO_HASH_02:
					builder.addClauseEqualAnd(eachColumn, recordInfo.geoHash02);
					break;
					
				case StorbyDaoDbTableColumn.COL_GEO_HASH_03:
					builder.addClauseEqualAnd(eachColumn, recordInfo.geoHash03);
					break;

				case StorbyDaoDbTableColumn.COL_RECORD_MODE :
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
