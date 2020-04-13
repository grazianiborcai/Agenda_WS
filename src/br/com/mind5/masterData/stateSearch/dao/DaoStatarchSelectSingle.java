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

public final class DaoStatarchSelectSingle extends DaoStmtTemplate<StatarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.STATE_TABLE;
	
	
	public DaoStatarchSelectSingle(Connection conn, StatarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StatarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new DaoStatarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(StatarchInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoStatarchJoinTxt(MAIN_TABLE);		
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
					
					dataInfo.codCountry = stmtResult.getString(DaoStatarchDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(DaoStatarchDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.txtState = stmtResult.getString(DaoStatarchDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoStatarchDbTableColumn.COL_COD_LANGUAGE);		
					
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
