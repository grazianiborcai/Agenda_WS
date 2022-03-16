package br.com.mind5.business.calendarMonthSearch.dao;

import java.util.List;

import br.com.mind5.business.calendarMonthSearch.info.CalontharchInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.DaoWhereCondition;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class CalontharchDaoWhere implements DaoStmtWhere {
	private String whereClause;
	
	
	public CalontharchDaoWhere(DaoWhereBuilderOption whereOption, String tableName, CalontharchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, CalontharchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case CalontharchDaoDbTableColumn.COL_CALMONTH :
					builder.addClauseEqualAnd(eachColumn, recordInfo.calmonth);
					builder.addClauseAnd(eachColumn, recordInfo.calmonthBegin, DaoWhereCondition.GREATER_OR_EQUAL);
					builder.addClauseAnd(eachColumn, recordInfo.calmonthEnd, DaoWhereCondition.LESS_OR_EQUAL);
					break;

			}
		}		
			
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
