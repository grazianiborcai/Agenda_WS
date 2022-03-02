package br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.dao;

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
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.info.SowusarchInfo;

public final class SowusarchDaoSelectSingle extends DaoStmtTemplate<SowusarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_OWNER_USER_MONTH_TABLE;
	
	
	public SowusarchDaoSelectSingle(Connection conn, SowusarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STAT_OWNER_USER_MONTH_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SowusarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new SowusarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SowusarchInfo> getResultParserHook() {
		return new DaoResultParser<SowusarchInfo>() {
			@Override public List<SowusarchInfo> parseResult(SowusarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SowusarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SowusarchInfo dataInfo = new SowusarchInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, SowusarchDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.calmonth = stmtResult.getString(SowusarchDaoDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, SowusarchDaoDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, SowusarchDaoDbTableColumn.COL_MONTH);
					dataInfo.codCountry = stmtResult.getString(SowusarchDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(SowusarchDaoDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(SowusarchDaoDbTableColumn.COL_CITY);
					dataInfo.countUserCreatedMonth = DaoFormatter.sqlToInt(stmtResult, SowusarchDaoDbTableColumn.COL_COUNT_USER_CREATION_MONTH);
					dataInfo.countUserCreatedLastYear = DaoFormatter.sqlToInt(stmtResult, SowusarchDaoDbTableColumn.COL_COUNT_USER_CREATION_MONTH_LAST_YEAR);
					dataInfo.countUserActiveMonth = DaoFormatter.sqlToInt(stmtResult, SowusarchDaoDbTableColumn.COL_COUNT_USER_ACTIVE_MONTH);
					dataInfo.countUserActiveLastYear = DaoFormatter.sqlToInt(stmtResult, SowusarchDaoDbTableColumn.COL_COUNT_USER_ACTIVE_MONTH_LAST_YEAR);
					dataInfo.countUserInactiveMonth = DaoFormatter.sqlToInt(stmtResult, SowusarchDaoDbTableColumn.COL_COUNT_USER_INACTIVE_MONTH);
					dataInfo.countUserInactiveLastYear = DaoFormatter.sqlToInt(stmtResult, SowusarchDaoDbTableColumn.COL_COUNT_USER_INACTIVE_MONTH_LAST_YEAR);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, SowusarchDaoDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
