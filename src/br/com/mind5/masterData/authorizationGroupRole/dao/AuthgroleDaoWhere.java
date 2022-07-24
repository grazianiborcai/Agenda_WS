package br.com.mind5.masterData.authorizationGroupRole.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;

public final class AuthgroleDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public AuthgroleDaoWhere(DaoWhereBuilderOption whereOption, String tableName, AuthgroleInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, AuthgroleInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case AuthgroleDaoDbTableColumn.COL_COD_AUTH_GROUP :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codAuthGroup);
					break;
				
				case AuthgroleDaoDbTableColumn.COL_COD_AUTH_ROLE :
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
