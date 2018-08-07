package br.com.gda.business.employeeWorkTime.dao;

import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoFormatterNumber;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;

final class EmpWTimeWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public EmpWTimeWhere(DaoWhereBuilderOption whereOption, String tableName, EmpWTimeInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, EmpWTimeInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case "cod_owner" :
					builder.addClauseEqualAnd(eachColumn, DaoFormatterNumber.numberToString(recordInfo.codOwner));
					break;
				
				case "cod_store" :
					builder.addClauseEqualAnd(eachColumn, DaoFormatterNumber.numberToString(recordInfo.codStore));
					break;
					
				case "cod_employee" :
					builder.addClauseEqualAnd(eachColumn, DaoFormatterNumber.numberToString(recordInfo.codEmployee));
					break;
					
				case "weekday" :
					builder.addClauseEqualAnd(eachColumn, DaoFormatterNumber.numberToString(recordInfo.codWeekday));
					break;
					
				case "record_mode" :
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
