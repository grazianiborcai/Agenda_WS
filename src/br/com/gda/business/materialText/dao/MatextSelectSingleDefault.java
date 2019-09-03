package br.com.gda.business.materialText.dao;

import java.sql.Connection;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoOptionValue;

public final class MatextSelectSingleDefault extends MatextSelectTemplate {

	public MatextSelectSingleDefault(Connection conn, MatextInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String buildWhereClauseHook() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MatextWhereDefault(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}

	
	
	@Override public DaoStmt<MatextInfo> getNewInstance() {
		return new MatextSelectSingleDefault(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
