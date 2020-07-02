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

public final class DaoAddressSelectSingle extends DaoStmtTemplate<AddressInfo> {
	private final String MAIN_TABLE = DaoDbTable.ADDRESS_TABLE;	
	
	
	public DaoAddressSelectSingle(Connection conn, AddressInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new DaoAddressWhere(whereOption, tableName, recordInfo);
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
					
					dataInfo.codAddress = stmtResult.getLong(DaoAddressDbTableColumn.COL_COD_ADDRESS);
					dataInfo.codOwner = stmtResult.getLong(DaoAddressDbTableColumn.COL_COD_OWNER);
					dataInfo.codCountry = stmtResult.getString(DaoAddressDbTableColumn.COL_COUNTRY);
					dataInfo.codState = stmtResult.getString(DaoAddressDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(DaoAddressDbTableColumn.COL_CITY);
					dataInfo.district = stmtResult.getString(DaoAddressDbTableColumn.COL_DISTRICT);
					dataInfo.districtSearch = stmtResult.getString(DaoAddressDbTableColumn.COL_DISTRICT_SEARCH);
					dataInfo.street = stmtResult.getString(DaoAddressDbTableColumn.COL_STREET);
					dataInfo.streetNumber = stmtResult.getString(DaoAddressDbTableColumn.COL_STREET_NUMBER);
					dataInfo.complement = stmtResult.getString(DaoAddressDbTableColumn.COL_COMPLEMENT);
					dataInfo.postalCode = stmtResult.getString(DaoAddressDbTableColumn.COL_POSTALCODE);
					dataInfo.line1 = stmtResult.getString(DaoAddressDbTableColumn.COL_LINE1);
					dataInfo.line2 = stmtResult.getString(DaoAddressDbTableColumn.COL_LINE2);
					dataInfo.line3 = stmtResult.getString(DaoAddressDbTableColumn.COL_LINE3);
					dataInfo.line4 = stmtResult.getString(DaoAddressDbTableColumn.COL_LINE4);
					dataInfo.line5 = stmtResult.getString(DaoAddressDbTableColumn.COL_LINE5);
					dataInfo.line6 = stmtResult.getString(DaoAddressDbTableColumn.COL_LINE6);
					dataInfo.line7 = stmtResult.getString(DaoAddressDbTableColumn.COL_LINE7);
					dataInfo.recordMode = stmtResult.getString(DaoAddressDbTableColumn.COL_RECORD_MODE);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoAddressDbTableColumn.COL_COD_STORE);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, DaoAddressDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, DaoAddressDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoAddressDbTableColumn.COL_COD_USER);
					dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, DaoAddressDbTableColumn.COL_COD_OWNER_REF);
					dataInfo.latitude = DaoFormatter.sqlToFloat(stmtResult, DaoAddressDbTableColumn.COL_LATITUDE);
					dataInfo.longitude = DaoFormatter.sqlToFloat(stmtResult, DaoAddressDbTableColumn.COL_LONGITUDE);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoAddressDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoAddressDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoAddressDbTableColumn.COL_COD_SNAPSHOT);		
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoAddressDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, DaoAddressDbTableColumn.COL_CREATED_BY);	
					dataInfo.geoHash01 = stmtResult.getString(DaoAddressDbTableColumn.COL_GEO_HASH_01);
					dataInfo.geoHash02 = stmtResult.getString(DaoAddressDbTableColumn.COL_GEO_HASH_02);					
					dataInfo.geoHash03 = stmtResult.getString(DaoAddressDbTableColumn.COL_GEO_HASH_03);
					dataInfo.geoHash04 = stmtResult.getString(DaoAddressDbTableColumn.COL_GEO_HASH_04);
					dataInfo.geoHash05 = stmtResult.getString(DaoAddressDbTableColumn.COL_GEO_HASH_05);
					dataInfo.geoHash12 = stmtResult.getString(DaoAddressDbTableColumn.COL_GEO_HASH_12);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
