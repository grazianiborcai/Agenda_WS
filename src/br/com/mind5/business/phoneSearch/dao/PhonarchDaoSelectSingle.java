package br.com.mind5.business.phoneSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PhonarchDaoSelectSingle extends DaoStmtTemplate<PhonarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.PHONE_TABLE;		
	
	
	public PhonarchDaoSelectSingle(Connection conn, PhonarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	protected String getLookupTableHook() {
		return DaoDbTable.PHONE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PhonarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new PhonarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<PhonarchInfo> getResultParserHook() {
		return new DaoResultParser<PhonarchInfo>() {
			@Override public List<PhonarchInfo> parseResult(PhonarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PhonarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PhonarchInfo dataInfo = new PhonarchInfo();
					
					dataInfo.codPhone = stmtResult.getLong(PhonarchDaoDbTableColumn.COL_COD_PHONE);
					dataInfo.codOwner = stmtResult.getLong(PhonarchDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codCountryPhone = stmtResult.getInt(PhonarchDaoDbTableColumn.COL_COUNTRY_PHONE);
					dataInfo.fullNumber = stmtResult.getString(PhonarchDaoDbTableColumn.COL_FULL_NUMBER);
					dataInfo.recordMode = stmtResult.getString(PhonarchDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codArea = stmtResult.getString(PhonarchDaoDbTableColumn.COL_COD_AREA);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, PhonarchDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, PhonarchDaoDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, PhonarchDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, PhonarchDaoDbTableColumn.COL_COD_USER);
					dataInfo.codLegalPerson = DaoFormatter.sqlToLong(stmtResult, PhonarchDaoDbTableColumn.COL_COD_LEGAL_PERSON);
					dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, PhonarchDaoDbTableColumn.COL_COD_OWNER_REF);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, PhonarchDaoDbTableColumn.COL_COD_SNAPSHOT);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
