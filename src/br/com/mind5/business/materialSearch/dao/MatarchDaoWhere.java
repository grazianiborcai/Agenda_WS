package br.com.mind5.business.materialSearch.dao;

import java.util.List;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.DaoWhereCondition;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

public final class MatarchDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public MatarchDaoWhere(DaoWhereBuilderOption whereOption, String tableName, MatarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, MatarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case MatarchDaoDbTableColumn.COL_COD_OWNER :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
					break;
					
				case MatarchDaoDbTableColumn.COL_COD_MATERIAL :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codMat));
					break;
					
				case MatarchDaoDbTableColumn.COL_COD_STORE :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
					break;

				case MatarchDaoDbTableColumn.COL_COD_TYPE  :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codType));
					break;
					
				case MatarchDaoDbTableColumn.COL_COD_GROUP :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codGroup));
					break;
					
				case MatarchDaoDbTableColumn.COL_COD_CATEGORY :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codMatCateg));
					break;
					
				case MatarchDaoDbTableColumn.COL_NAME_SEARCH :
					builder.addClauseAnd(eachColumn, recordInfo.txtMatSearch, DaoWhereCondition.LIKE);
					break;		
					
				case MatarchDaoDbTableColumn.COL_COD_LANGUAGE :
					if(recordInfo.txtMatSearch != null)
						builder.addClauseEqualAnd(eachColumn, recordInfo.codLanguage);
					break;

				case MatarchDaoDbTableColumn.COL_RECORD_MODE :
					builder.addClauseEqualAnd(eachColumn, recordInfo.recordMode);
					break;
			}
		}		
		//TODO: Join com MATEXT cria cartesiano. Verificar problema de desempenho
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
