package br.com.mind5.masterData.languageSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.languageSearch.info.LangarchInfo;

public final class DaoLangarchSelectSingle extends DaoStmtTemplate<LangarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.LANGUAGE_TABLE;	
	
	
	public DaoLangarchSelectSingle(Connection conn, LangarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.LANGUAGE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, LangarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new DaoLangarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<LangarchInfo> getResultParserHook() {
		return new DaoResultParser<LangarchInfo>() {
			@Override public List<LangarchInfo> parseResult(LangarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<LangarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					LangarchInfo dataInfo = new LangarchInfo();
					
					dataInfo.codLanguage = stmtResult.getString(DaoLangarchDbTableColumn.COL_COD_LANGUAGE);
					dataInfo.txtLanguage = stmtResult.getString(DaoLangarchDbTableColumn.COL_NAME);	
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
