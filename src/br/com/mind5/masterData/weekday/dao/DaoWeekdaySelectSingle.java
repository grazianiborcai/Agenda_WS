package br.com.mind5.masterData.weekday.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class DaoWeekdaySelectSingle extends DaoStmtTemplate<WeekdayInfo> {
	private final String MAIN_TABLE = DaoDbTable.WEEKDAY_TABLE;
	
	
	public DaoWeekdaySelectSingle(Connection conn, WeekdayInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, WeekdayInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoWeekdayWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(WeekdayInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoWeekdayJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<WeekdayInfo> getResultParserHook() {
		return new DaoResultParser<WeekdayInfo>() {
			@Override public List<WeekdayInfo> parseResult(WeekdayInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<WeekdayInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					WeekdayInfo dataInfo = new WeekdayInfo();
					
					dataInfo.codWeekday = stmtResult.getInt(DaoWeekdayDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.sortSaturday = stmtResult.getInt(DaoWeekdayDbTableColumn.COL_SORT_SATURDAY);
					dataInfo.sortSunday = stmtResult.getInt(DaoWeekdayDbTableColumn.COL_SORT_SUNDAY);
					dataInfo.txtWeekday = stmtResult.getString(DaoWeekdayDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoWeekdayDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
