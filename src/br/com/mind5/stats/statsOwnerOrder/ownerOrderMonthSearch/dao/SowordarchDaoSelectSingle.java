package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.dao;

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
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info.SowordarchInfo;

public final class SowordarchDaoSelectSingle extends DaoStmtTemplate<SowordarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_OWNER_ORDER_MONTH_TABLE;
	
	
	public SowordarchDaoSelectSingle(Connection conn, SowordarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STAT_OWNER_ORDER_MONTH_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SowordarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new SowordarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SowordarchInfo> getResultParserHook() {
		return new DaoResultParser<SowordarchInfo>() {
			@Override public List<SowordarchInfo> parseResult(SowordarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SowordarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SowordarchInfo dataInfo = new SowordarchInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, SowordarchDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.calmonth = stmtResult.getString(SowordarchDaoDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, SowordarchDaoDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, SowordarchDaoDbTableColumn.COL_MONTH);
					dataInfo.codCountry = stmtResult.getString(SowordarchDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(SowordarchDaoDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(SowordarchDaoDbTableColumn.COL_CITY);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
