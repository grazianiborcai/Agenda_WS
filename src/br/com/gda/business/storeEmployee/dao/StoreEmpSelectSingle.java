package br.com.gda.business.storeEmployee.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.MasterDataDbTableColumn;
import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoDictionary;
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

public final class StoreEmpSelectSingle implements DaoStmt<StoreEmpInfo> {	
	private final String LT_STORE_EMPLOYEE = DaoDbTable.STORE_EMP_TABLE;	
	private final String RT_EMPLOYEE = DaoDbTable.EMP_TABLE;	
	private final String RT_STORE = DaoDbTable.STORE_TABLE;	
	private final String RT_POSITION_TEXT = DaoDbTable.POSITION_TEXT_TABLE;
	
	private DaoStmt<StoreEmpInfo> stmtSql;
	private DaoStmtOption<StoreEmpInfo> stmtOption;
	
	
	
	public StoreEmpSelectSingle(Connection conn, StoreEmpInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, StoreEmpInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_STORE_EMPLOYEE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_STORE_EMPLOYEE);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StoreEmpWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();		
		joins.add(buildJoinPositionText());		
		joins.add(buildJoinStore());	
		joins.add(buildJoinEmployee());
		return joins;
	}
	
	
	
	private DaoJoin buildJoinPositionText() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_STORE_EMPLOYEE;
		oneColumn.leftColumnName = StoreEmpDbTableColumn.COL_COD_POSITION_STORE;
		oneColumn.rightColumnName = MasterDataDbTableColumn.COL_COD_POSITION;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_POSITION_TEXT;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RT_POSITION_TEXT);
		
		return join;
	}
	
	
	
	private String buildJoinConstraintText(String rightTableName) {
		StringBuilder constrainClause = new StringBuilder(); 
		
		constrainClause.append(rightTableName);
		constrainClause.append(DaoDictionary.PERIOD);
		constrainClause.append(MasterDataDbTableColumn.COL_COD_LANGUAGE);
		constrainClause.append(DaoDictionary.SPACE);
		constrainClause.append(DaoDictionary.EQUAL);
		constrainClause.append(DaoDictionary.SPACE);
		constrainClause.append(DaoDictionary.QUOTE);
		constrainClause.append(this.stmtOption.recordInfo.codLanguage);
		constrainClause.append(DaoDictionary.QUOTE);
		
		return constrainClause.toString();
	}
	
	
	
	private DaoJoin buildJoinStore() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		DaoJoinColumn oneColumn;
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_STORE_EMPLOYEE;
		oneColumn.leftColumnName = StoreEmpDbTableColumn.COL_COD_OWNER;
		oneColumn.rightColumnName = StoreEmpDbTableColumn.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_STORE_EMPLOYEE;
		oneColumn.leftColumnName = StoreEmpDbTableColumn.COL_COD_STORE;
		oneColumn.rightColumnName = StoreEmpDbTableColumn.COL_COD_STORE;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_STORE;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
	}
	
	
	private DaoJoin buildJoinEmployee() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		DaoJoinColumn oneColumn;
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_STORE_EMPLOYEE;
		oneColumn.leftColumnName = StoreEmpDbTableColumn.COL_COD_OWNER;
		oneColumn.rightColumnName = StoreEmpDbTableColumn.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_STORE_EMPLOYEE;
		oneColumn.leftColumnName = StoreEmpDbTableColumn.COL_COD_EMPLOYEE;
		oneColumn.rightColumnName = StoreEmpDbTableColumn.COL_COD_EMPLOYEE;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_EMPLOYEE;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
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

	
	
	@Override public List<StoreEmpInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<StoreEmpInfo> getNewInstance() {
		return new StoreEmpSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<StoreEmpInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final String COL_POSITION_TEXT = DaoDbTable.POSITION_TEXT_TABLE + "." + StoreEmpDbTableColumn.COL_NAME;
		private final String COL_STORE_NAME = DaoDbTable.STORE_TABLE + "." + StoreEmpDbTableColumn.COL_NAME;
		private final String COL_EMPLOYEE_NAME = DaoDbTable.EMP_TABLE + "." + StoreEmpDbTableColumn.COL_NAME;
		
		@Override public List<StoreEmpInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StoreEmpInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				StoreEmpInfo dataInfo = new StoreEmpInfo();
				dataInfo.codOwner = stmtResult.getLong(StoreEmpDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(StoreEmpDbTableColumn.COL_COD_STORE);
				dataInfo.codEmployee = stmtResult.getLong(StoreEmpDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codPositionStore = stmtResult.getLong(StoreEmpDbTableColumn.COL_COD_POSITION_STORE);
				dataInfo.txtPositionStore = stmtResult.getString(COL_POSITION_TEXT);
				dataInfo.nameStore = stmtResult.getString(COL_STORE_NAME);	
				dataInfo.nameEmployee = stmtResult.getString(COL_EMPLOYEE_NAME);	
				dataInfo.recordMode = stmtResult.getString(StoreEmpDbTableColumn.COL_RECORD_MODE);							
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
