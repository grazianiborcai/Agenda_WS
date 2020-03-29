package br.com.mind5.business.moonCalendar.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class MooncalSelectSingle extends DaoStmtTemplate<MooncalInfo> {
	private final String MAIN_TABLE = DaoDbTable.MOON_CALENDAR_TABLE;
	
	
	public MooncalSelectSingle(Connection conn, MooncalInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MooncalInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		
		DaoStmtWhere whereClause = new MooncalWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<MooncalInfo> getResultParserHook() {
		return new DaoResultParser<MooncalInfo>() {
			@Override public List<MooncalInfo> parseResult(MooncalInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MooncalInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MooncalInfo dataInfo = new MooncalInfo();
					
					dataInfo.moonDate = DaoFormatter.sqlToLocalDate(stmtResult, MooncalDbTableColumn.COL_MOON_DATE);
					dataInfo.moonDateTime = DaoFormatter.sqlToLocalDateTime(stmtResult, MooncalDbTableColumn.COL_MOON_DATE_TIME);
					dataInfo.moonTime = DaoFormatter.sqlToLocalTime(stmtResult, MooncalDbTableColumn.COL_MOON_TIME);
					dataInfo.codMoonPhase = stmtResult.getInt(MooncalDbTableColumn.COL_COD_MOON_PHASE);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
