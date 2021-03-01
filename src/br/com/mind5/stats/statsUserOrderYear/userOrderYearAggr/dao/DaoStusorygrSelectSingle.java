package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.info.StusorygrInfo;

public final class DaoStusorygrSelectSingle extends DaoStmtTemplate<StusorygrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_USER_ORDER_YEAR_AGGR_TABLE;	
	
	
	public DaoStusorygrSelectSingle(Connection conn, StusorygrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StusorygrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoStusorygrWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StusorygrInfo> getResultParserHook() {
		return new DaoResultParser<StusorygrInfo>() {
			@Override public List<StusorygrInfo> parseResult(StusorygrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StusorygrInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StusorygrInfo dataInfo = new StusorygrInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoStusorygrDbTableColumn.COL_COD_OWNER);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoStusorygrDbTableColumn.COL_COD_USER);
					dataInfo.postingYear = DaoFormatter.sqlToInt(stmtResult, DaoStusorygrDbTableColumn.COL_POSTING_YEAR);
					dataInfo.countYearCancelled = DaoFormatter.sqlToInt(stmtResult, DaoStusorygrDbTableColumn.COL_COUNT_YEAR_CANCELLED);
					dataInfo.countYearCreated = DaoFormatter.sqlToInt(stmtResult, DaoStusorygrDbTableColumn.COL_COUNT_YEAR_CREATED);
					dataInfo.countYearPaid = DaoFormatter.sqlToInt(stmtResult, DaoStusorygrDbTableColumn.COL_COUNT_YEAR_PAID);
					dataInfo.countYearPlaced = DaoFormatter.sqlToInt(stmtResult, DaoStusorygrDbTableColumn.COL_COUNT_YEAR_PLACED);				
					dataInfo.countYearTotal = DaoFormatter.sqlToInt(stmtResult, DaoStusorygrDbTableColumn.COL_COUNT_YEAR_TOTAL);					
					dataInfo.countYearWaiting = DaoFormatter.sqlToInt(stmtResult, DaoStusorygrDbTableColumn.COL_COUNT_YEAR_WAITING);					
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoStusorygrDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
