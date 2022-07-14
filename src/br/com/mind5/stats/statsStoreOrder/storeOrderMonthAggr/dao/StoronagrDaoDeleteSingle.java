package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.dao;

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
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;

public final class StoronagrDaoDeleteSingle extends DaoStmtTemplate<StoronagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_ORDER_MONTH_TABLE;
	
	
	public StoronagrDaoDeleteSingle(Connection conn, StoronagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.HARD_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StoronagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new StoronagrDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<StoronagrInfo> getResultParserHook() {
		return new DaoResultParser<StoronagrInfo>() {
			@Override public List<StoronagrInfo> parseResult(StoronagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StoronagrInfo> finalResult = new ArrayList<>();
				StoronagrInfo emptyInfo = new StoronagrInfo();
				finalResult.add(emptyInfo);
				return finalResult;
			}
		};
	}
}
