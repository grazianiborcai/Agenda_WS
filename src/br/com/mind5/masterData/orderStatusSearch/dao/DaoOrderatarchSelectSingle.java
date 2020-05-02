package br.com.mind5.masterData.orderStatusSearch.dao;

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
import br.com.mind5.masterData.orderStatusSearch.info.OrderatarchInfo;

public final class DaoOrderatarchSelectSingle extends DaoStmtTemplate<OrderatarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.ORDER_STATUS_TABLE;
	
	
	public DaoOrderatarchSelectSingle(Connection conn, OrderatarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.ORDER_STATUS_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OrderatarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new DaoOrderatarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(OrderatarchInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoOrderatarchJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<OrderatarchInfo> getResultParserHook() {
		return new DaoResultParser<OrderatarchInfo>() {
			@Override public List<OrderatarchInfo> parseResult(OrderatarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OrderatarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					OrderatarchInfo dataInfo = new OrderatarchInfo();
					
					dataInfo.codOrderStatus = stmtResult.getString(DaoOrderatarchDbTableColumn.COL_COD_ORDER_STATUS);
					dataInfo.txtOrderStatus = stmtResult.getString(DaoOrderatarchDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoOrderatarchDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
