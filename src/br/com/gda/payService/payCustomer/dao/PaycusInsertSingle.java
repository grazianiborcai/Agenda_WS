package br.com.gda.payService.payCustomer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

public final class PaycusInsertSingle implements DaoStmt<PaycusInfo> {	
	private DaoStmt<PaycusInfo> stmtSql;
	private DaoStmtOption<PaycusInfo> stmtOption;
	
	
	
	public PaycusInsertSingle(Connection conn, PaycusInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
		
	}
	
	
	
	private void buildStmtOption(Connection conn, PaycusInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.PAY_CUS_TABLE;
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

	
	
	@Override public List<PaycusInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<PaycusInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PaycusInfo recordInfo) throws SQLException {
			
			Timestamp lastChanged = null;
			if(recordInfo.lastChanged != null)
				lastChanged = Timestamp.valueOf((recordInfo.lastChanged));
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);		
			stmt.setString(i++, recordInfo.recordMode);
			
			stmt.setTimestamp(i++, lastChanged);
			
			
			if (recordInfo.codPerson >= 0) {
				stmt.setLong(i++, recordInfo.codPerson);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			if (recordInfo.codUser >= 0) {
				stmt.setLong(i++, recordInfo.codUser);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			stmt.setString(i++, recordInfo.codPayCustomerExt);
			
			
			if (recordInfo.codPayPartner >= 0) {
				stmt.setLong(i++, recordInfo.codPayPartner);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			if (recordInfo.codPersonRef >= 0) {
				stmt.setLong(i++, recordInfo.codPersonRef);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			if (recordInfo.codPhoneRef >= 0) {
				stmt.setLong(i++, recordInfo.codPhoneRef);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			if (recordInfo.codAddressRef >= 0) {
				stmt.setLong(i++, recordInfo.codAddressRef);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<PaycusInfo> getNewInstance() {
		return new PaycusInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<PaycusInfo> {
		private PaycusInfo recordInfo;
		
		public ResultParser(PaycusInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<PaycusInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PaycusInfo> finalResult = new ArrayList<>();
			recordInfo.codPayCustomer = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
