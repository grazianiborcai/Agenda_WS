package br.com.gda.business.storeLeaveDate.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.dao.StoreDbTableColumn;
import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.common.SystemMessage;
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

class StolevateSelectTemplate implements DaoStmt<StolevateInfo> {	
	private final String LT_STORE_LEAVE_DATE = DaoDbTable.STORE_LD_TABLE;
	private final String RT_STORE = DaoDbTable.STORE_TABLE;
	
	private DaoStmt<StolevateInfo> stmtSql;
	private DaoStmtOption<StolevateInfo> stmtOption;
	
	
	
	public StolevateSelectTemplate(Connection conn, StolevateInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, StolevateInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_STORE_LEAVE_DATE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_STORE_LEAVE_DATE);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClauseHook(stmtOption.tableName, stmtOption.recordInfo);
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	protected String buildWhereClauseHook(String tableName, StolevateInfo recordInfo) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();		
		joins.add(buildJoinStore());
		return joins;
	}
	
	
	
	private DaoJoin buildJoinStore() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_STORE_LEAVE_DATE;
		oneColumn.leftColumnName = StolevateDbTableColumn.COL_COD_STORE;
		oneColumn.rightColumnName = StolevateDbTableColumn.COL_COD_STORE;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_STORE;
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

	
	
	@Override public List<StolevateInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<StolevateInfo> getNewInstance() {
		return new StolevateSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<StolevateInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<StolevateInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StolevateInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				StolevateInfo dataInfo = new StolevateInfo();
				dataInfo.codOwner = stmtResult.getLong(StolevateDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(StolevateDbTableColumn.COL_COD_STORE);
				dataInfo.description = stmtResult.getString(StolevateDbTableColumn.COL_DESCRIPTION);	
				dataInfo.codTimezone = stmtResult.getString(StolevateDbTableColumn.COL_COD_TIMEZONE);
				dataInfo.recordMode = stmtResult.getString(StolevateDbTableColumn.COL_RECORD_MODE);		
				
				
				Time tempTime = stmtResult.getTime(StolevateDbTableColumn.COL_TM_VALID_FROM);
				if (tempTime != null)
					dataInfo.timeValidFrom = tempTime.toLocalTime();
				
				
				tempTime = stmtResult.getTime(StolevateDbTableColumn.COL_TM_VALID_TO);
				if (tempTime != null)
					dataInfo.timeValidTo = tempTime.toLocalTime();	
				
				
				Date tempDate = stmtResult.getDate(StolevateDbTableColumn.COL_DT_VALID_FROM);
				if (tempDate != null)
					dataInfo.dateValidFrom = tempDate.toLocalDate();
				
				
				tempDate = stmtResult.getDate(StolevateDbTableColumn.COL_DT_VALID_TO);
				if (tempDate != null)
					dataInfo.dateValidTo = tempDate.toLocalDate();
				
				
				Timestamp lastChanged = stmtResult.getTimestamp(StolevateDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				
				stmtResult.getLong(StolevateDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(StoreDbTableColumn.COL_LAST_CHANGED_BY);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
