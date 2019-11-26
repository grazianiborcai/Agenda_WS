package br.com.mind5.message.emailBody.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.dao.obsolete.DaoResultParser_;
import br.com.mind5.dao.obsolete.DaoStmtOption_;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class EmabodySelectSingle implements DaoStmt<EmabodyInfo> {
	private final String MAIN_TABLE = DaoDbTable.SYS_EMAIL_BODY_TABLE;	
	
	private DaoStmt<EmabodyInfo> stmtSql;
	private DaoStmtOption_<EmabodyInfo> stmtOption;
	
	
	
	public EmabodySelectSingle(Connection conn, EmabodyInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, EmabodyInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = MAIN_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(MAIN_TABLE);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new EmabodyWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper_<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<EmabodyInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<EmabodyInfo> getNewInstance() {
		return new EmabodySelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<EmabodyInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<EmabodyInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<EmabodyInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				EmabodyInfo dataInfo = new EmabodyInfo();
				dataInfo.codBody = stmtResult.getString(EmabodyDbTableColumn.COL_COD_BODY);
				dataInfo.txtbody = stmtResult.getString(EmabodyDbTableColumn.COL_TXT_BODY);
				dataInfo.subject = stmtResult.getString(EmabodyDbTableColumn.COL_SUBJECT);
				dataInfo.codLanguage = stmtResult.getString(EmabodyDbTableColumn.COL_COD_LANGUAGE);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
