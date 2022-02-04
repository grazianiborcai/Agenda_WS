package br.com.mind5.stats.statsUserAccount.userAccountLive.dao;

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
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.UseraciveInfo;

public final class DaoUseraciveSelectSingle extends DaoStmtTemplate<UseraciveInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_USER_ACCOUNT_LIVE_TABLE;	
	
	
	public DaoUseraciveSelectSingle(Connection conn, UseraciveInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, UseraciveInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoUseraciveWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<UseraciveInfo> getResultParserHook() {
		return new DaoResultParser<UseraciveInfo>() {
			@Override public List<UseraciveInfo> parseResult(UseraciveInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<UseraciveInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					UseraciveInfo dataInfo = new UseraciveInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoUseraciveDbTableColumn.COL_COD_OWNER);
					dataInfo.calmonth = stmtResult.getString(DaoUseraciveDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, DaoUseraciveDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, DaoUseraciveDbTableColumn.COL_MONTH);
					dataInfo.codCountry = stmtResult.getString(DaoUseraciveDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(DaoUseraciveDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(DaoUseraciveDbTableColumn.COL_CITY);
					dataInfo.countUserCreatedCumulative = DaoFormatter.sqlToInt(stmtResult, DaoUseraciveDbTableColumn.COL_COUNT_USER_CREATION_CUMULATIVE);
					dataInfo.countUserCreatedMonth = DaoFormatter.sqlToInt(stmtResult, DaoUseraciveDbTableColumn.COL_COUNT_USER_CREATION_MONTH);
					dataInfo.countUserCreatedMonthLastYear = DaoFormatter.sqlToInt(stmtResult, DaoUseraciveDbTableColumn.COL_COUNT_USER_CREATION_MONTH_LAST_YEAR);
					dataInfo.countUserCreatedVar = DaoFormatter.sqlToDouble(stmtResult, DaoUseraciveDbTableColumn.COL_COUNT_USER_CREATION_VAR);					
					dataInfo.countUserActiveCumulative = DaoFormatter.sqlToInt(stmtResult, DaoUseraciveDbTableColumn.COL_COUNT_USER_ACTIVE_CUMULATIVE);
					dataInfo.countUserActiveMonth = DaoFormatter.sqlToInt(stmtResult, DaoUseraciveDbTableColumn.COL_COUNT_USER_ACTIVE_MONTH);
					dataInfo.countUserActiveMonthLastYear = DaoFormatter.sqlToInt(stmtResult, DaoUseraciveDbTableColumn.COL_COUNT_USER_ACTIVE_MONTH_LAST_YEAR);
					dataInfo.countUserActiveVar = DaoFormatter.sqlToDouble(stmtResult, DaoUseraciveDbTableColumn.COL_COUNT_USER_ACTIVE_VAR);					
					dataInfo.countUserInactiveCumulative = DaoFormatter.sqlToInt(stmtResult, DaoUseraciveDbTableColumn.COL_COUNT_USER_INACTIVE_CUMULATIVE);
					dataInfo.countUserInactiveMonth = DaoFormatter.sqlToInt(stmtResult, DaoUseraciveDbTableColumn.COL_COUNT_USER_INACTIVE_MONTH);
					dataInfo.countUserInactiveMonthLastYear = DaoFormatter.sqlToInt(stmtResult, DaoUseraciveDbTableColumn.COL_COUNT_USER_INACTIVE_MONTH_LAST_YEAR);
					dataInfo.countUserInactiveVar = DaoFormatter.sqlToDouble(stmtResult, DaoUseraciveDbTableColumn.COL_COUNT_USER_INACTIVE_VAR);					
					dataInfo.countOrderCumulative = DaoFormatter.sqlToInt(stmtResult, DaoUseraciveDbTableColumn.COL_COUNT_ORDER_TOTAL_CUMULATIVE);
					dataInfo.countOrderMonth = DaoFormatter.sqlToInt(stmtResult, DaoUseraciveDbTableColumn.COL_COUNT_ORDER_TOTAL_MONTH);
					dataInfo.countOrderMonthLastYear = DaoFormatter.sqlToInt(stmtResult, DaoUseraciveDbTableColumn.COL_COUNT_ORDER_TOTAL_MONTH_LAST_YEAR);
					dataInfo.countOrderVar = DaoFormatter.sqlToDouble(stmtResult, DaoUseraciveDbTableColumn.COL_COUNT_ORDER_TOTAL_VAR);					
					dataInfo.userEngagementCumulative = DaoFormatter.sqlToInt(stmtResult, DaoUseraciveDbTableColumn.COL_COUNT_USER_ENGAGEMENT_CUMULATIVE);
					dataInfo.userEngagementMonth = DaoFormatter.sqlToInt(stmtResult, DaoUseraciveDbTableColumn.COL_COUNT_USER_ENGAGEMENT_MONTH);
					dataInfo.userEngagementMonthLastYear = DaoFormatter.sqlToInt(stmtResult, DaoUseraciveDbTableColumn.COL_COUNT_USER_ENGAGEMENT_MONTH_LAST_YEAR);
					dataInfo.userEngagementVar = DaoFormatter.sqlToDouble(stmtResult, DaoUseraciveDbTableColumn.COL_COUNT_USER_ENGAGEMENT_MONTH_VAR);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
