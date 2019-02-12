package br.com.gda.business.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class CompInsertSingle implements DaoStmt<CompInfo> {	
	private DaoStmt<CompInfo> stmtSql;
	private DaoStmtOption<CompInfo> stmtOption;
	
	
	
	public CompInsertSingle(Connection conn, CompInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
		
	}
	
	
	
	private void buildStmtOption(Connection conn, CompInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = DaoDbTable.COMP_TABLE;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(stmtOption.tableName);
		stmtOption.stmtParamTranslator = new ParamTranslator();
		stmtOption.resultParser = new ResultParser(recordInfo);
		stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper<>(DaoOperation.INSERT, stmtOption);
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

	
	
	@Override public List<CompInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<CompInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CompInfo recordInfo) throws SQLException {
			Timestamp lastChanged = null;
			if(recordInfo.lastChanged != null)
				lastChanged = Timestamp.valueOf((recordInfo.lastChanged));
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setString(i++, recordInfo.cnpj);
			stmt.setString(i++, recordInfo.name);
			stmt.setString(i++, recordInfo.email);			
			stmt.setString(i++, recordInfo.recordMode);	
			stmt.setTimestamp(i++, lastChanged);
			stmt.setString(i++, recordInfo.codEntityCateg);
			stmt.setString(i++, recordInfo.codCountryLegal);
			stmt.setString(i++, recordInfo.inscrEst);
			stmt.setString(i++, recordInfo.inscrMun);
			stmt.setString(i++, recordInfo.razaoSocial);
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<CompInfo> getNewInstance() {
		return new CompInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<CompInfo> {
		private CompInfo recordInfo;
		
		public ResultParser(CompInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<CompInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<CompInfo> finalResult = new ArrayList<>();
			recordInfo.codCompany = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
