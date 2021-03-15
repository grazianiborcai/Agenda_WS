package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.dao;

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
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;

public final class DaoStusorygrarchSelectSingle extends DaoStmtTemplate<StusorygrarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_USER_ORDER_YEAR_AGGR_TABLE;	
	
	
	public DaoStusorygrarchSelectSingle(Connection conn, StusorygrarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STAT_USER_ORDER_YEAR_AGGR_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StusorygrarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoStusorygrarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StusorygrarchInfo> getResultParserHook() {
		return new DaoResultParser<StusorygrarchInfo>() {
			@Override public List<StusorygrarchInfo> parseResult(StusorygrarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StusorygrarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StusorygrarchInfo dataInfo = new StusorygrarchInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoStusorygrarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoStusorygrarchDbTableColumn.COL_COD_USER);
					dataInfo.postingYear = DaoFormatter.sqlToInt(stmtResult, DaoStusorygrarchDbTableColumn.COL_POSTING_YEAR);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
