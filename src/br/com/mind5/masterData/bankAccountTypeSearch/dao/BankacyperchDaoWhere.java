package br.com.mind5.masterData.bankAccountTypeSearch.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.masterData.bankAccountTypeSearch.info.BankacyperchInfo;

final class BankacyperchDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public BankacyperchDaoWhere(DaoWhereBuilderOption whereOption, String tableName, BankacyperchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, BankacyperchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case BankacyperchDaoDbTableColumn.COL_COD_BANK_ACCOUNT_TYPE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codBankAccount));
					break;
					
				case BankacyperchDaoDbTableColumn.COL_COD_LANGUAGE :
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
