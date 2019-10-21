package br.com.mind5.business.phone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

public final class PhoneInsertSingle implements DaoStmt<PhoneInfo> {
	private DaoStmt<PhoneInfo> stmtSql;
	private DaoStmtOption<PhoneInfo> stmtOption;
	
	
	
	public PhoneInsertSingle(Connection conn, PhoneInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, PhoneInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.PHONE_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = new ResultParser(recordInfo);
		this.stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.INSERT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<PhoneInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<PhoneInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PhoneInfo recordInfo) throws SQLException {
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployee);
			stmt.setInt(i++, recordInfo.codCountryPhone);
			stmt.setString(i++, recordInfo.fullNumber);
			stmt.setString(i++, recordInfo.recordMode);
			stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
			stmt.setString(i++, recordInfo.complement);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwnerRef);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
			stmt.setString(i++, recordInfo.number);
			stmt.setString(i++, recordInfo.codArea);		
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);	
			DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);	

			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<PhoneInfo> getNewInstance() {
		return new PhoneInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<PhoneInfo> {
		private PhoneInfo recordInfo;
		
		public ResultParser(PhoneInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<PhoneInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PhoneInfo> finalResult = new ArrayList<>();
			recordInfo.codPhone = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
