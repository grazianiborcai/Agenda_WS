package br.com.mind5.business.calendarWeekYear.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoCaleekySelectSingle extends DaoStmtTemplate<CaleekyInfo> {
	private final String MAIN_TABLE = DaoDbTable.CALENDAR_WEEK_YEAR_TABLE;
	
	
	public DaoCaleekySelectSingle(Connection conn, CaleekyInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CaleekyInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		
		DaoStmtWhere whereClause = new DaoCaleekyWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<CaleekyInfo> getResultParserHook() {
		return new DaoResultParser<CaleekyInfo>() {
			@Override public List<CaleekyInfo> parseResult(CaleekyInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CaleekyInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					CaleekyInfo dataInfo = new CaleekyInfo();
					
					dataInfo.weekYear = stmtResult.getInt(DaoCaleekyDbTableColumn.COL_WEEK_YEAR);
					dataInfo.dateWeekBegin = DaoFormatter.sqlToLocalDate(stmtResult, DaoCaleekyDbTableColumn.COL_DATE_WEEK_BEGIN);
					dataInfo.dateWeekEnd = DaoFormatter.sqlToLocalDate(stmtResult, DaoCaleekyDbTableColumn.COL_DATE_WEEK_END);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
