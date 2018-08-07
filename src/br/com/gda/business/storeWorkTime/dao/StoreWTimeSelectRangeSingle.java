package br.com.gda.business.storeWorkTime.dao;

import java.sql.Connection;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class StoreWTimeSelectRangeSingle extends StoreWTimeSelectTemplate {

	public StoreWTimeSelectRangeSingle(Connection conn, StoreWTimeInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StoreWTimeInfo recordInfo) {
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StoreWTimeWhereRange(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
}
