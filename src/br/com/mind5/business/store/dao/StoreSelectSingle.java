package br.com.mind5.business.store.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
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

public final class StoreSelectSingle implements DaoStmt<StoreInfo> {
	private final static String LT_STORE = DaoDbTable.STORE_TABLE;	
	
	private DaoStmt<StoreInfo> stmtSql;
	private DaoStmtOption<StoreInfo> stmtOption;
	
	
	
	public StoreSelectSingle(Connection conn, StoreInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, StoreInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_STORE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_STORE);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StoreWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<StoreInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<StoreInfo> getNewInstance() {
		return new StoreSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<StoreInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<StoreInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StoreInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				StoreInfo dataInfo = new StoreInfo();
				dataInfo.codOwner = stmtResult.getLong(StoreDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(StoreDbTableColumn.COL_COD_STORE);
				dataInfo.codCurr = stmtResult.getString(StoreDbTableColumn.COL_COD_CURRENCY);
				dataInfo.codTimezone = stmtResult.getString(StoreDbTableColumn.COL_COD_TIMEZONE);
				dataInfo.recordMode = stmtResult.getString(StoreDbTableColumn.COL_RECORD_MODE);	
				dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, StoreDbTableColumn.COL_COD_PERSON);
				dataInfo.codCompany = DaoFormatter.sqlToLong(stmtResult, StoreDbTableColumn.COL_COD_COMPANY);
				dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, StoreDbTableColumn.COL_COD_USER);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, StoreDbTableColumn.COL_LAST_CHANGED);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, StoreDbTableColumn.COL_LAST_CHANGED_BY);
				dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, StoreDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, StoreDbTableColumn.COL_CREATED_ON);
				dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, StoreDbTableColumn.COL_CREATED_BY);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
