package br.com.gda.security.userPassword.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.security.userPassword.info.UpswdInfo;

public final class UpswdSelectSingle implements DaoStmt<UpswdInfo> {	
	private final String LT_USER_PSWRD = DaoDbTable.USER_PASSWORD_TABLE;
	
	private DaoStmt<UpswdInfo> stmtSql;
	private DaoStmtOption<UpswdInfo> stmtOption;
	
	
	
	public UpswdSelectSingle(Connection conn, UpswdInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, UpswdInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_USER_PSWRD;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_USER_PSWRD);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new UpswdWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<UpswdInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<UpswdInfo> getNewInstance() {
		return new UpswdSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<UpswdInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<UpswdInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<UpswdInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				UpswdInfo dataInfo = new UpswdInfo();
				dataInfo.codOwner = stmtResult.getLong(UpswdDbTableColumn.COL_COD_OWNER);
				dataInfo.codUser = stmtResult.getLong(UpswdDbTableColumn.COL_COD_USER);
				
				stmtResult.getString(UpswdDbTableColumn.COL_PASSWORD);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.hash = Base64.getDecoder().decode(stmtResult.getString(UpswdDbTableColumn.COL_PASSWORD));	
				
				
				stmtResult.getString(UpswdDbTableColumn.COL_SALT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.salt = Base64.getDecoder().decode(stmtResult.getString(UpswdDbTableColumn.COL_SALT));	
				
				
				Timestamp lastChanged = stmtResult.getTimestamp(UpswdDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
