package br.com.mind5.business.scheduleYearData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
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

public class SchedyeratSelectSingle implements DaoStmt<SchedyeratInfo> {
	private final String LT_SCHEDULE = DaoDbTable.SCHEDULE_YEAR_TABLE;
	
	private DaoStmt<SchedyeratInfo> stmtSql;
	private DaoStmtOption_<SchedyeratInfo> stmtOption;
	
	
	
	public SchedyeratSelectSingle(Connection conn, SchedyeratInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, SchedyeratInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption_<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = LT_SCHEDULE;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(stmtOption.tableName);
		stmtOption.stmtParamTranslator = null;
		stmtOption.resultParser = new ResultParser();
		stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new SchedyeratWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper_<>(DaoOperation.SELECT, stmtOption, this.getClass());
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

	
	
	@Override public List<SchedyeratInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<SchedyeratInfo> getNewInstance() {
		return new SchedyeratSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<SchedyeratInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<SchedyeratInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<SchedyeratInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				SchedyeratInfo dataInfo = new SchedyeratInfo();
				dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, SchedyeratDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, SchedyeratDbTableColumn.COL_COD_STORE);
				dataInfo.month = DaoFormatter.sqlToInt(stmtResult, SchedyeratDbTableColumn.COL_MONTH);
				dataInfo.year = DaoFormatter.sqlToInt(stmtResult, SchedyeratDbTableColumn.COL_YEAR);
				dataInfo.confirmed = stmtResult.getInt(SchedyeratDbTableColumn.COL_CONFIRMED);
				dataInfo.waiting = stmtResult.getInt(SchedyeratDbTableColumn.COL_WAITING);
				dataInfo.counter = stmtResult.getInt(SchedyeratDbTableColumn.COL_COUNTER);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
