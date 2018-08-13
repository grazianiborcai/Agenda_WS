package br.com.gda.business.storeLeaveDate.dao;

import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoFormatterNumber;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.DaoWhereCondition;

public final class StoreLDateWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public StoreLDateWhere(DaoWhereBuilderOption whereOption, String tableName, StoreLDateInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, StoreLDateInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case "cod_owner" :
					builder.addClauseEqualAnd(eachColumn, DaoFormatterNumber.numberToString(recordInfo.codOwner));
					break;
					
				case "cod_store" :
					builder.addClauseEqualAnd(eachColumn, DaoFormatterNumber.numberToString(recordInfo.codStore));
					break;
					
				case "date_valid_from" :
					builder.addClauseAnd(eachColumn, DaoFormatterNumber.dateToString(recordInfo.dateValidFrom), DaoWhereCondition.LESS_OR_EQUAL);
					break;
					
				case "date_valid_to" :
					builder.addClauseAnd(eachColumn, DaoFormatterNumber.dateToString(recordInfo.dateValidTo), DaoWhereCondition.GREATER_OR_EQUAL);
					break;
					
				case "record_mode" :
					builder.addClauseEqualAnd(eachColumn,recordInfo.recordMode);
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
