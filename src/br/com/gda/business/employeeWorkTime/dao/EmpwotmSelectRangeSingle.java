package br.com.gda.business.employeeWorkTime.dao;

import java.sql.Connection;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class EmpwotmSelectRangeSingle extends EmpwotmSelectTemplate {

	public EmpwotmSelectRangeSingle(Connection conn, EmpwotmInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmpwotmInfo recordInfo) {
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmpwotmWhereRange(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
}
