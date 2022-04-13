package br.com.mind5.business.storeLunchTimeSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLunchTimeSearch.info.StuntmarchInfo;
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

public final class StuntmarchDaoSelectSingle extends DaoStmtTemplate<StuntmarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_LT_TABLE;		
	
	
	public StuntmarchDaoSelectSingle(Connection conn, StuntmarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STORE_LTIME_SEARCH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StuntmarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StuntmarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected List<DaoJoin> getJoinsHook(StuntmarchInfo recordInfo) {
		List<DaoJoin> joins = new ArrayList<>();
		
		DaoJoinBuilder joinStore = new DaoJoinStore(MAIN_TABLE);		
		joins.add(joinStore.build());
		
		return joins;
	}
	
	
	
	@Override protected DaoResultParser<StuntmarchInfo> getResultParserHook() {
		return new DaoResultParser<StuntmarchInfo>() {		
			@Override public List<StuntmarchInfo> parseResult(StuntmarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StuntmarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StuntmarchInfo dataInfo = new StuntmarchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(StuntmarchDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(StuntmarchDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codWeekday = stmtResult.getInt(StuntmarchDaoDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, StuntmarchDaoDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, StuntmarchDaoDbTableColumn.COL_END_TIME);
					dataInfo.recordMode = stmtResult.getString(StuntmarchDaoDbTableColumn.COL_RECORD_MODE);				
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
