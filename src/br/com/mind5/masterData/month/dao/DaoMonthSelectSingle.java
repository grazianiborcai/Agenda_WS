package br.com.mind5.masterData.month.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.month.info.MonthInfo;

public final class DaoMonthSelectSingle extends DaoStmtTemplate<MonthInfo> {
	private final String MAIN_TABLE = DaoDbTable.MONTH_TEXT_TABLE;
	
	
	public DaoMonthSelectSingle(Connection conn, MonthInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MonthInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoMonthWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<MonthInfo> getResultParserHook() {
		return new DaoResultParser<MonthInfo>() {
			@Override public List<MonthInfo> parseResult(MonthInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MonthInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MonthInfo dataInfo = new MonthInfo();
					
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, DaoMonthDbTableColumn.COL_MONTH);
					dataInfo.txtMonth = stmtResult.getString(DaoMonthDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoMonthDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
