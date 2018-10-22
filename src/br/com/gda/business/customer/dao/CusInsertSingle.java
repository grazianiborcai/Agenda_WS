package br.com.gda.business.customer.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;

public final class CusInsertSingle implements DaoStmt<CusInfo> {	
	private DaoStmt<CusInfo> stmtSql;
	private DaoStmtOption<CusInfo> stmtOption;
	
	
	
	public CusInsertSingle(Connection conn, CusInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
		
	}
	
	
	
	private void buildStmtOption(Connection conn, CusInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.CUS_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = new ResultParser(recordInfo);
		this.stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.INSERT, this.stmtOption);
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
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<CusInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CusInfo recordInfo) throws SQLException {
			Date birthDate = DaoFormatter.localToSqlDate(recordInfo.birthDate);
			
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
			stmt.setString(i++, recordInfo.phoneNumber1);			
			stmt.setString(i++, recordInfo.recordMode);
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<CusInfo> getNewInstance() {
		return new CusInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<CusInfo> {
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
