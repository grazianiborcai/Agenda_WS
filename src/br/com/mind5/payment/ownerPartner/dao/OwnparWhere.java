package br.com.mind5.payment.ownerPartner.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;

final class OwnparWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public OwnparWhere(DaoWhereBuilderOption whereOption, String tableName, OwnparInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, OwnparInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case OwnparDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;					
					
				case OwnparDbTableColumn.COL_IS_DEFAULT :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.booleanTrueToString(recordInfo.isDefault));
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
