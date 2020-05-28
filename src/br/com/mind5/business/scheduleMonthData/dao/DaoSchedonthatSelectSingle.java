package br.com.mind5.business.scheduleMonthData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public class DaoSchedonthatSelectSingle extends DaoStmtTemplate<SchedonthatInfo> {
	private final String MAIN_TABLE = DaoDbTable.SCHEDULE_MONTH_TABLE;
	
	
	public DaoSchedonthatSelectSingle(Connection conn, SchedonthatInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SchedonthatInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoSchedonthatWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SchedonthatInfo> getResultParserHook() {
		return new DaoResultParser<SchedonthatInfo>() {
			@Override public List<SchedonthatInfo> parseResult(SchedonthatInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {	
				List<SchedonthatInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SchedonthatInfo dataInfo = new SchedonthatInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoSchedonthatDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoSchedonthatDbTableColumn.COL_COD_STORE);				
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, DaoSchedonthatDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, DaoSchedonthatDbTableColumn.COL_COD_MATERIAL);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, DaoSchedonthatDbTableColumn.COL_DATE);	
					dataInfo.day = DaoFormatter.sqlToInt(stmtResult, DaoSchedonthatDbTableColumn.COL_DAY);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, DaoSchedonthatDbTableColumn.COL_MONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, DaoSchedonthatDbTableColumn.COL_YEAR);
					dataInfo.confirmed = stmtResult.getInt(DaoSchedonthatDbTableColumn.COL_CONFIRMED);
					dataInfo.waiting = stmtResult.getInt(DaoSchedonthatDbTableColumn.COL_WAITING);
					dataInfo.counter = stmtResult.getInt(DaoSchedonthatDbTableColumn.COL_COUNTER);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
