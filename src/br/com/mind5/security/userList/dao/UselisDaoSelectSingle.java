package br.com.mind5.security.userList.dao;

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
import br.com.mind5.security.userList.info.UselisInfo;

public final class UselisDaoSelectSingle extends DaoStmtTemplate<UselisInfo> {
	private final String MAIN_TABLE = DaoDbTable.USER_TABLE;
	
	
	public UselisDaoSelectSingle(Connection conn, UselisInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.USER_LIST_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, UselisInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new UselisDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<UselisInfo> getResultParserHook() {
		return new DaoResultParser<UselisInfo>() {
			@Override public List<UselisInfo> parseResult(UselisInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<UselisInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					UselisInfo dataInfo = new UselisInfo();
					
					dataInfo.codOwner = stmtResult.getLong(UselisDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codUser = stmtResult.getLong(UselisDaoDbTableColumn.COL_COD_USER);									
					dataInfo.recordMode = stmtResult.getString(UselisDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.username = stmtResult.getString(UselisDaoDbTableColumn.COL_USERNAME);
					dataInfo.codAuthGroup = stmtResult.getString(UselisDaoDbTableColumn.COL_COD_AUTH_GROUP);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, UselisDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, UselisDaoDbTableColumn.COL_COD_PERSON);
					dataInfo.codUserCategory = DaoFormatter.sqlToChar(stmtResult, UselisDaoDbTableColumn.COL_COD_USER_CATEG);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, UselisDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, UselisDaoDbTableColumn.COL_LAST_CHANGED);	
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
