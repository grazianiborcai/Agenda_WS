package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;

public final class SowedulagrDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public SowedulagrDaoWhere(DaoWhereBuilderOption whereOption, String tableName, SowedulagrInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, SowedulagrInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case SowedulagrDaoDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case SowedulagrDaoDbTableColumn.COL_CALMONTH :
					builder.addClauseEqualAnd(eachColumn, recordInfo.calmonth);
					break;
					
				case SowedulagrDaoDbTableColumn.COL_COD_COUNTRY :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codCountry);
					break;
					
				case SowedulagrDaoDbTableColumn.COL_STATE_PROVINCE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codState);
					break;
					
				case SowedulagrDaoDbTableColumn.COL_CITY :
					builder.addClauseEqualAnd(eachColumn, recordInfo.city);
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
