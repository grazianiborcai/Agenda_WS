package br.com.mind5.business.phoneDefault.dao;

import java.util.List;

import br.com.mind5.business.phoneDefault.info.PhonaultInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class DaoPhonaultWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public DaoPhonaultWhere(DaoWhereBuilderOption whereOption, String tableName, PhonaultInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, PhonaultInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case DaoPhonaultDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case DaoPhonaultDbTableColumn.COL_COD_CUSTOMER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codCustomer));
					break;
					
				case DaoPhonaultDbTableColumn.COL_COD_STORE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
					break;
					
				case DaoPhonaultDbTableColumn.COL_COD_EMPLOYEE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codEmployee));
					break;
					
				case DaoPhonaultDbTableColumn.COL_COD_USER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codUser));
					break;
					
				case DaoPhonaultDbTableColumn.COL_COD_OWNER_REF :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwnerRef));
					break;
					
				case DaoPhonaultDbTableColumn.COL_IS_DEFAULT :
					builder.addClauseEqualAnd(eachColumn, "1");
					break;
					
				case DaoPhonaultDbTableColumn.COL_RECORD_MODE :
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
