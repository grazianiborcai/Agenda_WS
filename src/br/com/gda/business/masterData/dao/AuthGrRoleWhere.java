package br.com.gda.business.masterData.dao;

import java.util.List;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class AuthGrRoleWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public AuthGrRoleWhere(DaoWhereBuilderOption whereOption, String tableName, AuthGrRoleInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, AuthGrRoleInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case MasterDataDbTableColumn.COL_COD_AUTH_GROUP :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codAuthGroup);
					break;
				
				case MasterDataDbTableColumn.COL_COD_AUTH_ROLE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codAuthRole);
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
