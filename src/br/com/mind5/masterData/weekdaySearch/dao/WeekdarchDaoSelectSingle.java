package br.com.mind5.masterData.weekdaySearch.dao;

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
import br.com.mind5.masterData.weekdaySearch.info.WeekdarchInfo;

public final class WeekdarchDaoSelectSingle extends DaoStmtTemplate<WeekdarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.WEEKDAY_TABLE;
	
	
	public WeekdarchDaoSelectSingle(Connection conn, WeekdarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.WEEKDAY_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, WeekdarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new WeekdarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(WeekdarchInfo recordInfo) {
		DaoJoinBuilder joinText = new WeekdarchDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<WeekdarchInfo> getResultParserHook() {
		return new DaoResultParser<WeekdarchInfo>() {
			@Override public List<WeekdarchInfo> parseResult(WeekdarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<WeekdarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					WeekdarchInfo dataInfo = new WeekdarchInfo();
					
					dataInfo.codWeekday = stmtResult.getInt(WeekdarchDaoDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.sortSaturday = stmtResult.getInt(WeekdarchDaoDbTableColumn.COL_SORT_SATURDAY);
					dataInfo.sortSunday = stmtResult.getInt(WeekdarchDaoDbTableColumn.COL_SORT_SUNDAY);
					dataInfo.txtWeekday = stmtResult.getString(WeekdarchDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(WeekdarchDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
