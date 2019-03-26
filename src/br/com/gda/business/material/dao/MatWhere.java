package br.com.gda.business.material.dao;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class MatWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public MatWhere(DaoWhereBuilderOption whereOption, String tableName, MatInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, MatInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case MatDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case MatDbTableColumn.COL_COD_MATERIAL :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codMat));
					break;
					
				case MatDbTableColumn.COL_COD_TYPE  :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codType));
					break;
					
				case MatDbTableColumn.COL_COD_GROUP :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codGroup));
					break;
					
				case MatDbTableColumn.COL_COD_CATEGORY :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codMatCateg));
					break;
					
				case MatDbTableColumn.COL_COD_LANGUAGE :
					if (tableName == DaoDbTable.MAT_TEXT_TABLE)
						builder.addClauseEqualAnd(eachColumn, recordInfo.codLanguage);
					break;
					
				case MatDbTableColumn.COL_RECORD_MODE :
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
