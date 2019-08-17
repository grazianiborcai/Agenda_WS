package br.com.gda.business.scheduleLineSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public class SchedinapInsertSingle implements DaoStmt<SchedinapInfo> {
	private DaoStmt<SchedinapInfo> stmtSql;
	private DaoStmtOption<SchedinapInfo> stmtOption;
	
	
	
	public SchedinapInsertSingle(Connection conn, SchedinapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, SchedinapInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = DaoDbTable.SCHEDULE_SNAPSHOT_TABLE;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(stmtOption.tableName);
		stmtOption.stmtParamTranslator = new ParamTranslator();
		stmtOption.resultParser = new ResultParser(recordInfo);
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

	
	
	@Override public List<SchedinapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<SchedinapInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, SchedinapInfo recordInfo) throws SQLException {			
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOrder);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codMat);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployee);
			stmt.setDate(i++, DaoFormatter.localToSqlDate(recordInfo.date));
			stmt.setTime(i++, DaoFormatter.localToSqlTime(recordInfo.beginTime));
			stmt.setTime(i++, DaoFormatter.localToSqlTime(recordInfo.endTime));
			stmt.setTimestamp(i++, DaoFormatter.localToSqlTimestamp(recordInfo.lastChanged));		
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStoreSnapshot);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codMatSnapshot);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployeeSnapshot);
			stmt.setString(i++, recordInfo.recordMode);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUserSnapshot);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomerSnapshot);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);			
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.day);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.weekMonth);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.weekYear);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.month);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.quarter);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.year);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codWeekday);
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<SchedinapInfo> getNewInstance() {
		return new SchedinapInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<SchedinapInfo> {
		private SchedinapInfo recordInfo;
		
		public ResultParser(SchedinapInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<SchedinapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<SchedinapInfo> finalResult = new ArrayList<>();
			recordInfo.codSnapshot = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
