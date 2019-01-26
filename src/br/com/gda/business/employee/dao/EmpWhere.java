package br.com.gda.business.employee.dao;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;

final class EmpWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public EmpWhere(DaoWhereBuilderOption whereOption, String tableName, EmpInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, EmpInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
			case EmpDbTableColumn.COL_COD_OWNER :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
				break;
				
			case EmpDbTableColumn.COL_COD_EMPLOYEE :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codEmployee));
				break;
				
			case EmpDbTableColumn.COL_RECORD_MODE :
				builder.addClauseEqualAnd(eachColumn, recordInfo.recordMode);
				break;
				
			case EmpDbTableColumn.COL_COD_LANGUAGE :
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
