package br.com.gda.business.storeLeaveDate.dao;

import java.sql.Connection;

import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class StoreLDateSelectRangeSingle extends StoreLDateSelectTemplate {

	public StoreLDateSelectRangeSingle(Connection conn, StoreLDateInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StoreLDateInfo recordInfo) {
		final boolean DONT_IGNORE_NULL = false;
		final boolean IGNORE_RECORD_MODE = true;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StoreLDateWhereRange(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
}
