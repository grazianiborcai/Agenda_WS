package br.com.gda.business.materialEmployee.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.sql.SqlDbTable;
import br.com.gda.sql.SqlDbTableColumnAll;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlResultParser;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtHelper;
import br.com.gda.sql.SqlStmtOption;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilderOption;

public final class MatEmpSelectSingle implements SqlStmt<MatEmpInfo> {
	private SqlStmt<MatEmpInfo> stmtSql;
	private SqlStmtOption<MatEmpInfo> stmtOption;
	
	
	
	public MatEmpSelectSingle(Connection conn, MatEmpInfo recordInfo, String schemaName) {
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
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		SqlWhereBuilderOption whereOption = new SqlWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		SqlStmtWhere whereClause = new MatEmpWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new SqlStmtHelper<>(SqlOperation.SELECT, this.stmtOption);
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
		return new MatEmpSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements SqlResultParser<MatEmpInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<MatEmpInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<MatEmpInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				MatEmpInfo dataInfo = new MatEmpInfo();
				dataInfo.codOwner = stmtResult.getLong("cod_owner");
				dataInfo.codStore = stmtResult.getLong("Cod_store");
				dataInfo.codEmployee = stmtResult.getLong("Cod_employee");
				dataInfo.codMat = stmtResult.getLong("Cod_material");
				dataInfo.recordMode = stmtResult.getString("Record_mode");							
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
