package br.com.gda.business.employeeWorkTime.dao;

import java.sql.Connection;
import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;


public final class EmpWTimeSelectSingle extends EmpWTimeSelectTemplate {
	
	public EmpWTimeSelectSingle(Connection conn, EmpWTimeInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmpWTimeInfo recordInfo) {
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmpWTimeWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
}