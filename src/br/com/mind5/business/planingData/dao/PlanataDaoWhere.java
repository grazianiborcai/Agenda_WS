package br.com.mind5.business.planingData.dao;

import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class PlanataDaoWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public PlanataDaoWhere(DaoWhereBuilderOption whereOption, String tableName, PlanataInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, PlanataInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
			case PlanataDaoDbTableColumn.COL_COD_OWNER :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
				break;
				
			case PlanataDaoDbTableColumn.COL_COD_STORE :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
				break;
				
			case PlanataDaoDbTableColumn.COL_COD_EMPLOYEE :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codEmployee));
				break;
				
			case PlanataDaoDbTableColumn.COL_COD_WEEKDAY :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codWeekday));
				break;
				
			case PlanataDaoDbTableColumn.COL_COD_MATERIAL :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codMat));
				break;
				
			case PlanataDaoDbTableColumn.COL_DATE :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.dateToString(recordInfo.date));
				break;
				
			case PlanataDaoDbTableColumn.COL_COD_MOON_PHASE :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codMoonPhase));
				break;

			case PlanataDaoDbTableColumn.COL_RECORD_MODE :
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
