package br.com.gda.business.addressSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

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
		final boolean IGNORE_NULL = true;
		final boolean IGNORE_RECORD_MODE = true;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new AddresnapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<AddresnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<AddresnapInfo> getNewInstance() {
		return new AddresnapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<AddresnapInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final boolean NOT_NULL = false;
		
		@Override public List<AddresnapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<AddresnapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				AddresnapInfo dataInfo = new AddresnapInfo();
				dataInfo.codAddress = stmtResult.getLong(AddresnapDbTableColumn.COL_COD_ADDRESS);
				dataInfo.codOwner = stmtResult.getLong(AddresnapDbTableColumn.COL_COD_OWNER);
				dataInfo.codSnapshot = stmtResult.getLong(AddresnapDbTableColumn.COL_COD_SNAPSHOT);
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
				
				stmtResult.getLong(AddresnapDbTableColumn.COL_COD_STORE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codStore = stmtResult.getLong(AddresnapDbTableColumn.COL_COD_STORE);
				
				stmtResult.getLong(AddresnapDbTableColumn.COL_COD_STORE_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codStoreSnapshot = stmtResult.getLong(AddresnapDbTableColumn.COL_COD_STORE_SNAPSHOT);
				
				stmtResult.getLong(AddresnapDbTableColumn.COL_COD_CUSTOMER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCustomer = stmtResult.getLong(AddresnapDbTableColumn.COL_COD_CUSTOMER);		
				
				stmtResult.getLong(AddresnapDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCustomerSnapshot = stmtResult.getLong(AddresnapDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT);	
				
				stmtResult.getLong(AddresnapDbTableColumn.COL_COD_EMPLOYEE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCustomer = stmtResult.getLong(AddresnapDbTableColumn.COL_COD_EMPLOYEE);
				
				stmtResult.getLong(AddresnapDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCustomerSnapshot = stmtResult.getLong(AddresnapDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT);
				
				stmtResult.getLong(AddresnapDbTableColumn.COL_COD_USER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codUser = stmtResult.getLong(AddresnapDbTableColumn.COL_COD_USER);	
				
				stmtResult.getLong(AddresnapDbTableColumn.COL_COD_USER_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codUserSnapshot = stmtResult.getLong(AddresnapDbTableColumn.COL_COD_USER_SNAPSHOT);	
				
				stmtResult.getFloat(AddresnapDbTableColumn.COL_LATITUDE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.latitude = stmtResult.getFloat(AddresnapDbTableColumn.COL_LATITUDE);	
				
				stmtResult.getFloat(AddresnapDbTableColumn.COL_LONGITUDE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.longitude = stmtResult.getFloat(AddresnapDbTableColumn.COL_LONGITUDE);

				Timestamp lastChanged = stmtResult.getTimestamp(AddresnapDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();		
				
				stmtResult.getLong(AddresnapDbTableColumn.COL_COD_OWNER_REF);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codOwnerRef = stmtResult.getLong(AddresnapDbTableColumn.COL_COD_OWNER_REF);	
				
				stmtResult.getLong(AddresnapDbTableColumn.COL_COD_OWNER_REF_SNAPSHOT);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codOwnerRefSnapshot = stmtResult.getLong(AddresnapDbTableColumn.COL_COD_OWNER_REF_SNAPSHOT);	
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
