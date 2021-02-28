package br.com.mind5.stats.userOrderYearLive.dao;

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
import br.com.mind5.stats.userOrderYearLive.info.StusoryliInfo;

public final class DaoStusoryliSelectSingle extends DaoStmtTemplate<StusoryliInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_USER_ORDER_YEAR_LIVE_TABLE;	
	
	
	public DaoStusoryliSelectSingle(Connection conn, StusoryliInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StusoryliInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoStusoryliWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StusoryliInfo> getResultParserHook() {
		return new DaoResultParser<StusoryliInfo>() {
			@Override public List<StusoryliInfo> parseResult(StusoryliInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StusoryliInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StusoryliInfo dataInfo = new StusoryliInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoStusoryliDbTableColumn.COL_COD_OWNER);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoStusoryliDbTableColumn.COL_COD_USER);
					dataInfo.postingYear = DaoFormatter.sqlToInt(stmtResult, DaoStusoryliDbTableColumn.COL_POSTING_YEAR);
					dataInfo.countYearCancelled = DaoFormatter.sqlToInt(stmtResult, DaoStusoryliDbTableColumn.COL_COUNT_YEAR_CANCELLED);
					dataInfo.countYearCreated = DaoFormatter.sqlToInt(stmtResult, DaoStusoryliDbTableColumn.COL_COUNT_YEAR_CREATED);
					dataInfo.countYearPaid = DaoFormatter.sqlToInt(stmtResult, DaoStusoryliDbTableColumn.COL_COUNT_YEAR_PAID);
					dataInfo.countYearPlaced = DaoFormatter.sqlToInt(stmtResult, DaoStusoryliDbTableColumn.COL_COUNT_YEAR_PLACED);				
					dataInfo.countYearTotal = DaoFormatter.sqlToInt(stmtResult, DaoStusoryliDbTableColumn.COL_COUNT_YEAR_TOTAL);					
					dataInfo.countYearWaiting = DaoFormatter.sqlToInt(stmtResult, DaoStusoryliDbTableColumn.COL_COUNT_YEAR_WAITING);					
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoStusoryliDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
