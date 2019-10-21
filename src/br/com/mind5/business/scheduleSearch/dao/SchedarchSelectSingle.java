package br.com.mind5.business.scheduleSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.dao.SchedinapDbTableColumn;
import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
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

public final class SchedarchSelectSingle implements DaoStmt<SchedarchInfo> {	
	private final String LT_SCHEDULE = DaoDbTable.SCHEDULE_TABLE;
	
	private DaoStmt<SchedarchInfo> stmtSql;
	private DaoStmtOption<SchedarchInfo> stmtOption;
	
	
	
	public SchedarchSelectSingle(Connection conn, SchedarchInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, SchedarchInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_SCHEDULE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.SCHEDULE_SEARCH_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new SchedarchWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<SchedarchInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<SchedarchInfo> getNewInstance() {
		return new SchedarchSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<SchedarchInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<SchedarchInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			
			List<SchedarchInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				SchedarchInfo dataInfo = new SchedarchInfo();
				dataInfo.codOwner = stmtResult.getLong(SchedarchDbTableColumn.COL_COD_OWNER);	
				dataInfo.codSchedule = stmtResult.getLong(SchedarchDbTableColumn.COL_COD_SCHEDULE);
				dataInfo.codOrder = stmtResult.getLong(SchedarchDbTableColumn.COL_COD_ORDER);
				dataInfo.recordMode = stmtResult.getString(SchedarchDbTableColumn.COL_RECORD_MODE);				
				dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, SchedarchDbTableColumn.COL_COD_STORE);
				dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, SchedarchDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, SchedarchDbTableColumn.COL_COD_MATERIAL);
				dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, SchedarchDbTableColumn.COL_DATE);
				dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, SchedarchDbTableColumn.COL_BEGIN_TIME);
				dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, SchedarchDbTableColumn.COL_END_TIME);
				dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, SchedarchDbTableColumn.COL_COD_USER);
				dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, SchedarchDbTableColumn.COL_COD_CUSTOMER);			
				dataInfo.day = DaoFormatter.sqlToInt(stmtResult, SchedarchDbTableColumn.COL_DAY);
				dataInfo.weekMonth = DaoFormatter.sqlToInt(stmtResult, SchedarchDbTableColumn.COL_WEEK_MONTH);
				dataInfo.weekYear = DaoFormatter.sqlToInt(stmtResult, SchedarchDbTableColumn.COL_WEEK_YEAR);
				dataInfo.month = DaoFormatter.sqlToInt(stmtResult, SchedarchDbTableColumn.COL_MONTH);
				dataInfo.quarter = DaoFormatter.sqlToInt(stmtResult, SchedarchDbTableColumn.COL_QUARTER);
				dataInfo.year = DaoFormatter.sqlToInt(stmtResult, SchedarchDbTableColumn.COL_YEAR);	
				dataInfo.codWeekday = DaoFormatter.sqlToInt(stmtResult, SchedarchDbTableColumn.COL_COD_WEEKDAY);
				dataInfo.codScheduleStatus = stmtResult.getString(SchedinapDbTableColumn.COL_COD_SCHEDULE_STATUS);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
