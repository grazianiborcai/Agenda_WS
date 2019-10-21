package br.com.mind5.business.employeeWorkTime.dao;

import java.sql.Connection;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmpwotmSelectRangeSingle extends EmpwotmSelectTemplate {

	public EmpwotmSelectRangeSingle(Connection conn, EmpwotmInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmpwotmInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmpwotmWhereRange(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
}
