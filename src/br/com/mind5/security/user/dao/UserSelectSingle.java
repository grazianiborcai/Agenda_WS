package br.com.mind5.security.user.dao;

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
import br.com.mind5.security.user.info.UserInfo;

public final class UserSelectSingle extends DaoStmtTemplate<UserInfo> {
	private final String MAIN_TABLE = DaoDbTable.USER_TABLE;
	
	
	public UserSelectSingle(Connection conn, UserInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, UserInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;	//DONT_IGNORE_NULL
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new UserWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<UserInfo> getResultParserHook() {
		return new DaoResultParserV2<UserInfo>() {
			@Override public List<UserInfo> parseResult(UserInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<UserInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					UserInfo dataInfo = new UserInfo();
					dataInfo.codOwner = stmtResult.getLong(UserDbTableColumn.COL_COD_OWNER);
					dataInfo.codUser = stmtResult.getLong(UserDbTableColumn.COL_COD_USER);									
					dataInfo.recordMode = stmtResult.getString(UserDbTableColumn.COL_RECORD_MODE);
					dataInfo.username = stmtResult.getString(UserDbTableColumn.COL_USERNAME);
					dataInfo.codAuthGroup = stmtResult.getString(UserDbTableColumn.COL_COD_AUTH_GROUP);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, UserDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, UserDbTableColumn.COL_COD_PERSON);
					dataInfo.codPersonSnapshot = DaoFormatter.sqlToLong(stmtResult, UserDbTableColumn.COL_COD_PERSON_SNAPSHOT);
					dataInfo.codUserCategory = DaoFormatter.sqlToChar(stmtResult, UserDbTableColumn.COL_COD_USER_CATEG);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, UserDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, UserDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
