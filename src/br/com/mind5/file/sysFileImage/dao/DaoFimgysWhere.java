package br.com.mind5.file.sysFileImage.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.file.sysFileImage.info.FimgysInfo;

public final class DaoFimgysWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public DaoFimgysWhere(DaoWhereBuilderOption whereOption, String tableName, FimgysInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, FimgysInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {					
				case DaoFimgysDbTableColumn.COL_COD_FILE_IMG :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codFileImg));
					break;
					
				case DaoFimgysDbTableColumn.COL_RECORD_MODE :
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
