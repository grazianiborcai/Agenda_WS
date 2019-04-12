package br.com.gda.business.employeeWorkTime.dao;

import java.sql.Connection;
import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;


public final class EmpwotmSelectSingle extends EmpwotmSelectTemplate {
	
	public EmpwotmSelectSingle(Connection conn, EmpwotmInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmpwotmInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmpwotmWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
}