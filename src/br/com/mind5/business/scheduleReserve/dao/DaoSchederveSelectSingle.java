package br.com.mind5.business.scheduleReserve.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleReserve.info.SchederveInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoSchederveSelectSingle extends DaoStmtTemplate<SchederveInfo> {
	private final String MAIN_TABLE = DaoDbTable.SCHEDULE_TABLE;
	
	
	public DaoSchederveSelectSingle(Connection conn, SchederveInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.SCHEDULE_RESERVE_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SchederveInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoSchederveWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SchederveInfo> getResultParserHook() {
		return new DaoResultParser<SchederveInfo>() {		
			@Override public List<SchederveInfo> parseResult(SchederveInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SchederveInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SchederveInfo dataInfo = new SchederveInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoSchederveDbTableColumn.COL_COD_OWNER);
					dataInfo.codSchedule = DaoFormatter.sqlToLong(stmtResult, DaoSchederveDbTableColumn.COL_COD_SCHEDULE);	
					dataInfo.codUser = stmtResult.getLong(DaoSchederveDbTableColumn.COL_COD_USER);
					dataInfo.codStore = stmtResult.getLong(DaoSchederveDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = stmtResult.getLong(DaoSchederveDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codMat = stmtResult.getLong(DaoSchederveDbTableColumn.COL_COD_MATERIAL);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, DaoSchederveDbTableColumn.COL_DATE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoSchederveDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoSchederveDbTableColumn.COL_END_TIME);		
					dataInfo.recordMode = stmtResult.getString(DaoSchederveDbTableColumn.COL_RECORD_MODE);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
