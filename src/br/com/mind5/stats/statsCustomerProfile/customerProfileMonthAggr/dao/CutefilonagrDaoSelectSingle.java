package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.dao;

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
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info.CutefilonagrInfo;

public final class CutefilonagrDaoSelectSingle extends DaoStmtTemplate<CutefilonagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_CUSTOMER_PROFILE_MONTH_TABLE;
	
	
	public CutefilonagrDaoSelectSingle(Connection conn, CutefilonagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CutefilonagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new CutefilonagrDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<CutefilonagrInfo> getResultParserHook() {
		return new DaoResultParser<CutefilonagrInfo>() {
			@Override public List<CutefilonagrInfo> parseResult(CutefilonagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CutefilonagrInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CutefilonagrInfo dataInfo = new CutefilonagrInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, CutefilonagrDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, CutefilonagrDaoDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, CutefilonagrDaoDbTableColumn.COL_COD_STORE);
					dataInfo.calmonth = stmtResult.getString(CutefilonagrDaoDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, CutefilonagrDaoDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, CutefilonagrDaoDbTableColumn.COL_MONTH);
					dataInfo.countScheduleCancelled = DaoFormatter.sqlToInt(stmtResult, CutefilonagrDaoDbTableColumn.COL_COUNT_SCHEDULE_CANCELLED);
					dataInfo.countScheduleWaiting = DaoFormatter.sqlToInt(stmtResult, CutefilonagrDaoDbTableColumn.COL_COUNT_SCHEDULE_WAITING);
					dataInfo.countScheduleTotal = DaoFormatter.sqlToInt(stmtResult, CutefilonagrDaoDbTableColumn.COL_COUNT_SCHEDULE_TOTAL);
					dataInfo.countScheduleConfirmed = DaoFormatter.sqlToInt(stmtResult, CutefilonagrDaoDbTableColumn.COL_COUNT_SCHEDULE_CONFIRMED);
					dataInfo.countGoods = DaoFormatter.sqlToInt(stmtResult, CutefilonagrDaoDbTableColumn.COL_COUNT_GOODS);
					dataInfo.countService = DaoFormatter.sqlToInt(stmtResult, CutefilonagrDaoDbTableColumn.COL_COUNT_SERVICE);
					dataInfo.countEmployee = DaoFormatter.sqlToInt(stmtResult, CutefilonagrDaoDbTableColumn.COL_COUNT_EMPLOYEE);
					dataInfo.countCustomer = DaoFormatter.sqlToInt(stmtResult, CutefilonagrDaoDbTableColumn.COL_COUNT_CUSTOMER);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, CutefilonagrDaoDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
