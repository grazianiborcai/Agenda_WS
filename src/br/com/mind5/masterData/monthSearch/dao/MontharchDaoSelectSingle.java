package br.com.mind5.masterData.monthSearch.dao;

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
import br.com.mind5.masterData.monthSearch.info.MontharchInfo;

public final class MontharchDaoSelectSingle extends DaoStmtTemplate<MontharchInfo> {
	private final String MAIN_TABLE = DaoDbTable.MONTH_TEXT_TABLE;
	
	
	public MontharchDaoSelectSingle(Connection conn, MontharchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.MONTH_TEXT_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MontharchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new MontharchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<MontharchInfo> getResultParserHook() {
		return new DaoResultParser<MontharchInfo>() {
			@Override public List<MontharchInfo> parseResult(MontharchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MontharchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MontharchInfo dataInfo = new MontharchInfo();
					
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, MontharchDaoDbTableColumn.COL_MONTH);
					dataInfo.txtMonth = stmtResult.getString(MontharchDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(MontharchDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
