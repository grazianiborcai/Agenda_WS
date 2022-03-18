package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveInfo;

public final class SteddiveDaoSelectSingle extends DaoStmtTemplate<SteddiveInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_SCHEDULE_DAY_LIVE_TABLE;
	
	
	public SteddiveDaoSelectSingle(Connection conn, SteddiveInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SteddiveInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new SteddiveDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SteddiveInfo> getResultParserHook() {
		return new DaoResultParser<SteddiveInfo>() {
			@Override public List<SteddiveInfo> parseResult(SteddiveInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SteddiveInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SteddiveInfo dataInfo = new SteddiveInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, SteddiveDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, SteddiveDaoDbTableColumn.COL_COD_STORE);
					dataInfo.calmonth = stmtResult.getString(SteddiveDaoDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, SteddiveDaoDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, SteddiveDaoDbTableColumn.COL_MONTH);
					dataInfo.day = DaoFormatter.sqlToInt(stmtResult, SteddiveDaoDbTableColumn.COL_DAY);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, SteddiveDaoDbTableColumn.COL_DATE);
					dataInfo.codCountry = stmtResult.getString(SteddiveDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(SteddiveDaoDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(SteddiveDaoDbTableColumn.COL_CITY);
					dataInfo.countScheduleCancelledDay = DaoFormatter.sqlToInt(stmtResult, SteddiveDaoDbTableColumn.COL_COUNT_SCHEDULE_CANCELLED_DAY);
					dataInfo.countScheduleWaitingDay = DaoFormatter.sqlToInt(stmtResult, SteddiveDaoDbTableColumn.COL_COUNT_SCHEDULE_WAITING_DAY);
					dataInfo.countScheduleTotalDay = DaoFormatter.sqlToInt(stmtResult, SteddiveDaoDbTableColumn.COL_COUNT_SCHEDULE_TOTAL_DAY);
					dataInfo.countScheduleConfirmedDay = DaoFormatter.sqlToInt(stmtResult, SteddiveDaoDbTableColumn.COL_COUNT_SCHEDULE_CONFIRMED_DAY);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
