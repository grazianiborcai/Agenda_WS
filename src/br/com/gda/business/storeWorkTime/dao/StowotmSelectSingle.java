package br.com.gda.business.storeWorkTime.dao;

import java.sql.Connection;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class StowotmSelectSingle extends StowotmSelectTemplate {	

	public StowotmSelectSingle(Connection conn, StowotmInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StowotmInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StowotmWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
}
