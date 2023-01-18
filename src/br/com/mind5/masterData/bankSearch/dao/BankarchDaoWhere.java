package br.com.mind5.masterData.bankSearch.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.masterData.bankSearch.info.BankarchInfo;

final class BankarchDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public BankarchDaoWhere(DaoWhereBuilderOption whereOption, String tableName, BankarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, BankarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case BankarchDaoDbTableColumn.COL_COD_BANK :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codBank));
					break;
					
				case BankarchDaoDbTableColumn.COL_COD_COMPE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codCompe);
					break;
					
				case BankarchDaoDbTableColumn.COL_COD_COUNTRY :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codCountry);
					break;
					
				case BankarchDaoDbTableColumn.COL_COD_LANGUAGE :
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
