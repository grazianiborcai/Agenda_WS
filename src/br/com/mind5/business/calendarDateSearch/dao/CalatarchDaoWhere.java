package br.com.mind5.business.calendarDateSearch.dao;

import java.util.List;

import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class CalatarchDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public CalatarchDaoWhere(DaoWhereBuilderOption whereOption, String tableName, CalatarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, CalatarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case CalatarchDaoDbTableColumn.COL_YEAR :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.year));
					break;
					
				case CalatarchDaoDbTableColumn.COL_MONTH :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.month));
					break;
					
				case CalatarchDaoDbTableColumn.COL_WEEK_MONTH :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.weekMonth));
					break;
					
				case CalatarchDaoDbTableColumn.COL_WEEK_YEAR :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.weekYear));
					break;
			}
		}		
			
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
