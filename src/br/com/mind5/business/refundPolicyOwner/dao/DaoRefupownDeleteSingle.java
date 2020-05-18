package br.com.mind5.business.refundPolicyOwner.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoRefupownDeleteSingle extends DaoStmtTemplate<RefupownInfo> {
	private final String MAIN_TABLE = DaoDbTable.REFUND_POLICY_OWNER_TABLE;	
	
	
	public DaoRefupownDeleteSingle(Connection conn, RefupownInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, RefupownInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new DaoRefupownWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<RefupownInfo> getResultParserHook() {
		return new DaoResultParser<RefupownInfo>() {
			@Override public List<RefupownInfo> parseResult(RefupownInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<RefupownInfo> finalResult = new ArrayList<>();
				RefupownInfo emptyInfo = new RefupownInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
