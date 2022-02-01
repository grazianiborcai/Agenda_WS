package br.com.mind5.business.calendarMonth.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoCalonthSelectSingle extends DaoStmtTemplate<CalonthInfo> {
	private final String MAIN_TABLE = DaoDbTable.CALENDAR_MONTH_TABLE;
	
	
	public DaoCalonthSelectSingle(Connection conn, CalonthInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CalonthInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		
		DaoStmtWhere whereClause = new DaoCalonthWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<CalonthInfo> getResultParserHook() {
		return new DaoResultParser<CalonthInfo>() {
			@Override public List<CalonthInfo> parseResult(CalonthInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CalonthInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					CalonthInfo dataInfo = new CalonthInfo();
					
					dataInfo.calmonth = stmtResult.getString(DaoCalonthDbTableColumn.COL_CALMONTH);
					dataInfo.year = stmtResult.getInt(DaoCalonthDbTableColumn.COL_YEAR);					
					dataInfo.month = stmtResult.getInt(DaoCalonthDbTableColumn.COL_MONTH);
					dataInfo.lastDay = DaoFormatter.sqlToLocalDate(stmtResult, DaoCalonthDbTableColumn.COL_LAST_DAY);
					dataInfo.firstDay =  DaoFormatter.sqlToLocalDate(stmtResult, DaoCalonthDbTableColumn.COL_FIRST_DAY);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
