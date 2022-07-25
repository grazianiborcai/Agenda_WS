package br.com.mind5.masterData.scheduleStatus.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;

final class SchedatusDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public SchedatusDaoWhere(DaoWhereBuilderOption whereOption, String tableName, SchedatusInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, SchedatusInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case SchedatusDaoDbTableColumn.COL_COD_SCHEDULE_STATUS :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codScheduleStatus);
					break;
					
				case SchedatusDaoDbTableColumn.COL_COD_LANGUAGE :
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
