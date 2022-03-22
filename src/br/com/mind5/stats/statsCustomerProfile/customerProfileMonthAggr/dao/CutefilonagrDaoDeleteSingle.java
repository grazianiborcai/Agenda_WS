package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.dao;

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
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info.CutefilonagrInfo;

public final class CutefilonagrDaoDeleteSingle extends DaoStmtTemplate<CutefilonagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_CUSTOMER_PROFILE_MONTH_TABLE;	
	
	
	public CutefilonagrDaoDeleteSingle(Connection conn, CutefilonagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.HARD_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CutefilonagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new CutefilonagrDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<CutefilonagrInfo> getResultParserHook() {
		return new DaoResultParser<CutefilonagrInfo>() {
			@Override public List<CutefilonagrInfo> parseResult(CutefilonagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CutefilonagrInfo> finalResult = new ArrayList<>();
				CutefilonagrInfo emptyInfo = new CutefilonagrInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
