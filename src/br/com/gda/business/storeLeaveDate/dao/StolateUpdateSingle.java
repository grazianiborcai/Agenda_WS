package br.com.gda.business.storeLeaveDate.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolateInfo;
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
import br.com.gda.dao.common.DaoOptionValue;

public final class StolateUpdateSingle implements DaoStmt<StolateInfo> {
	private DaoStmt<StolateInfo> stmtSql;
	private DaoStmtOption<StolateInfo> stmtOption;
	
	
	public StolateUpdateSingle(Connection conn, StolateInfo recordInfo, String schemaName) {
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
		this.stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new StolateWhereKey(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.UPDATE, this.stmtOption, this.getClass());
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
	
	
	
	@Override public DaoStmt<StolateInfo> getNewInstance() {
		return new StolateUpdateSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<StolateInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StolateInfo recordInfo) throws SQLException {
			Time endTime = DaoFormatter.localToSqlTime(recordInfo.timeValidTo);	
			Date endDate = DaoFormatter.localToSqlDate(recordInfo.dateValidTo);	
			Timestamp lastChanged = DaoFormatter.localToSqlTimestamp(recordInfo.lastChanged);
			
			int i = 1;
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
}
