package br.com.mind5.payment.countryPartner.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

final class CounparWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public CounparWhere(DaoWhereBuilderOption whereOption, String tableName, CounparInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, CounparInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case CounparDbTableColumn.COL_COD_COUNTRY :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codCountry);
					break;
					
				case CounparDbTableColumn.COL_IS_DEFAULT :
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
