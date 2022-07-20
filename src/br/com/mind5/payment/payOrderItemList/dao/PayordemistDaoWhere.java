package br.com.mind5.payment.payOrderItemList.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;

public final class PayordemistDaoWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public PayordemistDaoWhere(DaoWhereBuilderOption whereOption, String tableName, PayordemistInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, PayordemistInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case PayordemistDaoDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case PayordemistDaoDbTableColumn.COL_COD_PAY_ORDER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codPayOrder));
					break;
					
				case PayordemistDaoDbTableColumn.COL_COD_PAY_ORDER_ITEM :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codPayOrderItem));
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
