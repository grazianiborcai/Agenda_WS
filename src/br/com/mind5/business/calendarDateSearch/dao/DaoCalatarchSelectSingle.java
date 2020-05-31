package br.com.mind5.business.calendarDateSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoCalatarchSelectSingle extends DaoStmtTemplate<CalatarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.CALENDAR_DATE_TABLE;
	
	
	public DaoCalatarchSelectSingle(Connection conn, CalatarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.CALENDAR_DATE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CalatarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		
		DaoStmtWhere whereClause = new DaoCalatarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<CalatarchInfo> getResultParserHook() {
		return new DaoResultParser<CalatarchInfo>() {
			@Override public List<CalatarchInfo> parseResult(CalatarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CalatarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					CalatarchInfo dataInfo = new CalatarchInfo();
					
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, DaoCalatarchDbTableColumn.COL_DATE);
					dataInfo.year = stmtResult.getInt(DaoCalatarchDbTableColumn.COL_YEAR);					
					dataInfo.month = stmtResult.getInt(DaoCalatarchDbTableColumn.COL_MONTH);
					dataInfo.day = stmtResult.getInt(DaoCalatarchDbTableColumn.COL_DAY);
					dataInfo.codWeekday = stmtResult.getInt(DaoCalatarchDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.quarter = stmtResult.getInt(DaoCalatarchDbTableColumn.COL_QUARTER);
					dataInfo.weekYear = stmtResult.getInt(DaoCalatarchDbTableColumn.COL_WEEK_YEAR);
					dataInfo.weekMonth = stmtResult.getInt(DaoCalatarchDbTableColumn.COL_WEEK_MONTH);
					dataInfo.isWeekend = stmtResult.getBoolean(DaoCalatarchDbTableColumn.COL_IS_WEEKEND);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
