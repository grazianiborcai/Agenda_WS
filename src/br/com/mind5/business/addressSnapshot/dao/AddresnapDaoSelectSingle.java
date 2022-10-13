package br.com.mind5.business.addressSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class AddresnapDaoSelectSingle extends DaoStmtTemplate<AddresnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.ADDRESS_SNAPSHOT_TABLE;	
	
	
	public AddresnapDaoSelectSingle(Connection conn, AddresnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, AddresnapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new AddresnapDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<AddresnapInfo> getResultParserHook() {
		return new DaoResultParser<AddresnapInfo>() {
			@Override public List<AddresnapInfo> parseResult(AddresnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<AddresnapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					AddresnapInfo dataInfo = new AddresnapInfo();
					
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, AddresnapDaoDbTableColumn.COL_COD_SNAPSHOT);	
					dataInfo.codAddress = stmtResult.getLong(AddresnapDaoDbTableColumn.COL_COD_ADDRESS);
					dataInfo.codOwner = stmtResult.getLong(AddresnapDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codCountry = stmtResult.getString(AddresnapDaoDbTableColumn.COL_COUNTRY);
					dataInfo.codState = stmtResult.getString(AddresnapDaoDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(AddresnapDaoDbTableColumn.COL_CITY);
					dataInfo.district = stmtResult.getString(AddresnapDaoDbTableColumn.COL_DISTRICT);
					dataInfo.districtSearch = stmtResult.getString(AddresnapDaoDbTableColumn.COL_DISTRICT_SEARCH);
					dataInfo.street = stmtResult.getString(AddresnapDaoDbTableColumn.COL_STREET);
					dataInfo.streetNumber = stmtResult.getString(AddresnapDaoDbTableColumn.COL_STREET_NUMBER);
					dataInfo.complement = stmtResult.getString(AddresnapDaoDbTableColumn.COL_COMPLEMENT);
					dataInfo.postalCode = stmtResult.getString(AddresnapDaoDbTableColumn.COL_POSTALCODE);
					dataInfo.line1 = stmtResult.getString(AddresnapDaoDbTableColumn.COL_LINE1);
					dataInfo.line2 = stmtResult.getString(AddresnapDaoDbTableColumn.COL_LINE2);
					dataInfo.line3 = stmtResult.getString(AddresnapDaoDbTableColumn.COL_LINE3);
					dataInfo.line4 = stmtResult.getString(AddresnapDaoDbTableColumn.COL_LINE4);
					dataInfo.line5 = stmtResult.getString(AddresnapDaoDbTableColumn.COL_LINE5);
					dataInfo.line6 = stmtResult.getString(AddresnapDaoDbTableColumn.COL_LINE6);
					dataInfo.line7 = stmtResult.getString(AddresnapDaoDbTableColumn.COL_LINE7);
					dataInfo.recordMode = stmtResult.getString(AddresnapDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, AddresnapDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codStoreSnapshot = DaoFormatter.sqlToLong(stmtResult, AddresnapDaoDbTableColumn.COL_COD_STORE_SNAPSHOT);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, AddresnapDaoDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codCustomerSnapshot = DaoFormatter.sqlToLong(stmtResult, AddresnapDaoDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, AddresnapDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codEmployeeSnapshot = DaoFormatter.sqlToLong(stmtResult, AddresnapDaoDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, AddresnapDaoDbTableColumn.COL_COD_USER);
					dataInfo.codUserSnapshot = DaoFormatter.sqlToLong(stmtResult, AddresnapDaoDbTableColumn.COL_COD_USER_SNAPSHOT);
					dataInfo.codLegalPerson = DaoFormatter.sqlToLong(stmtResult, AddresnapDaoDbTableColumn.COL_COD_LEGAL_PERSON);					
					dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, AddresnapDaoDbTableColumn.COL_COD_OWNER_REF);
					dataInfo.codOwnerRefSnapshot = DaoFormatter.sqlToLong(stmtResult, AddresnapDaoDbTableColumn.COL_COD_OWNER_REF_SNAPSHOT);
					dataInfo.latitude = DaoFormatter.sqlToFloat(stmtResult, AddresnapDaoDbTableColumn.COL_LATITUDE);
					dataInfo.longitude = DaoFormatter.sqlToFloat(stmtResult, AddresnapDaoDbTableColumn.COL_LONGITUDE);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, AddresnapDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, AddresnapDaoDbTableColumn.COL_LAST_CHANGED_BY);		
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, AddresnapDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, AddresnapDaoDbTableColumn.COL_CREATED_BY);	
					dataInfo.geoHash01 = stmtResult.getString(AddresnapDaoDbTableColumn.COL_GEO_HASH_01);
					dataInfo.geoHash02 = stmtResult.getString(AddresnapDaoDbTableColumn.COL_GEO_HASH_02);					
					dataInfo.geoHash03 = stmtResult.getString(AddresnapDaoDbTableColumn.COL_GEO_HASH_03);
					dataInfo.geoHash04 = stmtResult.getString(AddresnapDaoDbTableColumn.COL_GEO_HASH_04);
					dataInfo.geoHash05 = stmtResult.getString(AddresnapDaoDbTableColumn.COL_GEO_HASH_05);
					dataInfo.geoHash12 = stmtResult.getString(AddresnapDaoDbTableColumn.COL_GEO_HASH_12);
					dataInfo.addressName = stmtResult.getString(AddresnapDaoDbTableColumn.COL_ADDRESS_NAME);
					dataInfo.isDefault = stmtResult.getBoolean(AddresnapDaoDbTableColumn.COL_IS_DEFAULT);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
