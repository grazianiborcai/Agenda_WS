package br.com.mind5.business.storeWorkTime.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class StowotmSelectSingle extends DaoStmtTemplate<StowotmInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_WT_TABLE;	
	
	
	public StowotmSelectSingle(Connection conn, StowotmInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StowotmInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StowotmWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StowotmInfo> getResultParserHook() {
		return new DaoResultParser<StowotmInfo>() {
			@Override public List<StowotmInfo> parseResult(StowotmInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StowotmInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StowotmInfo dataInfo = new StowotmInfo();
					
					dataInfo.codOwner = stmtResult.getLong(StowotmDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(StowotmDbTableColumn.COL_COD_STORE);
					dataInfo.codWeekday = stmtResult.getInt(StowotmDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.recordMode = stmtResult.getString(StowotmDbTableColumn.COL_RECORD_MODE);	
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, StowotmDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, StowotmDbTableColumn.COL_END_TIME);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, StowotmDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, StowotmDbTableColumn.COL_LAST_CHANGED_BY);				
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, StowotmDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, StowotmDbTableColumn.COL_CREATED_BY);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
