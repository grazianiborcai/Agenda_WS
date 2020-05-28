package br.com.mind5.business.scheduleWeekData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public class DaoSchedeekdatSelectSingle extends DaoStmtTemplate<SchedeekdatInfo> {
	private final String MAIN_TABLE = DaoDbTable.SCHEDULE_WEEK_TABLE;
	
	
	public DaoSchedeekdatSelectSingle(Connection conn, SchedeekdatInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SchedeekdatInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoSchedeekdatWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<SchedeekdatInfo> getResultParserHook() {
		return new DaoResultParser<SchedeekdatInfo>() {
			@Override public List<SchedeekdatInfo> parseResult(SchedeekdatInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {	
				List<SchedeekdatInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SchedeekdatInfo dataInfo = new SchedeekdatInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoSchedeekdatDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoSchedeekdatDbTableColumn.COL_COD_STORE);				
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, DaoSchedeekdatDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, DaoSchedeekdatDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, DaoSchedeekdatDbTableColumn.COL_COD_MATERIAL);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, DaoSchedeekdatDbTableColumn.COL_DATE);	
					dataInfo.day = DaoFormatter.sqlToInt(stmtResult, DaoSchedeekdatDbTableColumn.COL_DAY);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, DaoSchedeekdatDbTableColumn.COL_MONTH);
					dataInfo.weekMonth = DaoFormatter.sqlToInt(stmtResult, DaoSchedeekdatDbTableColumn.COL_WEEK_MONTH);
					dataInfo.weekYear = DaoFormatter.sqlToInt(stmtResult, DaoSchedeekdatDbTableColumn.COL_WEEK_YEAR);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, DaoSchedeekdatDbTableColumn.COL_YEAR);
					dataInfo.confirmed = stmtResult.getInt(DaoSchedeekdatDbTableColumn.COL_CONFIRMED);
					dataInfo.waiting = stmtResult.getInt(DaoSchedeekdatDbTableColumn.COL_WAITING);
					dataInfo.counter = stmtResult.getInt(DaoSchedeekdatDbTableColumn.COL_COUNTER);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
