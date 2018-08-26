package br.com.gda.business.employeeLeaveDate.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;

public final class EmpLDateInsertSingle implements DaoStmt<EmpLDateInfo> {
	private DaoStmt<EmpLDateInfo> stmtSql;
	private DaoStmtOption<EmpLDateInfo> stmtOption;
	
	
	
	public EmpLDateInsertSingle(Connection conn, EmpLDateInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, EmpLDateInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.EMP_LD_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = null;
		this.stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.INSERT, this.stmtOption);
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
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<EmpLDateInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, EmpLDateInfo recordInfo) throws SQLException {
			Time beginTime = DaoFormatter.localToSqlTime(recordInfo.timeValidFrom);
			Time endTime = DaoFormatter.localToSqlTime(recordInfo.timeValidTo);				
			Date beginDate = DaoFormatter.localToSqlDate(recordInfo.dateValidFrom);
			Date endDate = DaoFormatter.localToSqlDate(recordInfo.dateValidTo);	
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codStore);
			stmt.setLong(i++, recordInfo.codEmployee);
			stmt.setDate(i++, beginDate);
			stmt.setTime(i++, beginTime);
			stmt.setDate(i++, endDate);
			stmt.setTime(i++, endTime);
			stmt.setString(i++, recordInfo.description);
			stmt.setString(i++, recordInfo.recordMode);
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<EmpLDateInfo> getNewInstance() {
		return new EmpLDateInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
