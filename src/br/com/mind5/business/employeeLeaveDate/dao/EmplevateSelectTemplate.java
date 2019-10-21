package br.com.mind5.business.employeeLeaveDate.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinColumn;
import br.com.mind5.dao.DaoJoinType;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

class EmplevateSelectTemplate implements DaoStmt<EmplevateInfo> {
	private final String LT_EMP_LD = DaoDbTable.EMP_LD_TABLE;	
	private final String RT_LANGU = DaoDbTable.LANGUAGE_TABLE;
	private final String RT_STORE = DaoDbTable.STORE_TABLE;
	
	private DaoStmt<EmplevateInfo> stmtSql;
	private DaoStmtOption<EmplevateInfo> stmtOption;
	
	
	
	public EmplevateSelectTemplate(Connection conn, EmplevateInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, EmplevateInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_EMP_LD;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClauseHook(stmtOption.tableName, stmtOption.recordInfo);
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	protected String buildWhereClauseHook(String tableName, EmplevateInfo recordInfo) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();		
		joins.add(buildJoinLanguage());	
		joins.add(buildJoinStore());		
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
	
	
	
	private DaoJoin buildJoinStore() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_EMP_LD;
		oneColumn.leftColumnName = EmplevateDbTableColumn.COL_COD_OWNER;
		oneColumn.rightColumnName = EmplevateDbTableColumn.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn.leftTableName = LT_EMP_LD;
		oneColumn.leftColumnName = EmplevateDbTableColumn.COL_COD_STORE;
		oneColumn.rightColumnName = EmplevateDbTableColumn.COL_COD_STORE;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_STORE;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
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

	
	
	@Override public List<EmplevateInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<EmplevateInfo> getNewInstance() {
		return new EmplevateSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements DaoResultParser<EmplevateInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<EmplevateInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<EmplevateInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
		
			do {				
				EmplevateInfo dataInfo = new EmplevateInfo();
				dataInfo.codOwner = stmtResult.getLong(EmplevateDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(EmplevateDbTableColumn.COL_COD_STORE);
				dataInfo.codEmployee = stmtResult.getLong(EmplevateDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codTimezone = stmtResult.getString(EmplevateDbTableColumn.COL_COD_TIMEZONE);
				dataInfo.recordMode = stmtResult.getString(EmplevateDbTableColumn.COL_RECORD_MODE);	
				dataInfo.description = stmtResult.getString(EmplevateDbTableColumn.COL_DESCRIPTION);	
				dataInfo.codLanguage = stmtResult.getString(EmplevateDbTableColumn.COL_COD_LANGUAGE);	
				
				Time tempTime = stmtResult.getTime(EmplevateDbTableColumn.COL_TM_VALID_FROM);
				if (tempTime != null)
					dataInfo.timeValidFrom = tempTime.toLocalTime();
				
				tempTime = stmtResult.getTime(EmplevateDbTableColumn.COL_TM_VALID_TO);
				if (tempTime != null)
					dataInfo.timeValidTo = tempTime.toLocalTime();	
				
				Date tempDate = stmtResult.getDate(EmplevateDbTableColumn.COL_DT_VALID_FROM);
				if (tempDate != null)
					dataInfo.dateValidFrom = tempDate.toLocalDate();
				
				tempDate = stmtResult.getDate(EmplevateDbTableColumn.COL_DT_VALID_TO);
				if (tempDate != null)
					dataInfo.dateValidTo = tempDate.toLocalDate();		
				
				Timestamp lastChanged = stmtResult.getTimestamp(EmplevateDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				stmtResult.getLong(EmplevateDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(EmplevateDbTableColumn.COL_LAST_CHANGED_BY);
				
				finalResult.add(dataInfo);				
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
