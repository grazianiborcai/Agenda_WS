package br.com.mind5.masterData.bankHolderTypeSearch.dao;

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
import br.com.mind5.masterData.bankHolderTypeSearch.info.BankoldyperchInfo;

public final class BankoldyperchDaoSelectSingle extends DaoStmtTemplate<BankoldyperchInfo> {
	private final String MAIN_TABLE = DaoDbTable.BANK_HOLDER_TYPE_TABLE;
	
	
	public BankoldyperchDaoSelectSingle(Connection conn, BankoldyperchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.BANK_HOLDER_TYPE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, BankoldyperchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new BankoldyperchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(BankoldyperchInfo recordInfo) {
		DaoJoinBuilder joinText = new BankoldyperchDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<BankoldyperchInfo> getResultParserHook() {
		return new DaoResultParser<BankoldyperchInfo>() {
			@Override public List<BankoldyperchInfo> parseResult(BankoldyperchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<BankoldyperchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					BankoldyperchInfo dataInfo = new BankoldyperchInfo();
					
					dataInfo.codBankHolder = stmtResult.getInt(BankoldyperchDaoDbTableColumn.COL_COD_BANK_HOLDER_TYPE);
					dataInfo.txtBankHolder = stmtResult.getString(BankoldyperchDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(BankoldyperchDaoDbTableColumn.COL_COD_LANGUAGE);		
					
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
