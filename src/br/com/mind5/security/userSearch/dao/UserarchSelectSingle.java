package br.com.mind5.security.userSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.security.userSearch.info.UserarchInfo;

public final class UserarchSelectSingle extends DaoStmtTemplate<UserarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.USER_TABLE;
	
	
	public UserarchSelectSingle(Connection conn, UserarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.USER_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, UserarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new UserarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<UserarchInfo> getResultParserHook() {
		return new DaoResultParserV2<UserarchInfo>() {
			@Override public List<UserarchInfo> parseResult(UserarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<UserarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					UserarchInfo dataInfo = new UserarchInfo();
					dataInfo.codOwner = stmtResult.getLong(UserarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codUser = stmtResult.getLong(UserarchDbTableColumn.COL_COD_USER);									
					dataInfo.recordMode = stmtResult.getString(UserarchDbTableColumn.COL_RECORD_MODE);
					dataInfo.username = stmtResult.getString(UserarchDbTableColumn.COL_USERNAME);
					dataInfo.codAuthGroup = stmtResult.getString(UserarchDbTableColumn.COL_COD_AUTH_GROUP);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, UserarchDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, UserarchDbTableColumn.COL_COD_PERSON);
					dataInfo.codUserCategory = DaoFormatter.sqlToChar(stmtResult, UserarchDbTableColumn.COL_COD_USER_CATEG);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
