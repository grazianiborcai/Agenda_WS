package br.com.mind5.security.user.dao;

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
import br.com.mind5.security.user.info.UserInfo;

public final class DaoUserSelectSingle extends DaoStmtTemplate<UserInfo> {
	private final String MAIN_TABLE = DaoDbTable.USER_TABLE;
	
	
	public DaoUserSelectSingle(Connection conn, UserInfo recordInfo, String schemaName) {
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
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoUserWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<UserInfo> getResultParserHook() {
		return new DaoResultParser<UserInfo>() {
			@Override public List<UserInfo> parseResult(UserInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<UserInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					UserInfo dataInfo = new UserInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoUserDbTableColumn.COL_COD_OWNER);
					dataInfo.codUser = stmtResult.getLong(DaoUserDbTableColumn.COL_COD_USER);									
					dataInfo.recordMode = stmtResult.getString(DaoUserDbTableColumn.COL_RECORD_MODE);
					dataInfo.username = stmtResult.getString(DaoUserDbTableColumn.COL_USERNAME);
					dataInfo.codAuthGroup = stmtResult.getString(DaoUserDbTableColumn.COL_COD_AUTH_GROUP);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoUserDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, DaoUserDbTableColumn.COL_COD_PERSON);
					dataInfo.codUserCategory = DaoFormatter.sqlToChar(stmtResult, DaoUserDbTableColumn.COL_COD_USER_CATEG);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoUserDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoUserDbTableColumn.COL_LAST_CHANGED);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoUserDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, DaoUserDbTableColumn.COL_CREATED_BY);	
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
