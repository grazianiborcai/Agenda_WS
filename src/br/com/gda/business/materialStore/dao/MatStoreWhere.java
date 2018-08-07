package br.com.gda.business.materialStore.dao;

import java.util.List;

import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoFormatterNumber;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class MatStoreWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public MatStoreWhere(DaoWhereBuilderOption whereOption, String tableName, MatStoreInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, MatStoreInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case "Cod_owner" :
					builder.addClauseEqualAnd(eachColumn, DaoFormatterNumber.numberToString(recordInfo.codOwner));
					break;
					
				case "Cod_store" :
					builder.addClauseEqualAnd(eachColumn, DaoFormatterNumber.numberToString(recordInfo.codStore));
					break;
					
				case "Cod_material" :
					builder.addClauseEqualAnd(eachColumn, DaoFormatterNumber.numberToString(recordInfo.codMat));
					break;
					
				case "record_mode" :
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
