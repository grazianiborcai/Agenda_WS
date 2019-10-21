package br.com.mind5.business.customerSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerSnapshot.info.CusnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

public final class CusnapInsertSingle implements DaoStmt<CusnapInfo> {	
	private DaoStmt<CusnapInfo> stmtSql;
	private DaoStmtOption<CusnapInfo> stmtOption;
	
	
	
	public CusnapInsertSingle(Connection conn, CusnapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
		
	}
	
	
	
	private void buildStmtOption(Connection conn, CusnapInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.CUS_SNAPSHOT_TABLE;
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

	
	
	@Override public List<CusnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<CusnapInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CusnapInfo recordInfo) throws SQLException {			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);		
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
			stmt.setString(i++, recordInfo.recordMode);			
			stmt.setTimestamp(i++, DaoFormatter.localToSqlTimestamp(recordInfo.lastChanged));
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPerson);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPersonSnapshot);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUserSnapshot);
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<CusnapInfo> getNewInstance() {
		return new CusnapInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<CusnapInfo> {
		private CusnapInfo recordInfo;
		
		public ResultParser(CusnapInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<CusnapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<CusnapInfo> finalResult = new ArrayList<>();
			recordInfo.codSnapshot = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
