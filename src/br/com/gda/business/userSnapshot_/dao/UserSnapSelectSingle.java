package br.com.gda.business.userSnapshot_.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.userSnapshot_.info.UserSnapInfo;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class UserSnapSelectSingle implements DaoStmt<UserSnapInfo> {
	private final String LT_USER = DaoDbTable.USER_SNAPSHOT_TABLE;
	
	private DaoStmt<UserSnapInfo> stmtSql;
	private DaoStmtOption<UserSnapInfo> stmtOption;
	
	
	
	public UserSnapSelectSingle(Connection conn, UserSnapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, UserSnapInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_USER;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_USER);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new UserSnapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption);
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

	
	
	@Override public List<UserSnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<UserSnapInfo> getNewInstance() {
		return new UserSnapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<UserSnapInfo> {
		private final boolean NOT_NULL = false;
		
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<UserSnapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<UserSnapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				UserSnapInfo dataInfo = new UserSnapInfo();
				dataInfo.codOwner = stmtResult.getLong(UserSnapDbTableColumn.COL_COD_OWNER);
				dataInfo.codSnapshot = stmtResult.getLong(UserSnapDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codUser = stmtResult.getLong(UserSnapDbTableColumn.COL_COD_USER);									
				dataInfo.recordMode = stmtResult.getString(UserSnapDbTableColumn.COL_RECORD_MODE);
				
				stmtResult.getInt(UserSnapDbTableColumn.COL_COD_PERSON);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codPerson = stmtResult.getInt(UserSnapDbTableColumn.COL_COD_PERSON);
				
				Timestamp lastChanged = stmtResult.getTimestamp(UserSnapDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();	

				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
