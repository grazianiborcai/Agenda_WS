package br.com.mind5.business.scheduleSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoSchedarchSelectSingle extends DaoStmtTemplate<SchedarchInfo> {	
	private final String MAIN_TABLE = DaoDbTable.SCHEDULE_TABLE;
	
	
	public DaoSchedarchSelectSingle(Connection conn, SchedarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.SCHEDULE_SEARCH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SchedarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoSchedarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SchedarchInfo> getResultParserHook() {
		return new DaoResultParser<SchedarchInfo>() {
			@Override public List<SchedarchInfo> parseResult(SchedarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {	
				List<SchedarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SchedarchInfo dataInfo = new SchedarchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoSchedarchDbTableColumn.COL_COD_OWNER);	
					dataInfo.codSchedule = stmtResult.getLong(DaoSchedarchDbTableColumn.COL_COD_SCHEDULE);
					dataInfo.codOrder = stmtResult.getLong(DaoSchedarchDbTableColumn.COL_COD_ORDER);
					dataInfo.codOrderItem = stmtResult.getInt(DaoSchedarchDbTableColumn.COL_COD_ORDER_ITEM);
					dataInfo.recordMode = stmtResult.getString(DaoSchedarchDbTableColumn.COL_RECORD_MODE);				
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoSchedarchDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, DaoSchedarchDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, DaoSchedarchDbTableColumn.COL_COD_MATERIAL);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, DaoSchedarchDbTableColumn.COL_DATE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoSchedarchDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoSchedarchDbTableColumn.COL_END_TIME);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoSchedarchDbTableColumn.COL_COD_USER);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, DaoSchedarchDbTableColumn.COL_COD_CUSTOMER);			
					dataInfo.day = DaoFormatter.sqlToInt(stmtResult, DaoSchedarchDbTableColumn.COL_DAY);
					dataInfo.weekMonth = DaoFormatter.sqlToInt(stmtResult, DaoSchedarchDbTableColumn.COL_WEEK_MONTH);
					dataInfo.weekYear = DaoFormatter.sqlToInt(stmtResult, DaoSchedarchDbTableColumn.COL_WEEK_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, DaoSchedarchDbTableColumn.COL_MONTH);
					dataInfo.quarter = DaoFormatter.sqlToInt(stmtResult, DaoSchedarchDbTableColumn.COL_QUARTER);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, DaoSchedarchDbTableColumn.COL_YEAR);	
					dataInfo.codWeekday = DaoFormatter.sqlToInt(stmtResult, DaoSchedarchDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.codScheduleStatus = stmtResult.getString(DaoSchedarchDbTableColumn.COL_COD_SCHEDULE_STATUS);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
