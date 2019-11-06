package br.com.mind5.business.employeeList.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmplisSelectSingle implements DaoStmt<EmplisInfo> {
	private final String LT_EMP = DaoDbTable.EMP_TABLE;
	
	private DaoStmt<EmplisInfo> stmtSql;
	private DaoStmtOption<EmplisInfo> stmtOption;
	
	
	
	public EmplisSelectSingle(Connection conn, EmplisInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, EmplisInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_EMP;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.EMP_LIST_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmplisWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}

	
		
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<EmplisInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<EmplisInfo> getNewInstance() {
		return new EmplisSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<EmplisInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<EmplisInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<EmplisInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				EmplisInfo dataInfo = new EmplisInfo();
				dataInfo.codOwner = stmtResult.getLong(EmplisDbTableColumn.COL_COD_OWNER);
				dataInfo.codEmployee = stmtResult.getLong(EmplisDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.recordMode = stmtResult.getString(EmplisDbTableColumn.COL_RECORD_MODE);
				dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, EmplisDbTableColumn.COL_COD_PERSON);
				dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, EmplisDbTableColumn.COL_COD_SNAPSHOT);				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
