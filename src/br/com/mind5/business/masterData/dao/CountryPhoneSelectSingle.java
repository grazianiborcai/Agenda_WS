package br.com.mind5.business.masterData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.CountryPhoneInfo;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class CountryPhoneSelectSingle extends DaoStmtTemplate<CountryPhoneInfo> {
	private final String MAIN_TABLE = DaoDbTable.COUNTRY_PHONE_TABLE;
	
	
	public CountryPhoneSelectSingle(Connection conn, CountryPhoneInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CountryPhoneInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new CountryPhoneWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(CountryPhoneInfo recordInfo) {
		DaoJoinBuilder joinText = new CountryPhoneJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParserV2<CountryPhoneInfo> getResultParserHook() {
		return new DaoResultParserV2<CountryPhoneInfo>() {
			@Override public List<CountryPhoneInfo> parseResult(CountryPhoneInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CountryPhoneInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					CountryPhoneInfo dataInfo = new CountryPhoneInfo();
					
					dataInfo.codCountryPhone = stmtResult.getInt(MasterDataDbTableColumn.COL_COD_COUNTRY_PHONE);
					dataInfo.codCountry = stmtResult.getString(MasterDataDbTableColumn.COL_COD_COUNTRY);
					dataInfo.txtCountry = stmtResult.getString(MasterDataDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(MasterDataDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
