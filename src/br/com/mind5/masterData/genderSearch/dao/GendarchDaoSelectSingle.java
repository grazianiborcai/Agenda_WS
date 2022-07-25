package br.com.mind5.masterData.genderSearch.dao;

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
import br.com.mind5.masterData.genderSearch.info.GendarchInfo;

public final class GendarchDaoSelectSingle extends DaoStmtTemplate<GendarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.GENDER_TABLE;
	
	
	public GendarchDaoSelectSingle(Connection conn, GendarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.GENDER_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, GendarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new GendarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(GendarchInfo recordInfo) {
		DaoJoinBuilder joinText = new GendarchDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<GendarchInfo> getResultParserHook() {
		return new DaoResultParser<GendarchInfo>() {
			@Override public List<GendarchInfo> parseResult(GendarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<GendarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					GendarchInfo dataInfo = new GendarchInfo();
					
					dataInfo.codGender = stmtResult.getInt(GendarchDaoDbTableColumn.COL_COD_GENDER);
					dataInfo.txtGender = stmtResult.getString(GendarchDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(GendarchDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
