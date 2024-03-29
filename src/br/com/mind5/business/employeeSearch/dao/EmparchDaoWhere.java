package br.com.mind5.business.employeeSearch.dao;

import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class EmparchDaoWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public EmparchDaoWhere(DaoWhereBuilderOption whereOption, String tableName, EmparchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, EmparchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
			case EmparchDaoDbTableColumn.COL_COD_OWNER :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
				break;
				
			case EmparchDaoDbTableColumn.COL_COD_EMPLOYEE :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codEmployee));
				break;
				
			case EmparchDaoDbTableColumn.COL_COD_STORE:
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
				break;
				
			case EmparchDaoDbTableColumn.COL_COD_USER :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codUser));
				break;
				
			case EmparchDaoDbTableColumn.COL_EMAIL:
				builder.addClauseEqualAnd(eachColumn, recordInfo.email);
				break;
				
			case EmparchDaoDbTableColumn.COL_RECORD_MODE :
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
