package br.com.mind5.business.ownerSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

public final class OwnerapInsertSingle implements DaoStmt<OwnerapInfo> {	
	private DaoStmt<OwnerapInfo> stmtSql;
	private DaoStmtOption<OwnerapInfo> stmtOption;
	
	
	
	public OwnerapInsertSingle(Connection conn, OwnerapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
		
	}
	
	
	
	private void buildStmtOption(Connection conn, OwnerapInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.OWNER_SNAPSHOT_TABLE;
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

	
	
	@Override public List<OwnerapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<OwnerapInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, OwnerapInfo recordInfo) throws SQLException {
			
			int i = 1;
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
			DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
			stmt.setString(i++, recordInfo.recordMode);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPerson);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCompany);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
			DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPersonSnapshot);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUserSnapshot);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCompanySnapshot);
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<OwnerapInfo> getNewInstance() {
		return new OwnerapInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<OwnerapInfo> {
		private OwnerapInfo recordInfo;
		
		public ResultParser(OwnerapInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<OwnerapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<OwnerapInfo> finalResult = new ArrayList<>();
			recordInfo.codSnapshot = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
