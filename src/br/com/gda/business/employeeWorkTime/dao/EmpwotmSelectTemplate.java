package br.com.gda.business.employeeWorkTime.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.dao.DaoJoin;
import br.com.gda.dao.DaoJoinType;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

class EmpwotmSelectTemplate implements DaoStmt<EmpwotmInfo> {
	private final String LT_EMPLOYEE_WORK_TIME = DaoDbTable.EMP_WT_TABLE;	
	private final String RT_LANGU = DaoDbTable.LANGUAGE_TABLE;
	
	private DaoStmt<EmpwotmInfo> stmtSql;
	private DaoStmtOption<EmpwotmInfo> stmtOption;
	
	
	
	public EmpwotmSelectTemplate(Connection conn, EmpwotmInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, EmpwotmInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_EMPLOYEE_WORK_TIME;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClauseHook(stmtOption.tableName, stmtOption.recordInfo);
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	protected String buildWhereClauseHook(String tableName, EmpwotmInfo recordInfo) {
		//Template method to be overridden by subclasses
		throw new IllegalStateException(SystemMessage.NO_TEMPLATE_IMPLEMENTATION);
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();		
		joins.add(buildJoinLanguage());		
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

	
	
	@Override public List<EmpwotmInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<EmpwotmInfo> getNewInstance() {
		return new EmpwotmSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements DaoResultParser<EmpwotmInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<EmpwotmInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<EmpwotmInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
				return finalResult;
		
			do {				
				EmpwotmInfo dataInfo = new EmpwotmInfo();
				dataInfo.codOwner = stmtResult.getLong(EmpwotmDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(EmpwotmDbTableColumn.COL_COD_STORE);
				dataInfo.codEmployee = stmtResult.getLong(EmpwotmDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codWeekday = stmtResult.getInt(EmpwotmDbTableColumn.COL_WEEKDAY);
				dataInfo.recordMode = stmtResult.getString(EmpwotmDbTableColumn.COL_RECORD_MODE);
				dataInfo.codLanguage = stmtResult.getString(EmpwotmDbTableColumn.COL_COD_LANGUAGE);	
				
				Time tempTime = stmtResult.getTime(EmpwotmDbTableColumn.COL_BEGIN_TIME);
				if (tempTime != null)
					dataInfo.beginTime = tempTime.toLocalTime();
				
				tempTime = stmtResult.getTime(EmpwotmDbTableColumn.COL_END_TIME);
				if (tempTime != null)
					dataInfo.endTime = tempTime.toLocalTime();		
				
				Timestamp lastChanged = stmtResult.getTimestamp(EmpwotmDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				stmtResult.getLong(EmpwotmDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(EmpwotmDbTableColumn.COL_LAST_CHANGED_BY);
				
				
				finalResult.add(dataInfo);				
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
