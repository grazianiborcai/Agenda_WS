package br.com.mind5.business.companyConflict.dao;

import java.util.List;

import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.DaoWhereCondition;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

public final class CompcoDaoWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public CompcoDaoWhere(DaoWhereBuilderOption whereOption, String tableName, CompcoInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, CompcoInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case CompcoDaoDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case CompcoDaoDbTableColumn.COL_COD_COMPANY :
					builder.addClauseAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codCompany), DaoWhereCondition.NOT_EQUAL);
					break;
					
				case CompcoDaoDbTableColumn.COL_CNPJ :
					builder.addClauseEqualAnd(eachColumn, recordInfo.cnpj);
					break;
					
				case CompcoDaoDbTableColumn.COL_COD_ENTITY_CATEG :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codEntityCateg);
					break;
					
				case CompcoDaoDbTableColumn.COL_RECORD_MODE :
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
