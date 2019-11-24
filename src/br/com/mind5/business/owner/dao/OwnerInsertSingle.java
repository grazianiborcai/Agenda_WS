package br.com.mind5.business.owner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.obsolete.DaoResultParser_;
import br.com.mind5.dao.obsolete.DaoStmtOption_;

public final class OwnerInsertSingle implements DaoStmt<OwnerInfo> {	
	private DaoStmt<OwnerInfo> stmtSql;
	private DaoStmtOption_<OwnerInfo> stmtOption;
	
	
	
	public OwnerInsertSingle(Connection conn, OwnerInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
		
	}
	
	
	
	private void buildStmtOption(Connection conn, OwnerInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.OWNER_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = new ResultParser(recordInfo);
		this.stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper_<>(DaoOperation.INSERT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<OwnerInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<OwnerInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, OwnerInfo recordInfo) throws SQLException {
			
			int i = 1;
			DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
			stmt.setString(i++, recordInfo.recordMode);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPerson);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCompany);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
			DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<OwnerInfo> getNewInstance() {
		return new OwnerInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<OwnerInfo> {
		private OwnerInfo recordInfo;
		
		public ResultParser(OwnerInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<OwnerInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<OwnerInfo> finalResult = new ArrayList<>();
			recordInfo.codOwner = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
