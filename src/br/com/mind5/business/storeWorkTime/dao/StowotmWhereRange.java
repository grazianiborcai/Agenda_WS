package br.com.mind5.business.storeWorkTime.dao;

import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.DaoWhereCondition;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class StowotmWhereRange implements DaoStmtWhere {
	private String whereClause;	
	
	
	public StowotmWhereRange(DaoWhereBuilderOption whereOption, String tableName, StowotmInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, StowotmInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case StowotmDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case StowotmDbTableColumn.COL_COD_STORE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
					break;
					
				case StowotmDbTableColumn.COL_COD_WEEKDAY :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codWeekday));
					break;
					
				case StowotmDbTableColumn.COL_BEGIN_TIME :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.beginTime), DaoWhereCondition.LESS_OR_EQUAL);
					break;
					
				case StowotmDbTableColumn.COL_END_TIME :
					builder.addClauseAnd(eachColumn, DaoFormatter.timeToString(recordInfo.endTime), DaoWhereCondition.GREATER_OR_EQUAL);
					break;
					
				case StowotmDbTableColumn.COL_RECORD_MODE :
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
