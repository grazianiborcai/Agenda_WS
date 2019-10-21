package br.com.mind5.business.customerList.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
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

public final class CuslisSelectSingle implements DaoStmt<CuslisInfo> {
	private final String LT_CUSTOMER = DaoDbTable.CUS_TABLE;
	
	private DaoStmt<CuslisInfo> stmtSql;
	private DaoStmtOption<CuslisInfo> stmtOption;
	
	
	
	public CuslisSelectSingle(Connection conn, CuslisInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, CuslisInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_CUSTOMER;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.CUS_LIST_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new CuslisWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<CuslisInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<CuslisInfo> getNewInstance() {
		return new CuslisSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<CuslisInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<CuslisInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<CuslisInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				CuslisInfo dataInfo = new CuslisInfo();
				dataInfo.codOwner = stmtResult.getLong(CuslisDbTableColumn.COL_COD_OWNER);
				dataInfo.codCustomer = stmtResult.getLong(CuslisDbTableColumn.COL_COD_CUSTOMER);									
				dataInfo.recordMode = stmtResult.getString(CuslisDbTableColumn.COL_RECORD_MODE);
				dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, CuslisDbTableColumn.COL_COD_PERSON);
				dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, CuslisDbTableColumn.COL_COD_USER);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, CuslisDbTableColumn.COL_LAST_CHANGED);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, CuslisDbTableColumn.COL_LAST_CHANGED_BY);
				dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, CuslisDbTableColumn.COL_COD_SNAPSHOT);

				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
