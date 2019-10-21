package br.com.mind5.business.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

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

	
	
	@Override public List<StoreInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<StoreInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StoreInfo recordInfo) throws SQLException {
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPerson);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCompany);
			stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
			stmt.setString(i++, recordInfo.codCurr);
			stmt.setString(i++, recordInfo.codTimezone);
			stmt.setString(i++, recordInfo.recordMode);		
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
			stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
			
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
