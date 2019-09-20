package br.com.gda.business.addressSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
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

public final class AddresnapSelectSingle implements DaoStmt<AddresnapInfo> {
	private final String LT_MAIN = DaoDbTable.ADDRESS_SNAPSHOT_TABLE;	
	
	private DaoStmt<AddresnapInfo> stmtSql;
	private DaoStmtOption<AddresnapInfo> stmtOption;
	
	
	
	public AddresnapSelectSingle(Connection conn, AddresnapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, AddresnapInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
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
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new AddresnapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<AddresnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<AddresnapInfo> getNewInstance() {
		return new AddresnapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<AddresnapInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<AddresnapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<AddresnapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				AddresnapInfo dataInfo = new AddresnapInfo();
				dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, AddresnapDbTableColumn.COL_COD_SNAPSHOT);	
				dataInfo.codAddress = stmtResult.getLong(AddresnapDbTableColumn.COL_COD_ADDRESS);
				dataInfo.codOwner = stmtResult.getLong(AddresnapDbTableColumn.COL_COD_OWNER);
				dataInfo.codCountry = stmtResult.getString(AddresnapDbTableColumn.COL_COUNTRY);
				dataInfo.codState = stmtResult.getString(AddresnapDbTableColumn.COL_STATE_PROVINCE);
				dataInfo.city = stmtResult.getString(AddresnapDbTableColumn.COL_CITY);
				dataInfo.district = stmtResult.getString(AddresnapDbTableColumn.COL_DISTRICT);
				dataInfo.street = stmtResult.getString(AddresnapDbTableColumn.COL_STREET);
				dataInfo.streetNumber = stmtResult.getString(AddresnapDbTableColumn.COL_STREET_NUMBER);
				dataInfo.complement = stmtResult.getString(AddresnapDbTableColumn.COL_COMPLEMENT);
				dataInfo.postalCode = stmtResult.getString(AddresnapDbTableColumn.COL_POSTALCODE);
				dataInfo.line1 = stmtResult.getString(AddresnapDbTableColumn.COL_LINE1);
				dataInfo.line2 = stmtResult.getString(AddresnapDbTableColumn.COL_LINE2);
				dataInfo.line3 = stmtResult.getString(AddresnapDbTableColumn.COL_LINE3);
				dataInfo.line4 = stmtResult.getString(AddresnapDbTableColumn.COL_LINE4);
				dataInfo.line5 = stmtResult.getString(AddresnapDbTableColumn.COL_LINE5);
				dataInfo.line6 = stmtResult.getString(AddresnapDbTableColumn.COL_LINE6);
				dataInfo.line7 = stmtResult.getString(AddresnapDbTableColumn.COL_LINE7);
				dataInfo.recordMode = stmtResult.getString(AddresnapDbTableColumn.COL_RECORD_MODE);
				dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, AddresnapDbTableColumn.COL_COD_STORE);
				dataInfo.codStoreSnapshot = DaoFormatter.sqlToLong(stmtResult, AddresnapDbTableColumn.COL_COD_STORE_SNAPSHOT);
				dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, AddresnapDbTableColumn.COL_COD_CUSTOMER);
				dataInfo.codCustomerSnapshot = DaoFormatter.sqlToLong(stmtResult, AddresnapDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT);
				dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, AddresnapDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codEmployeeSnapshot = DaoFormatter.sqlToLong(stmtResult, AddresnapDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT);
				dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, AddresnapDbTableColumn.COL_COD_USER);
				dataInfo.codUserSnapshot = DaoFormatter.sqlToLong(stmtResult, AddresnapDbTableColumn.COL_COD_USER_SNAPSHOT);
				dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, AddresnapDbTableColumn.COL_COD_OWNER_REF);
				dataInfo.codOwnerRefSnapshot = DaoFormatter.sqlToLong(stmtResult, AddresnapDbTableColumn.COL_COD_OWNER_REF_SNAPSHOT);
				dataInfo.latitude = DaoFormatter.sqlToFloat(stmtResult, AddresnapDbTableColumn.COL_LATITUDE);
				dataInfo.longitude = DaoFormatter.sqlToFloat(stmtResult, AddresnapDbTableColumn.COL_LONGITUDE);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, AddresnapDbTableColumn.COL_LAST_CHANGED);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, AddresnapDbTableColumn.COL_LAST_CHANGED_BY);		
				dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, AddresnapDbTableColumn.COL_CREATED_ON);
				dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, AddresnapDbTableColumn.COL_CREATED_BY);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
