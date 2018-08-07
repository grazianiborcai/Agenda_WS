package br.com.gda.business.masterData.dao;

import java.util.List;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class CurrencyWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public CurrencyWhere(DaoWhereBuilderOption whereOption, String tableName, CurrencyInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, CurrencyInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case "Cod_curr" :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codCurr);
					break;
			}
		}		
			
		whereClause = builder.generateClause();

	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
