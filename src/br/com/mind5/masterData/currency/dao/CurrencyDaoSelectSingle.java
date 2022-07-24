package br.com.mind5.masterData.currency.dao;

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
import br.com.mind5.masterData.currency.info.CurrencyInfo;

public final class CurrencyDaoSelectSingle extends DaoStmtTemplate<CurrencyInfo> {
	private final String MAIN_TABLE = DaoDbTable.CURRENCY_TABLE;
	
	
	public CurrencyDaoSelectSingle(Connection conn, CurrencyInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CurrencyInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new CurrencyDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(CurrencyInfo recordInfo) {
		DaoJoinBuilder joinText = new CurrencyDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<CurrencyInfo> getResultParserHook() {
		return new DaoResultParser<CurrencyInfo>() {
			@Override public List<CurrencyInfo> parseResult(CurrencyInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CurrencyInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					CurrencyInfo dataInfo = new CurrencyInfo();
					
					dataInfo.codCurr = stmtResult.getString(CurrencyDaoDbTableColumn.COL_COD_CURRENCY);
					dataInfo.symbolCurr = stmtResult.getString(CurrencyDaoDbTableColumn.COL_CURRENCY_SYMBOL);
					dataInfo.txtCurr = stmtResult.getString(CurrencyDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(CurrencyDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
