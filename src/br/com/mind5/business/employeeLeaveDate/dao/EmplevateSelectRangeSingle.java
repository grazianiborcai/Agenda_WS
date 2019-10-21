package br.com.mind5.business.employeeLeaveDate.dao;

import java.sql.Connection;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmplevateSelectRangeSingle extends EmplevateSelectTemplate {

	public EmplevateSelectRangeSingle(Connection conn, EmplevateInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmplevateInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmplevateWhereRange(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
}
