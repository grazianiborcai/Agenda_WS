package br.com.gda.business.storeList.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class StolisSelectSingle implements DaoStmt<StolisInfo> {
	private final static String LT_STORE = DaoDbTable.STORE_TABLE;	
	
	private DaoStmt<StolisInfo> stmtSql;
	private DaoStmtOption<StolisInfo> stmtOption;
	
	
	
	public StolisSelectSingle(Connection conn, StolisInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, StolisInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_STORE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.STORE_LIST_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StolisWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<StolisInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<StolisInfo> getNewInstance() {
		return new StolisSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<StolisInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<StolisInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StolisInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				StolisInfo dataInfo = new StolisInfo();
				dataInfo.codOwner = stmtResult.getLong(StolisDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(StolisDbTableColumn.COL_COD_STORE);
				dataInfo.codCurr = stmtResult.getString(StolisDbTableColumn.COL_COD_CURRENCY);
				dataInfo.codTimezone = stmtResult.getString(StolisDbTableColumn.COL_COD_TIMEZONE);
				dataInfo.recordMode = stmtResult.getString(StolisDbTableColumn.COL_RECORD_MODE);	
				
				
				stmtResult.getLong(StolisDbTableColumn.COL_COD_COMPANY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCompany = stmtResult.getLong(StolisDbTableColumn.COL_COD_COMPANY);
				
				
				Timestamp lastChanged = stmtResult.getTimestamp(StolisDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				
				stmtResult.getLong(StolisDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getLong(StolisDbTableColumn.COL_LAST_CHANGED_BY);
				
				
				stmtResult.getLong(StolisDbTableColumn.COL_COD_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codSnapshot = stmtResult.getLong(StolisDbTableColumn.COL_COD_SNAPSHOT);
		
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
