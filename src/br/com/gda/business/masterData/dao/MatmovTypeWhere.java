package br.com.gda.business.masterData.dao;

import java.util.List;

import br.com.gda.business.masterData.info.MatmovTypeInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTableColumnAll;

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
			}
		}		
			
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
