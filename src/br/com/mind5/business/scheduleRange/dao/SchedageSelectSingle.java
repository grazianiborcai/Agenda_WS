package br.com.mind5.business.scheduleRange.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.dao.SchedinapDbTableColumn;
import br.com.mind5.business.scheduleRange.info.SchedageInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.common.DaoOptionValue;

public final class SchedageSelectSingle implements DaoStmt<SchedageInfo> {	
	private final String LT_SCHEDULE = DaoDbTable.SCHEDULE_TABLE;
	
	private DaoStmt<SchedageInfo> stmtSql;
	private DaoStmtOption<SchedageInfo> stmtOption;
	
	
	
	public SchedageSelectSingle(Connection conn, SchedageInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, SchedageInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_SCHEDULE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.SCHEDULE_RANGE_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new SchedageWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<SchedageInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<SchedageInfo> getNewInstance() {
		return new SchedageSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<SchedageInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<SchedageInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			
			List<SchedageInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				SchedageInfo dataInfo = new SchedageInfo();
				dataInfo.codOwner = stmtResult.getLong(SchedageDbTableColumn.COL_COD_OWNER);	
				dataInfo.codSchedule = stmtResult.getLong(SchedageDbTableColumn.COL_COD_SCHEDULE);
				dataInfo.codOrder = stmtResult.getLong(SchedageDbTableColumn.COL_COD_ORDER);
				dataInfo.recordMode = stmtResult.getString(SchedageDbTableColumn.COL_RECORD_MODE);				
				dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, SchedageDbTableColumn.COL_COD_STORE);
				dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, SchedageDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, SchedageDbTableColumn.COL_COD_MATERIAL);
				dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, SchedageDbTableColumn.COL_DATE);
				dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, SchedageDbTableColumn.COL_BEGIN_TIME);
				dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, SchedageDbTableColumn.COL_END_TIME);
				dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, SchedageDbTableColumn.COL_COD_USER);
				dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, SchedageDbTableColumn.COL_COD_CUSTOMER);			
				dataInfo.day = DaoFormatter.sqlToInt(stmtResult, SchedageDbTableColumn.COL_DAY);
				dataInfo.weekMonth = DaoFormatter.sqlToInt(stmtResult, SchedageDbTableColumn.COL_WEEK_MONTH);
				dataInfo.weekYear = DaoFormatter.sqlToInt(stmtResult, SchedageDbTableColumn.COL_WEEK_YEAR);
				dataInfo.month = DaoFormatter.sqlToInt(stmtResult, SchedageDbTableColumn.COL_MONTH);
				dataInfo.quarter = DaoFormatter.sqlToInt(stmtResult, SchedageDbTableColumn.COL_QUARTER);
				dataInfo.year = DaoFormatter.sqlToInt(stmtResult, SchedageDbTableColumn.COL_YEAR);	
				dataInfo.codWeekday = DaoFormatter.sqlToInt(stmtResult, SchedageDbTableColumn.COL_COD_WEEKDAY);
				dataInfo.codScheduleStatus = stmtResult.getString(SchedinapDbTableColumn.COL_COD_SCHEDULE_STATUS);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
