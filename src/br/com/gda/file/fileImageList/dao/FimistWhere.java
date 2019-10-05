package br.com.gda.file.fileImageList.dao;

import java.util.List;

import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTableColumnAll;
import br.com.gda.file.fileImageList.info.FimistInfo;
import br.com.gda.file.fileImageSearch.dao.FimarchDbTableColumn;

public final class FimistWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public FimistWhere(DaoWhereBuilderOption whereOption, String tableName, FimistInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, FimistInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
			case FimarchDbTableColumn.COL_COD_OWNER :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
				break;
				
			case FimarchDbTableColumn.COL_COD_FILE_IMG :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codFileImg));
				break;
				
			case FimarchDbTableColumn.COL_COD_PERSON :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codPerson));
				break;
				
			case FimarchDbTableColumn.COL_COD_STORE :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
				break;
				
			case FimarchDbTableColumn.COL_COD_OWNER_REF :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwnerRef));
				break;
				
			case FimarchDbTableColumn.COL_COD_MATERIAL :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codMat));
				break;
				
			case FimarchDbTableColumn.COL_RECORD_MODE :
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
