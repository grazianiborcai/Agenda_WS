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

public final class MatEmpInsertSingle implements SqlStmt<MatEmpInfo> {
	private SqlStmt<MatEmpInfo> stmtSql;
	private SqlStmtOption<MatEmpInfo> stmtOption;
	
	
	
	public MatEmpInsertSingle(Connection conn, MatEmpInfo recordInfo, String schemaName) {
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
		this.stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new SqlStmtHelper<>(SqlOperation.INSERT, this.stmtOption);
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
	
	
	
	private class ParamTranslator implements SqlStmtParamTranslator<MatEmpInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, MatEmpInfo recordInfo) throws SQLException {
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codStore);
			stmt.setLong(i++, recordInfo.codEmployee);
			stmt.setLong(i++, recordInfo.codMat);
			stmt.setString(i++, recordInfo.recordMode);
			
			return stmt;
		}		
	}
	
	
	
	@Override public SqlStmt<MatEmpInfo> getNewInstance() {
		return new MatEmpInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
