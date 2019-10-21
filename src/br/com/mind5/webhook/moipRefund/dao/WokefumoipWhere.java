package br.com.mind5.webhook.moipRefund.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;

final class WokefumoipWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public WokefumoipWhere(DaoWhereBuilderOption whereOption, String tableName, WokefumoipInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, WokefumoipInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case WokefumoipDbTableColumn.COL_ID_PAYMENT_PARTNER :
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
