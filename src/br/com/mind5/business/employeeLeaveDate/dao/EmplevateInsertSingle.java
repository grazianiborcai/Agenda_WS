package br.com.mind5.business.employeeLeaveDate.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

public final class EmplevateInsertSingle implements DaoStmt<EmplevateInfo> {
	private DaoStmt<EmplevateInfo> stmtSql;
	private DaoStmtOption<EmplevateInfo> stmtOption;
	
	
	
	public EmplevateInsertSingle(Connection conn, EmplevateInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, EmplevateInfo recordInfo, String schemaName) {
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
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.INSERT, this.stmtOption, this.getClass());
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
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<EmplevateInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, EmplevateInfo recordInfo) throws SQLException {
			Time beginTime = DaoFormatter.localToSqlTime(recordInfo.timeValidFrom);
			Time endTime = DaoFormatter.localToSqlTime(recordInfo.timeValidTo);				
			Date beginDate = DaoFormatter.localToSqlDate(recordInfo.dateValidFrom);
			Date endDate = DaoFormatter.localToSqlDate(recordInfo.dateValidTo);	
			Timestamp lastChanged = DaoFormatter.localToSqlTimestamp(recordInfo.lastChanged);
			
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
			stmt.setTimestamp(i++, lastChanged);
			
			if (recordInfo.lastChangedBy >= 0) {
				stmt.setLong(i++, recordInfo.lastChangedBy);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<EmplevateInfo> getNewInstance() {
		return new EmplevateInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
