package br.com.gda.business.ownerStore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.dao.DaoJoin;
import br.com.gda.dao.DaoJoinColumn;
import br.com.gda.dao.DaoJoinType;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class OwntoreSelectSingle implements DaoStmt<OwntoreInfo> {
	private final static String VIEW_OWNER_STORE = DaoDbTable.OWNER_STORE_VIEW;	
	private final static String LT_STORE = DaoDbTable.STORE_TABLE;	
	private final static String RT_OWNER = DaoDbTable.OWNER_TABLE;	
	private final String RT_LANGU = DaoDbTable.LANGUAGE_TABLE;
	
	private DaoStmt<OwntoreInfo> stmtSql;
	private DaoStmtOption<OwntoreInfo> stmtOption;
	
	
	
	public OwntoreSelectSingle(Connection conn, OwntoreInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, OwntoreInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = LT_STORE;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(VIEW_OWNER_STORE);
		stmtOption.stmtParamTranslator = null;
		stmtOption.resultParser = new ResultParser();
		stmtOption.whereClause = buildWhereClause();
		stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new OwntoreWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();		
		joins.add(buildJoinLanguage());		
		joins.add(buildJoinOwner());
		return joins;
	}
	
	
	
	private DaoJoin buildJoinLanguage() {
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_LANGU;
		join.joinType = DaoJoinType.CROSS_JOIN;
		join.joinColumns = null;
		join.constraintClause = null;
		
		return join;
	}
	
	
	
	private DaoJoin buildJoinOwner() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_STORE;
		oneColumn.leftColumnName = OwntoreDbTableColumn.COL_COD_OWNER;
		oneColumn.rightColumnName = OwntoreDbTableColumn.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_STORE;
		oneColumn.leftColumnName = OwntoreDbTableColumn.COL_RECORD_MODE;
		oneColumn.rightColumnName = OwntoreDbTableColumn.COL_RECORD_MODE;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_OWNER;
		join.joinType = DaoJoinType.INNER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
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

	
	
	@Override public List<OwntoreInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<OwntoreInfo> getNewInstance() {
		return new OwntoreSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<OwntoreInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<OwntoreInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<OwntoreInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				OwntoreInfo dataInfo = new OwntoreInfo();
				dataInfo.codOwner = stmtResult.getLong(OwntoreDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(OwntoreDbTableColumn.COL_COD_STORE);
				dataInfo.recordMode = stmtResult.getString(OwntoreDbTableColumn.COL_RECORD_MODE);	
				
				
				stmtResult.getLong(OwntoreDbTableColumn.COL_COD_USER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codUser = stmtResult.getLong(OwntoreDbTableColumn.COL_COD_USER);
				
				
				stmtResult.getString(OwntoreDbTableColumn.COL_COD_LANGUAGE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codLanguage = stmtResult.getString(OwntoreDbTableColumn.COL_COD_LANGUAGE);
		
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
