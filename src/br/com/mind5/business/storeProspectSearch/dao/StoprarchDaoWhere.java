package br.com.mind5.business.storeProspectSearch.dao;

import java.util.List;

import br.com.mind5.business.storeProspectSearch.info.StoprarchInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

public final class StoprarchDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public StoprarchDaoWhere(DaoWhereBuilderOption whereOption, String tableName, StoprarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, StoprarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case StoprarchDaoDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case StoprarchDaoDbTableColumn.COL_COD_STORE_PROSPECT :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStoreProspect));
					break;
					
				case StoprarchDaoDbTableColumn.COL_PROSPECT_EMAIL :
					builder.addClauseEqualAnd(eachColumn, recordInfo.prospectEmail);
					break;
					
				case StoprarchDaoDbTableColumn.COL_COD_PROSPECT_STATUS :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codProspectStatus);
					break;
					
				case StoprarchDaoDbTableColumn.COL_RECORD_MODE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.recordMode);
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
