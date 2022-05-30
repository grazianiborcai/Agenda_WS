package br.com.mind5.security.userSearch.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.security.userSearch.info.UserarchInfo;

public final class UserarchDaoWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public UserarchDaoWhere(DaoWhereBuilderOption whereOption, String tableName, UserarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, UserarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case UserarchDaoDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case UserarchDaoDbTableColumn.COL_COD_USER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codUser));
					break;
					
				case UserarchDaoDbTableColumn.COL_COD_PERSON :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codPerson));
					break;
					
				case UserarchDaoDbTableColumn.COL_USERNAME :
					builder.addClauseEqualAnd(eachColumn, recordInfo.username);
					break;
					
				case UserarchDaoDbTableColumn.COL_COD_USER_CATEG :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.charToString(recordInfo.codUserCategory));
					break;
					
				case UserarchDaoDbTableColumn.COL_COD_AUTH_GROUP :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codAuthGroup);
					break;
					
				case UserarchDaoDbTableColumn.COL_RECORD_MODE :
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
