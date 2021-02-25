package br.com.mind5.stats.userOrderYearStgn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.stats.userOrderYearStgn.info.StusorygeInfo;

public final class DaoStusorygeUpdateSingle extends DaoStmtTemplate<StusorygeInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_USER_ORDER_YEAR_STGN_TABLE;
	
	
	public DaoStusorygeUpdateSingle(Connection conn, StusorygeInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StusorygeInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new DaoStusorygeWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<StusorygeInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<StusorygeInfo>() {	
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StusorygeInfo recordInfo) throws SQLException {	
				int i = 1;				
				
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);	
				
				return stmt;
			}		
		};
	}
}
