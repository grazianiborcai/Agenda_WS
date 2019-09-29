package br.com.gda.business.companySnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.companySnapshot.info.CompnapInfo;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class CompnapInsertSingle implements DaoStmt<CompnapInfo> {	
	private DaoStmt<CompnapInfo> stmtSql;
	private DaoStmtOption<CompnapInfo> stmtOption;
	
	
	
	public CompnapInsertSingle(Connection conn, CompnapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
		
	}
	
	
	
	private void buildStmtOption(Connection conn, CompnapInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = DaoDbTable.COMP_SNAPHOT_TABLE;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(stmtOption.tableName);
		stmtOption.stmtParamTranslator = new ParamTranslator();
		stmtOption.resultParser = new ResultParser(recordInfo);
		stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper<>(DaoOperation.INSERT, stmtOption, this.getClass());
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

	
	
	@Override public List<CompnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<CompnapInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CompnapInfo recordInfo) throws SQLException {
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codCompany);
			stmt.setString(i++, recordInfo.cnpj);
			stmt.setString(i++, recordInfo.name);
			stmt.setString(i++, recordInfo.email);			
			stmt.setString(i++, recordInfo.recordMode);	
			DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
			stmt.setString(i++, recordInfo.codEntityCateg);
			stmt.setString(i++, recordInfo.codCountryLegal);
			stmt.setString(i++, recordInfo.inscrEst);
			stmt.setString(i++, recordInfo.inscrMun);
			stmt.setString(i++, recordInfo.razaoSocial);			
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);	
			DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);	
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<CompnapInfo> getNewInstance() {
		return new CompnapInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<CompnapInfo> {
		private CompnapInfo recordInfo;
		
		public ResultParser(CompnapInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<CompnapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<CompnapInfo> finalResult = new ArrayList<>();
			recordInfo.codSnapshot = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
