package br.com.mind5.business.feeOwner.dao;

import java.util.List;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class FeewnerWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public FeewnerWhere(DaoWhereBuilderOption whereOption, String tableName, FeewnerInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, FeewnerInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case FeewnerDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case FeewnerDbTableColumn.COL_COD_CURR :
					builder.addClauseEqualAnd(eachColumn, recordInfo.codCurr);
					break;
					
				case FeewnerDbTableColumn.COL_COD_FEE_CATEG :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.charToString(recordInfo.codFeeCateg));
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
