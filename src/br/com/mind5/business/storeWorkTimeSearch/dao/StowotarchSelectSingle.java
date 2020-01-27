package br.com.mind5.business.storeWorkTimeSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoJoinStore;
import br.com.mind5.dao.common.DaoOptionValue;

public final class StowotarchSelectSingle extends DaoStmtTemplate<StowotarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_WT_TABLE;		
	
	
	public StowotarchSelectSingle(Connection conn, StowotarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STORE_WTIME_SEARCH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StowotarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StowotarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected List<DaoJoin> getJoinsHook(StowotarchInfo recordInfo) {
		List<DaoJoin> joins = new ArrayList<>();
		
		DaoJoinBuilder joinStore = new DaoJoinStore(MAIN_TABLE);		
		joins.add(joinStore.build());
		
		return joins;
	}
	
	
	
	@Override protected DaoResultParserV2<StowotarchInfo> getResultParserHook() {
		return new DaoResultParserV2<StowotarchInfo>() {		
			@Override public List<StowotarchInfo> parseResult(StowotarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StowotarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StowotarchInfo dataInfo = new StowotarchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(StowotarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(StowotarchDbTableColumn.COL_COD_STORE);
					dataInfo.codWeekday = stmtResult.getInt(StowotarchDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, StowotarchDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, StowotarchDbTableColumn.COL_END_TIME);
					dataInfo.recordMode = stmtResult.getString(StowotarchDbTableColumn.COL_RECORD_MODE);				
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
