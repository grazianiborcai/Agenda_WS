package br.com.mind5.business.calendarMonthSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonthSearch.info.CalontharchInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoCalontharchSelectSingle extends DaoStmtTemplate<CalontharchInfo> {
	private final String MAIN_TABLE = DaoDbTable.CALENDAR_MONTH_TABLE;
	
	
	public DaoCalontharchSelectSingle(Connection conn, CalontharchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.CALENDAR_MONTH_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CalontharchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		
		DaoStmtWhere whereClause = new DaoCalontharchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<CalontharchInfo> getResultParserHook() {
		return new DaoResultParser<CalontharchInfo>() {
			@Override public List<CalontharchInfo> parseResult(CalontharchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CalontharchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					CalontharchInfo dataInfo = new CalontharchInfo();
					
					dataInfo.calmonth = stmtResult.getString(DaoCalontharchDbTableColumn.COL_CALMONTH);
					dataInfo.year = stmtResult.getInt(DaoCalontharchDbTableColumn.COL_YEAR);					
					dataInfo.month = stmtResult.getInt(DaoCalontharchDbTableColumn.COL_MONTH);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
