package br.com.gda.business.materialEmployee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.sql.SqlDbTable;
import br.com.gda.sql.SqlDbTableColumnAll;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtHelper;
import br.com.gda.sql.SqlStmtOption;
import br.com.gda.sql.SqlStmtParamTranslator;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilderOption;

public final class MatEmpUpdateSingle implements SqlStmt<MatEmpInfo> {
	private SqlStmt<MatEmpInfo> stmtSql;
	private SqlStmtOption<MatEmpInfo> stmtOption;
	
	
	public MatEmpUpdateSingle(Connection conn, MatEmpInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, MatEmpInfo recordInfo, String schemaName) {
		this.stmtOption = new SqlStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = SqlDbTable.MAT_EMP_TABLE;
		this.stmtOption.columns = SqlDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = null;
		this.stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		final boolean DONT_IGNORE_NULL = false;
		final boolean IGNORE_RECORD_MODE = true;
		
		SqlWhereBuilderOption whereOption = new SqlWhereBuilderOption();
		whereOption.ignoreNull = DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = IGNORE_RECORD_MODE;
		
		SqlStmtWhere whereClause = new MatEmpWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new SqlStmtHelper<>(SqlOperation.UPDATE, this.stmtOption);
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

	
	
	@Override public List<MatEmpInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public SqlStmt<MatEmpInfo> getNewInstance() {
		return new MatEmpUpdateSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ParamTranslator implements SqlStmtParamTranslator<MatEmpInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, MatEmpInfo recordInfo) throws SQLException {
			
			int i = 1;
			stmt.setString(i++, recordInfo.recordMode);
			
			return stmt;
		}		
	}
}
