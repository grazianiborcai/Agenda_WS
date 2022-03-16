package br.com.mind5.business.store.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class StoreDaoSelectSingle extends DaoStmtTemplate<StoreInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_TABLE;	
	
	
	public StoreDaoSelectSingle(Connection conn, StoreInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StoreInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StoreDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StoreInfo> getResultParserHook() {
		return new DaoResultParser<StoreInfo>() {
			@Override public List<StoreInfo> parseResult(StoreInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StoreInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StoreInfo dataInfo = new StoreInfo();
					
					dataInfo.codOwner = stmtResult.getLong(StoreDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(StoreDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codCurr = stmtResult.getString(StoreDaoDbTableColumn.COL_COD_CURRENCY);
					dataInfo.codTimezone = stmtResult.getString(StoreDaoDbTableColumn.COL_COD_TIMEZONE);
					dataInfo.recordMode = stmtResult.getString(StoreDaoDbTableColumn.COL_RECORD_MODE);	
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, StoreDaoDbTableColumn.COL_COD_PERSON);
					dataInfo.codCompany = DaoFormatter.sqlToLong(stmtResult, StoreDaoDbTableColumn.COL_COD_COMPANY);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, StoreDaoDbTableColumn.COL_COD_USER);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, StoreDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, StoreDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, StoreDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, StoreDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, StoreDaoDbTableColumn.COL_CREATED_BY);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
