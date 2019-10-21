package br.com.mind5.business.owner.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
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

public final class OwnerSelectSingle implements DaoStmt<OwnerInfo> {
	private final String LEFT_TABLE = DaoDbTable.OWNER_TABLE;	
	
	private DaoStmt<OwnerInfo> stmtSql;
	private DaoStmtOption<OwnerInfo> stmtOption;
	
	
	
	public OwnerSelectSingle(Connection conn, OwnerInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, OwnerInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new OwnerWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<OwnerInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<OwnerInfo> getNewInstance() {
		return new OwnerSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<OwnerInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<OwnerInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<OwnerInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				OwnerInfo dataInfo = new OwnerInfo();
				dataInfo.codOwner = stmtResult.getLong(OwnerDbTableColumn.COL_COD_OWNER);
				dataInfo.recordMode = stmtResult.getString(OwnerDbTableColumn.COL_RECORD_MODE);
				dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, OwnerDbTableColumn.COL_COD_PERSON);
				dataInfo.codCompany = DaoFormatter.sqlToLong(stmtResult, OwnerDbTableColumn.COL_COD_COMPANY);
				dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, OwnerDbTableColumn.COL_COD_USER);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, OwnerDbTableColumn.COL_LAST_CHANGED_BY);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, OwnerDbTableColumn.COL_LAST_CHANGED);				
				dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, OwnerDbTableColumn.COL_CREATED_BY);
				dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, OwnerDbTableColumn.COL_CREATED_ON);
				dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, OwnerDbTableColumn.COL_COD_SNAPSHOT);				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
