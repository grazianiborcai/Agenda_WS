package br.com.mind5.business.bankAccountSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.bankAccountSearch.info.BankaccarchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class BankaccarchDaoSelectSingle extends DaoStmtTemplate<BankaccarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.BANK_ACCOUNT_TABLE;
	
	
	public BankaccarchDaoSelectSingle(Connection conn, BankaccarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.BANK_ACCOUNT_SEARCH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, BankaccarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull       = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;			
		
		DaoStmtWhere whereClause = new BankaccarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<BankaccarchInfo> getResultParserHook() {
		return new DaoResultParser<BankaccarchInfo>() {
			@Override public List<BankaccarchInfo> parseResult(BankaccarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<BankaccarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					BankaccarchInfo dataInfo = new BankaccarchInfo();
					
					dataInfo.codBank            = DaoFormatter.sqlToLong(stmtResult, BankaccarchDaoDbTableColumn.COL_COD_BANK);
					dataInfo.codStore           = DaoFormatter.sqlToLong(stmtResult, BankaccarchDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codOwner           = DaoFormatter.sqlToLong(stmtResult, BankaccarchDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.createdOn          = DaoFormatter.sqlToLocalDateTime(stmtResult, BankaccarchDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy          = DaoFormatter.sqlToLong(stmtResult, BankaccarchDaoDbTableColumn.COL_CREATED_BY);
					dataInfo.holderName         = stmtResult.getString(BankaccarchDaoDbTableColumn.COL_HOLDER_NAME);
					dataInfo.recordMode         = stmtResult.getString(BankaccarchDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.lastChanged        = DaoFormatter.sqlToLocalDateTime(stmtResult, BankaccarchDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.codSnapshot        = DaoFormatter.sqlToLong(stmtResult, BankaccarchDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.branchNumber       = stmtResult.getString(BankaccarchDaoDbTableColumn.COL_BRANCH_NUMBER);
					dataInfo.accountNumber      = stmtResult.getString(BankaccarchDaoDbTableColumn.COL_ACCOUNT_NUMBER);
					dataInfo.lastChangedBy      = DaoFormatter.sqlToLong(stmtResult, BankaccarchDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.codBankAccount     = DaoFormatter.sqlToLong(stmtResult, BankaccarchDaoDbTableColumn.COL_COD_BANK_ACCOUNT);
					dataInfo.holderDocument     = stmtResult.getString(BankaccarchDaoDbTableColumn.COL_HOLDER_DOCUMENT);
					dataInfo.branchCheckDigit   = stmtResult.getString(BankaccarchDaoDbTableColumn.COL_BRANCH_CHECK_DIGIT);
					dataInfo.codBankHolderType  = DaoFormatter.sqlToInt(stmtResult, BankaccarchDaoDbTableColumn.COL_COD_BANK_HOLDER_TYPE);
					dataInfo.accountCheckDigit  = stmtResult.getString(BankaccarchDaoDbTableColumn.COL_ACCOUNT_CHECK_DIGIT);
					dataInfo.codBankAccountType = DaoFormatter.sqlToInt(stmtResult, BankaccarchDaoDbTableColumn.COL_COD_BANK_ACCOUNT_TYPE);
					
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
