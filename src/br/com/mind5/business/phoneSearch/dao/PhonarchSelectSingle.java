package br.com.mind5.business.phoneSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PhonarchSelectSingle extends DaoStmtTemplate<PhonarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.PHONE_TABLE;		
	
	
	public PhonarchSelectSingle(Connection conn, PhonarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}	
	
	
	
	protected String getLookupTableHook() {
		return DaoDbTable.PHONE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PhonarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new PhonarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParserV2<PhonarchInfo> getResultParserHook() {
		return new DaoResultParserV2<PhonarchInfo>() {
			@Override public List<PhonarchInfo> parseResult(PhonarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PhonarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PhonarchInfo dataInfo = new PhonarchInfo();
					
					dataInfo.codPhone = stmtResult.getLong(PhonarchDbTableColumn.COL_COD_PHONE);
					dataInfo.codOwner = stmtResult.getLong(PhonarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codCountryPhone = stmtResult.getInt(PhonarchDbTableColumn.COL_COUNTRY_PHONE);
					dataInfo.fullNumber = stmtResult.getString(PhonarchDbTableColumn.COL_FULL_NUMBER);
					dataInfo.recordMode = stmtResult.getString(PhonarchDbTableColumn.COL_RECORD_MODE);
					dataInfo.codArea = stmtResult.getString(PhonarchDbTableColumn.COL_COD_AREA);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, PhonarchDbTableColumn.COL_COD_STORE);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, PhonarchDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, PhonarchDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, PhonarchDbTableColumn.COL_COD_USER);
					dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, PhonarchDbTableColumn.COL_COD_OWNER_REF);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, PhonarchDbTableColumn.COL_COD_SNAPSHOT);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
