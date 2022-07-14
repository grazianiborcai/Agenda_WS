package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.dao;

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
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchInfo;

public final class StusorygerchDaoSelectSingle extends DaoStmtTemplate<StusorygerchInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_USER_ORDER_YEAR_STGN_TABLE;	
	
	
	public StusorygerchDaoSelectSingle(Connection conn, StusorygerchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STAT_USER_ORDER_YEAR_STGN_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StusorygerchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StusorygerchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StusorygerchInfo> getResultParserHook() {
		return new DaoResultParser<StusorygerchInfo>() {
			@Override public List<StusorygerchInfo> parseResult(StusorygerchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StusorygerchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StusorygerchInfo dataInfo = new StusorygerchInfo();
					
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, StusorygerchDaoDbTableColumn.COL_COD_USER);
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, StusorygerchDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.postingYear = DaoFormatter.sqlToInt(stmtResult, StusorygerchDaoDbTableColumn.COL_POSTING_YEAR);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
