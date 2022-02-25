package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.dao;

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
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;

public final class DaoSowedulagrDeleteSingle extends DaoStmtTemplate<SowedulagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_OWNER_SCHEDULE_MONTH_TABLE;	
	
	
	public DaoSowedulagrDeleteSingle(Connection conn, SowedulagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.HARD_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SowedulagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new DaoSowedulagrWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<SowedulagrInfo> getResultParserHook() {
		return new DaoResultParser<SowedulagrInfo>() {
			@Override public List<SowedulagrInfo> parseResult(SowedulagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SowedulagrInfo> finalResult = new ArrayList<>();
				SowedulagrInfo emptyInfo = new SowedulagrInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
