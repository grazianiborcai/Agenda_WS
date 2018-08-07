package br.com.gda.business.employeeLeaveDate.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class EmpLDateDeleteSingle implements DaoStmt<EmpLDateInfo> {
	private final String LT_EMPLOYEE_LEAVE_DATE = DaoDbTable.EMP_LD_TABLE;	
	
	private DaoStmt<EmpLDateInfo> stmtSql;
	private DaoStmtOption<EmpLDateInfo> stmtOption;	
	
	
	public EmpLDateDeleteSingle(Connection conn, EmpLDateInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, EmpLDateInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_EMPLOYEE_LEAVE_DATE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();		
	}
	
	
	
	private String buildWhereClause() {
		final boolean DONT_IGNORE_NULL = false;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;	
		
		
		DaoStmtWhere whereClause = new EmpLDateWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SOFT_DELETE, this.stmtOption);
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

	
	
	@Override public List<EmpLDateInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<EmpLDateInfo> getNewInstance() {
		return new EmpLDateDeleteSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements DaoResultParser<EmpLDateInfo> {
		@Override public List<EmpLDateInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<EmpLDateInfo> finalResult = new ArrayList<>();
			EmpLDateInfo emptyInfo = new EmpLDateInfo();
			finalResult.add(emptyInfo);			
			return finalResult;
		}
	}
}
