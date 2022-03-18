package br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.dao;

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
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info.StefilonagrInfo;

public final class StefilonagrDaoSelectSingle extends DaoStmtTemplate<StefilonagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_PROFILE_MONTH_TABLE;
	
	
	public StefilonagrDaoSelectSingle(Connection conn, StefilonagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StefilonagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new StefilonagrDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StefilonagrInfo> getResultParserHook() {
		return new DaoResultParser<StefilonagrInfo>() {
			@Override public List<StefilonagrInfo> parseResult(StefilonagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StefilonagrInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StefilonagrInfo dataInfo = new StefilonagrInfo();
					
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, StefilonagrDaoDbTableColumn.COL_COD_STORE);
					dataInfo.calmonth = stmtResult.getString(StefilonagrDaoDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, StefilonagrDaoDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, StefilonagrDaoDbTableColumn.COL_MONTH);
					dataInfo.countScheduleCancelled = DaoFormatter.sqlToInt(stmtResult, StefilonagrDaoDbTableColumn.COL_COUNT_SCHEDULE_CANCELLED);
					dataInfo.countScheduleWaiting = DaoFormatter.sqlToInt(stmtResult, StefilonagrDaoDbTableColumn.COL_COUNT_SCHEDULE_WAITING);
					dataInfo.countScheduleTotal = DaoFormatter.sqlToInt(stmtResult, StefilonagrDaoDbTableColumn.COL_COUNT_SCHEDULE_TOTAL);
					dataInfo.countScheduleConfirmed = DaoFormatter.sqlToInt(stmtResult, StefilonagrDaoDbTableColumn.COL_COUNT_SCHEDULE_CONFIRMED);
					dataInfo.countGoods = DaoFormatter.sqlToInt(stmtResult, StefilonagrDaoDbTableColumn.COL_COUNT_GOODS);
					dataInfo.countService = DaoFormatter.sqlToInt(stmtResult, StefilonagrDaoDbTableColumn.COL_COUNT_SERVICE);
					dataInfo.countEmployee = DaoFormatter.sqlToInt(stmtResult, StefilonagrDaoDbTableColumn.COL_COUNT_EMPLOYEE);
					dataInfo.countCustomer = DaoFormatter.sqlToInt(stmtResult, StefilonagrDaoDbTableColumn.COL_COUNT_CUSTOMER);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, StefilonagrDaoDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
