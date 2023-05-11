package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.dao;

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
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;

public final class SowotagrDaoSelectSingle extends DaoStmtTemplate<SowotagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_OWNER_STORE_MONTH_TABLE;
	
	
	public SowotagrDaoSelectSingle(Connection conn, SowotagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SowotagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull       = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new SowotagrDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SowotagrInfo> getResultParserHook() {
		return new DaoResultParser<SowotagrInfo>() {
			@Override public List<SowotagrInfo> parseResult(SowotagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SowotagrInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SowotagrInfo dataInfo = new SowotagrInfo();
					
					dataInfo.city                        = stmtResult.getString(SowotagrDaoDbTableColumn.COL_CITY);
					dataInfo.year                        = DaoFormatter.sqlToInt(stmtResult, SowotagrDaoDbTableColumn.COL_YEAR);
					dataInfo.month                       = DaoFormatter.sqlToInt(stmtResult, SowotagrDaoDbTableColumn.COL_MONTH);
					dataInfo.codOwner                    = DaoFormatter.sqlToLong(stmtResult, SowotagrDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.calmonth                    = stmtResult.getString(SowotagrDaoDbTableColumn.COL_CALMONTH);
					dataInfo.codState                    = stmtResult.getString(SowotagrDaoDbTableColumn.COL_STATE_PROVINCE);					
					dataInfo.codCountry                  = stmtResult.getString(SowotagrDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.lastChanged                 = DaoFormatter.sqlToLocalDateTime(stmtResult, SowotagrDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.countStoreTotalMonth        = DaoFormatter.sqlToInt(stmtResult, SowotagrDaoDbTableColumn.COL_COUNT_STORE_MONTH);
					dataInfo.countStorePendingMonth      = DaoFormatter.sqlToInt(stmtResult, SowotagrDaoDbTableColumn.COL_COUNT_STORE_ACCOUNT_PENDING_MONTH);
					dataInfo.countStoreCreatedMonth      = DaoFormatter.sqlToInt(stmtResult, SowotagrDaoDbTableColumn.COL_COUNT_STORE_CREATED_MONTH);
					dataInfo.countStoreTotalLastYear     = DaoFormatter.sqlToInt(stmtResult, SowotagrDaoDbTableColumn.COL_COUNT_STORE_MONTH_LAST_YEAR);
					dataInfo.countStoreCompletedMonth    = DaoFormatter.sqlToInt(stmtResult, SowotagrDaoDbTableColumn.COL_COUNT_STORE_ACCOUNT_COMPLETED_MONTH);
					dataInfo.countStorePendingLastYear   = DaoFormatter.sqlToInt(stmtResult, SowotagrDaoDbTableColumn.COL_COUNT_STORE_ACCOUNT_PENDING_MONTH_LAST_YEAR);
					dataInfo.countStoreCreatedLastYear   = DaoFormatter.sqlToInt(stmtResult, SowotagrDaoDbTableColumn.COL_COUNT_STORE_CREATED_MONTH_LAST_YEAR);
					dataInfo.countStoreCompletedLastYear = DaoFormatter.sqlToInt(stmtResult, SowotagrDaoDbTableColumn.COL_COUNT_STORE_ACCOUNT_COMPLETED_MONTH_LAST_YEAR);
										
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
