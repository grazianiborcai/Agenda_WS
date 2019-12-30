package br.com.mind5.business.storeLeaveDateSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class StolarchSelectSingle extends DaoStmtTemplate<StolarchInfo> {	
	private final String MAIN_TABLE = DaoDbTable.STORE_LD_TABLE;
	
	
	public StolarchSelectSingle(Connection conn, StolarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STORE_LD_SEARCH_VIEW;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StolarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StolarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
		
	@Override protected DaoResultParserV2<StolarchInfo> getResultParserHook() {
		return new DaoResultParserV2<StolarchInfo>() {
			@Override public List<StolarchInfo> parseResult(StolarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StolarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StolarchInfo dataInfo = new StolarchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(StolarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(StolarchDbTableColumn.COL_COD_STORE);
					dataInfo.recordMode = stmtResult.getString(StolarchDbTableColumn.COL_RECORD_MODE);	
					dataInfo.timeValidFrom = DaoFormatter.sqlToLocalTime(stmtResult, StolarchDbTableColumn.COL_TM_VALID_FROM);
					dataInfo.timeValidTo = DaoFormatter.sqlToLocalTime(stmtResult, StolarchDbTableColumn.COL_TM_VALID_TO);
					dataInfo.dateValidFrom = DaoFormatter.sqlToLocalDate(stmtResult, StolarchDbTableColumn.COL_DT_VALID_FROM);
					dataInfo.dateValidTo = DaoFormatter.sqlToLocalDate(stmtResult, StolarchDbTableColumn.COL_DT_VALID_TO);		
					dataInfo.monthValidFrom = DaoFormatter.sqlToInt(stmtResult, StolarchDbTableColumn.COL_MONTH_VALID_FROM);		
					dataInfo.yearValidFrom = DaoFormatter.sqlToInt(stmtResult, StolarchDbTableColumn.COL_YEAR_VALID_FROM);	
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
