package br.com.mind5.business.personSearch.dao;

import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.DaoWhereCondition;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

public final class DaoPerarchWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public DaoPerarchWhere(DaoWhereBuilderOption whereOption, String tableName, PerarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, PerarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case DaoPerarchDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case DaoPerarchDbTableColumn.COL_COD_PERSON :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codPerson));
					break;
					
				case DaoPerarchDbTableColumn.COL_CPF :
					builder.addClauseEqualAnd(eachColumn, recordInfo.cpf);
					break;
					
				case DaoPerarchDbTableColumn.COL_EMAIL :
					builder.addClauseEqualAnd(eachColumn, recordInfo.email);
					break;
					
				case DaoPerarchDbTableColumn.COL_COD_ENTITY_CATEG :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codEntityCateg);
					break;
					
				case DaoPerarchDbTableColumn.COL_NAME_SEARCH :
					builder.addClauseAnd(eachColumn, recordInfo.nameSearch, DaoWhereCondition.LIKE);
					break;
					
				case DaoPerarchDbTableColumn.COL_RECORD_MODE :
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
