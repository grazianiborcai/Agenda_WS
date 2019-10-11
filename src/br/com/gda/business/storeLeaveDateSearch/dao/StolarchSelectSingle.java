package br.com.gda.business.storeLeaveDateSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDateSearch.info.StolarchInfo;
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

public final class StolarchSelectSingle implements DaoStmt<StolarchInfo> {	
	private final String LT_STORE_LEAVE_DATE = DaoDbTable.STORE_LD_TABLE;
	
	private DaoStmt<StolarchInfo> stmtSql;
	private DaoStmtOption<StolarchInfo> stmtOption;
	
	
	
	public StolarchSelectSingle(Connection conn, StolarchInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, StolarchInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_STORE_LEAVE_DATE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_STORE_LEAVE_DATE);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StolarchWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<StolarchInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<StolarchInfo> getNewInstance() {
		return new StolarchSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<StolarchInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<StolarchInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StolarchInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				StolarchInfo dataInfo = new StolarchInfo();
				dataInfo.codOwner = stmtResult.getLong(StolarchDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(StolarchDbTableColumn.COL_COD_STORE);
				dataInfo.recordMode = stmtResult.getString(StolarchDbTableColumn.COL_RECORD_MODE);	
				dataInfo.timeValidFrom = DaoFormatter.sqlToLocalTime(stmtResult, StolarchDbTableColumn.COL_TM_VALID_FROM);
				dataInfo.timeValidTo = DaoFormatter.sqlToLocalTime(stmtResult, StolarchDbTableColumn.COL_TM_VALID_TO);
				dataInfo.dateValidFrom = DaoFormatter.sqlToLocalDate(stmtResult, StolarchDbTableColumn.COL_DT_VALID_FROM);
				dataInfo.dateValidTo = DaoFormatter.sqlToLocalDate(stmtResult, StolarchDbTableColumn.COL_DT_VALID_TO);				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
