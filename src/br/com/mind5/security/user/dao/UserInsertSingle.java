package br.com.mind5.security.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.obsolete.DaoResultParser_;
import br.com.mind5.dao.obsolete.DaoStmtOption_;
import br.com.mind5.security.user.info.UserInfo;

public final class UserInsertSingle implements DaoStmt<UserInfo> {	
	private DaoStmt<UserInfo> stmtSql;
	private DaoStmtOption_<UserInfo> stmtOption;
	
	
	
	public UserInsertSingle(Connection conn, UserInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, UserInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.USER_TABLE;
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

	
	
	@Override public List<UserInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<UserInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, UserInfo recordInfo) throws SQLException {
			
			int i = 1;
			
			stmt.setLong(i++, recordInfo.codOwner);		
			stmt.setString(i++, recordInfo.recordMode);			
			stmt.setTimestamp(i++, DaoFormatter.localToSqlTimestamp(recordInfo.lastChanged));
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPerson);
			stmt = DaoFormatter.charToStmt(stmt, i++, recordInfo.codUserCategory);
			stmt.setString(i++, recordInfo.username);	
			stmt.setString(i++, recordInfo.codAuthGroup);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPersonSnapshot);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);			
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<UserInfo> getNewInstance() {
		return new UserInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<UserInfo> {
		private UserInfo recordInfo;
		
		public ResultParser(UserInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<UserInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<UserInfo> finalResult = new ArrayList<>();
			recordInfo.codUser = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
