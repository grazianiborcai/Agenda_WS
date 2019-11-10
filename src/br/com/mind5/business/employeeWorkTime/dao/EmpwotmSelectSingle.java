package br.com.mind5.business.employeeWorkTime.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
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

public final class EmpwotmSelectSingle implements DaoStmt<EmpwotmInfo> {
	private final String LT_EMPLOYEE_WORK_TIME = DaoDbTable.EMP_WT_TABLE;	
	
	private DaoStmt<EmpwotmInfo> stmtSql;
	private DaoStmtOption<EmpwotmInfo> stmtOption;
	
	
	
	public EmpwotmSelectSingle(Connection conn, EmpwotmInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, EmpwotmInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_EMPLOYEE_WORK_TIME;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmpwotmWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<EmpwotmInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<EmpwotmInfo> getNewInstance() {
		return new EmpwotmSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements DaoResultParser<EmpwotmInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<EmpwotmInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<EmpwotmInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
		
			do {				
				EmpwotmInfo dataInfo = new EmpwotmInfo();
				dataInfo.codOwner = stmtResult.getLong(EmpwotmDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(EmpwotmDbTableColumn.COL_COD_STORE);
				dataInfo.codEmployee = stmtResult.getLong(EmpwotmDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codWeekday = stmtResult.getInt(EmpwotmDbTableColumn.COL_COD_WEEKDAY);
				dataInfo.recordMode = stmtResult.getString(EmpwotmDbTableColumn.COL_RECORD_MODE);	
				dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, EmpwotmDbTableColumn.COL_BEGIN_TIME);
				dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, EmpwotmDbTableColumn.COL_END_TIME);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, EmpwotmDbTableColumn.COL_LAST_CHANGED);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, EmpwotmDbTableColumn.COL_LAST_CHANGED_BY);				
				
				finalResult.add(dataInfo);				
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
