package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.dao;

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
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;

public final class DaoStordagrDeleteSingle extends DaoStmtTemplate<StordagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_ORDER_DAY_TABLE;
	
	
	public DaoStordagrDeleteSingle(Connection conn, StordagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.HARD_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StordagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new DaoStordagrWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<StordagrInfo> getResultParserHook() {
		return new DaoResultParser<StordagrInfo>() {
			@Override public List<StordagrInfo> parseResult(StordagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StordagrInfo> finalResult = new ArrayList<>();
				StordagrInfo emptyInfo = new StordagrInfo();
				finalResult.add(emptyInfo);
				return finalResult;
			}
		};
	}
}
