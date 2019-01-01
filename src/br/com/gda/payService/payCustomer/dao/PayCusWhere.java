package br.com.gda.payService.payCustomer.dao;

import java.util.List;

import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

public final class PayCusWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public PayCusWhere(DaoWhereBuilderOption whereOption, String tableName, PayCusInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, PayCusInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case PayCusDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case PayCusDbTableColumn.COL_COD_PAY_CUSTOMER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codPayCustomer));
					break;
					
				case PayCusDbTableColumn.COL_COD_PERSON :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codPerson));
					break;
					
				case PayCusDbTableColumn.COL_COD_USER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codUser));
					break;
					
				case PayCusDbTableColumn.COL_RECORD_MODE :
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
