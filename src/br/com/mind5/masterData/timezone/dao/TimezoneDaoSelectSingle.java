package br.com.mind5.masterData.timezone.dao;

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
import br.com.mind5.masterData.timezone.info.TimezoneInfo;

public final class TimezoneDaoSelectSingle extends DaoStmtTemplate<TimezoneInfo> {
	private final String MAIN_TABLE = DaoDbTable.TIMEZONE_TABLE;
	
	
	public TimezoneDaoSelectSingle(Connection conn, TimezoneInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, TimezoneInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new TimezoneDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(TimezoneInfo recordInfo) {
		DaoJoinBuilder joinText = new TimezoneDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<TimezoneInfo> getResultParserHook() {
		return new DaoResultParser<TimezoneInfo>() {
			@Override public List<TimezoneInfo> parseResult(TimezoneInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<TimezoneInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					TimezoneInfo dataInfo = new TimezoneInfo();
					
					dataInfo.codTimezone = stmtResult.getString(TimezoneDaoDbTableColumn.COL_COD_TIMEZONE);
					dataInfo.txtTimezone = stmtResult.getString(TimezoneDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(TimezoneDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
