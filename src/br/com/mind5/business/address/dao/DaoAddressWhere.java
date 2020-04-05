package br.com.mind5.business.address.dao;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class DaoAddressWhere implements DaoStmtWhere {	
	private String whereClause;	
	
	
	public DaoAddressWhere(DaoWhereBuilderOption whereOption, String tableName, AddressInfo recordInfo) {
		whereClause = generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private String generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, AddressInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case DaoAddressDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case DaoAddressDbTableColumn.COL_COD_ADDRESS :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codAddress));
					break;

				case DaoAddressDbTableColumn.COL_RECORD_MODE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.recordMode);
					break;
			}
		}		
		
		return builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
