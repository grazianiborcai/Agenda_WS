package br.com.mind5.business.bankAccount.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class BankaccDaoSelectSingle extends DaoStmtTemplate<BankaccInfo> {
	private final String MAIN_TABLE = DaoDbTable.BANK_ACCOUNT_TABLE;
	
	
	public BankaccDaoSelectSingle(Connection conn, BankaccInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, BankaccInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new BankaccDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<BankaccInfo> getResultParserHook() {
		return new DaoResultParser<BankaccInfo>() {
			@Override public List<BankaccInfo> parseResult(BankaccInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<BankaccInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					BankaccInfo dataInfo = new BankaccInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, BankaccDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codBankAccount = DaoFormatter.sqlToLong(stmtResult, BankaccDaoDbTableColumn.COL_COD_BANK_ACCOUNT);
					dataInfo.accountNumber = stmtResult.getString(BankaccDaoDbTableColumn.COL_ACCOUNT_NUMBER);
					dataInfo.codBankHolderType = DaoFormatter.sqlToInt(stmtResult, BankaccDaoDbTableColumn.COL_COD_BANK_HOLDER_TYPE);
					dataInfo.codBankAccountType = DaoFormatter.sqlToInt(stmtResult, BankaccDaoDbTableColumn.COL_COD_BANK_ACCOUNT_TYPE);
					dataInfo.branchCheckDigit = stmtResult.getString(BankaccDaoDbTableColumn.COL_BRANCH_CHECK_DIGIT);
					dataInfo.branchNumber = stmtResult.getString(BankaccDaoDbTableColumn.COL_BRANCH_NUMBER);
					dataInfo.recordMode = stmtResult.getString(BankaccDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, BankaccDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, BankaccDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, BankaccDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, BankaccDaoDbTableColumn.COL_CREATED_BY);
					dataInfo.accountCheckDigit = stmtResult.getString(BankaccDaoDbTableColumn.COL_ACCOUNT_CHECK_DIGIT);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, BankaccDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codBank = DaoFormatter.sqlToLong(stmtResult, BankaccDaoDbTableColumn.COL_COD_BANK);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, BankaccDaoDbTableColumn.COL_COD_STORE);
					dataInfo.holderName = stmtResult.getString(BankaccDaoDbTableColumn.COL_HOLDER_NAME);
					dataInfo.holderDocument = stmtResult.getString(BankaccDaoDbTableColumn.COL_HOLDER_DOCUMENT);
					
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
