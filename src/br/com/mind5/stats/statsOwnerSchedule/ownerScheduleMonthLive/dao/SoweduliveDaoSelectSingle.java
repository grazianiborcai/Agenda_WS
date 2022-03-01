package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.dao;

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
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;

public final class SoweduliveDaoSelectSingle extends DaoStmtTemplate<SoweduliveInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_SCHEDULE_DASH_LIVE_TABLE;	
	
	
	public SoweduliveDaoSelectSingle(Connection conn, SoweduliveInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SoweduliveInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new SoweduliveDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SoweduliveInfo> getResultParserHook() {
		return new DaoResultParser<SoweduliveInfo>() {
			@Override public List<SoweduliveInfo> parseResult(SoweduliveInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SoweduliveInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SoweduliveInfo dataInfo = new SoweduliveInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, SoweduliveDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.calmonth = stmtResult.getString(SoweduliveDaoDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, SoweduliveDaoDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, SoweduliveDaoDbTableColumn.COL_MONTH);
					dataInfo.codCountry = stmtResult.getString(SoweduliveDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(SoweduliveDaoDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(SoweduliveDaoDbTableColumn.COL_CITY);
					dataInfo.countScheduleCancelledMonth = DaoFormatter.sqlToInt(stmtResult, SoweduliveDaoDbTableColumn.COL_COUNT_SCHEDULE_CANCELLED_MONTH);
					dataInfo.countScheduleWaitingMonth = DaoFormatter.sqlToInt(stmtResult, SoweduliveDaoDbTableColumn.COL_COUNT_SCHEDULE_WAITING_MONTH);
					dataInfo.countScheduleTotalMonth = DaoFormatter.sqlToInt(stmtResult, SoweduliveDaoDbTableColumn.COL_COUNT_SCHEDULE_TOTAL_MONTH);
					dataInfo.countScheduleConfirmedMonth = DaoFormatter.sqlToInt(stmtResult, SoweduliveDaoDbTableColumn.COL_COUNT_SCHEDULE_CONFIRMED_MONTH);
					dataInfo.countScheduleCancelledLastYear = DaoFormatter.sqlToInt(stmtResult, SoweduliveDaoDbTableColumn.COL_COUNT_SCHEDULE_CANCELLED_MONTH_LAST_YEAR);
					dataInfo.countScheduleWaitingLastYear = DaoFormatter.sqlToInt(stmtResult, SoweduliveDaoDbTableColumn.COL_COUNT_SCHEDULE_WAITING_MONTH_LAST_YEAR);
					dataInfo.countScheduleTotalLastYear = DaoFormatter.sqlToInt(stmtResult, SoweduliveDaoDbTableColumn.COL_COUNT_SCHEDULE_TOTAL_MONTH_LAST_YEAR);
					dataInfo.countScheduleConfirmedLastYear = DaoFormatter.sqlToInt(stmtResult, SoweduliveDaoDbTableColumn.COL_COUNT_SCHEDULE_CONFIRMED_MONTH_LAST_YEAR);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
