package br.com.mind5.security.otpUserPassword.dao;

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
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;

public final class OtperasDaoDeleteSingle extends DaoStmtTemplate<OtperasInfo> {
	private final String MAIN_TABLE = DaoDbTable.OTP_USER_PASSWORD_TABLE;
	
	
	public OtperasDaoDeleteSingle(Connection conn, OtperasInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.HARD_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OtperasInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new OtperasDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<OtperasInfo> getResultParserHook() {
		return new DaoResultParser<OtperasInfo>() {
			@Override public List<OtperasInfo> parseResult(OtperasInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OtperasInfo> finalResult = new ArrayList<>();
				OtperasInfo emptyInfo = new OtperasInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
