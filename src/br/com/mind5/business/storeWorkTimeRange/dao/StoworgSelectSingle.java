package br.com.mind5.business.storeWorkTimeRange.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class StoworgSelectSingle extends DaoStmtTemplate<StoworgInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_WT_TABLE;
	
	
	public StoworgSelectSingle(Connection conn, StoworgInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}	
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STORE_WTIME_RANGE_VIEW;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StoworgInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StoworgWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<StoworgInfo> getResultParserHook() {
		return new DaoResultParser<StoworgInfo>() {
			@Override public List<StoworgInfo> parseResult(StoworgInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StoworgInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StoworgInfo dataInfo = new StoworgInfo();
					
					dataInfo.codOwner = stmtResult.getLong(StoworgDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(StoworgDbTableColumn.COL_COD_STORE);
					dataInfo.codWeekday = stmtResult.getInt(StoworgDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.recordMode = stmtResult.getString(StoworgDbTableColumn.COL_RECORD_MODE);	
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, StoworgDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, StoworgDbTableColumn.COL_END_TIME);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
