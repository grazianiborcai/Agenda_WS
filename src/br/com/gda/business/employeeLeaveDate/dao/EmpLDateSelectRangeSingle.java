package br.com.gda.business.employeeLeaveDate.dao;

import java.sql.Connection;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class EmpLDateSelectRangeSingle extends EmpLDateSelectTemplate {

	public EmpLDateSelectRangeSingle(Connection conn, EmpLDateInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmpLDateInfo recordInfo) {
		final boolean DONT_IGNORE_NULL = false;
		final boolean IGNORE_RECORD_MODE = true;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmpLDateWhereRange(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
}
