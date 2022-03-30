package br.com.mind5.business.phone.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PhoneDaoDeleteSingle extends DaoStmtTemplate<PhoneInfo> {
	private final String MAIN_TABLE = DaoDbTable.PHONE_TABLE;	
	
	
	public PhoneDaoDeleteSingle(Connection conn, PhoneInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PhoneInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new PhoneDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<PhoneInfo> getResultParserHook() {
		return new DaoResultParser<PhoneInfo>() {
			@Override public List<PhoneInfo> parseResult(PhoneInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PhoneInfo> finalResult = new ArrayList<>();
				PhoneInfo emptyInfo = new PhoneInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
