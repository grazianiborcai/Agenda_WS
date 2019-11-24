package br.com.mind5.business.scheduleList.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.dao.SchedinapDbTableColumn;
import br.com.mind5.business.scheduleList.info.SchedistInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.dao.obsolete.DaoResultParser_;
import br.com.mind5.dao.obsolete.DaoStmtOption_;

public final class SchedistSelectSingle implements DaoStmt<SchedistInfo> {	
	private final String LT_SCHEDULE = DaoDbTable.SCHEDULE_TABLE;
	
	private DaoStmt<SchedistInfo> stmtSql;
	private DaoStmtOption_<SchedistInfo> stmtOption;
	
	
	
	public SchedistSelectSingle(Connection conn, SchedistInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, SchedistInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_SCHEDULE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.SCHEDULE_LIST_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new SchedistWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper_<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<SchedistInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<SchedistInfo> getNewInstance() {
		return new SchedistSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<SchedistInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<SchedistInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			
			List<SchedistInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				SchedistInfo dataInfo = new SchedistInfo();
				dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, SchedistDbTableColumn.COL_COD_OWNER);	
				dataInfo.codSchedule = DaoFormatter.sqlToLong(stmtResult, SchedistDbTableColumn.COL_COD_SCHEDULE);	
				dataInfo.codOrder = DaoFormatter.sqlToLong(stmtResult, SchedistDbTableColumn.COL_COD_ORDER);
				dataInfo.codOrderItem = DaoFormatter.sqlToInt(stmtResult, SchedistDbTableColumn.COL_COD_ORDER_ITEM);
				dataInfo.recordMode = stmtResult.getString(SchedistDbTableColumn.COL_RECORD_MODE);				
				dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, SchedistDbTableColumn.COL_COD_STORE);
				dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, SchedistDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, SchedistDbTableColumn.COL_COD_MATERIAL);
				dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, SchedistDbTableColumn.COL_DATE);
				dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, SchedistDbTableColumn.COL_BEGIN_TIME);
				dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, SchedistDbTableColumn.COL_END_TIME);
				dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, SchedistDbTableColumn.COL_COD_USER);
				dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, SchedistDbTableColumn.COL_COD_CUSTOMER);			
				dataInfo.day = DaoFormatter.sqlToInt(stmtResult, SchedistDbTableColumn.COL_DAY);
				dataInfo.weekMonth = DaoFormatter.sqlToInt(stmtResult, SchedistDbTableColumn.COL_WEEK_MONTH);
				dataInfo.weekYear = DaoFormatter.sqlToInt(stmtResult, SchedistDbTableColumn.COL_WEEK_YEAR);
				dataInfo.month = DaoFormatter.sqlToInt(stmtResult, SchedistDbTableColumn.COL_MONTH);
				dataInfo.quarter = DaoFormatter.sqlToInt(stmtResult, SchedistDbTableColumn.COL_QUARTER);
				dataInfo.year = DaoFormatter.sqlToInt(stmtResult, SchedistDbTableColumn.COL_YEAR);		
				dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, SchedistDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codWeekday = DaoFormatter.sqlToInt(stmtResult, SchedistDbTableColumn.COL_COD_WEEKDAY);
				dataInfo.codScheduleStatus = stmtResult.getString(SchedinapDbTableColumn.COL_COD_SCHEDULE_STATUS);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
