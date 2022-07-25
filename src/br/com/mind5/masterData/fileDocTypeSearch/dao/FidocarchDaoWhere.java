package br.com.mind5.masterData.fileDocTypeSearch.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.masterData.fileDocTypeSearch.info.FidocarchInfo;

final class FidocarchDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public FidocarchDaoWhere(DaoWhereBuilderOption whereOption, String tableName, FidocarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, FidocarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case FidocarchDaoDbTableColumn.COL_COD_FILE_DOC_TYPE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codFileDocType);
					break;
					
				case FidocarchDaoDbTableColumn.COL_COD_LANGUAGE :
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
