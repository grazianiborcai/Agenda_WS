package br.com.mind5.stats.statsStoreAccount.storeAccountLive.dao;

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
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveInfo;

public final class DaoStoraciveSelectSingle extends DaoStmtTemplate<StoraciveInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_ACCOUNT_DASH_LIVE_TABLE;	
	
	
	public DaoStoraciveSelectSingle(Connection conn, StoraciveInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StoraciveInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoStoraciveWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StoraciveInfo> getResultParserHook() {
		return new DaoResultParser<StoraciveInfo>() {
			@Override public List<StoraciveInfo> parseResult(StoraciveInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StoraciveInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StoraciveInfo dataInfo = new StoraciveInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoStoraciveDbTableColumn.COL_COD_OWNER);
					dataInfo.calmonth = stmtResult.getString(DaoStoraciveDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, DaoStoraciveDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, DaoStoraciveDbTableColumn.COL_MONTH);
					dataInfo.codCountry = stmtResult.getString(DaoStoraciveDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(DaoStoraciveDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(DaoStoraciveDbTableColumn.COL_CITY);
					dataInfo.countStoreCreatedMonth = DaoFormatter.sqlToInt(stmtResult, DaoStoraciveDbTableColumn.COL_COUNT_STORE_MONTH);					
					dataInfo.countStoreCompletedMonth = DaoFormatter.sqlToInt(stmtResult, DaoStoraciveDbTableColumn.COL_COUNT_STORE_ACCOUNT_COMPLETED_MONTH);
					dataInfo.countStorePendingMonth = DaoFormatter.sqlToInt(stmtResult, DaoStoraciveDbTableColumn.COL_COUNT_STORE_ACCOUNT_PENDING_MONTH);					
					dataInfo.countStoreCreatedMonthLastYear = DaoFormatter.sqlToInt(stmtResult, DaoStoraciveDbTableColumn.COL_COUNT_STORE_MONTH_LAST_YEAR);					
					dataInfo.countStoreCompletedMonthLastYear = DaoFormatter.sqlToInt(stmtResult, DaoStoraciveDbTableColumn.COL_COUNT_STORE_ACCOUNT_COMPLETED_MONTH_LAST_YEAR);
					dataInfo.countStorePendingMonthLastYear = DaoFormatter.sqlToInt(stmtResult, DaoStoraciveDbTableColumn.COL_COUNT_STORE_ACCOUNT_PENDING_MONTH_LAST_YEAR);					
					dataInfo.countStoreCreatedVar = DaoFormatter.sqlToDouble(stmtResult, DaoStoraciveDbTableColumn.COL_COUNT_STORE_VAR);					
					dataInfo.countStoreCompletedVar = DaoFormatter.sqlToDouble(stmtResult, DaoStoraciveDbTableColumn.COL_COUNT_STORE_ACCOUNT_COMPLETED_VAR);
					dataInfo.countStorePendingVar = DaoFormatter.sqlToDouble(stmtResult, DaoStoraciveDbTableColumn.COL_COUNT_STORE_ACCOUNT_PENDING_VAR);					
					dataInfo.countStoreCreatedCumulative = DaoFormatter.sqlToInt(stmtResult, DaoStoraciveDbTableColumn.COL_COUNT_STORE_CUMULATIVE);					
					dataInfo.countStoreCompletedCumulative = DaoFormatter.sqlToInt(stmtResult, DaoStoraciveDbTableColumn.COL_COUNT_STORE_ACCOUNT_COMPLETED_CUMULATIVE);
					dataInfo.countStorePendingCumulative = DaoFormatter.sqlToInt(stmtResult, DaoStoraciveDbTableColumn.COL_COUNT_STORE_ACCOUNT_PENDING_CUMULATIVE);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
