package br.com.mind5.business.storeSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
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

public final class StorapSelectSingle implements DaoStmt<StorapInfo> {
	private final static String LT_STORE = DaoDbTable.STORE_SNAPSHOT_TABLE;	
	
	private DaoStmt<StorapInfo> stmtSql;
	private DaoStmtOption<StorapInfo> stmtOption;
	
	
	
	public StorapSelectSingle(Connection conn, StorapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, StorapInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new StorapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<StorapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<StorapInfo> getNewInstance() {
		return new StorapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<StorapInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<StorapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StorapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				StorapInfo dataInfo = new StorapInfo();
				dataInfo.codOwner = stmtResult.getLong(StorapDbTableColumn.COL_COD_OWNER);
				dataInfo.codSnapshot = stmtResult.getLong(StorapDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codStore = stmtResult.getLong(StorapDbTableColumn.COL_COD_STORE);
				dataInfo.codCurr = stmtResult.getString(StorapDbTableColumn.COL_COD_CURRENCY);
				dataInfo.codTimezone = stmtResult.getString(StorapDbTableColumn.COL_COD_TIMEZONE);
				dataInfo.recordMode = stmtResult.getString(StorapDbTableColumn.COL_RECORD_MODE);	
				dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, StorapDbTableColumn.COL_COD_PERSON);
				dataInfo.codCompany = DaoFormatter.sqlToLong(stmtResult, StorapDbTableColumn.COL_COD_COMPANY);
				dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, StorapDbTableColumn.COL_COD_USER);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, StorapDbTableColumn.COL_LAST_CHANGED);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, StorapDbTableColumn.COL_LAST_CHANGED_BY);
				dataInfo.codCompanySnapshot = DaoFormatter.sqlToLong(stmtResult, StorapDbTableColumn.COL_COD_COMPANY_SNAPSHOT);
				dataInfo.codPersonSnapshot = DaoFormatter.sqlToLong(stmtResult, StorapDbTableColumn.COL_COD_PERSON_SNAPSHOT);
				dataInfo.codUserSnapshot = DaoFormatter.sqlToLong(stmtResult, StorapDbTableColumn.COL_COD_USER_SNAPSHOT);
				dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, StorapDbTableColumn.COL_CREATED_ON);
				dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, StorapDbTableColumn.COL_CREATED_BY);
		
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
