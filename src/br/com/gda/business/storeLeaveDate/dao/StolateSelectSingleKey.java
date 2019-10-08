package br.com.gda.business.storeLeaveDate.dao;

import java.sql.Connection;
import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoOptionValue;

public final class StolateSelectSingleKey extends StolateSelectTemplate {	
	
	public StolateSelectSingleKey(Connection conn, StolateInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StolateInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StolateWhereKey(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
}
