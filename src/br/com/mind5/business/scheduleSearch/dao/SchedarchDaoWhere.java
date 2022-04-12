package br.com.mind5.business.scheduleSearch.dao;

import java.util.List;

import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

public final class SchedarchDaoWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public SchedarchDaoWhere(DaoWhereBuilderOption whereOption, String tableName, SchedarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, SchedarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case SchedarchDaoDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case SchedarchDaoDbTableColumn.COL_COD_SCHEDULE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codSchedule));
					break;
					
				case SchedarchDaoDbTableColumn.COL_COD_ORDER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOrder));
					break;
					
				case SchedarchDaoDbTableColumn.COL_COD_ORDER_ITEM :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOrderItem));
					break;
					
				case SchedarchDaoDbTableColumn.COL_COD_MATERIAL :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codMat));
					break;
					
				case SchedarchDaoDbTableColumn.COL_COD_STORE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
					break;
					
				case SchedarchDaoDbTableColumn.COL_COD_EMPLOYEE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codEmployee));
					break;
					
				case SchedarchDaoDbTableColumn.COL_DATE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.dateToString(recordInfo.date));
					break;
					
				case SchedarchDaoDbTableColumn.COL_BEGIN_TIME :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.timeToString(recordInfo.beginTime));
					break;
					
				case SchedarchDaoDbTableColumn.COL_END_TIME :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.timeToString(recordInfo.endTime));
					break;
					
				case SchedarchDaoDbTableColumn.COL_COD_USER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codUser));
					break;
					
				case SchedarchDaoDbTableColumn.COL_YEAR :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.year));
					break;
					
				case SchedarchDaoDbTableColumn.COL_MONTH :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.month));
					break;
					
				case SchedarchDaoDbTableColumn.COL_RECORD_MODE :
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
