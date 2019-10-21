package br.com.mind5.business.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

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

	
	
	@Override public List<CusInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<CusInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CusInfo recordInfo) throws SQLException {			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);		
			stmt.setString(i++, recordInfo.recordMode);			
			stmt.setTimestamp(i++, DaoFormatter.localToSqlTimestamp(recordInfo.lastChanged));
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPerson);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
			
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
