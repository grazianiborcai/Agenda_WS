package br.com.mind5.masterData.countryLegalSearch.dao;

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
import br.com.mind5.masterData.countryLegalSearch.info.CountrarchInfo;

public final class DaoCountrarchSelectSingle extends DaoStmtTemplate<CountrarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.COUNTRY_LEGAL_TABLE;
	
	
	public DaoCountrarchSelectSingle(Connection conn, CountrarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.COUNTRY_LEGAL_SEARCH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CountrarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new DaoCountrarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<CountrarchInfo> getResultParserHook() {
		return new DaoResultParser<CountrarchInfo>() {
			@Override public List<CountrarchInfo> parseResult(CountrarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CountrarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					CountrarchInfo dataInfo = new CountrarchInfo();
					
					dataInfo.codCountry = stmtResult.getString(DaoCountrarchDbTableColumn.COL_COD_COUNTRY);
					dataInfo.recordMode = stmtResult.getString(DaoCountrarchDbTableColumn.COL_RECORD_MODE);
					
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
