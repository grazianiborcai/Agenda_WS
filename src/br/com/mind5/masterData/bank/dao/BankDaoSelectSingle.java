package br.com.mind5.masterData.bank.dao;

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
import br.com.mind5.masterData.bank.info.BankInfo;

public final class BankDaoSelectSingle extends DaoStmtTemplate<BankInfo> {
	private final String MAIN_TABLE = DaoDbTable.BANK_TABLE;
	
	
	public BankDaoSelectSingle(Connection conn, BankInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, BankInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new BankDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(BankInfo recordInfo) {
		DaoJoinBuilder joinText = new BankDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<BankInfo> getResultParserHook() {
		return new DaoResultParser<BankInfo>() {
			@Override public List<BankInfo> parseResult(BankInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<BankInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					BankInfo dataInfo = new BankInfo();
					
					dataInfo.codBank = stmtResult.getLong(BankDaoDbTableColumn.COL_COD_BANK);
					dataInfo.codCountry = stmtResult.getString(BankDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.txtBank = stmtResult.getString(BankDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(BankDaoDbTableColumn.COL_COD_LANGUAGE);
					dataInfo.codCompe = stmtResult.getString(BankDaoDbTableColumn.COL_COD_COMPE);
					
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
