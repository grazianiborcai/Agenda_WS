package br.com.mind5.masterData.orderStatus.dao;

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
import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;

public final class DaoOrderatusSelectSingle extends DaoStmtTemplate<OrderatusInfo> {
	private final String MAIN_TABLE = DaoDbTable.ORDER_STATUS_TABLE;
	
	
	public DaoOrderatusSelectSingle(Connection conn, OrderatusInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OrderatusInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoOrderatusWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(OrderatusInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoOrderatusJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<OrderatusInfo> getResultParserHook() {
		return new DaoResultParser<OrderatusInfo>() {
			@Override public List<OrderatusInfo> parseResult(OrderatusInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OrderatusInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					OrderatusInfo dataInfo = new OrderatusInfo();
					
					dataInfo.codOrderStatus = stmtResult.getString(DaoOrderatusDbTableColumn.COL_COD_ORDER_STATUS);
					dataInfo.txtOrderStatus = stmtResult.getString(DaoOrderatusDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoOrderatusDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
