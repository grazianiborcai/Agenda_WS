package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.dao;

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
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthSearch.info.SowotarchInfo;

public final class SowotarchDaoSelectSingle extends DaoStmtTemplate<SowotarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_OWNER_STORE_MONTH_TABLE;
	
	
	public SowotarchDaoSelectSingle(Connection conn, SowotarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STAT_OWNER_STORE_MONTH_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SowotarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new SowotarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SowotarchInfo> getResultParserHook() {
		return new DaoResultParser<SowotarchInfo>() {
			@Override public List<SowotarchInfo> parseResult(SowotarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SowotarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SowotarchInfo dataInfo = new SowotarchInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, SowotarchDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.calmonth = stmtResult.getString(SowotarchDaoDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, SowotarchDaoDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, SowotarchDaoDbTableColumn.COL_MONTH);
					dataInfo.codCountry = stmtResult.getString(SowotarchDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(SowotarchDaoDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(SowotarchDaoDbTableColumn.COL_CITY);
					dataInfo.countStoreCreatedMonth = DaoFormatter.sqlToInt(stmtResult, SowotarchDaoDbTableColumn.COL_COUNT_STORE_CREATED_MONTH);
					dataInfo.countStoreCreatedLastYear = DaoFormatter.sqlToInt(stmtResult, SowotarchDaoDbTableColumn.COL_COUNT_STORE_CREATED_MONTH_LAST_YEAR);					
					dataInfo.countStoreTotalMonth = DaoFormatter.sqlToInt(stmtResult, SowotarchDaoDbTableColumn.COL_COUNT_STORE_MONTH);
					dataInfo.countStoreTotalLastYear = DaoFormatter.sqlToInt(stmtResult, SowotarchDaoDbTableColumn.COL_COUNT_STORE_MONTH_LAST_YEAR);					
					dataInfo.countStoreCompletedMonth = DaoFormatter.sqlToInt(stmtResult, SowotarchDaoDbTableColumn.COL_COUNT_STORE_ACCOUNT_COMPLETED_MONTH);
					dataInfo.countStoreCompletedLastYear = DaoFormatter.sqlToInt(stmtResult, SowotarchDaoDbTableColumn.COL_COUNT_STORE_ACCOUNT_COMPLETED_MONTH_LAST_YEAR);					
					dataInfo.countStorePendingMonth = DaoFormatter.sqlToInt(stmtResult, SowotarchDaoDbTableColumn.COL_COUNT_STORE_ACCOUNT_PENDING_MONTH);
					dataInfo.countStorePendingLastYear = DaoFormatter.sqlToInt(stmtResult, SowotarchDaoDbTableColumn.COL_COUNT_STORE_ACCOUNT_PENDING_MONTH_LAST_YEAR);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, SowotarchDaoDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
