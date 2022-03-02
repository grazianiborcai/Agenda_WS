package br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.dao;

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
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.info.SowusiveInfo;

public final class SowusiveDaoSelectSingle extends DaoStmtTemplate<SowusiveInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_OWNER_USER_MONTH_LIVE_TABLE;	
	
	
	public SowusiveDaoSelectSingle(Connection conn, SowusiveInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new SowusiveDaoWhere(whereOption, tableName, recordInfo);
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
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, SowusiveDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.calmonth = stmtResult.getString(SowusiveDaoDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, SowusiveDaoDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, SowusiveDaoDbTableColumn.COL_MONTH);
					dataInfo.codCountry = stmtResult.getString(SowusiveDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(SowusiveDaoDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(SowusiveDaoDbTableColumn.COL_CITY);
					dataInfo.countUserCreatedMonth = DaoFormatter.sqlToInt(stmtResult, SowusiveDaoDbTableColumn.COL_COUNT_USER_CREATION_MONTH);
					dataInfo.countUserCreatedLastYear = DaoFormatter.sqlToInt(stmtResult, SowusiveDaoDbTableColumn.COL_COUNT_USER_CREATION_MONTH_LAST_YEAR);
					dataInfo.countUserActiveMonth = DaoFormatter.sqlToInt(stmtResult, SowusiveDaoDbTableColumn.COL_COUNT_USER_ACTIVE_MONTH);
					dataInfo.countUserActiveLastYear = DaoFormatter.sqlToInt(stmtResult, SowusiveDaoDbTableColumn.COL_COUNT_USER_ACTIVE_MONTH_LAST_YEAR);
					dataInfo.countUserInactiveMonth = DaoFormatter.sqlToInt(stmtResult, SowusiveDaoDbTableColumn.COL_COUNT_USER_INACTIVE_MONTH);
					dataInfo.countUserInactiveLastYear = DaoFormatter.sqlToInt(stmtResult, SowusiveDaoDbTableColumn.COL_COUNT_USER_INACTIVE_MONTH_LAST_YEAR);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
