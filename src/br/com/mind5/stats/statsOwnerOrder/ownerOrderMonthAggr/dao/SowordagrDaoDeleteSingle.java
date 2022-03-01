package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.dao;

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
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;

public final class SowordagrDaoDeleteSingle extends DaoStmtTemplate<SowordagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_OWNER_ORDER_MONTH_TABLE;
	
	
	public SowordagrDaoDeleteSingle(Connection conn, SowordagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.HARD_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SowordagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new SowordagrDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<SowordagrInfo> getResultParserHook() {
		return new DaoResultParser<SowordagrInfo>() {
			@Override public List<SowordagrInfo> parseResult(SowordagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SowordagrInfo> finalResult = new ArrayList<>();
				SowordagrInfo emptyInfo = new SowordagrInfo();
				finalResult.add(emptyInfo);
				return finalResult;
			}
		};
	}
}
