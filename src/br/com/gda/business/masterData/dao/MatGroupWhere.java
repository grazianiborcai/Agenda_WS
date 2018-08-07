package br.com.gda.business.masterData.dao;

import java.util.List;

import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoFormatterNumber;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class MatGroupWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public MatGroupWhere(DaoWhereBuilderOption whereOption, String tableName, MatGroupInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, MatGroupInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case "Cod_group" :
					builder.addClauseEqualAnd(eachColumn, DaoFormatterNumber.numberToString(recordInfo.codGroup));
					break;
					
				case "Cod_business" :
					builder.addClauseEqualAnd(eachColumn, DaoFormatterNumber.numberToString(recordInfo.codBusiness));
					break;
			}
		}		
			
		whereClause = builder.generateClause();

	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
