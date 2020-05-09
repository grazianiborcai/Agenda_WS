package br.com.mind5.payment.payOrderItemSearch.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

public final class DaoPayormarchWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public DaoPayormarchWhere(DaoWhereBuilderOption whereOption, String tableName, PayormarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, PayormarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case DaoPayormarchDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case DaoPayormarchDbTableColumn.COL_COD_PAY_ORDER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codPayOrder));
					break;
					
				case DaoPayormarchDbTableColumn.COL_COD_PAY_ORDER_ITEM :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codPayOrderItem));
					break;
					
				case DaoPayormarchDbTableColumn.COL_COD_ORDER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOrder));
					break;
					
				case DaoPayormarchDbTableColumn.COL_COD_ORDER_ITEM :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOrderItem));
					break;
					
				case DaoPayormarchDbTableColumn.COL_STATUS_ORDER_PARTNER :
					builder.addClauseEqualAnd(eachColumn, recordInfo.statusOrderPartner);
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
