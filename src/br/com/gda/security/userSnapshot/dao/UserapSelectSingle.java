package br.com.gda.security.userSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;
import br.com.gda.security.userSnapshot.info.UserapInfo;

public final class UserapSelectSingle implements DaoStmt<UserapInfo> {
	private final String LT_USER = DaoDbTable.USER_SNAPSHOT_TABLE;
	
	private DaoStmt<UserapInfo> stmtSql;
	private DaoStmtOption<UserapInfo> stmtOption;
	
	
	
	public UserapSelectSingle(Connection conn, UserapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, UserapInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new UserapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<UserapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<UserapInfo> getNewInstance() {
		return new UserapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<UserapInfo> {
		private final boolean NOT_NULL = false;
		
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<UserapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<UserapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				UserapInfo dataInfo = new UserapInfo();
				dataInfo.codOwner = stmtResult.getLong(UserapDbTableColumn.COL_COD_OWNER);
				dataInfo.codUser = stmtResult.getLong(UserapDbTableColumn.COL_COD_USER);									
				dataInfo.recordMode = stmtResult.getString(UserapDbTableColumn.COL_RECORD_MODE);
				dataInfo.username = stmtResult.getString(UserapDbTableColumn.COL_USERNAME);
				dataInfo.codAuthGroup = stmtResult.getString(UserapDbTableColumn.COL_COD_AUTH_GROUP);
				
				stmtResult.getLong(UserapDbTableColumn.COL_COD_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codSnapshot = stmtResult.getLong(UserapDbTableColumn.COL_COD_SNAPSHOT);
				
				
				stmtResult.getLong(UserapDbTableColumn.COL_COD_PERSON);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codPerson = stmtResult.getLong(UserapDbTableColumn.COL_COD_PERSON);
				
				
				stmtResult.getLong(UserapDbTableColumn.COL_COD_PERSON_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codPersonSnapshot = stmtResult.getLong(UserapDbTableColumn.COL_COD_PERSON_SNAPSHOT);
				
				
				stmtResult.getString(UserapDbTableColumn.COL_COD_USER_CATEG);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codUserCategory = stmtResult.getString(UserapDbTableColumn.COL_COD_USER_CATEG).charAt(0);
				
				
				stmtResult.getLong(UserapDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(UserapDbTableColumn.COL_LAST_CHANGED_BY);
				
				
				Timestamp lastChanged = stmtResult.getTimestamp(UserapDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();	

				
				finalResult.add(dataInfo);				
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
