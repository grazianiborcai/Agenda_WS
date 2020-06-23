package br.com.mind5.business.scheduleLine.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoSchedineSelectSingle extends DaoStmtTemplate<SchedineInfo> {	
	private final String MAIN_TABLE = DaoDbTable.SCHEDULE_TABLE;
	
	
	public DaoSchedineSelectSingle(Connection conn, SchedineInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SchedineInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoSchedineWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
		
	
	
	@Override protected DaoResultParser<SchedineInfo> getResultParserHook() {
		return new DaoResultParser<SchedineInfo>() {
			@Override public List<SchedineInfo> parseResult(SchedineInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {				
				List<SchedineInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SchedineInfo dataInfo = new SchedineInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoSchedineDbTableColumn.COL_COD_OWNER);	
					dataInfo.codSchedule = DaoFormatter.sqlToLong(stmtResult, DaoSchedineDbTableColumn.COL_COD_SCHEDULE);	
					dataInfo.codScheduleRef = DaoFormatter.sqlToLong(stmtResult, DaoSchedineDbTableColumn.COL_COD_SCHEDULE_REF);	
					dataInfo.codOrder = DaoFormatter.sqlToLong(stmtResult, DaoSchedineDbTableColumn.COL_COD_ORDER);
					dataInfo.codOrderItem = DaoFormatter.sqlToInt(stmtResult, DaoSchedineDbTableColumn.COL_COD_ORDER_ITEM);
					dataInfo.recordMode = stmtResult.getString(DaoSchedineDbTableColumn.COL_RECORD_MODE);				
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoSchedineDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, DaoSchedineDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, DaoSchedineDbTableColumn.COL_COD_MATERIAL);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, DaoSchedineDbTableColumn.COL_DATE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoSchedineDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoSchedineDbTableColumn.COL_END_TIME);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoSchedineDbTableColumn.COL_LAST_CHANGED);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoSchedineDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, DaoSchedineDbTableColumn.COL_CREATED_BY);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoSchedineDbTableColumn.COL_COD_USER);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, DaoSchedineDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoSchedineDbTableColumn.COL_LAST_CHANGED_BY);				
					dataInfo.day = DaoFormatter.sqlToInt(stmtResult, DaoSchedineDbTableColumn.COL_DAY);
					dataInfo.weekMonth = DaoFormatter.sqlToInt(stmtResult, DaoSchedineDbTableColumn.COL_WEEK_MONTH);
					dataInfo.weekYear = DaoFormatter.sqlToInt(stmtResult, DaoSchedineDbTableColumn.COL_WEEK_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, DaoSchedineDbTableColumn.COL_MONTH);
					dataInfo.quarter = DaoFormatter.sqlToInt(stmtResult, DaoSchedineDbTableColumn.COL_QUARTER);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, DaoSchedineDbTableColumn.COL_YEAR);		
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoSchedineDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codWeekday = DaoFormatter.sqlToInt(stmtResult, DaoSchedineDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.codScheduleStatus = stmtResult.getString(DaoSchedineDbTableColumn.COL_COD_SCHEDULE_STATUS);
					dataInfo.codScheduleStatusOld = stmtResult.getString(DaoSchedineDbTableColumn.COL_COD_SCHEDULE_STATUS);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
