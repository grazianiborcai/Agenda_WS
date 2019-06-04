package br.com.gda.business.addressSnapshot.dao;

import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTableColumnAll;

final class AddresnapWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public AddresnapWhere(DaoWhereBuilderOption whereOption, String tableName, AddresnapInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, AddresnapInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case AddresnapDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case AddresnapDbTableColumn.COL_COD_SNAPSHOT :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codSnapshot));
					break;
					
				case AddresnapDbTableColumn.COL_COD_ADDRESS :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codAddress));
					break;
				///
				case AddresnapDbTableColumn.COL_COD_CUSTOMER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codCustomer));
					break;
					
				case AddresnapDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codCustomerSnapshot));
					break;
					
				case AddresnapDbTableColumn.COL_COD_STORE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
					break;
					
				case AddresnapDbTableColumn.COL_COD_STORE_SNAPSHOT :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStoreSnapshot));
					break;
					
				case AddresnapDbTableColumn.COL_COD_EMPLOYEE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codEmployee));
					break;
					
				case AddresnapDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codEmployeeSnapshot));
					break;
					
				case AddresnapDbTableColumn.COL_COD_USER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codUser));
					break;
					
				case AddresnapDbTableColumn.COL_COD_USER_SNAPSHOT :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codUserSnapshot));
					break;
					
				case AddresnapDbTableColumn.COL_COD_OWNER_REF :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwnerRef));
					break;
					
				case AddresnapDbTableColumn.COL_COD_OWNER_REF_SNAPSHOT :
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
