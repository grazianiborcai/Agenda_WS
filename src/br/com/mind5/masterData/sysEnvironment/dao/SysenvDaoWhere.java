package br.com.mind5.masterData.sysEnvironment.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.masterData.sysEnvironment.info.SysenvInfo;

final class SysenvDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public SysenvDaoWhere(DaoWhereBuilderOption whereOption, String tableName, SysenvInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, SysenvInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case SysenvDaoDbTableColumn.COL_COD_SYS_ENVIRONMENT :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codSysEnviron);
					break;
			}
		}		
			
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
