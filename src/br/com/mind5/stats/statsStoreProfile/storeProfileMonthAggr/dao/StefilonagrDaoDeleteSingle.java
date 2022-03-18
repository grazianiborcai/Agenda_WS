package br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info.StefilonagrInfo;

public final class StefilonagrDaoDeleteSingle extends DaoStmtTemplate<StefilonagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_PROFILE_MONTH_TABLE;	
	
	
	public StefilonagrDaoDeleteSingle(Connection conn, StefilonagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.HARD_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StefilonagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new StefilonagrDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<StefilonagrInfo> getResultParserHook() {
		return new DaoResultParser<StefilonagrInfo>() {
			@Override public List<StefilonagrInfo> parseResult(StefilonagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StefilonagrInfo> finalResult = new ArrayList<>();
				StefilonagrInfo emptyInfo = new StefilonagrInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
