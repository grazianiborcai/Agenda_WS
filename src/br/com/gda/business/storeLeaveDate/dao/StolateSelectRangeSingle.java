package br.com.gda.business.storeLeaveDate.dao;

import java.sql.Connection;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoOptionValue;

public final class StolevateSelectRangeSingle extends StolevateSelectTemplate {

	public StolevateSelectRangeSingle(Connection conn, StolevateInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StolevateInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StolevateWhereRange(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
}
