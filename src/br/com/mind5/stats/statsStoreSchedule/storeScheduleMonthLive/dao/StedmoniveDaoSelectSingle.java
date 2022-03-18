package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.dao;

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
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthLive.info.StedmoniveInfo;

public final class StedmoniveDaoSelectSingle extends DaoStmtTemplate<StedmoniveInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_SCHEDULE_MONTH_LIVE_TABLE;
	
	
	public StedmoniveDaoSelectSingle(Connection conn, StedmoniveInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StedmoniveInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new StedmoniveDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StedmoniveInfo> getResultParserHook() {
		return new DaoResultParser<StedmoniveInfo>() {
			@Override public List<StedmoniveInfo> parseResult(StedmoniveInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StedmoniveInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StedmoniveInfo dataInfo = new StedmoniveInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, StedmoniveDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, StedmoniveDaoDbTableColumn.COL_COD_STORE);
					dataInfo.calmonth = stmtResult.getString(StedmoniveDaoDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, StedmoniveDaoDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, StedmoniveDaoDbTableColumn.COL_MONTH);
					dataInfo.codCountry = stmtResult.getString(StedmoniveDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(StedmoniveDaoDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(StedmoniveDaoDbTableColumn.COL_CITY);
					dataInfo.countScheduleCancelledMonth = DaoFormatter.sqlToInt(stmtResult, StedmoniveDaoDbTableColumn.COL_COUNT_SCHEDULE_CANCELLED_MONTH);
					dataInfo.countScheduleWaitingMonth = DaoFormatter.sqlToInt(stmtResult, StedmoniveDaoDbTableColumn.COL_COUNT_SCHEDULE_WAITING_MONTH);
					dataInfo.countScheduleTotalMonth = DaoFormatter.sqlToInt(stmtResult, StedmoniveDaoDbTableColumn.COL_COUNT_SCHEDULE_TOTAL_MONTH);
					dataInfo.countScheduleConfirmedMonth = DaoFormatter.sqlToInt(stmtResult, StedmoniveDaoDbTableColumn.COL_COUNT_SCHEDULE_CONFIRMED_MONTH);					
					dataInfo.countScheduleCancelledLastYear = DaoFormatter.sqlToInt(stmtResult, StedmoniveDaoDbTableColumn.COL_COUNT_SCHEDULE_CANCELLED_MONTH_LAST_YEAR);
					dataInfo.countScheduleWaitingLastYear = DaoFormatter.sqlToInt(stmtResult, StedmoniveDaoDbTableColumn.COL_COUNT_SCHEDULE_WAITING_MONTH_LAST_YEAR);
					dataInfo.countScheduleTotalLastYear = DaoFormatter.sqlToInt(stmtResult, StedmoniveDaoDbTableColumn.COL_COUNT_SCHEDULE_TOTAL_MONTH_LAST_YEAR);
					dataInfo.countScheduleConfirmedLastYear = DaoFormatter.sqlToInt(stmtResult, StedmoniveDaoDbTableColumn.COL_COUNT_SCHEDULE_CONFIRMED_MONTH_LAST_YEAR);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
