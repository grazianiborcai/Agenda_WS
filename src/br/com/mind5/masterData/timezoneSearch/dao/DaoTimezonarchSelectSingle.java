package br.com.mind5.masterData.timezoneSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.timezoneSearch.info.TimezonarchInfo;

public final class DaoTimezonarchSelectSingle extends DaoStmtTemplate<TimezonarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.TIMEZONE_TABLE;
	
	
	public DaoTimezonarchSelectSingle(Connection conn, TimezonarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.TIMEZONE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, TimezonarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new DaoTimezonarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(TimezonarchInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoTimezonarchJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<TimezonarchInfo> getResultParserHook() {
		return new DaoResultParser<TimezonarchInfo>() {
			@Override public List<TimezonarchInfo> parseResult(TimezonarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<TimezonarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					TimezonarchInfo dataInfo = new TimezonarchInfo();
					
					dataInfo.codTimezone = stmtResult.getString(DaoTimezonarchDbTableColumn.COL_COD_TIMEZONE);
					dataInfo.txtTimezone = stmtResult.getString(DaoTimezonarchDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoTimezonarchDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
