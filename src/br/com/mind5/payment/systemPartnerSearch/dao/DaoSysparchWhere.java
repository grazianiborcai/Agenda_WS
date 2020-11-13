package br.com.mind5.payment.systemPartnerSearch.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.payment.systemPartnerSearch.info.SysparchInfo;

final class DaoSysparchWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public DaoSysparchWhere(DaoWhereBuilderOption whereOption, String tableName, SysparchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, SysparchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case DaoSysparchDbTableColumn.COL_COD_PAY_PARTNER:
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codPayPartner));
					break;
					
				case DaoSysparchDbTableColumn.COL_ID_PAY_PARTNER_SYSTEM:
					builder.addClauseEqualAnd(eachColumn, recordInfo.idPayPartnerSystem);
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
