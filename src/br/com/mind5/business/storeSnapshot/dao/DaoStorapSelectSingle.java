package br.com.mind5.business.storeSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoStorapSelectSingle extends DaoStmtTemplate<StorapInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_SNAPSHOT_TABLE;	
	
	
	public DaoStorapSelectSingle(Connection conn, StorapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StorapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoStorapWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<StorapInfo> getResultParserHook() {
		return new DaoResultParser<StorapInfo>() {
			@Override public List<StorapInfo> parseResult(StorapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StorapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StorapInfo dataInfo = new StorapInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoStorapDbTableColumn.COL_COD_OWNER);
					dataInfo.codSnapshot = stmtResult.getLong(DaoStorapDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codStore = stmtResult.getLong(DaoStorapDbTableColumn.COL_COD_STORE);
					dataInfo.codCurr = stmtResult.getString(DaoStorapDbTableColumn.COL_COD_CURRENCY);
					dataInfo.codTimezone = stmtResult.getString(DaoStorapDbTableColumn.COL_COD_TIMEZONE);
					dataInfo.recordMode = stmtResult.getString(DaoStorapDbTableColumn.COL_RECORD_MODE);	
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, DaoStorapDbTableColumn.COL_COD_PERSON);
					dataInfo.codCompany = DaoFormatter.sqlToLong(stmtResult, DaoStorapDbTableColumn.COL_COD_COMPANY);
					dataInfo.codAddress = DaoFormatter.sqlToLong(stmtResult, DaoStorapDbTableColumn.COL_COD_ADDRESS);					
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoStorapDbTableColumn.COL_COD_USER);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoStorapDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoStorapDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.codCompanySnapshot = DaoFormatter.sqlToLong(stmtResult, DaoStorapDbTableColumn.COL_COD_COMPANY_SNAPSHOT);
					dataInfo.codAddressSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoStorapDbTableColumn.COL_COD_ADDRESS_SNAPSHOT);					
					dataInfo.codPersonSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoStorapDbTableColumn.COL_COD_PERSON_SNAPSHOT);
					dataInfo.codUserSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoStorapDbTableColumn.COL_COD_USER_SNAPSHOT);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoStorapDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, DaoStorapDbTableColumn.COL_CREATED_BY);		
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
