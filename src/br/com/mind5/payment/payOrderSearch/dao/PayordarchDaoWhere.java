package br.com.mind5.payment.payOrderSearch.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

final class PayordarchDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public PayordarchDaoWhere(DaoWhereBuilderOption whereOption, String tableName, PayordarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, PayordarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case PayordarchDaoDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case PayordarchDaoDbTableColumn.COL_COD_PAY_ORDER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codPayOrder));
					break;
					
				case PayordarchDaoDbTableColumn.COL_COD_ORDER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOrder));
					break;
					
				case PayordarchDaoDbTableColumn.COL_COD_USER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codUser));
					break;
					
				case PayordarchDaoDbTableColumn.COL_HAS_WEBHOOK_EVENT :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.booleanTrueToString(recordInfo.hasWebhookEvent));
					break;	
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
