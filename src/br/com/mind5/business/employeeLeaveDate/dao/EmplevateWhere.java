package br.com.mind5.business.employeeLeaveDate.dao;

import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.DaoWhereCondition;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

public final class EmplevateWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public EmplevateWhere(DaoWhereBuilderOption whereOption, String tableName, EmplevateInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, EmplevateInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case EmplevateDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
				
				case EmplevateDbTableColumn.COL_COD_STORE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
					break;
					
				case EmplevateDbTableColumn.COL_COD_EMPLOYEE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codEmployee));
					break;
					
				case EmplevateDbTableColumn.COL_DT_VALID_FROM  :
					builder.addClauseAnd(eachColumn, DaoFormatter.dateToString(recordInfo.dateValidFrom), DaoWhereCondition.LESS_OR_EQUAL);
					break;
					
				case EmplevateDbTableColumn.COL_DT_VALID_TO :
					builder.addClauseAnd(eachColumn, DaoFormatter.dateToString(recordInfo.dateValidTo), DaoWhereCondition.GREATER_OR_EQUAL);
					break;
					
				case EmplevateDbTableColumn.COL_RECORD_MODE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.recordMode);
					break;
					
				case EmplevateDbTableColumn.COL_COD_LANGUAGE :
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
