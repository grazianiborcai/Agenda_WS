package br.com.mind5.masterData.fileDocType.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.masterData.fileDocType.info.FidoceInfo;

final class FidoceDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public FidoceDaoWhere(DaoWhereBuilderOption whereOption, String tableName, FidoceInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, FidoceInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case FidoceDaoDbTableColumn.COL_COD_FILE_DOC_TYPE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codFileDocType);
					break;
					
				case FidoceDaoDbTableColumn.COL_COD_LANGUAGE :
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
