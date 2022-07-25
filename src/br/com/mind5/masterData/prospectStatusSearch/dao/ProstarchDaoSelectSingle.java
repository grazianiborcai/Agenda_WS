package br.com.mind5.masterData.prospectStatusSearch.dao;

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
import br.com.mind5.masterData.prospectStatusSearch.info.ProstarchInfo;

public final class ProstarchDaoSelectSingle extends DaoStmtTemplate<ProstarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.PROSPECT_STATUS_TABLE;
	
	
	public ProstarchDaoSelectSingle(Connection conn, ProstarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PROSPECT_STATUS_SEARCH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, ProstarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();

		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new ProstarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(ProstarchInfo recordInfo) {
		DaoJoinBuilder joinText = new ProstarchDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<ProstarchInfo> getResultParserHook() {
		return new DaoResultParser<ProstarchInfo>() {
			@Override public List<ProstarchInfo> parseResult(ProstarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<ProstarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					ProstarchInfo dataInfo = new ProstarchInfo();
					
					dataInfo.codProspectStatus = stmtResult.getString(ProstarchDaoDbTableColumn.COL_COD_PROSPECT_STATUS);
					dataInfo.txtProspectStatus = stmtResult.getString(ProstarchDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(ProstarchDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}
