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
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.SuseraciveInfo;

public final class DaoSuseraciveSelectSingle extends DaoStmtTemplate<SuseraciveInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_USER_ACCOUNT_LIVE_TABLE;	
	
	
	public DaoSuseraciveSelectSingle(Connection conn, SuseraciveInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SuseraciveInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoSuseraciveWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SuseraciveInfo> getResultParserHook() {
		return new DaoResultParser<SuseraciveInfo>() {
			@Override public List<SuseraciveInfo> parseResult(SuseraciveInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SuseraciveInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SuseraciveInfo dataInfo = new SuseraciveInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoSuseraciveDbTableColumn.COL_COD_OWNER);
					dataInfo.calmonth = stmtResult.getString(DaoSuseraciveDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, DaoSuseraciveDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, DaoSuseraciveDbTableColumn.COL_MONTH);
					dataInfo.codCountry = stmtResult.getString(DaoSuseraciveDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(DaoSuseraciveDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(DaoSuseraciveDbTableColumn.COL_CITY);
					dataInfo.countUserCreatedCumulative = DaoFormatter.sqlToInt(stmtResult, DaoSuseraciveDbTableColumn.COL_COUNT_USER_CREATION_CUMULATIVE);
					dataInfo.countUserCreatedMonth = DaoFormatter.sqlToInt(stmtResult, DaoSuseraciveDbTableColumn.COL_COUNT_USER_CREATION_MONTH);
					dataInfo.countUserCreatedMonthLastYear = DaoFormatter.sqlToInt(stmtResult, DaoSuseraciveDbTableColumn.COL_COUNT_USER_CREATION_MONTH_LAST_YEAR);
					dataInfo.countUserCreatedVar = DaoFormatter.sqlToDouble(stmtResult, DaoSuseraciveDbTableColumn.COL_COUNT_USER_CREATION_VAR);					
					dataInfo.countUserActiveCumulative = DaoFormatter.sqlToInt(stmtResult, DaoSuseraciveDbTableColumn.COL_COUNT_USER_ACTIVE_CUMULATIVE);
					dataInfo.countUserActiveMonth = DaoFormatter.sqlToInt(stmtResult, DaoSuseraciveDbTableColumn.COL_COUNT_USER_ACTIVE_MONTH);
					dataInfo.countUserActiveMonthLastYear = DaoFormatter.sqlToInt(stmtResult, DaoSuseraciveDbTableColumn.COL_COUNT_USER_ACTIVE_MONTH_LAST_YEAR);
					dataInfo.countUserActiveVar = DaoFormatter.sqlToDouble(stmtResult, DaoSuseraciveDbTableColumn.COL_COUNT_USER_ACTIVE_VAR);					
					dataInfo.countUserInactiveCumulative = DaoFormatter.sqlToInt(stmtResult, DaoSuseraciveDbTableColumn.COL_COUNT_USER_INACTIVE_CUMULATIVE);
					dataInfo.countUserInactiveMonth = DaoFormatter.sqlToInt(stmtResult, DaoSuseraciveDbTableColumn.COL_COUNT_USER_INACTIVE_MONTH);
					dataInfo.countUserInactiveMonthLastYear = DaoFormatter.sqlToInt(stmtResult, DaoSuseraciveDbTableColumn.COL_COUNT_USER_INACTIVE_MONTH_LAST_YEAR);
					dataInfo.countUserInactiveVar = DaoFormatter.sqlToDouble(stmtResult, DaoSuseraciveDbTableColumn.COL_COUNT_USER_INACTIVE_VAR);					
					dataInfo.countOrderCumulative = DaoFormatter.sqlToInt(stmtResult, DaoSuseraciveDbTableColumn.COL_COUNT_ORDER_TOTAL_CUMULATIVE);
					dataInfo.countOrderMonth = DaoFormatter.sqlToInt(stmtResult, DaoSuseraciveDbTableColumn.COL_COUNT_ORDER_TOTAL_MONTH);
					dataInfo.countOrderMonthLastYear = DaoFormatter.sqlToInt(stmtResult, DaoSuseraciveDbTableColumn.COL_COUNT_ORDER_TOTAL_MONTH_LAST_YEAR);
					dataInfo.countOrderVar = DaoFormatter.sqlToDouble(stmtResult, DaoSuseraciveDbTableColumn.COL_COUNT_ORDER_TOTAL_VAR);					
					dataInfo.userEngagementCumulative = DaoFormatter.sqlToInt(stmtResult, DaoSuseraciveDbTableColumn.COL_COUNT_USER_ENGAGEMENT_CUMULATIVE);
					dataInfo.userEngagementMonth = DaoFormatter.sqlToInt(stmtResult, DaoSuseraciveDbTableColumn.COL_COUNT_USER_ENGAGEMENT_MONTH);
					dataInfo.userEngagementMonthLastYear = DaoFormatter.sqlToInt(stmtResult, DaoSuseraciveDbTableColumn.COL_COUNT_USER_ENGAGEMENT_MONTH_LAST_YEAR);
					dataInfo.userEngagementVar = DaoFormatter.sqlToDouble(stmtResult, DaoSuseraciveDbTableColumn.COL_COUNT_USER_ENGAGEMENT_MONTH_VAR);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
