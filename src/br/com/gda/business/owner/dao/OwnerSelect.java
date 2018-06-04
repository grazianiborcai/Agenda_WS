package br.com.gda.business.owner.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.sql.SqlDbTable;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlResultParser;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtHelper;
import br.com.gda.sql.SqlStmtOption;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilderOption;

public final class OwnerSelect implements SqlStmt<OwnerInfo> {
	private final String LEFT_TABLE = SqlDbTable.OWNER_TABLE;	
	
	private SqlStmt<OwnerInfo> stmtSql;
	private SqlStmtOption<OwnerInfo> stmtOption;
	
	
	
	public OwnerSelect(Connection conn, OwnerInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, OwnerInfo recordInfo, String schemaName) {
		this.stmtOption = new SqlStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LEFT_TABLE;
		this.stmtOption.columns = OwnerDbTableColumn.getTableColumnsAsList(LEFT_TABLE);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		final boolean DONT_IGNORE_NULL = false;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		SqlWhereBuilderOption whereOption = new SqlWhereBuilderOption();
		whereOption.ignoreNull = DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		SqlStmtWhere whereClause = new OwnerWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<OwnerInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public SqlStmt<OwnerInfo> getNewInstance() {
		return new OwnerSelect(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements SqlResultParser<OwnerInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<OwnerInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<OwnerInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				OwnerInfo dataInfo = new OwnerInfo();
				dataInfo.codOwner = stmtResult.getLong("cod_owner");
				dataInfo.name = stmtResult.getString("Name");
				dataInfo.recordMode = stmtResult.getString("record_mode");			
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
