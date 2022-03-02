package br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.dao;

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
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrInfo;

public final class SowusagrDaoDeleteSingle extends DaoStmtTemplate<SowusagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_OWNER_USER_MONTH_TABLE;	
	
	
	public SowusagrDaoDeleteSingle(Connection conn, SowusagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.HARD_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SowusagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new SowusagrDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<SowusagrInfo> getResultParserHook() {
		return new DaoResultParser<SowusagrInfo>() {
			@Override public List<SowusagrInfo> parseResult(SowusagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SowusagrInfo> finalResult = new ArrayList<>();
				SowusagrInfo emptyInfo = new SowusagrInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
