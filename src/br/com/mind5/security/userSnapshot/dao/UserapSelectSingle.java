package br.com.mind5.security.userSnapshot.dao;

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
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class UserapSelectSingle extends DaoStmtTemplate<UserapInfo> {
	private final String MAIN_TABLE = DaoDbTable.USER_SNAPSHOT_TABLE;
	
	
	public UserapSelectSingle(Connection conn, UserapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, UserapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new UserapWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<UserapInfo> getResultParserHook() {
		return new DaoResultParser<UserapInfo>() {
			@Override public List<UserapInfo> parseResult(UserapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<UserapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					UserapInfo dataInfo = new UserapInfo();
					
					dataInfo.codOwner = stmtResult.getLong(UserapDbTableColumn.COL_COD_OWNER);
					dataInfo.codSnapshot = stmtResult.getLong(UserapDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codUser = stmtResult.getLong(UserapDbTableColumn.COL_COD_USER);									
					dataInfo.recordMode = stmtResult.getString(UserapDbTableColumn.COL_RECORD_MODE);
					dataInfo.username = stmtResult.getString(UserapDbTableColumn.COL_USERNAME);
					dataInfo.codAuthGroup = stmtResult.getString(UserapDbTableColumn.COL_COD_AUTH_GROUP);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, UserapDbTableColumn.COL_COD_PERSON);
					dataInfo.codPersonSnapshot = DaoFormatter.sqlToLong(stmtResult, UserapDbTableColumn.COL_COD_PERSON_SNAPSHOT);
					dataInfo.codUserCategory = DaoFormatter.sqlToChar(stmtResult, UserapDbTableColumn.COL_COD_USER_CATEG);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, UserapDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, UserapDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
