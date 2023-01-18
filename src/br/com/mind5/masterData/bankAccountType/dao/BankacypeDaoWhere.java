package br.com.mind5.masterData.bankAccountType.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.masterData.bankAccountType.info.BankacypeInfo;

final class BankacypeDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public BankacypeDaoWhere(DaoWhereBuilderOption whereOption, String tableName, BankacypeInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, BankacypeInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case BankacypeDaoDbTableColumn.COL_COD_BANK_ACCOUNT_TYPE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codBankAccountType));
					break;
					
				case BankacypeDaoDbTableColumn.COL_COD_LANGUAGE :
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
