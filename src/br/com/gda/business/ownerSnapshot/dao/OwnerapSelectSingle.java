package br.com.gda.business.ownerSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.ownerSnapshot.info.OwnerapInfo;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;
import br.com.gda.dao.common.DaoOptionValue;

public final class OwnerapSelectSingle implements DaoStmt<OwnerapInfo> {
	private final String LEFT_TABLE = DaoDbTable.OWNER_SNAPSHOT_TABLE;	
	
	private DaoStmt<OwnerapInfo> stmtSql;
	private DaoStmtOption<OwnerapInfo> stmtOption;
	
	
	
	public OwnerapSelectSingle(Connection conn, OwnerapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, OwnerapInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LEFT_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LEFT_TABLE);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new OwnerapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<OwnerapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<OwnerapInfo> getNewInstance() {
		return new OwnerapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<OwnerapInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<OwnerapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<OwnerapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				OwnerapInfo dataInfo = new OwnerapInfo();
				dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, OwnerapDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codOwner = stmtResult.getLong(OwnerapDbTableColumn.COL_COD_OWNER);
				dataInfo.recordMode = stmtResult.getString(OwnerapDbTableColumn.COL_RECORD_MODE);
				dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, OwnerapDbTableColumn.COL_COD_PERSON);
				dataInfo.codPersonSnapshot = DaoFormatter.sqlToLong(stmtResult, OwnerapDbTableColumn.COL_COD_PERSON_SNAPSHOT);				
				dataInfo.codCompany = DaoFormatter.sqlToLong(stmtResult, OwnerapDbTableColumn.COL_COD_COMPANY);
				dataInfo.codCompanySnapshot = DaoFormatter.sqlToLong(stmtResult, OwnerapDbTableColumn.COL_COD_COMPANY_SNAPSHOT);
				dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, OwnerapDbTableColumn.COL_COD_USER);
				dataInfo.codUserSnapshot = DaoFormatter.sqlToLong(stmtResult, OwnerapDbTableColumn.COL_COD_USER_SNAPSHOT);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, OwnerapDbTableColumn.COL_LAST_CHANGED_BY);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, OwnerapDbTableColumn.COL_LAST_CHANGED);				
				dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, OwnerapDbTableColumn.COL_CREATED_BY);
				dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, OwnerapDbTableColumn.COL_CREATED_ON);								
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
