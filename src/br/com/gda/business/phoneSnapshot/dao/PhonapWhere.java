package br.com.gda.business.phoneSnapshot.dao;

import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTableColumnAll;

final class PhonapWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public PhonapWhere(DaoWhereBuilderOption whereOption, String tableName, PhonapInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, PhonapInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case PhonapDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case PhonapDbTableColumn.COL_COD_SNAPSHOT :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codSnapshot));
					break;
					
				case PhonapDbTableColumn.COL_COD_PHONE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codPhone));
					break;
					
				case PhonapDbTableColumn.COL_COD_CUSTOMER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codCustomer));
					break;
					
				case PhonapDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codCustomerSnapshot));
					break;
					
				case PhonapDbTableColumn.COL_COD_STORE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
					break;
					
				case PhonapDbTableColumn.COL_COD_STORE_SNAPSHOT :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStoreSnapshot));
					break;
					
				case PhonapDbTableColumn.COL_COD_EMPLOYEE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codEmployee));
					break;
					
				case PhonapDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codEmployeeSnapshot));
					break;
					
				case PhonapDbTableColumn.COL_COD_USER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codUser));
					break;
					
				case PhonapDbTableColumn.COL_COD_USER_SNAPSHOT :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codUserSnapshot));
					break;
					
				case PhonapDbTableColumn.COL_COD_OWNER_REF :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwnerRef));
					break;
					
				case PhonapDbTableColumn.COL_COD_OWNER_REF_SNAPSHOT :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwnerRefSnapshot));
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
