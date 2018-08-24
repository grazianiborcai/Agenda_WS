package br.com.gda.business.storeWorkTime.dao;

import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoFormatterNumber;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.DaoWhereCondition;

final class StoreWTimeWhereRange implements DaoStmtWhere {
	private String whereClause;	
	
	
	public StoreWTimeWhereRange(DaoWhereBuilderOption whereOption, String tableName, StoreWTimeInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, StoreWTimeInfo recordInfo) {
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
					
				case "weekday" :
					builder.addClauseEqualAnd(eachColumn, DaoFormatterNumber.numberToString(recordInfo.codWeekday));
					break;
					
				case "begin_time" :
					builder.addClauseAnd(eachColumn, DaoFormatterNumber.timeToString(recordInfo.beginTime), DaoWhereCondition.LESS_OR_EQUAL);
					break;
					
				case "end_time" :
					builder.addClauseAnd(eachColumn, DaoFormatterNumber.timeToString(recordInfo.endTime), DaoWhereCondition.GREATER_OR_EQUAL);
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
