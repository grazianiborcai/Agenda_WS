package br.com.mind5.business.phone.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PhoneDaoSelectSingle extends DaoStmtTemplate<PhoneInfo> {
	private final String MAIN_TABLE = DaoDbTable.PHONE_TABLE;	
	
	
	public PhoneDaoSelectSingle(Connection conn, PhoneInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PhoneInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new PhoneDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
		
	@Override protected DaoResultParser<PhoneInfo> getResultParserHook() {
		return new DaoResultParser<PhoneInfo>() {
			@Override public List<PhoneInfo> parseResult(PhoneInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PhoneInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PhoneInfo dataInfo = new PhoneInfo();

					dataInfo.number          = stmtResult.getString(PhoneDaoDbTableColumn.COL_NUMBER);		
					dataInfo.codUser         = DaoFormatter.sqlToLong(stmtResult, PhoneDaoDbTableColumn.COL_COD_USER);								
					dataInfo.codArea         = stmtResult.getString(PhoneDaoDbTableColumn.COL_COD_AREA);
					dataInfo.codStore        = DaoFormatter.sqlToLong(stmtResult, PhoneDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codPhone        = stmtResult.getLong(PhoneDaoDbTableColumn.COL_COD_PHONE);
					dataInfo.codOwner        = stmtResult.getLong(PhoneDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.createdOn       = DaoFormatter.sqlToLocalDateTime(stmtResult, PhoneDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy       = DaoFormatter.sqlToLong(stmtResult, PhoneDaoDbTableColumn.COL_CREATED_BY);					
					dataInfo.isDefault       = stmtResult.getBoolean(PhoneDaoDbTableColumn.COL_IS_DEFAULT);
					dataInfo.phoneName       = stmtResult.getString(PhoneDaoDbTableColumn.COL_PHONE_NAME);
					dataInfo.fullNumber      = stmtResult.getString(PhoneDaoDbTableColumn.COL_FULL_NUMBER);
					dataInfo.recordMode      = stmtResult.getString(PhoneDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.complement      = stmtResult.getString(PhoneDaoDbTableColumn.COL_COMPLEMENT);
					dataInfo.codOwnerRef     = DaoFormatter.sqlToLong(stmtResult, PhoneDaoDbTableColumn.COL_COD_OWNER_REF);
					dataInfo.lastChanged     = DaoFormatter.sqlToLocalDateTime(stmtResult, PhoneDaoDbTableColumn.COL_LAST_CHANGED);					
					dataInfo.codSnapshot     = DaoFormatter.sqlToLong(stmtResult, PhoneDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codCustomer     = DaoFormatter.sqlToLong(stmtResult, PhoneDaoDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codEmployee     = DaoFormatter.sqlToLong(stmtResult, PhoneDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.lastChangedBy   = DaoFormatter.sqlToLong(stmtResult, PhoneDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.codLegalPerson  = DaoFormatter.sqlToLong(stmtResult, PhoneDaoDbTableColumn.COL_COD_LEGAL_PERSON);
					dataInfo.codCountryPhone = stmtResult.getInt(PhoneDaoDbTableColumn.COL_COUNTRY_PHONE);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
