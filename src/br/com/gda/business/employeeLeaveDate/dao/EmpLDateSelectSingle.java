package br.com.gda.business.employeeLeaveDate.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
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

public final class EmpLDateSelectSingle implements DaoStmt<EmpLDateInfo> {
	private final String LT_EMPLOYEE_LEAVE_DATE = DaoDbTable.EMP_LD_TABLE;	
	private final String RT_STORE = DaoDbTable.STORE_TABLE;
	
	private DaoStmt<EmpLDateInfo> stmtSql;
	private DaoStmtOption<EmpLDateInfo> stmtOption;
	
	
	
	public EmpLDateSelectSingle(Connection conn, EmpLDateInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, EmpLDateInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_EMPLOYEE_LEAVE_DATE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
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
		
		DaoStmtWhere whereClause = new EmpLDateWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();		
		joins.add(buildJoinStore());		
		return joins;
	}
	
	
	
	private DaoJoin buildJoinStore() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_EMPLOYEE_LEAVE_DATE;
		oneColumn.leftColumnName = "cod_store";
		oneColumn.rightColumnName = "Cod_store";
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

	
	
	@Override public List<EmpLDateInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<EmpLDateInfo> getNewInstance() {
		return new EmpLDateSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements DaoResultParser<EmpLDateInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final String TIMEZONE_COL = DaoDbTable.STORE_TABLE + "." + "Cod_timezone";
		
		@Override public List<EmpLDateInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<EmpLDateInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
				return finalResult;
		
			do {				
				EmpLDateInfo dataInfo = new EmpLDateInfo();
				dataInfo.codOwner = stmtResult.getLong("cod_owner");
				dataInfo.codStore = stmtResult.getLong("cod_store");
				dataInfo.codEmployee = stmtResult.getLong("cod_employee");
				dataInfo.codTimezone = stmtResult.getString(TIMEZONE_COL);
				dataInfo.recordMode = stmtResult.getString("record_mode");	
				dataInfo.description = stmtResult.getString("description");	
				
				Time tempTime = stmtResult.getTime("time_valid_from");
				if (tempTime != null)
					dataInfo.timeValidFrom = tempTime.toLocalTime();
				
				tempTime = stmtResult.getTime("time_valid_to");
				if (tempTime != null)
					dataInfo.timeValidTo = tempTime.toLocalTime();	
				
				Date tempDate = stmtResult.getDate("date_valid_from");
				if (tempDate != null)
					dataInfo.dateValidFrom = tempDate.toLocalDate();
				
				tempDate = stmtResult.getDate("date_valid_to");
				if (tempDate != null)
					dataInfo.dateValidTo = tempDate.toLocalDate();		
				
				finalResult.add(dataInfo);				
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
