package br.com.mind5.stats.statsOwnerStore.ownerStoreLive.dao;

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
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info.SowotiveInfo;

public final class SowotiveDaoSelectSingle extends DaoStmtTemplate<SowotiveInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_OWNER_STORE_MONTH_LIVE_TABLE;	
	
	
	public SowotiveDaoSelectSingle(Connection conn, SowotiveInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SowotiveInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new SowotiveDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SowotiveInfo> getResultParserHook() {
		return new DaoResultParser<SowotiveInfo>() {
			@Override public List<SowotiveInfo> parseResult(SowotiveInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SowotiveInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SowotiveInfo dataInfo = new SowotiveInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, SowotiveDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.calmonth = stmtResult.getString(SowotiveDaoDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, SowotiveDaoDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, SowotiveDaoDbTableColumn.COL_MONTH);
					dataInfo.codCountry = stmtResult.getString(SowotiveDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(SowotiveDaoDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(SowotiveDaoDbTableColumn.COL_CITY);
					dataInfo.countStoreCreatedMonth = DaoFormatter.sqlToInt(stmtResult, SowotiveDaoDbTableColumn.COL_COUNT_STORE_MONTH);					
					dataInfo.countStoreCompletedMonth = DaoFormatter.sqlToInt(stmtResult, SowotiveDaoDbTableColumn.COL_COUNT_STORE_ACCOUNT_COMPLETED_MONTH);
					dataInfo.countStorePendingMonth = DaoFormatter.sqlToInt(stmtResult, SowotiveDaoDbTableColumn.COL_COUNT_STORE_ACCOUNT_PENDING_MONTH);					
					dataInfo.countStoreCreatedLastYear = DaoFormatter.sqlToInt(stmtResult, SowotiveDaoDbTableColumn.COL_COUNT_STORE_MONTH_LAST_YEAR);					
					dataInfo.countStoreCompletedLastYear = DaoFormatter.sqlToInt(stmtResult, SowotiveDaoDbTableColumn.COL_COUNT_STORE_ACCOUNT_COMPLETED_MONTH_LAST_YEAR);
					dataInfo.countStorePendingLastYear = DaoFormatter.sqlToInt(stmtResult, SowotiveDaoDbTableColumn.COL_COUNT_STORE_ACCOUNT_PENDING_MONTH_LAST_YEAR);					
					dataInfo.countStoreCreatedVar = DaoFormatter.sqlToDouble(stmtResult, SowotiveDaoDbTableColumn.COL_COUNT_STORE_VAR);					
					dataInfo.countStoreCompletedVar = DaoFormatter.sqlToDouble(stmtResult, SowotiveDaoDbTableColumn.COL_COUNT_STORE_ACCOUNT_COMPLETED_VAR);
					dataInfo.countStorePendingVar = DaoFormatter.sqlToDouble(stmtResult, SowotiveDaoDbTableColumn.COL_COUNT_STORE_ACCOUNT_PENDING_VAR);	
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
