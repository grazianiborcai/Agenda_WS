package br.com.gda.business.scheduleLine.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLineSnapshot.dao.SchedinapDbTableColumn;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class SchedineSelectSingle implements DaoStmt<SchedineInfo> {	
	private final String LT_SCHEDULE = DaoDbTable.SCHEDULE_TABLE;
	
	private DaoStmt<SchedineInfo> stmtSql;
	private DaoStmtOption<SchedineInfo> stmtOption;
	
	
	
	public SchedineSelectSingle(Connection conn, SchedineInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, SchedineInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_SCHEDULE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_SCHEDULE);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new SchedineWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption);
	}
	
	

	@Override public void generateStmt() throws SQLException {
		stmtSql.generateStmt();		
	}

	
	
	@Override public boolean checkStmtGeneration() {
		return stmtSql.checkStmtGeneration();
	}

	
	
	@Override public void executeStmt() throws SQLException {
		stmtSql.executeStmt();
	}

	
	
	@Override public List<SchedineInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<SchedineInfo> getNewInstance() {
		return new SchedineSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<SchedineInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<SchedineInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			
			List<SchedineInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				SchedineInfo dataInfo = new SchedineInfo();
				dataInfo.codOwner = stmtResult.getLong(SchedineDbTableColumn.COL_COD_OWNER);	
				dataInfo.codSchedule = stmtResult.getLong(SchedineDbTableColumn.COL_COD_SCHEDULE);
				dataInfo.codOrder = stmtResult.getLong(SchedineDbTableColumn.COL_COD_ORDER);
				dataInfo.recordMode = stmtResult.getString(SchedineDbTableColumn.COL_RECORD_MODE);				
				dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, SchedineDbTableColumn.COL_COD_STORE);
				dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, SchedineDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, SchedineDbTableColumn.COL_COD_MATERIAL);
				dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, SchedineDbTableColumn.COL_DATE);
				dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, SchedineDbTableColumn.COL_BEGIN_TIME);
				dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, SchedineDbTableColumn.COL_END_TIME);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, SchedineDbTableColumn.COL_LAST_CHANGED);
				dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, SchedineDbTableColumn.COL_CREATED_ON);
				dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, SchedineDbTableColumn.COL_CREATED_BY);
				dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, SchedineDbTableColumn.COL_COD_USER);
				dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, SchedineDbTableColumn.COL_COD_CUSTOMER);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, SchedineDbTableColumn.COL_LAST_CHANGED_BY);				
				dataInfo.day = DaoFormatter.sqlToInt(stmtResult, SchedineDbTableColumn.COL_DAY);
				dataInfo.weekMonth = DaoFormatter.sqlToInt(stmtResult, SchedineDbTableColumn.COL_WEEK_MONTH);
				dataInfo.weekYear = DaoFormatter.sqlToInt(stmtResult, SchedineDbTableColumn.COL_WEEK_YEAR);
				dataInfo.month = DaoFormatter.sqlToInt(stmtResult, SchedineDbTableColumn.COL_MONTH);
				dataInfo.quarter = DaoFormatter.sqlToInt(stmtResult, SchedineDbTableColumn.COL_QUARTER);
				dataInfo.year = DaoFormatter.sqlToInt(stmtResult, SchedineDbTableColumn.COL_YEAR);		
				dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, SchedineDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codWeekday = DaoFormatter.sqlToInt(stmtResult, SchedineDbTableColumn.COL_COD_WEEKDAY);
				dataInfo.codScheduleStatus = stmtResult.getString(SchedinapDbTableColumn.COL_COD_SCHEDULE_STATUS);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
