package br.com.gda.payment.payOrderItem.dao;

import java.util.List;

import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTableColumnAll;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

public final class PayordemWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public PayordemWhere(DaoWhereBuilderOption whereOption, String tableName, PayordemInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, PayordemInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case PayordemDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case PayordemDbTableColumn.COL_COD_PAY_ORDER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codPayOrder));
					break;
					
				case PayordemDbTableColumn.COL_ITEM_NUMBER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.itemNum));
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
