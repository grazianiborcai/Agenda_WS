package br.com.mind5.business.scheduleRange.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoSchedageSelectSingle extends DaoStmtTemplate<SchedageInfo> {	
	private final String MAIN_TABLE = DaoDbTable.SCHEDULE_TABLE;
	
	
	public DaoSchedageSelectSingle(Connection conn, SchedageInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.SCHEDULE_RANGE_VIEW;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SchedageInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoSchedageWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<SchedageInfo> getResultParserHook() {
		return new DaoResultParser<SchedageInfo>() {
			@Override public List<SchedageInfo> parseResult(SchedageInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {				
				List<SchedageInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SchedageInfo dataInfo = new SchedageInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoSchedageDbTableColumn.COL_COD_OWNER);	
					dataInfo.codSchedule = stmtResult.getLong(DaoSchedageDbTableColumn.COL_COD_SCHEDULE);
					dataInfo.codOrder = stmtResult.getLong(DaoSchedageDbTableColumn.COL_COD_ORDER);
					dataInfo.recordMode = stmtResult.getString(DaoSchedageDbTableColumn.COL_RECORD_MODE);				
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoSchedageDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, DaoSchedageDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, DaoSchedageDbTableColumn.COL_COD_MATERIAL);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, DaoSchedageDbTableColumn.COL_DATE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoSchedageDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoSchedageDbTableColumn.COL_END_TIME);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoSchedageDbTableColumn.COL_COD_USER);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, DaoSchedageDbTableColumn.COL_COD_CUSTOMER);			
					dataInfo.day = DaoFormatter.sqlToInt(stmtResult, DaoSchedageDbTableColumn.COL_DAY);
					dataInfo.weekMonth = DaoFormatter.sqlToInt(stmtResult, DaoSchedageDbTableColumn.COL_WEEK_MONTH);
					dataInfo.weekYear = DaoFormatter.sqlToInt(stmtResult, DaoSchedageDbTableColumn.COL_WEEK_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, DaoSchedageDbTableColumn.COL_MONTH);
					dataInfo.quarter = DaoFormatter.sqlToInt(stmtResult, DaoSchedageDbTableColumn.COL_QUARTER);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, DaoSchedageDbTableColumn.COL_YEAR);	
					dataInfo.codWeekday = DaoFormatter.sqlToInt(stmtResult, DaoSchedageDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.codScheduleStatus = stmtResult.getString(DaoSchedageDbTableColumn.COL_COD_SCHEDULE_STATUS);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
