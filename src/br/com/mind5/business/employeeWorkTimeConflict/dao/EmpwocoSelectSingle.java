package br.com.mind5.business.employeeWorkTimeConflict.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
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


public final class EmpwocoSelectSingle implements DaoStmt<EmpwocoInfo> {
	private final String LT_EMP_WT = DaoDbTable.EMP_WT_TABLE;
	
	private DaoStmt<EmpwocoInfo> stmtSql;
	private DaoStmtOption<EmpwocoInfo> stmtOption;
	
	
	
	public EmpwocoSelectSingle(Connection conn, EmpwocoInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, EmpwocoInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_EMP_WT;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.EMP_WT_CONFLICT_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause(stmtOption.tableName, stmtOption.recordInfo);
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause(String tableName, EmpwocoInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		
		DaoStmtWhere whereClause = new EmpwocoWhere(whereOption, tableName, recordInfo);
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

	
	
	@Override public List<EmpwocoInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<EmpwocoInfo> getNewInstance() {
		return new EmpwocoSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements DaoResultParser<EmpwocoInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<EmpwocoInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<EmpwocoInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
		
			do {				
				EmpwocoInfo dataInfo = new EmpwocoInfo();
				dataInfo.codOwner = stmtResult.getLong(EmpwocoDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(EmpwocoDbTableColumn.COL_COD_STORE);
				dataInfo.codEmployee = stmtResult.getLong(EmpwocoDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codWeekday = stmtResult.getInt(EmpwocoDbTableColumn.COL_COD_WEEKDAY);
				dataInfo.recordMode = stmtResult.getString(EmpwocoDbTableColumn.COL_RECORD_MODE);
				dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, EmpwocoDbTableColumn.COL_BEGIN_TIME);
				dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, EmpwocoDbTableColumn.COL_END_TIME);
				
				finalResult.add(dataInfo);				
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
