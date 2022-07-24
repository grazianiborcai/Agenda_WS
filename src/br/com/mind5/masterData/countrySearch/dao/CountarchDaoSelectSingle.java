package br.com.mind5.masterData.countrySearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoJoinCountryTxt;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.countrySearch.info.CountarchInfo;

public final class CountarchDaoSelectSingle extends DaoStmtTemplate<CountarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.COUNTRY_TABLE;
	
	
	public CountarchDaoSelectSingle(Connection conn, CountarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.COUNTRY_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CountarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new CountarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoJoin getJoinHook(CountarchInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoJoinCountryTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<CountarchInfo> getResultParserHook() {
		return new DaoResultParser<CountarchInfo>() {
			@Override public List<CountarchInfo> parseResult(CountarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CountarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					CountarchInfo dataInfo = new CountarchInfo();
					
					dataInfo.codCountry = stmtResult.getString(CountarchDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codCountryAlpha3 = stmtResult.getString(CountarchDaoDbTableColumn.COL_COD_COUNTRY_ALPHA3);
					dataInfo.txtCountry = stmtResult.getString(CountarchDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(CountarchDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
