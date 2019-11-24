package br.com.mind5.business.scheduleLineSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.obsolete.DaoResultParser_;
import br.com.mind5.dao.obsolete.DaoStmtOption_;

public class SchedinapInsertSingle implements DaoStmt<SchedinapInfo> {
	private DaoStmt<SchedinapInfo> stmtSql;
	private DaoStmtOption_<SchedinapInfo> stmtOption;
	
	
	
	public SchedinapInsertSingle(Connection conn, SchedinapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, SchedinapInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption_<>();
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
		stmtSql = new DaoStmtHelper_<>(DaoOperation.INSERT, stmtOption, this.getClass());
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
			stmt.setLong(i++, recordInfo.codSchedule);
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
			stmt.setTimestamp(i++, DaoFormatter.localToSqlTimestamp(recordInfo.createdOn));
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
			stmt.setString(i++, recordInfo.codScheduleStatus);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOrderItem);
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<SchedinapInfo> getNewInstance() {
		return new SchedinapInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<SchedinapInfo> {
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
