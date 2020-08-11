package br.com.mind5.security.userPasswordSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchInfo;

public final class DaoUpswdarchSelectSingle extends DaoStmtTemplate<UpswdarchInfo> {	
	private final String MAIN_TABLE = DaoDbTable.USER_PASSWORD_TABLE;
	
	
	public DaoUpswdarchSelectSingle(Connection conn, UpswdarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.USER_PASSWORD_SEARCH_VIEW;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, UpswdarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoUpswdarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<UpswdarchInfo> getResultParserHook() {
		return new DaoResultParser<UpswdarchInfo>() {
			@Override public List<UpswdarchInfo> parseResult(UpswdarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<UpswdarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					UpswdarchInfo dataInfo = new UpswdarchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoUpswdarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codUser = stmtResult.getLong(DaoUpswdarchDbTableColumn.COL_COD_USER);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoUpswdarchDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
