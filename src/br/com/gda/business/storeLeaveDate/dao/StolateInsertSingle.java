package br.com.gda.business.storeLeaveDate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class StolateInsertSingle implements DaoStmt<StolateInfo> {
	private DaoStmt<StolateInfo> stmtSql;
	private DaoStmtOption<StolateInfo> stmtOption;
	
	
	
	public StolateInsertSingle(Connection conn, StolateInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, StolateInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.STORE_LD_TABLE;
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

	
	
	@Override public List<StolateInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<StolateInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StolateInfo recordInfo) throws SQLException {			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codStore);
			stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.dateValidFrom);
			stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.timeValidFrom);
			stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.dateValidTo);
			stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.timeValidTo);
			stmt.setString(i++, recordInfo.description);
			stmt.setString(i++, recordInfo.recordMode);
			stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.monthValidFrom);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.yearValidFrom);
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<StolateInfo> getNewInstance() {
		return new StolateInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
