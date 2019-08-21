package br.com.gda.business.customerSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customerSnapshot.info.CusnapInfo;
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

public final class CusnapSelectSingle implements DaoStmt<CusnapInfo> {
	private final String LT_CUSTOMER_SNAPSHOT = DaoDbTable.CUS_SNAPSHOT_TABLE;
	
	private DaoStmt<CusnapInfo> stmtSql;
	private DaoStmtOption<CusnapInfo> stmtOption;
	
	
	
	public CusnapSelectSingle(Connection conn, CusnapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, CusnapInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_CUSTOMER_SNAPSHOT;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_CUSTOMER_SNAPSHOT);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new CusnapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<CusnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<CusnapInfo> getNewInstance() {
		return new CusnapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<CusnapInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<CusnapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<CusnapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				CusnapInfo dataInfo = new CusnapInfo();
				dataInfo.codOwner = stmtResult.getLong(CusnapDbTableColumn.COL_COD_OWNER);
				dataInfo.codCustomer = stmtResult.getLong(CusnapDbTableColumn.COL_COD_CUSTOMER);									
				dataInfo.recordMode = stmtResult.getString(CusnapDbTableColumn.COL_RECORD_MODE);
				dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, CusnapDbTableColumn.COL_COD_PERSON);
				dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, CusnapDbTableColumn.COL_COD_USER);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, CusnapDbTableColumn.COL_LAST_CHANGED);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, CusnapDbTableColumn.COL_LAST_CHANGED_BY);
				dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, CusnapDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codUserSnapshot = DaoFormatter.sqlToLong(stmtResult, CusnapDbTableColumn.COL_COD_USER_SNAPSHOT);
				dataInfo.codPersonSnapshot = DaoFormatter.sqlToLong(stmtResult, CusnapDbTableColumn.COL_COD_PERSON_SNAPSHOT);

				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
