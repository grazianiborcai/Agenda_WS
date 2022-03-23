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

public final class SchedineDaoSelectSingle extends DaoStmtTemplate<SchedineInfo> {	
	private final String MAIN_TABLE = DaoDbTable.SCHEDULE_TABLE;
	
	
	public SchedineDaoSelectSingle(Connection conn, SchedineInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new SchedineDaoWhere(whereOption, tableName, recordInfo);
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
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, SchedineDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codSchedule = DaoFormatter.sqlToLong(stmtResult, SchedineDaoDbTableColumn.COL_COD_SCHEDULE);	
					dataInfo.codScheduleRef = DaoFormatter.sqlToLong(stmtResult, SchedineDaoDbTableColumn.COL_COD_SCHEDULE_REF);	
					dataInfo.codOrder = DaoFormatter.sqlToLong(stmtResult, SchedineDaoDbTableColumn.COL_COD_ORDER);
					dataInfo.codOrderItem = DaoFormatter.sqlToInt(stmtResult, SchedineDaoDbTableColumn.COL_COD_ORDER_ITEM);
					dataInfo.recordMode = stmtResult.getString(SchedineDaoDbTableColumn.COL_RECORD_MODE);				
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, SchedineDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, SchedineDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, SchedineDaoDbTableColumn.COL_COD_MATERIAL);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, SchedineDaoDbTableColumn.COL_DATE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, SchedineDaoDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, SchedineDaoDbTableColumn.COL_END_TIME);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, SchedineDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, SchedineDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, SchedineDaoDbTableColumn.COL_CREATED_BY);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, SchedineDaoDbTableColumn.COL_COD_USER);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, SchedineDaoDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, SchedineDaoDbTableColumn.COL_LAST_CHANGED_BY);				
					dataInfo.day = DaoFormatter.sqlToInt(stmtResult, SchedineDaoDbTableColumn.COL_DAY);
					dataInfo.weekMonth = DaoFormatter.sqlToInt(stmtResult, SchedineDaoDbTableColumn.COL_WEEK_MONTH);
					dataInfo.weekYear = DaoFormatter.sqlToInt(stmtResult, SchedineDaoDbTableColumn.COL_WEEK_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, SchedineDaoDbTableColumn.COL_MONTH);
					dataInfo.quarter = DaoFormatter.sqlToInt(stmtResult, SchedineDaoDbTableColumn.COL_QUARTER);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, SchedineDaoDbTableColumn.COL_YEAR);		
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, SchedineDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codWeekday = DaoFormatter.sqlToInt(stmtResult, SchedineDaoDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.codScheduleStatus = stmtResult.getString(SchedineDaoDbTableColumn.COL_COD_SCHEDULE_STATUS);
					dataInfo.codScheduleStatusOld = stmtResult.getString(SchedineDaoDbTableColumn.COL_COD_SCHEDULE_STATUS);
					dataInfo.codPet = DaoFormatter.sqlToLong(stmtResult, SchedineDaoDbTableColumn.COL_COD_PET);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
