package br.com.gda.business.material.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.sql.SqlDbTable;
import br.com.gda.sql.SqlDbTableColumnAll;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlResultParser;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtHelper;
import br.com.gda.sql.SqlStmtOption;
import br.com.gda.sql.SqlStmtParamTranslator;

public final class MatInsertAttrSingle implements SqlStmt<MatInfo> {
	private SqlStmt<MatInfo> stmtSql;
	private SqlStmtOption<MatInfo> stmtOption;
	
	
	
	public MatInsertAttrSingle(Connection conn, MatInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
		
	}
	
	
	
	private void buildStmtOption(Connection conn, MatInfo recordInfo, String schemaName) {
		this.stmtOption = new SqlStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = SqlDbTable.MATERIAL_TABLE;
		this.stmtOption.columns = SqlDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = new ResultParser(recordInfo);
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

	
	
	@Override public List<MatInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements SqlStmtParamTranslator<MatInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, MatInfo recordInfo) throws SQLException {
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setDouble(i++, recordInfo.price);
			stmt.setInt(i++, recordInfo.codType);
			stmt.setInt(i++, recordInfo.codCategory);
			stmt.setString(i++, recordInfo.codCurr);
			stmt.setString(i++, recordInfo.codUnit);
			stmt.setInt(i++, recordInfo.priceUnit);
			stmt.setInt(i++, recordInfo.codGroup);
			stmt.setBoolean(i++, recordInfo.isLocked);
			stmt.setString(i++, recordInfo.recordMode);
			
			return stmt;
		}		
	}
	
	
	
	@Override public SqlStmt<MatInfo> getNewInstance() {
		return new MatInsertAttrSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private class ResultParser implements SqlResultParser<MatInfo> {
		private MatInfo recordInfo;
		
		public ResultParser(MatInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<MatInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<MatInfo> finalResult = new ArrayList<>();
			recordInfo.codMat = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
