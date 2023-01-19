package br.com.mind5.business.bankAccountSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bankAccountSnapshot.info.BankaccnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class BankaccnapDaoSelectSingle extends DaoStmtTemplate<BankaccnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.BANK_ACCOUNT_SNAPSHOT_TABLE;
	
	
	public BankaccnapDaoSelectSingle(Connection conn, BankaccnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, BankaccnapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new BankaccnapDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<BankaccnapInfo> getResultParserHook() {
		return new DaoResultParser<BankaccnapInfo>() {
			@Override public List<BankaccnapInfo> parseResult(BankaccnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<BankaccnapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					BankaccnapInfo dataInfo = new BankaccnapInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, BankaccnapDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codBankAccount = DaoFormatter.sqlToLong(stmtResult, BankaccnapDaoDbTableColumn.COL_COD_BANK_ACCOUNT);
					dataInfo.accountNumber = stmtResult.getString(BankaccnapDaoDbTableColumn.COL_ACCOUNT_NUMBER);
					dataInfo.codBankHolderType = DaoFormatter.sqlToInt(stmtResult, BankaccnapDaoDbTableColumn.COL_COD_BANK_HOLDER_TYPE);
					dataInfo.codBankAccountType = DaoFormatter.sqlToInt(stmtResult, BankaccnapDaoDbTableColumn.COL_COD_BANK_ACCOUNT_TYPE);
					dataInfo.branchCheckDigit = stmtResult.getString(BankaccnapDaoDbTableColumn.COL_BRANCH_CHECK_DIGIT);
					dataInfo.branchNumber = stmtResult.getString(BankaccnapDaoDbTableColumn.COL_BRANCH_NUMBER);
					dataInfo.recordMode = stmtResult.getString(BankaccnapDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, BankaccnapDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, BankaccnapDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, BankaccnapDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, BankaccnapDaoDbTableColumn.COL_CREATED_BY);
					dataInfo.accountCheckDigit = stmtResult.getString(BankaccnapDaoDbTableColumn.COL_ACCOUNT_CHECK_DIGIT);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, BankaccnapDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codBank = DaoFormatter.sqlToLong(stmtResult, BankaccnapDaoDbTableColumn.COL_COD_BANK);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, BankaccnapDaoDbTableColumn.COL_COD_STORE);
					dataInfo.holderName = stmtResult.getString(BankaccnapDaoDbTableColumn.COL_HOLDER_NAME);
					dataInfo.holderDocument = stmtResult.getString(BankaccnapDaoDbTableColumn.COL_HOLDER_DOCUMENT);
					dataInfo.codPayBankAccount = stmtResult.getString(BankaccnapDaoDbTableColumn.COL_COD_PAY_BANK_ACCOUNT);
					
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
