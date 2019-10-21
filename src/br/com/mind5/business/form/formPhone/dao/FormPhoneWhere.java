package br.com.mind5.business.form.formPhone.dao;

import java.util.List;

import br.com.mind5.business.form.formPhone.info.FormPhoneInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class FormPhoneWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public FormPhoneWhere(DaoWhereBuilderOption whereOption, String tableName, FormPhoneInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, FormPhoneInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case FormPhoneDbTableColumn.COL_COD_COUNTRY :
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
