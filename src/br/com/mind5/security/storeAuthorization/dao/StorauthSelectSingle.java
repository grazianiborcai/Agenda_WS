package br.com.mind5.security.storeAuthorization.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinColumn;
import br.com.mind5.dao.DaoJoinType;
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
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;

public final class StorauthSelectSingle implements DaoStmt<StorauthInfo> {
	private final static String VIEW_STORE_AUTH = DaoDbTable.STORE_AUTH_VIEW;	
	private final static String LT_STORE = DaoDbTable.STORE_TABLE;	
	private final static String RT_OWNER = DaoDbTable.OWNER_TABLE;
	
	private DaoStmt<StorauthInfo> stmtSql;
	private DaoStmtOption_<StorauthInfo> stmtOption;
	
	
	
	public StorauthSelectSingle(Connection conn, StorauthInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, StorauthInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption_<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = LT_STORE;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(VIEW_STORE_AUTH);
		stmtOption.stmtParamTranslator = null;
		stmtOption.resultParser = new ResultParser();
		stmtOption.whereClause = buildWhereClause();
		stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StorauthWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();
		joins.add(buildJoinOwner());
		return joins;
	}
	
	
	
	private DaoJoin buildJoinOwner() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_STORE;
		oneColumn.leftColumnName = StorauthDbTableColumn.COL_COD_OWNER;
		oneColumn.rightColumnName = StorauthDbTableColumn.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_STORE;
		oneColumn.leftColumnName = StorauthDbTableColumn.COL_RECORD_MODE;
		oneColumn.rightColumnName = StorauthDbTableColumn.COL_RECORD_MODE;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_OWNER;
		join.joinType = DaoJoinType.INNER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
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

	
	
	@Override public List<StorauthInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<StorauthInfo> getNewInstance() {
		return new StorauthSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<StorauthInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<StorauthInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StorauthInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				StorauthInfo dataInfo = new StorauthInfo();
				dataInfo.codOwner = stmtResult.getLong(StorauthDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(StorauthDbTableColumn.COL_COD_STORE);
				dataInfo.recordMode = stmtResult.getString(StorauthDbTableColumn.COL_RECORD_MODE);	
				dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, StorauthDbTableColumn.COL_COD_USER);
		
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
