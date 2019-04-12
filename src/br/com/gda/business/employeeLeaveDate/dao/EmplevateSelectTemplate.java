package br.com.gda.business.employeeLeaveDate.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmplevateInfo;
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

class EmplevateSelectTemplate implements DaoStmt<EmplevateInfo> {
	private final String LT_ELT = DaoDbTable.EMP_LD_TABLE;	
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
		this.stmtOption.tableName = LT_ELT;
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
		joins.add(buildJoinStore());		
		return joins;
	}
	
	
	
	private DaoJoin buildJoinStore() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_ELT;
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

	
	
	@Override public List<EmplevateInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<EmplevateInfo> getNewInstance() {
		return new EmplevateSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements DaoResultParser<EmplevateInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final String TIMEZONE_COL = DaoDbTable.STORE_TABLE + "." + EmplevateDbTableColumn.COL_COD_TIMEZONE;
		
		@Override public List<EmplevateInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<EmplevateInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
				return finalResult;
		
			do {				
				EmplevateInfo dataInfo = new EmplevateInfo();
				dataInfo.codOwner = stmtResult.getLong(EmplevateDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(EmplevateDbTableColumn.COL_COD_STORE);
				dataInfo.codEmployee = stmtResult.getLong(EmplevateDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codTimezone = stmtResult.getString(TIMEZONE_COL);
				dataInfo.recordMode = stmtResult.getString(EmplevateDbTableColumn.COL_RECORD_MODE);	
				dataInfo.description = stmtResult.getString(EmplevateDbTableColumn.COL_DESCRIPTION);	
				
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
				
				finalResult.add(dataInfo);				
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
