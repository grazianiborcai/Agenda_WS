package br.com.mind5.business.addressSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
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

public final class AddarchSelectSingle implements DaoStmt<AddarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.ADDRESS_TABLE;	
	
	private DaoStmt<AddarchInfo> stmtSql;
	private DaoStmtOption_<AddarchInfo> stmtOption;
	
	
	
	public AddarchSelectSingle(Connection conn, AddarchInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, AddarchInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = MAIN_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.ADDRESS_SEARCH_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new AddarchWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<AddarchInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<AddarchInfo> getNewInstance() {
		return new AddarchSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<AddarchInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<AddarchInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<AddarchInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				AddarchInfo dataInfo = new AddarchInfo();
				dataInfo.codAddress = stmtResult.getLong(AddarchDbTableColumn.COL_COD_ADDRESS);
				dataInfo.codOwner = stmtResult.getLong(AddarchDbTableColumn.COL_COD_OWNER);
				dataInfo.codCountry = stmtResult.getString(AddarchDbTableColumn.COL_COUNTRY);
				dataInfo.codState = stmtResult.getString(AddarchDbTableColumn.COL_STATE_PROVINCE);
				dataInfo.city = stmtResult.getString(AddarchDbTableColumn.COL_CITY);
				dataInfo.recordMode = stmtResult.getString(AddarchDbTableColumn.COL_RECORD_MODE);
				dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, AddarchDbTableColumn.COL_COD_STORE);
				dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, AddarchDbTableColumn.COL_COD_CUSTOMER);
				dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, AddarchDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, AddarchDbTableColumn.COL_COD_USER);
				dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, AddarchDbTableColumn.COL_COD_OWNER_REF);
				dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, AddarchDbTableColumn.COL_COD_SNAPSHOT);				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
