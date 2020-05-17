package br.com.mind5.masterData.refundPolicyGroupHeaderSearch.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.masterData.refundPolicyGroupHeaderSearch.info.RefugradarchInfo;

final class DaoRefugradarchWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public DaoRefugradarchWhere(DaoWhereBuilderOption whereOption, String tableName, RefugradarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, RefugradarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {			
				case DaoRefugradarchDbTableColumn.COL_COD_REFUND_POLICY_GROUP :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codRefundPolicyGroup));
					break;
					
				case DaoRefugradarchDbTableColumn.COL_COD_LANGUAGE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codLanguage);
					break;
			}
		}		
			
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
