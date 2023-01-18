package br.com.mind5.masterData.bankSearch.dao;

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
import br.com.mind5.masterData.bankSearch.info.BankarchInfo;

public final class BankarchDaoSelectSingle extends DaoStmtTemplate<BankarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.BANK_TABLE;
	
	
	public BankarchDaoSelectSingle(Connection conn, BankarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.BANK_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, BankarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new BankarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(BankarchInfo recordInfo) {
		DaoJoinBuilder joinText = new BankarchDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<BankarchInfo> getResultParserHook() {
		return new DaoResultParser<BankarchInfo>() {
			@Override public List<BankarchInfo> parseResult(BankarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<BankarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					BankarchInfo dataInfo = new BankarchInfo();
					
					dataInfo.codBank = stmtResult.getLong(BankarchDaoDbTableColumn.COL_COD_BANK);
					dataInfo.codCountry = stmtResult.getString(BankarchDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.txtBank = stmtResult.getString(BankarchDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(BankarchDaoDbTableColumn.COL_COD_LANGUAGE);
					dataInfo.codCompe = stmtResult.getString(BankarchDaoDbTableColumn.COL_COD_COMPE);
					
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
