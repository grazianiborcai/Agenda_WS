package br.com.mind5.business.address.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class AddressSelectSingle extends DaoStmtTemplate<AddressInfo> {
	private final String MAIN_TABLE = DaoDbTable.ADDRESS_TABLE;	
	
	
	public AddressSelectSingle(Connection conn, AddressInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, AddressInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new AddressWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<AddressInfo> getResultParserHook() {
		return new DaoResultParser<AddressInfo>() {
			@Override public List<AddressInfo> parseResult(AddressInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<AddressInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
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
		};
	}
}
