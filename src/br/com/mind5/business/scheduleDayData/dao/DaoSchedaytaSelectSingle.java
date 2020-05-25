package br.com.mind5.business.scheduleDayData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.business.scheduleLineSnapshot.dao.SchedinapDbTableColumn;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoSchedaytaSelectSingle extends DaoStmtTemplate<SchedaytaInfo> {	
	private final String MAIN_TABLE = DaoDbTable.SCHEDULE_TABLE;
	
	
	public DaoSchedaytaSelectSingle(Connection conn, SchedaytaInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.SCHEDULE_DAY_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SchedaytaInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoSchedaytaWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
		
	
	
	@Override protected DaoResultParser<SchedaytaInfo> getResultParserHook() {
		return new DaoResultParser<SchedaytaInfo>() {
			@Override public List<SchedaytaInfo> parseResult(SchedaytaInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {				
				List<SchedaytaInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SchedaytaInfo dataInfo = new SchedaytaInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoSchedaytaDbTableColumn.COL_COD_OWNER);	
					dataInfo.codSchedule = DaoFormatter.sqlToLong(stmtResult, DaoSchedaytaDbTableColumn.COL_COD_SCHEDULE);
					dataInfo.recordMode = stmtResult.getString(DaoSchedaytaDbTableColumn.COL_RECORD_MODE);				
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoSchedaytaDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, DaoSchedaytaDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, DaoSchedaytaDbTableColumn.COL_COD_MATERIAL);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, DaoSchedaytaDbTableColumn.COL_DATE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoSchedaytaDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoSchedaytaDbTableColumn.COL_END_TIME);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoSchedaytaDbTableColumn.COL_COD_USER);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, DaoSchedaytaDbTableColumn.COL_COD_CUSTOMER);			
					dataInfo.day = DaoFormatter.sqlToInt(stmtResult, DaoSchedaytaDbTableColumn.COL_DAY);
					dataInfo.weekMonth = DaoFormatter.sqlToInt(stmtResult, DaoSchedaytaDbTableColumn.COL_WEEK_MONTH);
					dataInfo.weekYear = DaoFormatter.sqlToInt(stmtResult, DaoSchedaytaDbTableColumn.COL_WEEK_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, DaoSchedaytaDbTableColumn.COL_MONTH);
					dataInfo.quarter = DaoFormatter.sqlToInt(stmtResult, DaoSchedaytaDbTableColumn.COL_QUARTER);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, DaoSchedaytaDbTableColumn.COL_YEAR);
					dataInfo.codWeekday = DaoFormatter.sqlToInt(stmtResult, DaoSchedaytaDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.codScheduleStatus = stmtResult.getString(SchedinapDbTableColumn.COL_COD_SCHEDULE_STATUS);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
