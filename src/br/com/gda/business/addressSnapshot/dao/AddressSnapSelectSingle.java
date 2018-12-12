package br.com.gda.business.addressSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddressSnapInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class AddressSnapSelectSingle implements DaoStmt<AddressSnapInfo> {
	private final String LT_MAIN = DaoDbTable.ADDRESS_SNAPSHOT_TABLE;	
	
	private DaoStmt<AddressSnapInfo> stmtSql;
	private DaoStmtOption<AddressSnapInfo> stmtOption;
	
	
	
	public AddressSnapSelectSingle(Connection conn, AddressSnapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, AddressSnapInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new AddressSnapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<AddressSnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<AddressSnapInfo> getNewInstance() {
		return new AddressSnapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<AddressSnapInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final boolean NOT_NULL = false;
		
		@Override public List<AddressSnapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<AddressSnapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				AddressSnapInfo dataInfo = new AddressSnapInfo();
				dataInfo.codAddress = stmtResult.getLong(AddressSnapDbTableColumn.COL_COD_ADDRESS);
				dataInfo.codOwner = stmtResult.getLong(AddressSnapDbTableColumn.COL_COD_OWNER);
				dataInfo.codSnapshot = stmtResult.getLong(AddressSnapDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codCountry = stmtResult.getString(AddressSnapDbTableColumn.COL_COUNTRY);
				dataInfo.codState = stmtResult.getString(AddressSnapDbTableColumn.COL_STATE_PROVINCE);
				dataInfo.city = stmtResult.getString(AddressSnapDbTableColumn.COL_CITY);
				dataInfo.district = stmtResult.getString(AddressSnapDbTableColumn.COL_DISTRICT);
				dataInfo.street = stmtResult.getString(AddressSnapDbTableColumn.COL_STREET);
				dataInfo.streetNumber = stmtResult.getString(AddressSnapDbTableColumn.COL_STREET_NUMBER);
				dataInfo.complement = stmtResult.getString(AddressSnapDbTableColumn.COL_COMPLEMENT);
				dataInfo.postalCode = stmtResult.getString(AddressSnapDbTableColumn.COL_POSTALCODE);
				dataInfo.line1 = stmtResult.getString(AddressSnapDbTableColumn.COL_LINE1);
				dataInfo.line2 = stmtResult.getString(AddressSnapDbTableColumn.COL_LINE2);
				dataInfo.line3 = stmtResult.getString(AddressSnapDbTableColumn.COL_LINE3);
				dataInfo.line4 = stmtResult.getString(AddressSnapDbTableColumn.COL_LINE4);
				dataInfo.line5 = stmtResult.getString(AddressSnapDbTableColumn.COL_LINE5);
				dataInfo.line6 = stmtResult.getString(AddressSnapDbTableColumn.COL_LINE6);
				dataInfo.line7 = stmtResult.getString(AddressSnapDbTableColumn.COL_LINE7);
				dataInfo.recordMode = stmtResult.getString(AddressSnapDbTableColumn.COL_RECORD_MODE);
				
				stmtResult.getLong(AddressSnapDbTableColumn.COL_COD_STORE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codStore = stmtResult.getLong(AddressSnapDbTableColumn.COL_COD_STORE);
				
				stmtResult.getLong(AddressSnapDbTableColumn.COL_COD_CUSTOMER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCustomer = stmtResult.getLong(AddressSnapDbTableColumn.COL_COD_CUSTOMER);				
				
				stmtResult.getLong(AddressSnapDbTableColumn.COL_COD_EMPLOYEE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCustomer = stmtResult.getLong(AddressSnapDbTableColumn.COL_COD_EMPLOYEE);
				
				stmtResult.getLong(AddressSnapDbTableColumn.COL_COD_USER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codUser = stmtResult.getLong(AddressSnapDbTableColumn.COL_COD_USER);	
				
				stmtResult.getFloat(AddressSnapDbTableColumn.COL_LATITUDE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.latitude = stmtResult.getFloat(AddressSnapDbTableColumn.COL_LATITUDE);	
				
				stmtResult.getFloat(AddressSnapDbTableColumn.COL_LONGITUDE);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.longitude = stmtResult.getFloat(AddressSnapDbTableColumn.COL_LONGITUDE);

				Timestamp lastChanged = stmtResult.getTimestamp(AddressSnapDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();		
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
