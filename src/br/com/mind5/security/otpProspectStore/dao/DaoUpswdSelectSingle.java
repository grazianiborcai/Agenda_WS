package br.com.mind5.security.otpProspectStore.dao;

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
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;

public final class DaoUpswdSelectSingle extends DaoStmtTemplate<OtporeInfo> {	
	private final String MAIN_TABLE = DaoDbTable.USER_PASSWORD_TABLE;
	
	
	public DaoUpswdSelectSingle(Connection conn, OtporeInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OtporeInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoUpswdWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<OtporeInfo> getResultParserHook() {
		return new DaoResultParser<OtporeInfo>() {
			@Override public List<OtporeInfo> parseResult(OtporeInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OtporeInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					OtporeInfo dataInfo = new OtporeInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoUpswdDbTableColumn.COL_COD_OWNER);
					dataInfo.prospectEmail = stmtResult.getLong(DaoUpswdDbTableColumn.COL_COD_USER);
					dataInfo.hash = DaoFormatter.sqlToBase64(stmtResult, DaoUpswdDbTableColumn.COL_PASSWORD);	
					dataInfo.salt = DaoFormatter.sqlToBase64(stmtResult, DaoUpswdDbTableColumn.COL_SALT);	
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoUpswdDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
