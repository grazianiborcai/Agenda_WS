package br.com.gda.business.storeWorkTime.dao;

import java.sql.Connection;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilderOption;

public final class StoreWTimeSelectTRangeSingle extends StoreWTimeSelectTemplate {

	public StoreWTimeSelectTRangeSingle(Connection conn, StoreWTimeInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StoreWTimeInfo recordInfo) {
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		SqlWhereBuilderOption whereOption = new SqlWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		SqlStmtWhere whereClause = new StoreWTimeWhereTRange(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
}
