package br.com.mind5.security.userPassword.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class DaoUpswdDeleteSingle extends DaoStmtTemplate<UpswdInfo> {
	private final String MAIN_TABLE = DaoDbTable.USER_PASSWORD_TABLE;
	
	
	public DaoUpswdDeleteSingle(Connection conn, UpswdInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.HARD_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, UpswdInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new DaoUpswdWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<UpswdInfo> getResultParserHook() {
		return new DaoResultParser<UpswdInfo>() {
			@Override public List<UpswdInfo> parseResult(UpswdInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<UpswdInfo> finalResult = new ArrayList<>();
				UpswdInfo emptyInfo = new UpswdInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
