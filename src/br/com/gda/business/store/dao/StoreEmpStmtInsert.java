package br.com.gda.business.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.sql.DbTable;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlResultParser;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtHelper;
import br.com.gda.sql.SqlStmtOption;
import br.com.gda.sql.SqlStmtParamTranslator;

final class StoreEmpStmtInsert implements SqlStmt<StoreEmpInfo> {
	private SqlStmt<StoreEmpInfo> stmtSql;
	private SqlStmtOption<StoreEmpInfo> stmtOption;
	
	
	
	public StoreEmpStmtInsert(Connection conn, StoreEmpInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
		
	}
	
	
	
	private void buildStmtOption(Connection conn, StoreEmpInfo recordInfo, String schemaName) {
		this.stmtOption = new SqlStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DbTable.STORE_EMPLOYEE_TABLE;
		this.stmtOption.columns = StoreDbTableColumn.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = new ResultParser();
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

	
	
	@Override public List<StoreEmpInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements SqlStmtParamTranslator<StoreEmpInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StoreEmpInfo recordInfo) throws SQLException {
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codStore);
			stmt.setLong(i++, recordInfo.codEmployee);
			stmt.setLong(i++, recordInfo.codPositionStore);
			stmt.setString(i++, recordInfo.recordMode);
			
			return stmt;
		}		
	}
	
	
	
	@Override public SqlStmt<StoreEmpInfo> getNewInstance() {
		return new StoreEmpStmtInsert(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements SqlResultParser<StoreEmpInfo> {
		@Override public List<StoreEmpInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StoreEmpInfo> finalResult = new ArrayList<>();
			StoreEmpInfo recordInfo = new StoreEmpInfo();
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
