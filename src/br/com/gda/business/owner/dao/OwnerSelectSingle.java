package br.com.gda.business.owner.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

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
		final boolean DONT_IGNORE_NULL = false;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new OwnerWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<OwnerInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<OwnerInfo> getNewInstance() {
		return new OwnerSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<OwnerInfo> {
		private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<OwnerInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<OwnerInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				OwnerInfo dataInfo = new OwnerInfo();
				dataInfo.codOwner = stmtResult.getLong(OwnerDbTableColumn.COL_COD_OWNER);
				dataInfo.recordMode = stmtResult.getString(OwnerDbTableColumn.COL_RECORD_MODE);
				
				stmtResult.getLong(OwnerDbTableColumn.COL_COD_PERSON);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codPerson = stmtResult.getLong(OwnerDbTableColumn.COL_COD_PERSON);
				
				stmtResult.getLong(OwnerDbTableColumn.COL_COD_COMPANY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCompany = stmtResult.getLong(OwnerDbTableColumn.COL_COD_COMPANY);
				
				Timestamp lastChanged = stmtResult.getTimestamp(OwnerDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
