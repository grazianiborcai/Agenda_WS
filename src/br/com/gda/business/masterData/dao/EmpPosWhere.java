package br.com.gda.business.masterData.dao;

import java.util.List;

import br.com.gda.business.masterData.info.EmpPosInfo;
import br.com.gda.dao.DaoColumn;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoFormatterNumber;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilder;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class EmpPosWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public EmpPosWhere(DaoWhereBuilderOption whereOption, String tableName, EmpPosInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, EmpPosInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
				case "Cod_position" :
					builder.addClauseEqualAnd(eachColumn, DaoFormatterNumber.numberToString(recordInfo.codPosition));
					break;
			}
		}		
			
		whereClause = builder.generateClause();

	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
