package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.dao;

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
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;

public final class DaoStedmonagrSelectSingle extends DaoStmtTemplate<StedmonagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_SCHEDULE_MONTH_TABLE;
	
	
	public DaoStedmonagrSelectSingle(Connection conn, StedmonagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StedmonagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoStedmonagrWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StedmonagrInfo> getResultParserHook() {
		return new DaoResultParser<StedmonagrInfo>() {
			@Override public List<StedmonagrInfo> parseResult(StedmonagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StedmonagrInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StedmonagrInfo dataInfo = new StedmonagrInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoStedmonagrDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoStedmonagrDbTableColumn.COL_COD_STORE);
					dataInfo.calmonth = stmtResult.getString(DaoStedmonagrDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, DaoStedmonagrDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, DaoStedmonagrDbTableColumn.COL_MONTH);
					dataInfo.codCountry = stmtResult.getString(DaoStedmonagrDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(DaoStedmonagrDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(DaoStedmonagrDbTableColumn.COL_CITY);
					dataInfo.countScheduleCancelledMonth = DaoFormatter.sqlToInt(stmtResult, DaoStedmonagrDbTableColumn.COL_COUNT_SCHEDULE_CANCELLED_MONTH);
					dataInfo.countScheduleWaitingMonth = DaoFormatter.sqlToInt(stmtResult, DaoStedmonagrDbTableColumn.COL_COUNT_SCHEDULE_WAITING_MONTH);
					dataInfo.countScheduleTotalMonth = DaoFormatter.sqlToInt(stmtResult, DaoStedmonagrDbTableColumn.COL_COUNT_SCHEDULE_TOTAL_MONTH);
					dataInfo.countScheduleConfirmedMonth = DaoFormatter.sqlToInt(stmtResult, DaoStedmonagrDbTableColumn.COL_COUNT_SCHEDULE_CONFIRMED_MONTH);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoStedmonagrDbTableColumn.COL_LAST_CHANGED);					
					dataInfo.countScheduleCancelledLastYear = DaoFormatter.sqlToInt(stmtResult, DaoStedmonagrDbTableColumn.COL_COUNT_SCHEDULE_CANCELLED_MONTH_LAST_YEAR);
					dataInfo.countScheduleWaitingLastYear = DaoFormatter.sqlToInt(stmtResult, DaoStedmonagrDbTableColumn.COL_COUNT_SCHEDULE_WAITING_MONTH_LAST_YEAR);
					dataInfo.countScheduleTotalLastYear = DaoFormatter.sqlToInt(stmtResult, DaoStedmonagrDbTableColumn.COL_COUNT_SCHEDULE_TOTAL_MONTH_LAST_YEAR);
					dataInfo.countScheduleConfirmedLastYear = DaoFormatter.sqlToInt(stmtResult, DaoStedmonagrDbTableColumn.COL_COUNT_SCHEDULE_CONFIRMED_MONTH_LAST_YEAR);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
