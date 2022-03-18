package br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.dao;

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
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info.StefiloniveInfo;

public final class StefiloniveDaoSelectSingle extends DaoStmtTemplate<StefiloniveInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_PROFILE_MONTH_LIVE_TABLE;
	
	
	public StefiloniveDaoSelectSingle(Connection conn, StefiloniveInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StefiloniveInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new StefiloniveDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StefiloniveInfo> getResultParserHook() {
		return new DaoResultParser<StefiloniveInfo>() {
			@Override public List<StefiloniveInfo> parseResult(StefiloniveInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StefiloniveInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StefiloniveInfo dataInfo = new StefiloniveInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, StefiloniveDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, StefiloniveDaoDbTableColumn.COL_COD_STORE);
					dataInfo.calmonth = stmtResult.getString(StefiloniveDaoDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, StefiloniveDaoDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, StefiloniveDaoDbTableColumn.COL_MONTH);
					dataInfo.countScheduleCancelled = DaoFormatter.sqlToInt(stmtResult, StefiloniveDaoDbTableColumn.COL_COUNT_SCHEDULE_CANCELLED);
					dataInfo.countScheduleWaiting = DaoFormatter.sqlToInt(stmtResult, StefiloniveDaoDbTableColumn.COL_COUNT_SCHEDULE_WAITING);
					dataInfo.countScheduleTotal = DaoFormatter.sqlToInt(stmtResult, StefiloniveDaoDbTableColumn.COL_COUNT_SCHEDULE_TOTAL);
					dataInfo.countScheduleConfirmed = DaoFormatter.sqlToInt(stmtResult, StefiloniveDaoDbTableColumn.COL_COUNT_SCHEDULE_CONFIRMED);
					dataInfo.countGoods = DaoFormatter.sqlToInt(stmtResult, StefiloniveDaoDbTableColumn.COL_COUNT_GOODS);
					dataInfo.countService = DaoFormatter.sqlToInt(stmtResult, StefiloniveDaoDbTableColumn.COL_COUNT_SERVICE);
					dataInfo.countEmployee = DaoFormatter.sqlToInt(stmtResult, StefiloniveDaoDbTableColumn.COL_COUNT_EMPLOYEE);
					dataInfo.countCustomer = DaoFormatter.sqlToInt(stmtResult, StefiloniveDaoDbTableColumn.COL_COUNT_CUSTOMER);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
