package br.com.gda.business.personUser.dao;

import java.util.List;

import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTableColumnAll;

final class PersonUserWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public PersonUserWhere(DaoWhereBuilderOption whereOption, String tableName, PersonUserInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, PersonUserInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
			case PersonUserDbTableColumn.COL_COD_OWNER :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
				break;
				
			case PersonUserDbTableColumn.COL_COD_PERSON :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codPerson));
				break;
				
			case PersonUserDbTableColumn.COL_COD_USER :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codUser));
				break;
				
			case PersonUserDbTableColumn.COL_CPF :
				builder.addClauseEqualAnd(eachColumn, recordInfo.cpf);
				break;
				
			case PersonUserDbTableColumn.COL_EMAIL :
				builder.addClauseEqualAnd(eachColumn, recordInfo.email);
				break;
				
			case PersonUserDbTableColumn.COL_COD_ENTITY_CATEG :
				builder.addClauseEqualAnd(eachColumn, recordInfo.codEntityCateg);
				break;
				
			case PersonUserDbTableColumn.COL_RECORD_MODE :
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
