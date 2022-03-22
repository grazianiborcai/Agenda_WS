package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.dao;

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
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrInfo;

public final class CustamonagrDaoSelectSingle extends DaoStmtTemplate<CustamonagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_CUSTOMER_SCHEDULE_MONTH_TABLE;
	
	
	public CustamonagrDaoSelectSingle(Connection conn, CustamonagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CustamonagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new CustamonagrDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<CustamonagrInfo> getResultParserHook() {
		return new DaoResultParser<CustamonagrInfo>() {
			@Override public List<CustamonagrInfo> parseResult(CustamonagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CustamonagrInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CustamonagrInfo dataInfo = new CustamonagrInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, CustamonagrDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, CustamonagrDaoDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, CustamonagrDaoDbTableColumn.COL_COD_STORE);
					dataInfo.calmonth = stmtResult.getString(CustamonagrDaoDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, CustamonagrDaoDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, CustamonagrDaoDbTableColumn.COL_MONTH);
					dataInfo.codCountry = stmtResult.getString(CustamonagrDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(CustamonagrDaoDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(CustamonagrDaoDbTableColumn.COL_CITY);
					dataInfo.countScheduleCancelledMonth = DaoFormatter.sqlToInt(stmtResult, CustamonagrDaoDbTableColumn.COL_COUNT_SCHEDULE_CANCELLED_MONTH);
					dataInfo.countScheduleWaitingMonth = DaoFormatter.sqlToInt(stmtResult, CustamonagrDaoDbTableColumn.COL_COUNT_SCHEDULE_WAITING_MONTH);
					dataInfo.countScheduleTotalMonth = DaoFormatter.sqlToInt(stmtResult, CustamonagrDaoDbTableColumn.COL_COUNT_SCHEDULE_TOTAL_MONTH);
					dataInfo.countScheduleConfirmedMonth = DaoFormatter.sqlToInt(stmtResult, CustamonagrDaoDbTableColumn.COL_COUNT_SCHEDULE_CONFIRMED_MONTH);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, CustamonagrDaoDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
