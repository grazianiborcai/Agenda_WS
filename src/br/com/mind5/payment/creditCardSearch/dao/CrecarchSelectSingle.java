package br.com.mind5.payment.creditCardSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.payment.creditCardSearch.info.CrecarchInfo;

public final class CrecarchSelectSingle extends DaoStmtTemplate<CrecarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.CREDIT_CARD_TABLE;	
	
	
	public CrecarchSelectSingle(Connection conn, CrecarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.CREDIT_CARD_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CrecarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new CrecarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<CrecarchInfo> getResultParserHook() {
		return new DaoResultParser<CrecarchInfo>() {
			@Override public List<CrecarchInfo> parseResult(CrecarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CrecarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CrecarchInfo dataInfo = new CrecarchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(CrecarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codCreditCard = stmtResult.getLong(CrecarchDbTableColumn.COL_COD_CREDIT_CARD);
					dataInfo.codPayCustomer = stmtResult.getLong(CrecarchDbTableColumn.COL_COD_PAY_CUSTOMER);
					dataInfo.creditCardId = stmtResult.getString(CrecarchDbTableColumn.COL_CREDIT_CARD_ID);
					dataInfo.recordMode = stmtResult.getString(CrecarchDbTableColumn.COL_RECORD_MODE);			
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
