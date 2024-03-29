package br.com.mind5.business.phoneSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PhonapDaoSelectSingle extends DaoStmtTemplate<PhonapInfo> {
	private final String MAIN_TABLE = DaoDbTable.PHONE_SNAPSHOT_TABLE;	
	
	
	public PhonapDaoSelectSingle(Connection conn, PhonapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PhonapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new PhonapDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<PhonapInfo> getResultParserHook() {
		return new DaoResultParser<PhonapInfo>() {
			@Override public List<PhonapInfo> parseResult(PhonapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PhonapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PhonapInfo dataInfo = new PhonapInfo();
					
					dataInfo.codPhone = stmtResult.getLong(PhonapDaoDbTableColumn.COL_COD_PHONE);
					dataInfo.codSnapshot = stmtResult.getLong(PhonapDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codOwner = stmtResult.getLong(PhonapDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codCountryPhone = stmtResult.getInt(PhonapDaoDbTableColumn.COL_COUNTRY_PHONE);
					dataInfo.fullNumber = stmtResult.getString(PhonapDaoDbTableColumn.COL_FULL_NUMBER);
					dataInfo.recordMode = stmtResult.getString(PhonapDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.complement = stmtResult.getString(PhonapDaoDbTableColumn.COL_COMPLEMENT);
					dataInfo.number = stmtResult.getString(PhonapDaoDbTableColumn.COL_NUMBER);
					dataInfo.codArea = stmtResult.getString(PhonapDaoDbTableColumn.COL_COD_AREA);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, PhonapDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codStoreSnapshot = DaoFormatter.sqlToLong(stmtResult, PhonapDaoDbTableColumn.COL_COD_STORE_SNAPSHOT);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, PhonapDaoDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codCustomerSnapshot = DaoFormatter.sqlToLong(stmtResult, PhonapDaoDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, PhonapDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codEmployeeSnapshot = DaoFormatter.sqlToLong(stmtResult, PhonapDaoDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, PhonapDaoDbTableColumn.COL_COD_USER);
					dataInfo.codUserSnapshot = DaoFormatter.sqlToLong(stmtResult, PhonapDaoDbTableColumn.COL_COD_USER_SNAPSHOT);
					dataInfo.codLegalPerson = DaoFormatter.sqlToLong(stmtResult, PhonapDaoDbTableColumn.COL_COD_LEGAL_PERSON);
					dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, PhonapDaoDbTableColumn.COL_COD_OWNER_REF);
					dataInfo.codOwnerRefSnapshot = DaoFormatter.sqlToLong(stmtResult, PhonapDaoDbTableColumn.COL_COD_OWNER_REF_SNAPSHOT);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, PhonapDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, PhonapDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, PhonapDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, PhonapDaoDbTableColumn.COL_CREATED_BY);
					dataInfo.isDefault = stmtResult.getBoolean(PhonapDaoDbTableColumn.COL_IS_DEFAULT);
					dataInfo.phoneName = stmtResult.getString(PhonapDaoDbTableColumn.COL_PHONE_NAME);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
