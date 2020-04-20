package br.com.mind5.masterData.countryPhoneSearch.dao;

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
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.countryPhoneSearch.info.CountronarchInfo;

public final class DaoCountronarchSelectSingle extends DaoStmtTemplate<CountronarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.COUNTRY_PHONE_TABLE;
	
	
	public DaoCountronarchSelectSingle(Connection conn, CountronarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.COUNTRY_PHONE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CountronarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new DaoCountronarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(CountronarchInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoCountronarchJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<CountronarchInfo> getResultParserHook() {
		return new DaoResultParser<CountronarchInfo>() {
			@Override public List<CountronarchInfo> parseResult(CountronarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CountronarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					CountronarchInfo dataInfo = new CountronarchInfo();
					
					dataInfo.codCountryPhone = stmtResult.getInt(DaoCountronarchDbTableColumn.COL_COD_COUNTRY_PHONE);
					dataInfo.codCountry = stmtResult.getString(DaoCountronarchDbTableColumn.COL_COD_COUNTRY);
					dataInfo.txtCountry = stmtResult.getString(DaoCountronarchDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoCountronarchDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
