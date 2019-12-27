package br.com.mind5.security.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.security.user.info.UserInfo;

public final class UserUpdateSingle extends DaoStmtTemplate<UserInfo> {
	private final String MAIN_TABLE = DaoDbTable.USER_TABLE;	
	
	
	public UserUpdateSingle(Connection conn, UserInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, UserInfo recordInfo) {	
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new UserWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<UserInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<UserInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, UserInfo recordInfo) throws SQLException {
				int i = 1;
	
				stmt.setString(i++, recordInfo.recordMode);	
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPerson);
				stmt = DaoFormatter.charToStmt(stmt, i++, recordInfo.codUserCategory);
				stmt.setString(i++, recordInfo.username);	
				stmt.setString(i++, recordInfo.codAuthGroup);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPersonSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);				
				
				return stmt;
			}	
		};
	}
}
