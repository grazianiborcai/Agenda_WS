package br.com.mind5.masterData.bankAccountType.dao;

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
import br.com.mind5.masterData.bankAccountType.info.BankacypeInfo;

public final class BankacypeDaoSelectSingle extends DaoStmtTemplate<BankacypeInfo> {
	private final String MAIN_TABLE = DaoDbTable.BANK_ACCOUNT_TYPE_TABLE;
	
	
	public BankacypeDaoSelectSingle(Connection conn, BankacypeInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, BankacypeInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new BankacypeDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(BankacypeInfo recordInfo) {
		DaoJoinBuilder joinText = new BankacypeDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<BankacypeInfo> getResultParserHook() {
		return new DaoResultParser<BankacypeInfo>() {
			@Override public List<BankacypeInfo> parseResult(BankacypeInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<BankacypeInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					BankacypeInfo dataInfo = new BankacypeInfo();
					
					dataInfo.codBankAccount = stmtResult.getInt(BankacypeDaoDbTableColumn.COL_COD_BANK_ACCOUNT_TYPE);
					dataInfo.txtBankAccount = stmtResult.getString(BankacypeDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(BankacypeDaoDbTableColumn.COL_COD_LANGUAGE);		
					
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
