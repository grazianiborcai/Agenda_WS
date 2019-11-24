package br.com.mind5.security.userPassword.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.obsolete.DaoStmtOption_;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class UpswdInsertSingle implements DaoStmt<UpswdInfo> {
	private DaoStmt<UpswdInfo> stmtSql;
	private DaoStmtOption_<UpswdInfo> stmtOption;
	
	
	
	public UpswdInsertSingle(Connection conn, UpswdInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
		
	}
	
	
	
	private void buildStmtOption(Connection conn, UpswdInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.USER_PASSWORD_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = null;
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

	
	
	@Override public List<UpswdInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<UpswdInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, UpswdInfo recordInfo) throws SQLException {
			Timestamp lastChanged = null;
			if(recordInfo.lastChanged != null)
				lastChanged = Timestamp.valueOf((recordInfo.lastChanged));
			
			String strHash;
			if (recordInfo.hash == null) {
				strHash = null;
			} else {
				strHash = Base64.getEncoder().encodeToString(recordInfo.hash);
			}
				

			String strSalt;
			if (recordInfo.salt == null) {
				strSalt = null;
			} else {
				strSalt = Base64.getEncoder().encodeToString(recordInfo.salt);
			}
			
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codUser);
			stmt.setString(i++, strHash);
			stmt.setString(i++, strSalt);
			stmt.setTimestamp(i++, lastChanged);
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<UpswdInfo> getNewInstance() {
		return new UpswdInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
