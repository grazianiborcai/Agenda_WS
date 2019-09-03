package br.com.gda.security.userPassword.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.List;

import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;
import br.com.gda.security.userPassword.info.UpswdInfo;

public final class UpswdInsertSingle implements DaoStmt<UpswdInfo> {
	private DaoStmt<UpswdInfo> stmtSql;
	private DaoStmtOption<UpswdInfo> stmtOption;
	
	
	
	public UpswdInsertSingle(Connection conn, UpswdInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
		
	}
	
	
	
	private void buildStmtOption(Connection conn, UpswdInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
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
