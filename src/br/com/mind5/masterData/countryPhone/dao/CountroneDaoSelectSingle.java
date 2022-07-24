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

public final class CountroneDaoSelectSingle extends DaoStmtTemplate<CountroneInfo> {
	private final String MAIN_TABLE = DaoDbTable.COUNTRY_PHONE_TABLE;
	
	
	public CountroneDaoSelectSingle(Connection conn, CountroneInfo recordInfo, String schemaName) {
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
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new CountroneDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(CountroneInfo recordInfo) {
		DaoJoinBuilder joinText = new CountroneDaoJoinTxt(MAIN_TABLE);		
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
					
					dataInfo.codCountryPhone = stmtResult.getInt(CountroneDaoDbTableColumn.COL_COD_COUNTRY_PHONE);
					dataInfo.codCountry = stmtResult.getString(CountroneDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.txtCountry = stmtResult.getString(CountroneDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(CountroneDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
