package br.com.gda.business.customerSearch.dao;

import java.util.List;

import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.DaoWhereOperator;
import br.com.gda.dao.common.DaoDbTableColumnAll;

final class CusarchWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public CusarchWhere(DaoWhereBuilderOption whereOption, String tableName, CusarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, CusarchInfo recordInfo) {
		DaoWhereBuilder builderWhereCustomer = null;
		DaoWhereBuilder builderWherePerson = null;
		DaoWhereBuilder builderWhereMerged = null;
		
		builderWhereCustomer = buildWhereCustomer(whereOption, tableName, recordInfo);
		
		if (hasPerson(recordInfo))
			builderWherePerson = buildWherePerson(whereOption, tableName, recordInfo);
		
		
		builderWhereMerged = mergeBuilder(builderWhereCustomer, builderWherePerson);		
		whereClause = builderWhereMerged.generateClause();
	}
	
	
	
	private DaoWhereBuilder mergeBuilder(DaoWhereBuilder whereCustomer, DaoWhereBuilder wherePerson) {		
		if (wherePerson != null)
			whereCustomer.mergeBuilder(wherePerson, DaoWhereOperator.AND);		
		
		return whereCustomer;
	}
	
	
	
	private DaoWhereBuilder buildWhereCustomer(DaoWhereBuilderOption whereOption, String tableName, CusarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
			case CusarchDbTableColumn.COL_COD_OWNER :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
				break;
				
			case CusarchDbTableColumn.COL_COD_CUSTOMER :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codCustomer));
				break;
				
			case CusarchDbTableColumn.COL_RECORD_MODE :
				builder.addClauseEqualAnd(eachColumn, recordInfo.recordMode);
				break;
				
			case CusarchDbTableColumn.COL_COD_LANGUAGE :
				builder.addClauseEqualAnd(eachColumn, recordInfo.codLanguage);
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
				case CusarchDbTableColumn.COL_COD_PERSON :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.personData.codPerson));
					break;
					
				case CusarchDbTableColumn.COL_CPF :
					builder.addClauseEqualAnd(eachColumn, recordInfo.personData.cpf);
					break;
					
				case CusarchDbTableColumn.COL_COD_GENDER :
					builder.addClauseEqualAnd(eachColumn,  DaoFormatter.numberToString(recordInfo.personData.codGender));
					break;
					
				case CusarchDbTableColumn.COL_EMAIL :
					builder.addClauseEqualAnd(eachColumn, recordInfo.personData.email);
					break;
					
				case CusarchDbTableColumn.COL_COD_ENTITY_CATEG :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codEntityCateg);
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
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
