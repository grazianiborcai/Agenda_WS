package br.com.gda.business.scheduleLine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public class SchedineUpdateSingle implements DaoStmt<SchedineInfo> {
	private DaoStmt<SchedineInfo> stmtSql;
	private DaoStmtOption<SchedineInfo> stmtOption;
	
	
	
	public SchedineUpdateSingle(Connection conn, SchedineInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, SchedineInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = DaoDbTable.SCHEDULE_TABLE;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(stmtOption.tableName);
		stmtOption.stmtParamTranslator = new ParamTranslator();
		stmtOption.resultParser = null;
		stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoWhereBuilderOption.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new SchedineWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper<>(DaoOperation.UPDATE, stmtOption);
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

	
	
	@Override public List<SchedineInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<SchedineInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, SchedineInfo recordInfo) throws SQLException {			
			
			int i = 1;
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOrder);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codMat);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployee);
			stmt.setDate(i++, DaoFormatter.localToSqlDate(recordInfo.date));
			stmt.setTime(i++, DaoFormatter.localToSqlTime(recordInfo.beginTime));
			stmt.setTime(i++, DaoFormatter.localToSqlTime(recordInfo.endTime));
			stmt.setTimestamp(i++, DaoFormatter.localToSqlTimestamp(recordInfo.lastChanged));	
			stmt.setString(i++, recordInfo.recordMode);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);			
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.day);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.weekMonth);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.weekYear);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.month);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.quarter);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.year);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codWeekday);
			stmt.setTimestamp(i++, DaoFormatter.localToSqlTimestamp(recordInfo.createdOn));	
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<SchedineInfo> getNewInstance() {
		return new SchedineUpdateSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
