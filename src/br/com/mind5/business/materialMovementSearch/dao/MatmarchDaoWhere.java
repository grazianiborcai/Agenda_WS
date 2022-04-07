package br.com.mind5.business.materialMovementSearch.dao;

import java.util.List;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

public final class MatmarchDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public MatmarchDaoWhere(DaoWhereBuilderOption whereOption, String tableName, MatmarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, MatmarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case MatmarchDaoDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case MatmarchDaoDbTableColumn.COL_COD_STORE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
					break;
					
				case MatmarchDaoDbTableColumn.COL_COD_MATERIAL :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codMat));
					break;
					
				case MatmarchDaoDbTableColumn.COL_COD_MAT_MOV :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codMatmov));
					break;
					
				case MatmarchDaoDbTableColumn.COL_POSTING_YEAR_MONTH :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.postingYearMonth));
					break;
					
				case MatmarchDaoDbTableColumn.COL_POSTING_YEAR :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.postingYear));
					break;
			}
		}		
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
