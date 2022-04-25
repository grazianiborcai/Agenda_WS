package br.com.mind5.business.employeeLunchTime.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmplutmDaoSelectSingle extends DaoStmtTemplate<EmplutmInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMP_LT_TABLE;	
	
	
	public EmplutmDaoSelectSingle(Connection conn, EmplutmInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmplutmInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmplutmDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<EmplutmInfo> getResultParserHook() {
		return new DaoResultParser<EmplutmInfo>() {
			@Override public List<EmplutmInfo> parseResult(EmplutmInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmplutmInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					EmplutmInfo dataInfo = new EmplutmInfo();
					
					dataInfo.codOwner = stmtResult.getLong(EmplutmDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(EmplutmDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = stmtResult.getLong(EmplutmDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codWeekday = stmtResult.getInt(EmplutmDaoDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.recordMode = stmtResult.getString(EmplutmDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, EmplutmDaoDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, EmplutmDaoDbTableColumn.COL_END_TIME);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, EmplutmDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, EmplutmDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, EmplutmDaoDbTableColumn.COL_COD_SNAPSHOT);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
