package br.com.mind5.masterData.movimentType.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.masterData.movimentType.info.MamovypeInfo;

final class DaoMamovypeWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public DaoMamovypeWhere(DaoWhereBuilderOption whereOption, String tableName, MamovypeInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, MamovypeInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case DaoMamovypeDbTableColumn.COL_COD_MAT_MOV_TYPE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.charToString(recordInfo.codMatmovType));
					break;
					
				case DaoMamovypeDbTableColumn.COL_COD_LANGUAGE :
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
