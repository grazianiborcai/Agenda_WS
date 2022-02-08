package br.com.mind5.stats.statsOwnerUser.ownerUserLive.dao;

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
import br.com.mind5.stats.statsOwnerUser.ownerUserLive.info.SowusiveInfo;

public final class DaoSowusiveSelectSingle extends DaoStmtTemplate<SowusiveInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_USER_ACCOUNT_DASH_LIVE_TABLE;	
	
	
	public DaoSowusiveSelectSingle(Connection conn, SowusiveInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SowusiveInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoSowusiveWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SowusiveInfo> getResultParserHook() {
		return new DaoResultParser<SowusiveInfo>() {
			@Override public List<SowusiveInfo> parseResult(SowusiveInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SowusiveInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SowusiveInfo dataInfo = new SowusiveInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoSowusiveDbTableColumn.COL_COD_OWNER);
					dataInfo.calmonth = stmtResult.getString(DaoSowusiveDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, DaoSowusiveDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, DaoSowusiveDbTableColumn.COL_MONTH);
					dataInfo.codCountry = stmtResult.getString(DaoSowusiveDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(DaoSowusiveDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(DaoSowusiveDbTableColumn.COL_CITY);
					dataInfo.countUserCreatedMonth = DaoFormatter.sqlToInt(stmtResult, DaoSowusiveDbTableColumn.COL_COUNT_USER_CREATION_MONTH);
					dataInfo.countUserCreatedMonthLastYear = DaoFormatter.sqlToInt(stmtResult, DaoSowusiveDbTableColumn.COL_COUNT_USER_CREATION_MONTH_LAST_YEAR);
					dataInfo.countUserCreatedVar = DaoFormatter.sqlToDouble(stmtResult, DaoSowusiveDbTableColumn.COL_COUNT_USER_CREATION_VAR);
					dataInfo.countUserActiveMonth = DaoFormatter.sqlToInt(stmtResult, DaoSowusiveDbTableColumn.COL_COUNT_USER_ACTIVE_MONTH);
					dataInfo.countUserActiveMonthLastYear = DaoFormatter.sqlToInt(stmtResult, DaoSowusiveDbTableColumn.COL_COUNT_USER_ACTIVE_MONTH_LAST_YEAR);
					dataInfo.countUserActiveVar = DaoFormatter.sqlToDouble(stmtResult, DaoSowusiveDbTableColumn.COL_COUNT_USER_ACTIVE_VAR);
					dataInfo.countUserInactiveMonth = DaoFormatter.sqlToInt(stmtResult, DaoSowusiveDbTableColumn.COL_COUNT_USER_INACTIVE_MONTH);
					dataInfo.countUserInactiveMonthLastYear = DaoFormatter.sqlToInt(stmtResult, DaoSowusiveDbTableColumn.COL_COUNT_USER_INACTIVE_MONTH_LAST_YEAR);
					dataInfo.countUserInactiveVar = DaoFormatter.sqlToDouble(stmtResult, DaoSowusiveDbTableColumn.COL_COUNT_USER_INACTIVE_VAR);
					dataInfo.countOrderMonth = DaoFormatter.sqlToInt(stmtResult, DaoSowusiveDbTableColumn.COL_COUNT_ORDER_TOTAL_MONTH);
					dataInfo.countOrderMonthLastYear = DaoFormatter.sqlToInt(stmtResult, DaoSowusiveDbTableColumn.COL_COUNT_ORDER_TOTAL_MONTH_LAST_YEAR);
					dataInfo.countOrderVar = DaoFormatter.sqlToDouble(stmtResult, DaoSowusiveDbTableColumn.COL_COUNT_ORDER_TOTAL_VAR);
					dataInfo.userEngagementMonth = DaoFormatter.sqlToInt(stmtResult, DaoSowusiveDbTableColumn.COL_COUNT_USER_ENGAGEMENT_MONTH);
					dataInfo.userEngagementMonthLastYear = DaoFormatter.sqlToInt(stmtResult, DaoSowusiveDbTableColumn.COL_COUNT_USER_ENGAGEMENT_MONTH_LAST_YEAR);
					dataInfo.userEngagementVar = DaoFormatter.sqlToDouble(stmtResult, DaoSowusiveDbTableColumn.COL_COUNT_USER_ENGAGEMENT_MONTH_VAR);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
