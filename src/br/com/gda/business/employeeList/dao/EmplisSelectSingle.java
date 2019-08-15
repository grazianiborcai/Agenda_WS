package br.com.gda.business.employeeList.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

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
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmplisWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}

	
		
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption);
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
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<EmplisInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<EmplisInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				EmplisInfo dataInfo = new EmplisInfo();
				dataInfo.codOwner = stmtResult.getLong(EmplisDbTableColumn.COL_COD_OWNER);
				dataInfo.codEmployee = stmtResult.getLong(EmplisDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.recordMode = stmtResult.getString(EmplisDbTableColumn.COL_RECORD_MODE);
				
				
				stmtResult.getLong(EmplisDbTableColumn.COL_COD_PERSON);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codPerson = stmtResult.getLong(EmplisDbTableColumn.COL_COD_PERSON);
				
				
				Timestamp lastChanged = stmtResult.getTimestamp(EmplisDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();	
				
				
				stmtResult.getLong(EmplisDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(EmplisDbTableColumn.COL_LAST_CHANGED_BY);
				
				
				stmtResult.getLong(EmplisDbTableColumn.COL_COD_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codSnapahot = stmtResult.getLong(EmplisDbTableColumn.COL_COD_SNAPSHOT);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
