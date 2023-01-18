package br.com.mind5.masterData.bankAccountTypeSearch.dao;

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
import br.com.mind5.masterData.bankAccountTypeSearch.info.BankacyperchInfo;

public final class BankacyperchDaoSelectSingle extends DaoStmtTemplate<BankacyperchInfo> {
	private final String MAIN_TABLE = DaoDbTable.BANK_ACCOUNT_TYPE_TABLE;
	
	
	public BankacyperchDaoSelectSingle(Connection conn, BankacyperchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.BANK_ACCOUNT_TYPE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, BankacyperchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new BankacyperchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(BankacyperchInfo recordInfo) {
		DaoJoinBuilder joinText = new BankacyperchDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<BankacyperchInfo> getResultParserHook() {
		return new DaoResultParser<BankacyperchInfo>() {
			@Override public List<BankacyperchInfo> parseResult(BankacyperchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<BankacyperchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					BankacyperchInfo dataInfo = new BankacyperchInfo();
					
					dataInfo.codBankAccountType = stmtResult.getInt(BankacyperchDaoDbTableColumn.COL_COD_BANK_ACCOUNT_TYPE);
					dataInfo.txtBankAccountType = stmtResult.getString(BankacyperchDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(BankacyperchDaoDbTableColumn.COL_COD_LANGUAGE);		
					
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
