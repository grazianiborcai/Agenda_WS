package br.com.mind5.security.userPassword.dao;

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
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class UpswdSelectSingle extends DaoStmtTemplate<UpswdInfo> {	
	private final String MAIN_TABLE = DaoDbTable.USER_PASSWORD_TABLE;
	
	
	public UpswdSelectSingle(Connection conn, UpswdInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, UpswdInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new UpswdWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<UpswdInfo> getResultParserHook() {
		return new DaoResultParser<UpswdInfo>() {
			@Override public List<UpswdInfo> parseResult(UpswdInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<UpswdInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					UpswdInfo dataInfo = new UpswdInfo();
					
					dataInfo.codOwner = stmtResult.getLong(UpswdDbTableColumn.COL_COD_OWNER);
					dataInfo.codUser = stmtResult.getLong(UpswdDbTableColumn.COL_COD_USER);
					dataInfo.hash = DaoFormatter.sqlToBase64(stmtResult, UpswdDbTableColumn.COL_PASSWORD);	
					dataInfo.salt = DaoFormatter.sqlToBase64(stmtResult, UpswdDbTableColumn.COL_SALT);	
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, UpswdDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
