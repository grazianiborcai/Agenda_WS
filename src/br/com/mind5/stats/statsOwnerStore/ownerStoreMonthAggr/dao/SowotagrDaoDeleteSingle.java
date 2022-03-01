package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.dao;

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
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;

public final class SowotagrDaoDeleteSingle extends DaoStmtTemplate<SowotagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_OWNER_STORE_MONTH_TABLE;	
	
	
	public SowotagrDaoDeleteSingle(Connection conn, SowotagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.HARD_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SowotagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new SowotagrDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<SowotagrInfo> getResultParserHook() {
		return new DaoResultParser<SowotagrInfo>() {
			@Override public List<SowotagrInfo> parseResult(SowotagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SowotagrInfo> finalResult = new ArrayList<>();
				SowotagrInfo emptyInfo = new SowotagrInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
