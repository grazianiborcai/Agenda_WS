package br.com.mind5.security.otpProspectStore.dao;

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
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;

public final class DaoOtporeDeleteSingle extends DaoStmtTemplate<OtporeInfo> {
	private final String MAIN_TABLE = DaoDbTable.OTP_PROSPECT_STORE_TABLE;
	
	
	public DaoOtporeDeleteSingle(Connection conn, OtporeInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.HARD_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OtporeInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new DaoOtporeWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<OtporeInfo> getResultParserHook() {
		return new DaoResultParser<OtporeInfo>() {
			@Override public List<OtporeInfo> parseResult(OtporeInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OtporeInfo> finalResult = new ArrayList<>();
				OtporeInfo emptyInfo = new OtporeInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
