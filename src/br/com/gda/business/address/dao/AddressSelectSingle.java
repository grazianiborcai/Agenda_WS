package br.com.gda.business.address.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class AddressSelectSingle implements DaoStmt<AddressInfo> {
	private final String LT_MAIN = DaoDbTable.ADDRESS_TABLE;	
	
	private DaoStmt<AddressInfo> stmtSql;
	private DaoStmtOption<AddressInfo> stmtOption;
	
	
	
	public AddressSelectSingle(Connection conn, AddressInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, AddressInfo recordInfo, String schemaName) {
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
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new AddressWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<AddressInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<AddressInfo> getNewInstance() {
		return new AddressSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<AddressInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final boolean NOT_NULL = false;
		
		@Override public List<AddressInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<AddressInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
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
				
				stmtResult.getLong(AddressDbTableColumn.COL_COD_STORE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codStore = stmtResult.getLong(AddressDbTableColumn.COL_COD_STORE);
				
				stmtResult.getLong(AddressDbTableColumn.COL_COD_CUSTOMER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCustomer = stmtResult.getLong(AddressDbTableColumn.COL_COD_CUSTOMER);				
				
				stmtResult.getLong(AddressDbTableColumn.COL_COD_EMPLOYEE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCustomer = stmtResult.getLong(AddressDbTableColumn.COL_COD_EMPLOYEE);			
				
				stmtResult.getFloat(AddressDbTableColumn.COL_LATITUDE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.latitude = stmtResult.getFloat(AddressDbTableColumn.COL_LATITUDE);	
				
				stmtResult.getFloat(AddressDbTableColumn.COL_LONGITUDE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.longitude = stmtResult.getFloat(AddressDbTableColumn.COL_LONGITUDE);

				Timestamp lastChanged = stmtResult.getTimestamp(AddressDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();		
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
