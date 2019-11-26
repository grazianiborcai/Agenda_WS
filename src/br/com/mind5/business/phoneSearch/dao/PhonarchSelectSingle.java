package br.com.mind5.business.phoneSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.dao.obsolete.DaoResultParser_;
import br.com.mind5.dao.obsolete.DaoStmtOption_;

public final class PhonarchSelectSingle implements DaoStmt<PhonarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.PHONE_TABLE;	
	
	private DaoStmt<PhonarchInfo> stmtSql;
	private DaoStmtOption_<PhonarchInfo> stmtOption;
	
	
	
	public PhonarchSelectSingle(Connection conn, PhonarchInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, PhonarchInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = MAIN_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.PHONE_SEARCH_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new PhonarchWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper_<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<PhonarchInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<PhonarchInfo> getNewInstance() {
		return new PhonarchSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<PhonarchInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<PhonarchInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PhonarchInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				PhonarchInfo dataInfo = new PhonarchInfo();
				dataInfo.codPhone = stmtResult.getLong(PhonarchDbTableColumn.COL_COD_PHONE);
				dataInfo.codOwner = stmtResult.getLong(PhonarchDbTableColumn.COL_COD_OWNER);
				dataInfo.codCountryPhone = stmtResult.getInt(PhonarchDbTableColumn.COL_COUNTRY_PHONE);
				dataInfo.fullNumber = stmtResult.getString(PhonarchDbTableColumn.COL_FULL_NUMBER);
				dataInfo.recordMode = stmtResult.getString(PhonarchDbTableColumn.COL_RECORD_MODE);
				dataInfo.codArea = stmtResult.getString(PhonarchDbTableColumn.COL_COD_AREA);
				dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, PhonarchDbTableColumn.COL_COD_STORE);
				dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, PhonarchDbTableColumn.COL_COD_CUSTOMER);
				dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, PhonarchDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, PhonarchDbTableColumn.COL_COD_USER);
				dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, PhonarchDbTableColumn.COL_COD_OWNER_REF);
				dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, PhonarchDbTableColumn.COL_COD_SNAPSHOT);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
