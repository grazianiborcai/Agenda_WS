package br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.dao;

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
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrInfo;

public final class SowusagrDaoSelectSingle extends DaoStmtTemplate<SowusagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_OWNER_USER_MONTH_TABLE;
	
	
	public SowusagrDaoSelectSingle(Connection conn, SowusagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SowusagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new SowusagrDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SowusagrInfo> getResultParserHook() {
		return new DaoResultParser<SowusagrInfo>() {
			@Override public List<SowusagrInfo> parseResult(SowusagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SowusagrInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SowusagrInfo dataInfo = new SowusagrInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, SowusagrDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.calmonth = stmtResult.getString(SowusagrDaoDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, SowusagrDaoDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, SowusagrDaoDbTableColumn.COL_MONTH);
					dataInfo.codCountry = stmtResult.getString(SowusagrDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(SowusagrDaoDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(SowusagrDaoDbTableColumn.COL_CITY);
					dataInfo.countUserCreatedMonth = DaoFormatter.sqlToInt(stmtResult, SowusagrDaoDbTableColumn.COL_COUNT_USER_CREATION_MONTH);
					dataInfo.countUserCreatedLastYear = DaoFormatter.sqlToInt(stmtResult, SowusagrDaoDbTableColumn.COL_COUNT_USER_CREATION_MONTH_LAST_YEAR);
					dataInfo.countUserActiveMonth = DaoFormatter.sqlToInt(stmtResult, SowusagrDaoDbTableColumn.COL_COUNT_USER_ACTIVE_MONTH);
					dataInfo.countUserActiveLastYear = DaoFormatter.sqlToInt(stmtResult, SowusagrDaoDbTableColumn.COL_COUNT_USER_ACTIVE_MONTH_LAST_YEAR);
					dataInfo.countUserInactiveMonth = DaoFormatter.sqlToInt(stmtResult, SowusagrDaoDbTableColumn.COL_COUNT_USER_INACTIVE_MONTH);
					dataInfo.countUserInactiveLastYear = DaoFormatter.sqlToInt(stmtResult, SowusagrDaoDbTableColumn.COL_COUNT_USER_INACTIVE_MONTH_LAST_YEAR);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, SowusagrDaoDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
