package br.com.mind5.business.addressSnapshotSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshotSearch.info.AddresnaparchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class AddresnaparchDaoSelectSingle extends DaoStmtTemplate<AddresnaparchInfo> {
	private final String MAIN_TABLE = DaoDbTable.ADDRESS_SNAPSHOT_TABLE;	
	
	
	public AddresnaparchDaoSelectSingle(Connection conn, AddresnaparchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.ADDRESS_SNAPSHOT_SEARCH_VIEW;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, AddresnaparchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new AddresnaparchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<AddresnaparchInfo> getResultParserHook() {
		return new DaoResultParser<AddresnaparchInfo>() {
			@Override public List<AddresnaparchInfo> parseResult(AddresnaparchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<AddresnaparchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					AddresnaparchInfo dataInfo = new AddresnaparchInfo();
					
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, AddresnaparchDaoDbTableColumn.COL_COD_SNAPSHOT);	
					dataInfo.codAddress = stmtResult.getLong(AddresnaparchDaoDbTableColumn.COL_COD_ADDRESS);
					dataInfo.codOwner = stmtResult.getLong(AddresnaparchDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.recordMode = stmtResult.getString(AddresnaparchDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, AddresnaparchDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codStoreSnapshot = DaoFormatter.sqlToLong(stmtResult, AddresnaparchDaoDbTableColumn.COL_COD_STORE_SNAPSHOT);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, AddresnaparchDaoDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codCustomerSnapshot = DaoFormatter.sqlToLong(stmtResult, AddresnaparchDaoDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, AddresnaparchDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codEmployeeSnapshot = DaoFormatter.sqlToLong(stmtResult, AddresnaparchDaoDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, AddresnaparchDaoDbTableColumn.COL_COD_USER);
					dataInfo.codUserSnapshot = DaoFormatter.sqlToLong(stmtResult, AddresnaparchDaoDbTableColumn.COL_COD_USER_SNAPSHOT);
					dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, AddresnaparchDaoDbTableColumn.COL_COD_OWNER_REF);
					dataInfo.codOwnerRefSnapshot = DaoFormatter.sqlToLong(stmtResult, AddresnaparchDaoDbTableColumn.COL_COD_OWNER_REF_SNAPSHOT);
					dataInfo.isDefault = stmtResult.getBoolean(AddresnaparchDaoDbTableColumn.COL_IS_DEFAULT);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
