package br.com.mind5.business.storeTextSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class StorextarchDaoSelectSingle extends DaoStmtTemplate<StorextarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_TEXT_TABLE;	
	
	public StorextarchDaoSelectSingle(Connection conn, StorextarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STORE_TEXT_SEARCH_VIEW;	
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StorextarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StorextarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
		
	@Override protected DaoResultParser<StorextarchInfo> getResultParserHook() {
		return new DaoResultParser<StorextarchInfo>() {
			@Override public List<StorextarchInfo> parseResult(StorextarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StorextarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StorextarchInfo dataInfo = new StorextarchInfo();
							
					dataInfo.codOwner = stmtResult.getLong(StorextarchDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(StorextarchDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codLanguage = stmtResult.getString(StorextarchDaoDbTableColumn.COL_COD_LANGUAGE);
					dataInfo.recordMode = stmtResult.getString(StorextarchDaoDbTableColumn.COL_RECORD_MODE);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
