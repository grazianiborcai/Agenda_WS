package br.com.gda.business.employeeWorkTime.dao;

import java.sql.Connection;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilderOption;

public final class EmpWTimeSelectTRangeInsSingle extends EmpWTimeSelectTemplate {
	
	public EmpWTimeSelectTRangeInsSingle(Connection conn, EmpWTimeInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
		
	@Override protected String buildWhereClauseHook(String tableName, EmpWTimeInfo recordInfo) {
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		SqlWhereBuilderOption whereOption = new SqlWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		SqlStmtWhere whereClause = new EmpWTimeWhereTRangeIns(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
}
