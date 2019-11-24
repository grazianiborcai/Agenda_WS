package br.com.mind5.business.address.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
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

public final class AddressSelectSingle implements DaoStmt<AddressInfo> {
	private final String LT_MAIN = DaoDbTable.ADDRESS_TABLE;	
	
	private DaoStmt<AddressInfo> stmtSql;
	private DaoStmtOption_<AddressInfo> stmtOption;
	
	
	
	public AddressSelectSingle(Connection conn, AddressInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, AddressInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_MAIN;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_MAIN);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new AddressWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<AddressInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<AddressInfo> getNewInstance() {
		return new AddressSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<AddressInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<AddressInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<AddressInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				AddressInfo dataInfo = new AddressInfo();
				dataInfo.codAddress = stmtResult.getLong(AddressDbTableColumn.COL_COD_ADDRESS);
				dataInfo.codOwner = stmtResult.getLong(AddressDbTableColumn.COL_COD_OWNER);
				dataInfo.codCountry = stmtResult.getString(AddressDbTableColumn.COL_COUNTRY);
				dataInfo.codState = stmtResult.getString(AddressDbTableColumn.COL_STATE_PROVINCE);
				dataInfo.city = stmtResult.getString(AddressDbTableColumn.COL_CITY);
				dataInfo.district = stmtResult.getString(AddressDbTableColumn.COL_DISTRICT);
				dataInfo.street = stmtResult.getString(AddressDbTableColumn.COL_STREET);
				dataInfo.streetNumber = stmtResult.getString(AddressDbTableColumn.COL_STREET_NUMBER);
				dataInfo.complement = stmtResult.getString(AddressDbTableColumn.COL_COMPLEMENT);
				dataInfo.postalCode = stmtResult.getString(AddressDbTableColumn.COL_POSTALCODE);
				dataInfo.line1 = stmtResult.getString(AddressDbTableColumn.COL_LINE1);
				dataInfo.line2 = stmtResult.getString(AddressDbTableColumn.COL_LINE2);
				dataInfo.line3 = stmtResult.getString(AddressDbTableColumn.COL_LINE3);
				dataInfo.line4 = stmtResult.getString(AddressDbTableColumn.COL_LINE4);
				dataInfo.line5 = stmtResult.getString(AddressDbTableColumn.COL_LINE5);
				dataInfo.line6 = stmtResult.getString(AddressDbTableColumn.COL_LINE6);
				dataInfo.line7 = stmtResult.getString(AddressDbTableColumn.COL_LINE7);
				dataInfo.recordMode = stmtResult.getString(AddressDbTableColumn.COL_RECORD_MODE);
				dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, AddressDbTableColumn.COL_COD_STORE);
				dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, AddressDbTableColumn.COL_COD_CUSTOMER);
				dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, AddressDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, AddressDbTableColumn.COL_COD_USER);
				dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, AddressDbTableColumn.COL_COD_OWNER_REF);
				dataInfo.latitude = DaoFormatter.sqlToFloat(stmtResult, AddressDbTableColumn.COL_LATITUDE);
				dataInfo.longitude = DaoFormatter.sqlToFloat(stmtResult, AddressDbTableColumn.COL_LONGITUDE);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, AddressDbTableColumn.COL_LAST_CHANGED);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, AddressDbTableColumn.COL_LAST_CHANGED_BY);
				dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, AddressDbTableColumn.COL_COD_SNAPSHOT);		
				dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, AddressDbTableColumn.COL_CREATED_ON);
				dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, AddressDbTableColumn.COL_CREATED_BY);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
