package br.com.gda.business.masterData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class AuthGrRoleSelectSingle implements DaoStmt<AuthGrRoleInfo> {	
	private final String LT_AUTH_GROUP_ROLE = DaoDbTable.AUTH_GROUP_ROLE_TABLE;
	
	private DaoStmt<AuthGrRoleInfo> stmtSql;
	private DaoStmtOption<AuthGrRoleInfo> stmtOption;
	
	
	
	public AuthGrRoleSelectSingle(Connection conn, AuthGrRoleInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, AuthGrRoleInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_AUTH_GROUP_ROLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_AUTH_GROUP_ROLE);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new AuthGrRoleWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<AuthGrRoleInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<AuthGrRoleInfo> getNewInstance() {
		return new AuthGrRoleSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<AuthGrRoleInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<AuthGrRoleInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<AuthGrRoleInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				AuthGrRoleInfo dataInfo = new AuthGrRoleInfo();
				dataInfo.codAuthRole = stmtResult.getString(MasterDataDbTableColumn.COL_COD_AUTH_ROLE);
				dataInfo.codAuthGroup = stmtResult.getString(MasterDataDbTableColumn.COL_COD_AUTH_GROUP);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
