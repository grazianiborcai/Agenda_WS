package br.com.gda.business.schedule.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public class ScheduInsertSingle implements DaoStmt<ScheduInfo> {
	private DaoStmt<ScheduInfo> stmtSql;
	private DaoStmtOption<ScheduInfo> stmtOption;
	
	
	
	public ScheduInsertSingle(Connection conn, ScheduInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, ScheduInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = DaoDbTable.SCHEDULE_TABLE;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(stmtOption.tableName);
		stmtOption.stmtParamTranslator = new ParamTranslator();
		stmtOption.resultParser = null;
		stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper<>(DaoOperation.INSERT, stmtOption);
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

	
	
	@Override public List<ScheduInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<ScheduInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, ScheduInfo recordInfo) throws SQLException {			
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codOrder);
			
			
			if (recordInfo.codStore >= 0) {
				stmt.setLong(i++, recordInfo.codStore);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codMat >= 0) {
				stmt.setLong(i++, recordInfo.codMat);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			if (recordInfo.codEmployee >= 0) {
				stmt.setLong(i++, recordInfo.codEmployee);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			stmt.setDate(i++, DaoFormatter.localToSqlDate(recordInfo.date));
			stmt.setTime(i++, DaoFormatter.localToSqlTime(recordInfo.beginTime));
			stmt.setTime(i++, DaoFormatter.localToSqlTime(recordInfo.endTime));
			stmt.setTimestamp(i++, DaoFormatter.localToSqlTimestamp(recordInfo.lastChanged));		
			
			
			if (recordInfo.codStoreSnapshot >= 0) {
				stmt.setLong(i++, recordInfo.codStoreSnapshot);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codMatSnapshot >= 0) {
				stmt.setLong(i++, recordInfo.codMatSnapshot);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codEmployeeSnapshot >= 0) {
				stmt.setLong(i++, recordInfo.codEmployeeSnapshot);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			stmt.setString(i++, recordInfo.recordMode);
			
			
			if (recordInfo.codUser >= 0) {
				stmt.setLong(i++, recordInfo.codUser);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codUserSnapshot >= 0) {
				stmt.setLong(i++, recordInfo.codUserSnapshot);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codCustomer >= 0) {
				stmt.setLong(i++, recordInfo.codCustomer);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codCustomerSnapshot >= 0) {
				stmt.setLong(i++, recordInfo.codCustomerSnapshot);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.lastChangedBy >= 0) {
				stmt.setLong(i++, recordInfo.lastChangedBy);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			stmt.setString(i++, recordInfo.recordMode);

			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<ScheduInfo> getNewInstance() {
		return new ScheduInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
