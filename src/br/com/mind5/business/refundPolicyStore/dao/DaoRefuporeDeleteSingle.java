package br.com.mind5.business.refundPolicyStore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoRefuporeDeleteSingle extends DaoStmtTemplate<RefuporeInfo> {
	private final String MAIN_TABLE = DaoDbTable.REFUND_POLICY_STORE_TABLE;	
	
	
	public DaoRefuporeDeleteSingle(Connection conn, RefuporeInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, RefuporeInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new DaoRefuporeWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<RefuporeInfo> getResultParserHook() {
		return new DaoResultParser<RefuporeInfo>() {
			@Override public List<RefuporeInfo> parseResult(RefuporeInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<RefuporeInfo> finalResult = new ArrayList<>();
				RefuporeInfo emptyInfo = new RefuporeInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
