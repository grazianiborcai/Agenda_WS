package br.com.mind5.masterData.businessAreaSearch.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.masterData.businessAreaSearch.info.BusarearchInfo;

final class DaoBusarearchWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public DaoBusarearchWhere(DaoWhereBuilderOption whereOption, String tableName, BusarearchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, BusarearchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case DaoBusarearchDbTableColumn.COL_COD_BUSINESS :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codBusiness));
					break;
					
				case DaoBusarearchDbTableColumn.COL_COD_LANGUAGE :
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
