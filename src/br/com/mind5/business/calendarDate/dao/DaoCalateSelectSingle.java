package br.com.mind5.business.calendarDate.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoCalateSelectSingle extends DaoStmtTemplate<CalateInfo> {
	private final String MAIN_TABLE = DaoDbTable.CALENDAR_DATE_TABLE;
	
	
	public DaoCalateSelectSingle(Connection conn, CalateInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CalateInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		
		DaoStmtWhere whereClause = new DaoCalateWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<CalateInfo> getResultParserHook() {
		return new DaoResultParser<CalateInfo>() {
			@Override public List<CalateInfo> parseResult(CalateInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CalateInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					CalateInfo dataInfo = new CalateInfo();
					
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, DaoCalateDbTableColumn.COL_DATE);
					dataInfo.year = stmtResult.getInt(DaoCalateDbTableColumn.COL_YEAR);					
					dataInfo.month = stmtResult.getInt(DaoCalateDbTableColumn.COL_MONTH);
					dataInfo.day = stmtResult.getInt(DaoCalateDbTableColumn.COL_DAY);
					dataInfo.codWeekday = stmtResult.getInt(DaoCalateDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.quarter = stmtResult.getInt(DaoCalateDbTableColumn.COL_QUARTER);
					dataInfo.weekYear = stmtResult.getInt(DaoCalateDbTableColumn.COL_WEEK_YEAR);
					dataInfo.isWeekend = stmtResult.getBoolean(DaoCalateDbTableColumn.COL_IS_WEEKEND);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
