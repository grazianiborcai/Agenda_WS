package br.com.gda.business.employeeLeaveDate.dao;

import java.sql.Connection;
import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class EmpLDateSelectSingle extends EmpLDateSelectTemplate {
	
	public EmpLDateSelectSingle(Connection conn, EmpLDateInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmpLDateInfo recordInfo) {
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmpLDateWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
}
