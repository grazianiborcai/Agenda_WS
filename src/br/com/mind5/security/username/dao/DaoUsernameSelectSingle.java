package br.com.mind5.security.username.dao;

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
import br.com.mind5.security.username.info.UsernameInfo;

public final class DaoUsernameSelectSingle extends DaoStmtTemplate<UsernameInfo> {
	private final String MAIN_TABLE = DaoDbTable.USER_TABLE;
	
		
	public DaoUsernameSelectSingle(Connection conn, UsernameInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.USERNAME_VIEW;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, UsernameInfo recordInfo) {	
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoUsernameWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<UsernameInfo> getResultParserHook() {
		return new DaoResultParser<UsernameInfo>() {
			@Override public List<UsernameInfo> parseResult(UsernameInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<UsernameInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					UsernameInfo dataInfo = new UsernameInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoUsernameDbTableColumn.COL_COD_OWNER);
					dataInfo.codUser = stmtResult.getLong(DaoUsernameDbTableColumn.COL_COD_USER);									
					dataInfo.recordMode = stmtResult.getString(DaoUsernameDbTableColumn.COL_RECORD_MODE);
					dataInfo.username = stmtResult.getString(DaoUsernameDbTableColumn.COL_USERNAME);
					dataInfo.codAuthGroup = stmtResult.getString(DaoUsernameDbTableColumn.COL_COD_AUTH_GROUP);
					dataInfo.codUserCategory = DaoFormatter.sqlToChar(stmtResult, DaoUsernameDbTableColumn.COL_COD_USER_CATEG);
	
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
