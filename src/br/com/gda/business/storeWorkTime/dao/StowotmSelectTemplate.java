package br.com.gda.business.storeWorkTime.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.dao.StoreDbTableColumn;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.dao.DaoDictionary;
import br.com.gda.dao.DaoJoin;
import br.com.gda.dao.DaoJoinColumn;
import br.com.gda.dao.DaoJoinType;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

class StowotmSelectTemplate implements DaoStmt<StowotmInfo> {
	private final String LT_STORE_WORK_TIME = DaoDbTable.STORE_WT_TABLE;	
	private final String RT_WEEKDAY_TEXT = DaoDbTable.WEEKDAY_TEXT_TABLE;
	private final String RT_STORE = DaoDbTable.STORE_TABLE;
	
	private DaoStmt<StowotmInfo> stmtSql;
	private DaoStmtOption<StowotmInfo> stmtOption;
	
	
	
	public StowotmSelectTemplate(Connection conn, StowotmInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, StowotmInfo recordInfo, String schemaName) {
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
	
	
	
	protected String buildWhereClauseHook(String tableName, StowotmInfo recordInfo) {
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
		oneColumn.leftColumnName = StowotmDbTableColumn.COL_COD_STORE;
		oneColumn.rightColumnName = StowotmDbTableColumn.COL_COD_STORE;
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
		oneColumn.leftColumnName = StowotmDbTableColumn.COL_COD_WEEKDAY;
		oneColumn.rightColumnName = StowotmDbTableColumn.COL_COD_WEEKDAY;
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
		constrainClause.append(StowotmDbTableColumn.COL_COD_LANGUAGE);
		constrainClause.append(DaoDictionary.SPACE);
		constrainClause.append(DaoDictionary.EQUAL);
		constrainClause.append(DaoDictionary.SPACE);
		constrainClause.append(DaoDictionary.QUOTE);
		constrainClause.append(this.stmtOption.recordInfo.codLanguage);
		constrainClause.append(DaoDictionary.QUOTE);
		
		return constrainClause.toString();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<StowotmInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<StowotmInfo> getNewInstance() {
		return new StowotmSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<StowotmInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<StowotmInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StowotmInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				StowotmInfo dataInfo = new StowotmInfo();
				dataInfo.codOwner = stmtResult.getLong(StowotmDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(StowotmDbTableColumn.COL_COD_STORE);
				dataInfo.codWeekday = stmtResult.getInt(StowotmDbTableColumn.COL_COD_WEEKDAY);
				dataInfo.txtWeekday = stmtResult.getString(StowotmDbTableColumn.COL_NAME);
				dataInfo.codTimezone = stmtResult.getString(StowotmDbTableColumn.COL_COD_TIME_ZONE);
				dataInfo.recordMode = stmtResult.getString(StowotmDbTableColumn.COL_RECORD_MODE);	
				
				stmtResult.getString(StowotmDbTableColumn.COL_COD_LANGUAGE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codLanguage = stmtResult.getString(StowotmDbTableColumn.COL_COD_LANGUAGE);
				
				
				Time tempTime = stmtResult.getTime(StowotmDbTableColumn.COL_BEGIN_TIME);
				if (tempTime != null)
					dataInfo.beginTime = tempTime.toLocalTime();
				
				
				tempTime = stmtResult.getTime(StowotmDbTableColumn.COL_END_TIME);
				if (tempTime != null)
					dataInfo.endTime = tempTime.toLocalTime();		
				
				
				Timestamp lastChanged = stmtResult.getTimestamp(StoreDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				
				stmtResult.getLong(StoreDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(StoreDbTableColumn.COL_LAST_CHANGED_BY);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
