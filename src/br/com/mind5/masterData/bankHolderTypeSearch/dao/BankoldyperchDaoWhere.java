package br.com.mind5.masterData.bankHolderTypeSearch.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.masterData.bankHolderTypeSearch.info.BankoldyperchInfo;

final class BankoldyperchDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public BankoldyperchDaoWhere(DaoWhereBuilderOption whereOption, String tableName, BankoldyperchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, BankoldyperchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case BankoldyperchDaoDbTableColumn.COL_COD_BANK_HOLDER_TYPE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codBankHolderType));
					break;
					
				case BankoldyperchDaoDbTableColumn.COL_COD_LANGUAGE :
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
