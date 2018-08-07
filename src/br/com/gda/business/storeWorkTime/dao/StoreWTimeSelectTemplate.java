package br.com.gda.business.storeWorkTime.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.common.SystemMessage;
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

class StoreWTimeSelectTemplate implements DaoStmt<StoreWTimeInfo> {
	private final String LT_STORE_WORK_TIME = DaoDbTable.STORE_WT_TABLE;	
	private final String RT_WEEKDAY_TEXT = DaoDbTable.WEEKDAY_TEXT_TABLE;
	private final String RT_STORE = DaoDbTable.STORE_TABLE;
	
	private DaoStmt<StoreWTimeInfo> stmtSql;
	private DaoStmtOption<StoreWTimeInfo> stmtOption;
	
	
	
	public StoreWTimeSelectTemplate(Connection conn, StoreWTimeInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, StoreWTimeInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_STORE_WORK_TIME;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_STORE_WORK_TIME);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClauseHook(stmtOption.tableName, stmtOption.recordInfo);
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	protected String buildWhereClauseHook(String tableName, StoreWTimeInfo recordInfo) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();		
		joins.add(buildJoinStore());
		joins.add(buildJoinWeekdayText());
		return joins;
	}
	
	
	
	private DaoJoin buildJoinStore() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_STORE_WORK_TIME;
		oneColumn.leftColumnName = "Cod_store";
		oneColumn.rightColumnName = "Cod_store";
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_STORE;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
	}
	
	
	
	private DaoJoin buildJoinWeekdayText() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_STORE_WORK_TIME;
		oneColumn.leftColumnName = "weekday";
		oneColumn.rightColumnName = "Weekday";
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_WEEKDAY_TEXT;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RT_WEEKDAY_TEXT);
		
		return join;
	}
	
	
	
	private String buildJoinConstraintText(String rightTableName) {
		StringBuilder constrainClause = new StringBuilder(); 
		
		constrainClause.append(rightTableName);
		constrainClause.append(DaoDictionary.PERIOD);
		constrainClause.append("Language");
		constrainClause.append(DaoDictionary.SPACE);
		constrainClause.append(DaoDictionary.EQUAL);
		constrainClause.append(DaoDictionary.SPACE);
		constrainClause.append(DaoDictionary.QUOTE);
		constrainClause.append(this.stmtOption.recordInfo.codLanguage);
		constrainClause.append(DaoDictionary.QUOTE);
		
		return constrainClause.toString();
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

	
	
	@Override public List<StoreWTimeInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<StoreWTimeInfo> getNewInstance() {
		return new StoreWTimeSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<StoreWTimeInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final String WEEKDAY_TEXT_COL = DaoDbTable.WEEKDAY_TEXT_TABLE + "." + "Name";
		private final String TIMEZONE_COL = DaoDbTable.STORE_TABLE + "." + "Cod_timezone";
		
		@Override public List<StoreWTimeInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StoreWTimeInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				StoreWTimeInfo dataInfo = new StoreWTimeInfo();
				dataInfo.codOwner = stmtResult.getLong("cod_owner");
				dataInfo.codStore = stmtResult.getLong("cod_store");
				dataInfo.codWeekday = stmtResult.getInt("weekday");
				dataInfo.txtWeekday = stmtResult.getString(WEEKDAY_TEXT_COL);
				dataInfo.codTimezone = stmtResult.getString(TIMEZONE_COL);
				dataInfo.recordMode = stmtResult.getString("record_mode");		
				
				Time tempTime = stmtResult.getTime("begin_time");
				if (tempTime != null)
					dataInfo.beginTime = tempTime.toLocalTime();
				
				tempTime = stmtResult.getTime("end_time");
				if (tempTime != null)
					dataInfo.endTime = tempTime.toLocalTime();		
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
