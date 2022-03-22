package br.com.mind5.business.customerSearch.dao;

import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.dao.DaoColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilder;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

final class CusarchDaoWhere implements DaoStmtWhere {
	private String whereClause;	
	
	
	public CusarchDaoWhere(DaoWhereBuilderOption whereOption, String tableName, CusarchInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(DaoWhereBuilderOption whereOption, String tableName, CusarchInfo recordInfo) {
		DaoWhereBuilder builder = DaoWhereBuilder.factory(whereOption);		
		List<DaoColumn> columns = DaoDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (DaoColumn eachColumn : columns) {
			switch(eachColumn.columnName) {
			case CusarchDaoDbTableColumn.COL_COD_OWNER :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codOwner));
				break;
				
			case CusarchDaoDbTableColumn.COL_COD_CUSTOMER :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codCustomer));
				break;
				
			case CusarchDaoDbTableColumn.COL_COD_USER :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codUser));
				break;
				
			case CusarchDaoDbTableColumn.COL_COD_STORE :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codStore));
				break;
				
			case CusarchDaoDbTableColumn.COL_COD_PERSON :
				builder.addClauseEqualAnd(eachColumn, DaoFormatter.numberToString(recordInfo.codPerson));
				break;
				
			case CusarchDaoDbTableColumn.COL_RECORD_MODE :
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
