package br.com.gda.file.filePath.dao;

import java.util.List;

import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTableColumnAll;
import br.com.gda.file.filePath.info.FathInfo;

public final class FathWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public FathWhere(DaoWhereBuilderOption whereOption, String tableName, FathInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, FathInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case FathDbTableColumn.COL_COD_FILE_PATH :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codFilePath);
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
