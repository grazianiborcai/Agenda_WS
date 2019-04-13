package br.com.gda.business.employeeLeaveDate.dao;

import java.sql.Connection;
import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class EmplevateSelectSingle extends EmplevateSelectTemplate {
	
	public EmplevateSelectSingle(Connection conn, EmplevateInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmplevateInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmplevateWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
}
