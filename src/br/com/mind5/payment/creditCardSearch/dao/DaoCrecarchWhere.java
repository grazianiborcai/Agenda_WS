package br.com.mind5.payment.creditCardSearch.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;

public final class DaoCrecarchWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public DaoCrecarchWhere(DaoWhereBuilderOption whereOption, String tableName, CrecarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, CrecarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case DaoCrecarchDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case DaoCrecarchDbTableColumn.COL_COD_CREDIT_CARD :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codCreditCard));
					break;
					
				case DaoCrecarchDbTableColumn.COL_COD_PAY_PARTNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codPayPartner));
					break;
					
				case DaoCrecarchDbTableColumn.COL_COD_PAY_CUSTOMER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codPayCustomer));
					break;
					
				case DaoCrecarchDbTableColumn.COL_COD_USER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codUser));
					break;
					
				case DaoCrecarchDbTableColumn.COL_CREDIT_CARD_ID :
					builder.addClauseEqualAnd(eachColumn, recordInfo.creditCardId);
					break;
					
				case DaoCrecarchDbTableColumn.COL_CREDIT_CARD_BRAND :
					builder.addClauseEqualAnd(eachColumn, recordInfo.creditCardBrand);
					break;
					
				case DaoCrecarchDbTableColumn.COL_CREDIT_CARD_LAST4:
					builder.addClauseEqualAnd(eachColumn, recordInfo.creditCardLast4);
					break;
					
				case DaoCrecarchDbTableColumn.COL_RECORD_MODE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.recordMode);
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
