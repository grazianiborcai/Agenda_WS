package br.com.gda.payment.creditCard.dao;

import java.util.List;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class CrecardWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public CrecardWhere(DaoWhereBuilderOption whereOption, String tableName, CrecardInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, CrecardInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case CrecardDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case CrecardDbTableColumn.COL_COD_MATERIAL :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codMat));
					break;
					
				case CrecardDbTableColumn.COL_COD_TYPE  :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codType));
					break;
					
				case CrecardDbTableColumn.COL_COD_GROUP :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codGroup));
					break;
					
				case CrecardDbTableColumn.COL_COD_CATEGORY :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codMatCateg));
					break;
					
				case CrecardDbTableColumn.COL_RECORD_MODE :
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
