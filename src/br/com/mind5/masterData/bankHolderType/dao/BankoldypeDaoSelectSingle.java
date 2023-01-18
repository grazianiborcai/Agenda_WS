package br.com.mind5.masterData.bankHolderType.dao;

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
import br.com.mind5.masterData.bankHolderType.info.BankoldypeInfo;

public final class BankoldypeDaoSelectSingle extends DaoStmtTemplate<BankoldypeInfo> {
	private final String MAIN_TABLE = DaoDbTable.BANK_HOLDER_TYPE_TABLE;
	
	
	public BankoldypeDaoSelectSingle(Connection conn, BankoldypeInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, BankoldypeInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new BankoldypeDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(BankoldypeInfo recordInfo) {
		DaoJoinBuilder joinText = new BankoldypeDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<BankoldypeInfo> getResultParserHook() {
		return new DaoResultParser<BankoldypeInfo>() {
			@Override public List<BankoldypeInfo> parseResult(BankoldypeInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<BankoldypeInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					BankoldypeInfo dataInfo = new BankoldypeInfo();
					
					dataInfo.codBankHolder = stmtResult.getInt(BankoldypeDaoDbTableColumn.COL_COD_BANK_HOLDER_TYPE);
					dataInfo.txtBankHolder = stmtResult.getString(BankoldypeDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(BankoldypeDaoDbTableColumn.COL_COD_LANGUAGE);		
					
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
