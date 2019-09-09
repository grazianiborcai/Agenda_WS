package br.com.gda.business.scheduleWeekData.dao;

import java.util.List;

import br.com.gda.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class SchedeekdatWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public SchedeekdatWhere(DaoWhereBuilderOption whereOption, String tableName, SchedeekdatInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, SchedeekdatInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case SchedeekdatDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case SchedeekdatDbTableColumn.COL_COD_STORE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
					break;
					
				case SchedeekdatDbTableColumn.COL_COD_EMPLOYEE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codEmployee));
					break;
					
				case SchedeekdatDbTableColumn.COL_COD_CUSTOMER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codCustomer));
					break;
					
				case SchedeekdatDbTableColumn.COL_COD_MATERIAL :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codMat));
					break;
					
				case SchedeekdatDbTableColumn.COL_YEAR :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.year));
					break;
					
				case SchedeekdatDbTableColumn.COL_MONTH :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.month));
					break;
					
				case SchedeekdatDbTableColumn.COL_WEEK_MONTH :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.weekMonth));
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
