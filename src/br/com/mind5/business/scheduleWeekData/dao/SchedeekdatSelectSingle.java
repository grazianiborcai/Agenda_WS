package br.com.mind5.business.scheduleWeekData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
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

public class SchedeekdatSelectSingle implements DaoStmt<SchedeekdatInfo> {
	private final String LT_SCHEDULE = DaoDbTable.SCHEDULE_WEEK_TABLE;
	
	private DaoStmt<SchedeekdatInfo> stmtSql;
	private DaoStmtOption_<SchedeekdatInfo> stmtOption;
	
	
	
	public SchedeekdatSelectSingle(Connection conn, SchedeekdatInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, SchedeekdatInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new SchedeekdatWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<SchedeekdatInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<SchedeekdatInfo> getNewInstance() {
		return new SchedeekdatSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<SchedeekdatInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<SchedeekdatInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<SchedeekdatInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				SchedeekdatInfo dataInfo = new SchedeekdatInfo();
				dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, SchedeekdatDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, SchedeekdatDbTableColumn.COL_COD_STORE);				
				dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, SchedeekdatDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, SchedeekdatDbTableColumn.COL_COD_CUSTOMER);
				dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, SchedeekdatDbTableColumn.COL_COD_MATERIAL);
				dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, SchedeekdatDbTableColumn.COL_DATE);	
				dataInfo.day = DaoFormatter.sqlToInt(stmtResult, SchedeekdatDbTableColumn.COL_DAY);
				dataInfo.month = DaoFormatter.sqlToInt(stmtResult, SchedeekdatDbTableColumn.COL_MONTH);
				dataInfo.weekMonth = DaoFormatter.sqlToInt(stmtResult, SchedeekdatDbTableColumn.COL_WEEK_MONTH);
				dataInfo.weekYear = DaoFormatter.sqlToInt(stmtResult, SchedeekdatDbTableColumn.COL_WEEK_YEAR);
				dataInfo.year = DaoFormatter.sqlToInt(stmtResult, SchedeekdatDbTableColumn.COL_YEAR);
				dataInfo.confirmed = stmtResult.getInt(SchedeekdatDbTableColumn.COL_CONFIRMED);
				dataInfo.waiting = stmtResult.getInt(SchedeekdatDbTableColumn.COL_WAITING);
				dataInfo.counter = stmtResult.getInt(SchedeekdatDbTableColumn.COL_COUNTER);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
