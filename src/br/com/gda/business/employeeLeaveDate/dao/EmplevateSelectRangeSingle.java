package br.com.gda.business.employeeLeaveDate.dao;

import java.sql.Connection;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class EmplevateSelectRangeSingle extends EmplevateSelectTemplate {

	public EmplevateSelectRangeSingle(Connection conn, EmplevateInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmplevateInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmplevateWhereRange(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
}
