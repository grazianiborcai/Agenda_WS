package br.com.mind5.security.username.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.dao.obsolete.DaoResultParser_;
import br.com.mind5.dao.obsolete.DaoStmtOption_;
import br.com.mind5.security.username.info.UsernameInfo;

public final class UsernameSelectSingle implements DaoStmt<UsernameInfo> {
	private final String LT_USER = DaoDbTable.USER_TABLE;
	private final String VW_USERNAME = DaoDbTable.USERNAME_VIEW;
	
	private DaoStmt<UsernameInfo> stmtSql;
	private DaoStmtOption_<UsernameInfo> stmtOption;
	
	
	
	public UsernameSelectSingle(Connection conn, UsernameInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, UsernameInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_USER;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(VW_USERNAME);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new UsernameWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper_<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<UsernameInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<UsernameInfo> getNewInstance() {
		return new UsernameSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<UsernameInfo> {
		private final boolean NOT_NULL = false;		
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<UsernameInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<UsernameInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				UsernameInfo dataInfo = new UsernameInfo();
				dataInfo.codOwner = stmtResult.getLong(UsernameDbTableColumn.COL_COD_OWNER);
				dataInfo.codUser = stmtResult.getLong(UsernameDbTableColumn.COL_COD_USER);									
				dataInfo.recordMode = stmtResult.getString(UsernameDbTableColumn.COL_RECORD_MODE);
				dataInfo.username = stmtResult.getString(UsernameDbTableColumn.COL_USERNAME);
				dataInfo.codAuthGroup = stmtResult.getString(UsernameDbTableColumn.COL_COD_AUTH_GROUP);
				
				stmtResult.getString(UsernameDbTableColumn.COL_COD_USER_CATEG);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codUserCategory = stmtResult.getString(UsernameDbTableColumn.COL_COD_USER_CATEG).charAt(0);

				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
