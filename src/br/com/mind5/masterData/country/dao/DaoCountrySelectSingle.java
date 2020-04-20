package br.com.mind5.masterData.country.dao;

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
import br.com.mind5.masterData.country.info.CountryInfo;

public final class DaoCountrySelectSingle extends DaoStmtTemplate<CountryInfo> {
	private final String MAIN_TABLE = DaoDbTable.COUNTRY_TABLE;
	
	
	public DaoCountrySelectSingle(Connection conn, CountryInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CountryInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoCountryWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoJoin getJoinHook(CountryInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoJoinCountryTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<CountryInfo> getResultParserHook() {
		return new DaoResultParser<CountryInfo>() {
			@Override public List<CountryInfo> parseResult(CountryInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CountryInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					CountryInfo dataInfo = new CountryInfo();
					
					dataInfo.codCountry = stmtResult.getString(DaoCountryDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codCountryAlpha3 = stmtResult.getString(DaoCountryDbTableColumn.COL_COD_COUNTRY_ALPHA3);
					dataInfo.txtCountry = stmtResult.getString(DaoCountryDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoCountryDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
