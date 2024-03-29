package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.dao;

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
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;

public final class SteddagrDaoSelectSingle extends DaoStmtTemplate<SteddagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_SCHEDULE_DAY_TABLE;
	
	
	public SteddagrDaoSelectSingle(Connection conn, SteddagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SteddagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new SteddagrDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SteddagrInfo> getResultParserHook() {
		return new DaoResultParser<SteddagrInfo>() {
			@Override public List<SteddagrInfo> parseResult(SteddagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SteddagrInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SteddagrInfo dataInfo = new SteddagrInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, SteddagrDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, SteddagrDaoDbTableColumn.COL_COD_STORE);
					dataInfo.calmonth = stmtResult.getString(SteddagrDaoDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, SteddagrDaoDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, SteddagrDaoDbTableColumn.COL_MONTH);
					dataInfo.day = DaoFormatter.sqlToInt(stmtResult, SteddagrDaoDbTableColumn.COL_DAY);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, SteddagrDaoDbTableColumn.COL_DATE);
					dataInfo.codCountry = stmtResult.getString(SteddagrDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(SteddagrDaoDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(SteddagrDaoDbTableColumn.COL_CITY);
					dataInfo.countScheduleCancelledDay = DaoFormatter.sqlToInt(stmtResult, SteddagrDaoDbTableColumn.COL_COUNT_SCHEDULE_CANCELLED_DAY);
					dataInfo.countScheduleWaitingDay = DaoFormatter.sqlToInt(stmtResult, SteddagrDaoDbTableColumn.COL_COUNT_SCHEDULE_WAITING_DAY);
					dataInfo.countScheduleTotalDay = DaoFormatter.sqlToInt(stmtResult, SteddagrDaoDbTableColumn.COL_COUNT_SCHEDULE_TOTAL_DAY);
					dataInfo.countScheduleConfirmedDay = DaoFormatter.sqlToInt(stmtResult, SteddagrDaoDbTableColumn.COL_COUNT_SCHEDULE_CONFIRMED_DAY);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, SteddagrDaoDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
