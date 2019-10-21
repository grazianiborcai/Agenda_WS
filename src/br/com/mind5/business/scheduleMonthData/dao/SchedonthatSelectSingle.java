package br.com.mind5.business.scheduleMonthData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
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

public class SchedonthatSelectSingle implements DaoStmt<SchedonthatInfo> {
	private final String LT_SCHEDULE = DaoDbTable.SCHEDULE_MONTH_TABLE;
	
	private DaoStmt<SchedonthatInfo> stmtSql;
	private DaoStmtOption<SchedonthatInfo> stmtOption;
	
	
	
	public SchedonthatSelectSingle(Connection conn, SchedonthatInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, SchedonthatInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption<>();
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
		
		DaoStmtWhere whereClause = new SchedonthatWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, stmtOption, this.getClass());
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

	
	
	@Override public List<SchedonthatInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<SchedonthatInfo> getNewInstance() {
		return new SchedonthatSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<SchedonthatInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<SchedonthatInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<SchedonthatInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				SchedonthatInfo dataInfo = new SchedonthatInfo();
				dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, SchedonthatDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, SchedonthatDbTableColumn.COL_COD_STORE);				
				dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, SchedonthatDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, SchedonthatDbTableColumn.COL_COD_MATERIAL);
				dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, SchedonthatDbTableColumn.COL_DATE);	
				dataInfo.day = DaoFormatter.sqlToInt(stmtResult, SchedonthatDbTableColumn.COL_DAY);
				dataInfo.month = DaoFormatter.sqlToInt(stmtResult, SchedonthatDbTableColumn.COL_MONTH);
				dataInfo.year = DaoFormatter.sqlToInt(stmtResult, SchedonthatDbTableColumn.COL_YEAR);
				dataInfo.confirmed = stmtResult.getInt(SchedonthatDbTableColumn.COL_CONFIRMED);
				dataInfo.waiting = stmtResult.getInt(SchedonthatDbTableColumn.COL_WAITING);
				dataInfo.counter = stmtResult.getInt(SchedonthatDbTableColumn.COL_COUNTER);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
