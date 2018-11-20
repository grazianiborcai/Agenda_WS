package br.com.gda.business.phone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;

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

	
	
	@Override public List<PhoneInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<PhoneInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PhoneInfo recordInfo) throws SQLException {
			
			Timestamp lastChanged = null;
			if(recordInfo.lastChanged != null)
				lastChanged = Timestamp.valueOf((recordInfo.lastChanged));
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			
			
			if (DaoFormatter.boxNumber(recordInfo.codStore) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codStore);
			}
			
			
			if (DaoFormatter.boxNumber(recordInfo.codCustomer) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codCustomer);
			}
			
			
			if (DaoFormatter.boxNumber(recordInfo.codEmployee) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codEmployee);
			}
			
			
			stmt.setString(i++, recordInfo.codCountry);
			stmt.setString(i++, recordInfo.fullNumber);
			stmt.setString(i++, recordInfo.recordMode);
			stmt.setTimestamp(i++, lastChanged);
			stmt.setString(i++, recordInfo.complement);

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
