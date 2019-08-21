package br.com.gda.business.masterData.dao;

import java.util.List;

import br.com.gda.business.masterData.info.ScheduleStatusInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTableColumnAll;

final class ScheduleStatusWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public ScheduleStatusWhere(DaoWhereBuilderOption whereOption, String tableName, ScheduleStatusInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, ScheduleStatusInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case MasterDataDbTableColumn.COL_COD_SCHEDULE_STATUS :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codScheduleStatus);
					break;
			}
		}		
			
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
