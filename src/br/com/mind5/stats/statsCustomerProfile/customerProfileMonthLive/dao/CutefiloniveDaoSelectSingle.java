package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.dao;

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
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info.CutefiloniveInfo;

public final class CutefiloniveDaoSelectSingle extends DaoStmtTemplate<CutefiloniveInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_CUSTOMER_PROFILE_MONTH_LIVE_TABLE;
	
	
	public CutefiloniveDaoSelectSingle(Connection conn, CutefiloniveInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CutefiloniveInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new CutefiloniveDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<CutefiloniveInfo> getResultParserHook() {
		return new DaoResultParser<CutefiloniveInfo>() {
			@Override public List<CutefiloniveInfo> parseResult(CutefiloniveInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CutefiloniveInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CutefiloniveInfo dataInfo = new CutefiloniveInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, CutefiloniveDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, CutefiloniveDaoDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, CutefiloniveDaoDbTableColumn.COL_COD_STORE);
					dataInfo.calmonth = stmtResult.getString(CutefiloniveDaoDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, CutefiloniveDaoDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, CutefiloniveDaoDbTableColumn.COL_MONTH);
					dataInfo.countScheduleCancelled = DaoFormatter.sqlToInt(stmtResult, CutefiloniveDaoDbTableColumn.COL_COUNT_SCHEDULE_CANCELLED);
					dataInfo.countScheduleWaiting = DaoFormatter.sqlToInt(stmtResult, CutefiloniveDaoDbTableColumn.COL_COUNT_SCHEDULE_WAITING);
					dataInfo.countScheduleTotal = DaoFormatter.sqlToInt(stmtResult, CutefiloniveDaoDbTableColumn.COL_COUNT_SCHEDULE_TOTAL);
					dataInfo.countScheduleConfirmed = DaoFormatter.sqlToInt(stmtResult, CutefiloniveDaoDbTableColumn.COL_COUNT_SCHEDULE_CONFIRMED);
					dataInfo.countGoods = DaoFormatter.sqlToInt(stmtResult, CutefiloniveDaoDbTableColumn.COL_COUNT_GOODS);
					dataInfo.countService = DaoFormatter.sqlToInt(stmtResult, CutefiloniveDaoDbTableColumn.COL_COUNT_SERVICE);
					dataInfo.countEmployee = DaoFormatter.sqlToInt(stmtResult, CutefiloniveDaoDbTableColumn.COL_COUNT_EMPLOYEE);
					dataInfo.countCustomer = DaoFormatter.sqlToInt(stmtResult, CutefiloniveDaoDbTableColumn.COL_COUNT_CUSTOMER);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
