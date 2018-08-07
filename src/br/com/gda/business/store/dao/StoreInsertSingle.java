package br.com.gda.business.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;

public final class StoreInsertSingle implements DaoStmt<StoreInfo> {
	private DaoStmt<StoreInfo> stmtSql;
	private DaoStmtOption<StoreInfo> stmtOption;
	
	
	
	public StoreInsertSingle(Connection conn, StoreInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, StoreInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.STORE_TABLE;
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

	
	
	@Override public List<StoreInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<StoreInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StoreInfo recordInfo) throws SQLException {
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setString(i++, recordInfo.cnpj);
			stmt.setString(i++, recordInfo.inscrMun);
			stmt.setString(i++, recordInfo.inscrEst);
			stmt.setString(i++, recordInfo.razaoSocial);
			stmt.setString(i++, recordInfo.name);
			stmt.setString(i++, recordInfo.address1);
			stmt.setString(i++, recordInfo.address2);
			stmt.setLong(i++, recordInfo.postalCode);
			stmt.setString(i++, recordInfo.city);
			stmt.setString(i++, recordInfo.codCountry);
			stmt.setString(i++, recordInfo.stateProvince);
			stmt.setString(i++, recordInfo.phone);	
			stmt.setString(i++, recordInfo.codCurr);
			stmt.setString(i++, recordInfo.codPayment);
			stmt.setDouble(i++, recordInfo.latitude);
			stmt.setDouble(i++, recordInfo.longitude);
			stmt.setString(i++, recordInfo.codTimezone);
			stmt.setString(i++, recordInfo.recordMode);
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<StoreInfo> getNewInstance() {
		return new StoreInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements DaoResultParser<StoreInfo> {
		private StoreInfo recordInfo;
		
		public ResultParser(StoreInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<StoreInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StoreInfo> finalResult = new ArrayList<>();
			recordInfo.codStore = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
