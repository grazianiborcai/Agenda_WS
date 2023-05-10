package br.com.mind5.masterData.stateSearch.dao;

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
import br.com.mind5.masterData.stateSearch.info.StatarchInfo;

public final class StatarchDaoSelectSingle extends DaoStmtTemplate<StatarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.STATE_TABLE;
	
	
	public StatarchDaoSelectSingle(Connection conn, StatarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STATE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}

	
		
	@Override protected String buildWhereClauseHook(String tableName, StatarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull           = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode     = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new StatarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(StatarchInfo recordInfo) {
		DaoJoinBuilder joinText = new StatarchDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<StatarchInfo> getResultParserHook() {
		return new DaoResultParser<StatarchInfo>() {
			@Override public List<StatarchInfo> parseResult(StatarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StatarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					StatarchInfo dataInfo = new StatarchInfo();					
					
					dataInfo.codState    = stmtResult.getString(StatarchDaoDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.txtState    = stmtResult.getString(StatarchDaoDbTableColumn.COL_NAME);
					dataInfo.codCountry  = stmtResult.getString(StatarchDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codLanguage = stmtResult.getString(StatarchDaoDbTableColumn.COL_COD_LANGUAGE);		
					
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
