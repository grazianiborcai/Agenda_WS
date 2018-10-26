package br.com.gda.business.form.dao;

import java.util.List;

import br.com.gda.business.form.info.AddressFormInfo;
import br.com.gda.business.masterData.dao.MasterDataDbTableColumn;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;

final class AddressFormWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public AddressFormWhere(DaoWhereBuilderOption whereOption, String tableName, AddressFormInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, AddressFormInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case MasterDataDbTableColumn.COL_COD_COUNTRY :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codCountry);
					break;
			}
		}		
			
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
