package br.com.mind5.business.masterData.dao;

import java.util.List;

import br.com.mind5.business.masterData.info.MatmovTypeInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class MatmovTypeWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public MatmovTypeWhere(DaoWhereBuilderOption whereOption, String tableName, MatmovTypeInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, MatmovTypeInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case MasterDataDbTableColumn.COL_COD_MAT_MOV_TYPE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.charToString(recordInfo.codMatmovType));
					break;
					
				case MasterDataDbTableColumn.COL_COD_LANGUAGE :
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
