package br.com.mind5.masterData.materialSubgroup.dao;

import java.util.List;

import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;

final class MatubupDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public MatubupDaoWhere(DaoWhereBuilderOption whereOption, String tableName, MatubupInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, MatubupInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case MatubupDaoDbTableColumn.COL_COD_MAT_SUBGROUP :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codSubgroup));
					break;
					
				case MatubupDaoDbTableColumn.COL_COD_MAT_GROUP :
					builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codGroup));
					break;
					
				case MatubupDaoDbTableColumn.COL_COD_LANGUAGE :
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
