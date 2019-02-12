package br.com.gda.business.masterData.dao;

import java.util.List;

import br.com.gda.business.masterData.info.RolurInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class RolurWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public RolurWhere(DaoWhereBuilderOption whereOption, String tableName, RolurInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, RolurInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case MasterDataDbTableColumn.COL_COD_ROLE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codRole);
					break;
					
				case MasterDataDbTableColumn.COL_COD_URI :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codUri);
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
