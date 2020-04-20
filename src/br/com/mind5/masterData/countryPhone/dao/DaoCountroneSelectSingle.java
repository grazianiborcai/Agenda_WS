package br.com.mind5.masterData.countryPhone.dao;

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
import br.com.mind5.masterData.countryPhone.info.CountroneInfo;

public final class DaoCountroneSelectSingle extends DaoStmtTemplate<CountroneInfo> {
	private final String MAIN_TABLE = DaoDbTable.COUNTRY_PHONE_TABLE;
	
	
	public DaoCountroneSelectSingle(Connection conn, CountroneInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CountroneInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new DaoCountroneWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(CountroneInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoCountroneJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<CountroneInfo> getResultParserHook() {
		return new DaoResultParser<CountroneInfo>() {
			@Override public List<CountroneInfo> parseResult(CountroneInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CountroneInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					CountroneInfo dataInfo = new CountroneInfo();
					
					dataInfo.codCountryPhone = stmtResult.getInt(DaoCountroneDbTableColumn.COL_COD_COUNTRY_PHONE);
					dataInfo.codCountry = stmtResult.getString(DaoCountroneDbTableColumn.COL_COD_COUNTRY);
					dataInfo.txtCountry = stmtResult.getString(DaoCountroneDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoCountroneDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
