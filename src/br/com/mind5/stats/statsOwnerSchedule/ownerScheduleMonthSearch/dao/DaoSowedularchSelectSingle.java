package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.dao;

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
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchInfo;

public final class DaoSowedularchSelectSingle extends DaoStmtTemplate<SowedularchInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_OWNER_SCHEDULE_MONTH_TABLE;
	
	
	public DaoSowedularchSelectSingle(Connection conn, SowedularchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STAT_OWNER_SCHEDULE_MONTH_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SowedularchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoSowedularchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SowedularchInfo> getResultParserHook() {
		return new DaoResultParser<SowedularchInfo>() {
			@Override public List<SowedularchInfo> parseResult(SowedularchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SowedularchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SowedularchInfo dataInfo = new SowedularchInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoSowedularchDbTableColumn.COL_COD_OWNER);
					dataInfo.calmonth = stmtResult.getString(DaoSowedularchDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, DaoSowedularchDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, DaoSowedularchDbTableColumn.COL_MONTH);
					dataInfo.codCountry = stmtResult.getString(DaoSowedularchDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(DaoSowedularchDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(DaoSowedularchDbTableColumn.COL_CITY);
					dataInfo.countScheduleCancelledMonth = DaoFormatter.sqlToInt(stmtResult, DaoSowedularchDbTableColumn.COL_COUNT_SCHEDULE_CANCELLED_MONTH);
					dataInfo.countScheduleWaitingMonth = DaoFormatter.sqlToInt(stmtResult, DaoSowedularchDbTableColumn.COL_COUNT_SCHEDULE_WAITING_MONTH);
					dataInfo.countScheduleTotalMonth = DaoFormatter.sqlToInt(stmtResult, DaoSowedularchDbTableColumn.COL_COUNT_SCHEDULE_TOTAL_MONTH);
					dataInfo.countScheduleConfirmedMonth = DaoFormatter.sqlToInt(stmtResult, DaoSowedularchDbTableColumn.COL_COUNT_SCHEDULE_CONFIRMED_MONTH);
					dataInfo.countScheduleCancelledLastYear = DaoFormatter.sqlToInt(stmtResult, DaoSowedularchDbTableColumn.COL_COUNT_SCHEDULE_CANCELLED_MONTH_LAST_YEAR);
					dataInfo.countScheduleWaitingLastYear = DaoFormatter.sqlToInt(stmtResult, DaoSowedularchDbTableColumn.COL_COUNT_SCHEDULE_WAITING_MONTH_LAST_YEAR);
					dataInfo.countScheduleTotalLastYear = DaoFormatter.sqlToInt(stmtResult, DaoSowedularchDbTableColumn.COL_COUNT_SCHEDULE_TOTAL_MONTH_LAST_YEAR);
					dataInfo.countScheduleConfirmedLastYear = DaoFormatter.sqlToInt(stmtResult, DaoSowedularchDbTableColumn.COL_COUNT_SCHEDULE_CONFIRMED_MONTH_LAST_YEAR);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
