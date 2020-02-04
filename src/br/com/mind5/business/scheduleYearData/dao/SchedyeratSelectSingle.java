package br.com.mind5.business.scheduleYearData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public class SchedyeratSelectSingle extends DaoStmtTemplate<SchedyeratInfo> {
	private final String MAIN_TABLE = DaoDbTable.SCHEDULE_YEAR_TABLE;
	
	
	public SchedyeratSelectSingle(Connection conn, SchedyeratInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SchedyeratInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new SchedyeratWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
		
	@Override protected DaoResultParser<SchedyeratInfo> getResultParserHook() {
		return new DaoResultParser<SchedyeratInfo>() {
			@Override public List<SchedyeratInfo> parseResult(SchedyeratInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SchedyeratInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SchedyeratInfo dataInfo = new SchedyeratInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, SchedyeratDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, SchedyeratDbTableColumn.COL_COD_STORE);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, SchedyeratDbTableColumn.COL_MONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, SchedyeratDbTableColumn.COL_YEAR);
					dataInfo.confirmed = stmtResult.getInt(SchedyeratDbTableColumn.COL_CONFIRMED);
					dataInfo.waiting = stmtResult.getInt(SchedyeratDbTableColumn.COL_WAITING);
					dataInfo.counter = stmtResult.getInt(SchedyeratDbTableColumn.COL_COUNTER);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
