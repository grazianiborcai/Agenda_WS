package br.com.mind5.security.userSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.obsolete.DaoResultParser_;
import br.com.mind5.dao.obsolete.DaoStmtOption_;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class UserapInsertSingle implements DaoStmt<UserapInfo> {	
	private DaoStmt<UserapInfo> stmtSql;
	private DaoStmtOption_<UserapInfo> stmtOption;
	
	
	
	public UserapInsertSingle(Connection conn, UserapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
		
	}
	
	
	
	private void buildStmtOption(Connection conn, UserapInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.USER_SNAPSHOT_TABLE;
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

	
	
	@Override public List<UserapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<UserapInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, UserapInfo recordInfo) throws SQLException {
			
			Timestamp lastChanged = null;
			if(recordInfo.lastChanged != null)
				lastChanged = Timestamp.valueOf((recordInfo.lastChanged));
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);		
			stmt.setLong(i++, recordInfo.codUser);	
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
						
			
			return stmt;
		}			
	}
	
	
	
	@Override public DaoStmt<UserapInfo> getNewInstance() {
		return new UserapInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<UserapInfo> {
		private UserapInfo recordInfo;
		
		public ResultParser(UserapInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<UserapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<UserapInfo> finalResult = new ArrayList<>();
			recordInfo.codSnapshot = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
