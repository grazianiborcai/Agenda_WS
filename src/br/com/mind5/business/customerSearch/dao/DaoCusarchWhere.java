package br.com.mind5.business.customerSearch.dao;

import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.DaoWhereOperator;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class DaoCusarchWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public DaoCusarchWhere(DaoWhereBuilderOption whereOption, String tableName, CusarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, CusarchInfo recordInfo) {
		DaoWhereBuilder builderWhereCustomer = null;
		DaoWhereBuilder builderWherePerson = null;
		DaoWhereBuilder builderWherePhone = null;
		DaoWhereBuilder builderWhereMerged = null;
		
		builderWhereCustomer = buildWhereCustomer(whereOption, tableName, recordInfo);
		
		if (hasPerson(recordInfo))
			builderWherePerson = buildWherePerson(whereOption, tableName, recordInfo);
		
		if (hasPhone(recordInfo))
			builderWherePhone = buildWherePhone(whereOption, tableName, recordInfo);
		
		
		builderWhereMerged = mergeBuilder(builderWhereCustomer, builderWherePerson, builderWherePhone);		
		whereClause = builderWhereMerged.generateClause();
	}
	
	
	
	private DaoWhereBuilder mergeBuilder(DaoWhereBuilder whereCustomer, DaoWhereBuilder wherePerson, DaoWhereBuilder wherePhone) {		
		if (wherePerson != null)
			whereCustomer.mergeBuilder(wherePerson, DaoWhereOperator.AND);		
		
		if (wherePhone != null)
			whereCustomer.mergeBuilder(wherePhone, DaoWhereOperator.AND);	
		
		return whereCustomer;
	}
	
	
	
	private DaoWhereBuilder buildWhereCustomer(DaoWhereBuilderOption whereOption, String tableName, CusarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
			case DaoCusarchDbTableColumn.COL_COD_OWNER :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
				break;
				
			case DaoCusarchDbTableColumn.COL_COD_CUSTOMER :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codCustomer));
				break;
				
			case DaoCusarchDbTableColumn.COL_COD_USER :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codUser));
				break;
				
			case DaoCusarchDbTableColumn.COL_COD_STORE :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
				break;
				
			case DaoCusarchDbTableColumn.COL_RECORD_MODE :
				builder.addClauseEqualAnd(eachColumn, recordInfo.recordMode);
				break;
			}
		}		
			
		return builder;
	}
	
	
	
	private DaoWhereBuilder buildWherePerson(DaoWhereBuilderOption whereOption, String tableName, CusarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case DaoCusarchDbTableColumn.COL_CPF :
					builder.addClauseEqualAnd(eachColumn, recordInfo.personData.cpf);
					break;
					
				case DaoCusarchDbTableColumn.COL_EMAIL :
					builder.addClauseEqualAnd(eachColumn, recordInfo.personData.email);
					break;
					
				case DaoCusarchDbTableColumn.COL_COD_ENTITY_CATEG :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codEntityCateg);
					break;
			}
		}		
			
		return builder;
	}
	
	
	
	private DaoWhereBuilder buildWherePhone(DaoWhereBuilderOption whereOption, String tableName, CusarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case DaoCusarchDbTableColumn.COL_COUNTRY_PHONE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.phoneData.codCountryPhone));
					break;
					
				case DaoCusarchDbTableColumn.COL_FULL_NUMBER :
					builder.addClauseEqualAnd(eachColumn, recordInfo.phoneData.fullNumber);
					break;
			}
		}		
			
		return builder;
	}
	
	
	
	private boolean hasPerson(CusarchInfo recordInfo) {
		if (recordInfo.personData == null)
			return false;
		
		return true;
	}
	
	
	
	private boolean hasPhone(CusarchInfo recordInfo) {
		if (recordInfo.phoneData == null)
			return false;
		
		return true;
	}	
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
