package br.com.mind5.business.personCustomer_.dao;

import java.util.List;

import br.com.mind5.business.personCustomer_.info.PersonCusInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class PersonCusWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public PersonCusWhere(DaoWhereBuilderOption whereOption, String tableName, PersonCusInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, PersonCusInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
			case PersonCusDbTableColumn.COL_COD_OWNER :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
				break;
				
			case PersonCusDbTableColumn.COL_COD_PERSON :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codPerson));
				break;
				
			case PersonCusDbTableColumn.COL_COD_CUSTOMER :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codCustomer));
				break;
				
			case PersonCusDbTableColumn.COL_CPF :
				builder.addClauseEqualAnd(eachColumn, recordInfo.cpf);
				break;
				
			case PersonCusDbTableColumn.COL_EMAIL :
				builder.addClauseEqualAnd(eachColumn, recordInfo.email);
				break;
				
			case PersonCusDbTableColumn.COL_COD_ENTITY_CATEG :
				builder.addClauseEqualAnd(eachColumn, recordInfo.codEntityCateg);
				break;
				
			case PersonCusDbTableColumn.COL_RECORD_MODE :
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
