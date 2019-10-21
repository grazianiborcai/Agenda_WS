package br.com.mind5.business.storeWorkTime.dao;

import java.sql.Connection;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoOptionValue;

public final class StowotmSelectSingle extends StowotmSelectTemplate {	

	public StowotmSelectSingle(Connection conn, StowotmInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StowotmInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StowotmWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
}
