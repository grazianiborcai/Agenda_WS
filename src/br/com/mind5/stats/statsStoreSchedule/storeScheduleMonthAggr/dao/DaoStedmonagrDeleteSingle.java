package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.dao;

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
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;

public final class DaoStedmonagrDeleteSingle extends DaoStmtTemplate<StedmonagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_SCHEDULE_MONTH_TABLE;	
	
	
	public DaoStedmonagrDeleteSingle(Connection conn, StedmonagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.HARD_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StedmonagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new DaoStedmonagrWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<StedmonagrInfo> getResultParserHook() {
		return new DaoResultParser<StedmonagrInfo>() {
			@Override public List<StedmonagrInfo> parseResult(StedmonagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StedmonagrInfo> finalResult = new ArrayList<>();
				StedmonagrInfo emptyInfo = new StedmonagrInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
