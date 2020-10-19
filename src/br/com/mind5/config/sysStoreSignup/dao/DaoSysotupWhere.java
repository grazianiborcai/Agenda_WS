package br.com.mind5.config.sysStoreSignup.dao;

import java.util.List;

import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class DaoSysotupWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public DaoSysotupWhere(DaoWhereBuilderOption whereOption, String tableName, SysotupInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, SysotupInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case DaoSysotupDbTableColumn.COL_STORE_SIGNUP :
					builder.addClauseEqualAnd(eachColumn, recordInfo.storeSignup);
					break;
			}
		}		
			
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
