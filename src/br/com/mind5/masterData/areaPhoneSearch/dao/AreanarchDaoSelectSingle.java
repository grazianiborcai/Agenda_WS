package br.com.mind5.masterData.areaPhoneSearch.dao;

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
import br.com.mind5.masterData.areaPhoneSearch.info.AreanarchInfo;

public final class AreanarchDaoSelectSingle extends DaoStmtTemplate<AreanarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.AREA_PHONE_TABLE;
	
	
	public AreanarchDaoSelectSingle(Connection conn, AreanarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.AREA_PHONE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, AreanarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new AreanarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(AreanarchInfo recordInfo) {
		DaoJoinBuilder joinText = new AreanarchDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<AreanarchInfo> getResultParserHook() {
		return new DaoResultParser<AreanarchInfo>() {
			@Override public List<AreanarchInfo> parseResult(AreanarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<AreanarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					AreanarchInfo dataInfo = new AreanarchInfo();
					
					dataInfo.codCountryPhone = stmtResult.getInt(AreanarchDaoDbTableColumn.COL_COD_COUNTRY_PHONE);
					dataInfo.codArea = stmtResult.getString(AreanarchDaoDbTableColumn.COL_COD_AREA_PHONE);
					dataInfo.txtArea = stmtResult.getString(AreanarchDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(AreanarchDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
