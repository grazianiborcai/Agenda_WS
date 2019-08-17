package br.com.gda.security.user.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;
import br.com.gda.security.user.info.UserInfo;

public final class UserSelectSingle implements DaoStmt<UserInfo> {
	private final String LT_USER = DaoDbTable.USER_TABLE;
	
	private DaoStmt<UserInfo> stmtSql;
	private DaoStmtOption<UserInfo> stmtOption;
	
	
	
	public UserSelectSingle(Connection conn, UserInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, UserInfo recordInfo, String schemaName) {
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
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new UserWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<UserInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<UserInfo> getNewInstance() {
		return new UserSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<UserInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<UserInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<UserInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				UserInfo dataInfo = new UserInfo();
				dataInfo.codOwner = stmtResult.getLong(UserDbTableColumn.COL_COD_OWNER);
				dataInfo.codUser = stmtResult.getLong(UserDbTableColumn.COL_COD_USER);									
				dataInfo.recordMode = stmtResult.getString(UserDbTableColumn.COL_RECORD_MODE);
				dataInfo.username = stmtResult.getString(UserDbTableColumn.COL_USERNAME);
				dataInfo.codAuthGroup = stmtResult.getString(UserDbTableColumn.COL_COD_AUTH_GROUP);
				dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, UserDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, UserDbTableColumn.COL_COD_PERSON);
				dataInfo.codPersonSnapshot = DaoFormatter.sqlToLong(stmtResult, UserDbTableColumn.COL_COD_PERSON_SNAPSHOT);
				dataInfo.codUserCategory = DaoFormatter.sqlToChar(stmtResult, UserDbTableColumn.COL_COD_USER_CATEG);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, UserDbTableColumn.COL_LAST_CHANGED_BY);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, UserDbTableColumn.COL_LAST_CHANGED);
				
				finalResult.add(dataInfo);				
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
