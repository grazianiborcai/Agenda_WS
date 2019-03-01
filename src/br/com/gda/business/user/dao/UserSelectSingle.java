package br.com.gda.business.user.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.dao.OwnerDbTableColumn;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

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
		private final boolean NOT_NULL = false;		
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
				
				stmtResult.getLong(UserDbTableColumn.COL_COD_PERSON);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codPerson = stmtResult.getLong(UserDbTableColumn.COL_COD_PERSON);
				
				
				stmtResult.getString(UserDbTableColumn.COL_COD_USER_CATEG);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codUserCategory = stmtResult.getString(UserDbTableColumn.COL_COD_USER_CATEG).charAt(0);
				
				
				stmtResult.getLong(OwnerDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(OwnerDbTableColumn.COL_LAST_CHANGED_BY);
				
				
				Timestamp lastChanged = stmtResult.getTimestamp(UserDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();	

				
				finalResult.add(dataInfo);				
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
