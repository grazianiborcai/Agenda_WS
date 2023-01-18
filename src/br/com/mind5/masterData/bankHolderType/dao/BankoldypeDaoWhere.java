package br.com.mind5.masterData.bankHolderType.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.masterData.bankHolderType.info.BankoldypeInfo;

final class BankoldypeDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public BankoldypeDaoWhere(DaoWhereBuilderOption whereOption, String tableName, BankoldypeInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, BankoldypeInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case BankoldypeDaoDbTableColumn.COL_COD_BANK_HOLDER_TYPE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codBankHolderType));
					break;
					
				case BankoldypeDaoDbTableColumn.COL_COD_LANGUAGE :
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
