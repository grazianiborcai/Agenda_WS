package br.com.mind5.business.storeFavorite.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoStoriteSelectSingle extends DaoStmtTemplate<StoriteInfo> {	
	private final String MAIN_TABLE = DaoDbTable.STORE_FAVORITE_TABLE;
	
	
	public DaoStoriteSelectSingle(Connection conn, StoriteInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StoriteInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoStoriteWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StoriteInfo> getResultParserHook() {
		return new DaoResultParser<StoriteInfo>() {
			@Override public List<StoriteInfo> parseResult(StoriteInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StoriteInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StoriteInfo dataInfo = new StoriteInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoStoriteDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(DaoStoriteDbTableColumn.COL_COD_STORE);
					dataInfo.codUser = stmtResult.getLong(DaoStoriteDbTableColumn.COL_COD_USER);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoStoriteDbTableColumn.COL_CREATED_ON);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoStoriteDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
