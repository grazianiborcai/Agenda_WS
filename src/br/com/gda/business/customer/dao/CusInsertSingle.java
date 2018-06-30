package br.com.gda.business.customer.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.sql.SqlDbTable;
import br.com.gda.sql.SqlDbTableColumnAll;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlResultParser;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtHelper;
import br.com.gda.sql.SqlStmtOption;
import br.com.gda.sql.SqlStmtParamTranslator;

public final class CusInsertSingle implements SqlStmt<CusInfo> {	
	private SqlStmt<CusInfo> stmtSql;
	private SqlStmtOption<CusInfo> stmtOption;
	
	
	
	public CusInsertSingle(Connection conn, CusInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
		
	}
	
	
	
	private void buildStmtOption(Connection conn, CusInfo recordInfo, String schemaName) {
		this.stmtOption = new SqlStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = SqlDbTable.CUS_TABLE;
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

	
	
	@Override public List<CusInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements SqlStmtParamTranslator<CusInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CusInfo recordInfo) throws SQLException {
			Date birthDate = SqlFormatterNumber.localToSqlDate(recordInfo.birthDate);
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setString(i++, recordInfo.cpf);
			stmt.setString(i++, recordInfo.name);
			stmt.setInt(i++, recordInfo.codGender);
			stmt.setDate(i++, birthDate);
			stmt.setString(i++, recordInfo.email);
			stmt.setString(i++, recordInfo.address1);
			stmt.setString(i++, recordInfo.address2);
			stmt.setLong(i++, recordInfo.postalCode);
			stmt.setString(i++, recordInfo.city);
			stmt.setString(i++, recordInfo.codCountry);
			stmt.setString(i++, recordInfo.stateProvince);
			stmt.setString(i++, recordInfo.phone);			
			stmt.setString(i++, recordInfo.recordMode);
			
			return stmt;
		}		
	}
	
	
	
	@Override public SqlStmt<CusInfo> getNewInstance() {
		return new CusInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements SqlResultParser<CusInfo> {
		private CusInfo recordInfo;
		
		public ResultParser(CusInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<CusInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<CusInfo> finalResult = new ArrayList<>();
			recordInfo.codCustomer = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
