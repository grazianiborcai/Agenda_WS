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

public final class AddressDaoSelectSingle extends DaoStmtTemplate<AddressInfo> {
	private final String MAIN_TABLE = DaoDbTable.ADDRESS_TABLE;	
	
	
	public AddressDaoSelectSingle(Connection conn, AddressInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new AddressDaoWhere(whereOption, tableName, recordInfo);
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
					
					dataInfo.city 			= stmtResult.getString(AddressDaoDbTableColumn.COL_CITY);
					dataInfo.line1          = stmtResult.getString(AddressDaoDbTableColumn.COL_LINE1);
					dataInfo.line2          = stmtResult.getString(AddressDaoDbTableColumn.COL_LINE2);
					dataInfo.line3          = stmtResult.getString(AddressDaoDbTableColumn.COL_LINE3);
					dataInfo.line4          = stmtResult.getString(AddressDaoDbTableColumn.COL_LINE4);
					dataInfo.line5          = stmtResult.getString(AddressDaoDbTableColumn.COL_LINE5);
					dataInfo.line6          = stmtResult.getString(AddressDaoDbTableColumn.COL_LINE6);
					dataInfo.line7          = stmtResult.getString(AddressDaoDbTableColumn.COL_LINE7);
					dataInfo.street         = stmtResult.getString(AddressDaoDbTableColumn.COL_STREET);
					dataInfo.codUser        = DaoFormatter.sqlToLong(stmtResult, AddressDaoDbTableColumn.COL_COD_USER);
					dataInfo.codOwner 		= stmtResult.getLong(AddressDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore       = DaoFormatter.sqlToLong(stmtResult, AddressDaoDbTableColumn.COL_COD_STORE);
					dataInfo.latitude       = DaoFormatter.sqlToFloat(stmtResult, AddressDaoDbTableColumn.COL_LATITUDE);
					dataInfo.district       = stmtResult.getString(AddressDaoDbTableColumn.COL_DISTRICT);
					dataInfo.codState       = stmtResult.getString(AddressDaoDbTableColumn.COL_STATE_PROVINCE);					
					dataInfo.longitude      = DaoFormatter.sqlToFloat(stmtResult, AddressDaoDbTableColumn.COL_LONGITUDE);
					dataInfo.createdOn      = DaoFormatter.sqlToLocalDateTime(stmtResult, AddressDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy      = DaoFormatter.sqlToLong(stmtResult, AddressDaoDbTableColumn.COL_CREATED_BY);
					dataInfo.geoHash01      = stmtResult.getString(AddressDaoDbTableColumn.COL_GEO_HASH_01);
					dataInfo.geoHash02      = stmtResult.getString(AddressDaoDbTableColumn.COL_GEO_HASH_02);
					dataInfo.geoHash03      = stmtResult.getString(AddressDaoDbTableColumn.COL_GEO_HASH_03);
					dataInfo.geoHash04      = stmtResult.getString(AddressDaoDbTableColumn.COL_GEO_HASH_04);
					dataInfo.geoHash05      = stmtResult.getString(AddressDaoDbTableColumn.COL_GEO_HASH_05);
					dataInfo.geoHash12      = stmtResult.getString(AddressDaoDbTableColumn.COL_GEO_HASH_12);					
					dataInfo.isDefault      = stmtResult.getBoolean(AddressDaoDbTableColumn.COL_IS_DEFAULT);
					dataInfo.codCountry 	= stmtResult.getString(AddressDaoDbTableColumn.COL_COUNTRY);
					dataInfo.complement     = stmtResult.getString(AddressDaoDbTableColumn.COL_COMPLEMENT);
					dataInfo.postalCode     = stmtResult.getString(AddressDaoDbTableColumn.COL_POSTALCODE);
					dataInfo.recordMode     = stmtResult.getString(AddressDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codAddress 	= stmtResult.getLong(AddressDaoDbTableColumn.COL_COD_ADDRESS);
					dataInfo.codCustomer    = DaoFormatter.sqlToLong(stmtResult, AddressDaoDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codEmployee    = DaoFormatter.sqlToLong(stmtResult, AddressDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codOwnerRef    = DaoFormatter.sqlToLong(stmtResult, AddressDaoDbTableColumn.COL_COD_OWNER_REF);
					dataInfo.addressName    = stmtResult.getString(AddressDaoDbTableColumn.COL_ADDRESS_NAME);
					dataInfo.codSnapshot    = DaoFormatter.sqlToLong(stmtResult, AddressDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.lastChanged    = DaoFormatter.sqlToLocalDateTime(stmtResult, AddressDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.streetNumber   = stmtResult.getString(AddressDaoDbTableColumn.COL_STREET_NUMBER);
					dataInfo.lastChangedBy  = DaoFormatter.sqlToLong(stmtResult, AddressDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.codLegalPerson = DaoFormatter.sqlToLong(stmtResult, AddressDaoDbTableColumn.COL_COD_LEGAL_PERSON);
					dataInfo.districtSearch = stmtResult.getString(AddressDaoDbTableColumn.COL_DISTRICT_SEARCH);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
