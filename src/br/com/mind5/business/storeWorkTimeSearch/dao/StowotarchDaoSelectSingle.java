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
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoJoinStore;
import br.com.mind5.dao.common.DaoOptionValue;

public final class StowotarchDaoSelectSingle extends DaoStmtTemplate<StowotarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_WT_TABLE;		
	
	
	public StowotarchDaoSelectSingle(Connection conn, StowotarchInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new StowotarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected List<DaoJoin> getJoinsHook(StowotarchInfo recordInfo) {
		List<DaoJoin> joins = new ArrayList<>();
		
		DaoJoinBuilder joinStore = new DaoJoinStore(MAIN_TABLE);		
		joins.add(joinStore.build());
		
		return joins;
	}
	
	
	
	@Override protected DaoResultParser<StowotarchInfo> getResultParserHook() {
		return new DaoResultParser<StowotarchInfo>() {		
			@Override public List<StowotarchInfo> parseResult(StowotarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StowotarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StowotarchInfo dataInfo = new StowotarchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(StowotarchDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(StowotarchDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codWeekday = stmtResult.getInt(StowotarchDaoDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, StowotarchDaoDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, StowotarchDaoDbTableColumn.COL_END_TIME);
					dataInfo.recordMode = stmtResult.getString(StowotarchDaoDbTableColumn.COL_RECORD_MODE);				
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
