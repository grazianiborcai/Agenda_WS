package br.com.mind5.webhook.moipMultipayment.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

final class WokaymoipWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public WokaymoipWhere(DaoWhereBuilderOption whereOption, String tableName, WokaymoipInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, WokaymoipInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case WokaymoipDbTableColumn.COL_ID_PAYMENT_PARTNER :
					builder.addClauseEqualAnd(eachColumn, recordInfo.idPaymentPartner);
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
