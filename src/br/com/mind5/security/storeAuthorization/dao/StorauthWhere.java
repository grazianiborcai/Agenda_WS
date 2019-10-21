package br.com.mind5.security.storeAuthorization.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;

public final class StorauthWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public StorauthWhere(DaoWhereBuilderOption whereOption, String tableName, StorauthInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, StorauthInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case StorauthDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;	
					
				case StorauthDbTableColumn.COL_COD_USER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codUser));
					break;	
					
				case StorauthDbTableColumn.COL_COD_STORE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
					break;					
					
				case StorauthDbTableColumn.COL_RECORD_MODE :
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
