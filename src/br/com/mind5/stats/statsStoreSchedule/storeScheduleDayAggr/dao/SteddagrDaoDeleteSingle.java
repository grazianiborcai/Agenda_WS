package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.dao;

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
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;

public final class SteddagrDaoDeleteSingle extends DaoStmtTemplate<SteddagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_SCHEDULE_DAY_TABLE;	
	
	
	public SteddagrDaoDeleteSingle(Connection conn, SteddagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.HARD_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SteddagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new SteddagrDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<SteddagrInfo> getResultParserHook() {
		return new DaoResultParser<SteddagrInfo>() {
			@Override public List<SteddagrInfo> parseResult(SteddagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SteddagrInfo> finalResult = new ArrayList<>();
				SteddagrInfo emptyInfo = new SteddagrInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
