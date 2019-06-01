package br.com.gda.business.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class UserInsertSingle implements DaoStmt<UserInfo> {	
	private DaoStmt<UserInfo> stmtSql;
	private DaoStmtOption<UserInfo> stmtOption;
	
	
	
	public UserInsertSingle(Connection conn, UserInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, UserInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
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
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.INSERT, this.stmtOption);
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
			
			Timestamp lastChanged = null;
			if(recordInfo.lastChanged != null)
				lastChanged = Timestamp.valueOf((recordInfo.lastChanged));
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);		
			stmt.setString(i++, recordInfo.recordMode);			
			stmt.setTimestamp(i++, lastChanged);
			
			
			if (recordInfo.codPerson >= 0) {
				stmt.setLong(i++, recordInfo.codPerson);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			if (recordInfo.codUserCategory == DefaultValue.character()) {
				stmt.setNull(i++, Types.VARCHAR);
			} else {
				stmt.setString(i++, Character.toString(recordInfo.codUserCategory));
			}
			
			
			stmt.setString(i++, recordInfo.username);	
			stmt.setString(i++, recordInfo.codAuthGroup);
			
			
			if (recordInfo.lastChangedBy >= 0) {
				stmt.setLong(i++, recordInfo.lastChangedBy);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			if (recordInfo.codPersonSnapshot >= 0) {
				stmt.setLong(i++, recordInfo.codPersonSnapshot);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			if (recordInfo.codSnapshot >= 0) {
				stmt.setLong(i++, recordInfo.codSnapshot);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<UserInfo> getNewInstance() {
		return new UserInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<UserInfo> {
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
