package br.com.gda.business.material.dao;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoFormatterNumber;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class MatWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public MatWhere(DaoWhereBuilderOption whereOption, String tableName, MatInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, MatInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);
		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {			
			switch(eachColumn.columnName) {
				case "Cod_owner" :
					builder.addClauseEqualAnd(eachColumn, DaoFormatterNumber.numberToString(recordInfo.codOwner));
					break;
					
				case "Cod_material" :
					builder.addClauseEqualAnd(eachColumn, DaoFormatterNumber.numberToString(recordInfo.codMat));
					break;
					
				case "Cod_type" :
					builder.addClauseEqualAnd(eachColumn, DaoFormatterNumber.numberToString(recordInfo.codType));
					break;
					
				case "Cod_group" :
					builder.addClauseEqualAnd(eachColumn, DaoFormatterNumber.numberToString(recordInfo.codGroup));
					break;
					
				case "Language":
					if (tableName == DaoDbTable.MAT_TEXT_TABLE)
						builder.addClauseEqualAnd(eachColumn, recordInfo.codLanguage);
					break;
					
				case "record_mode" :
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
