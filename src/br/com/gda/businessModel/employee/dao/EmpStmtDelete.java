package br.com.gda.businessModel.employee.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.businessModel.employee.info.EmpInfo;
import br.com.gda.sql.DbTable;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlResultParser;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtHelper;
import br.com.gda.sql.SqlStmtOption;
import br.com.gda.sql.SqlWhereBuilderOption;

final class EmpStmtDelete implements SqlStmt<EmpInfo> {
	private SqlStmt<EmpInfo> stmtSql;
	private SqlStmtOption<EmpInfo> stmtOption;	
	
	
	public EmpStmtDelete(Connection conn, EmpInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, EmpInfo recordInfo, String schemaName) {
		this.stmtOption = new SqlStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DbTable.EMPLOYEE_TABLE;
		this.stmtOption.columns = EmpDbTableColumn.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		final boolean DONT_IGNORE_NULL = false;
		final boolean IGNORE_NON_PK = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		SqlWhereBuilderOption whereOption = new SqlWhereBuilderOption();
		whereOption.isIgnoringNull = DONT_IGNORE_NULL;
		whereOption.isIgnoringRecordMode = DONT_IGNORE_RECORD_MODE;	
		whereOption.isIgnoringNonPrimaryKey = IGNORE_NON_PK;		
		
		EmpStmtWhere whereClause = new EmpStmtWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new SqlStmtHelper<>(SqlOperation.SOFT_DELETE, this.stmtOption);
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

	
	
	@Override public List<EmpInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public SqlStmt<EmpInfo> getNewInstance() {
		return new EmpStmtDelete(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements SqlResultParser<EmpInfo> {
		@Override public List<EmpInfo> parseResult(ResultSet stmtResult) throws SQLException {
			List<EmpInfo> finalResult = new ArrayList<>();
			EmpInfo emptyInfo = new EmpInfo();
			finalResult.add(emptyInfo);			
			return finalResult;
		}
	}
}
