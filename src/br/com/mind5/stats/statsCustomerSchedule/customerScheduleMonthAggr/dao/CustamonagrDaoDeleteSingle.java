package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.dao;

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
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrInfo;

public final class CustamonagrDaoDeleteSingle extends DaoStmtTemplate<CustamonagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_CUSTOMER_SCHEDULE_MONTH_TABLE;	
	
	
	public CustamonagrDaoDeleteSingle(Connection conn, CustamonagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.HARD_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CustamonagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new CustamonagrDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<CustamonagrInfo> getResultParserHook() {
		return new DaoResultParser<CustamonagrInfo>() {
			@Override public List<CustamonagrInfo> parseResult(CustamonagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CustamonagrInfo> finalResult = new ArrayList<>();
				CustamonagrInfo emptyInfo = new CustamonagrInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
