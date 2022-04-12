package br.com.mind5.business.storeFavoriteSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class StoritarchDaoSelectSingle extends DaoStmtTemplate<StoritarchInfo> {	
	private final String MAIN_TABLE = DaoDbTable.STORE_FAVORITE_TABLE;
	
	
	public StoritarchDaoSelectSingle(Connection conn, StoritarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STORE_FAVORITE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StoritarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StoritarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StoritarchInfo> getResultParserHook() {
		return new DaoResultParser<StoritarchInfo>() {
			@Override public List<StoritarchInfo> parseResult(StoritarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StoritarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StoritarchInfo dataInfo = new StoritarchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(StoritarchDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(StoritarchDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codUser = stmtResult.getLong(StoritarchDaoDbTableColumn.COL_COD_USER);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
