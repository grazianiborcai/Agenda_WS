package br.com.mind5.business.orderReserve.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoOrderveSelectSingle extends DaoStmtTemplate<OrderveInfo> {
	private final String MAIN_TABLE = DaoDbTable.ORDER_ITM_TABLE;	
	
	
	public DaoOrderveSelectSingle(Connection conn, OrderveInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.ORDER_RESERVE_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OrderveInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoOrderveWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(OrderveInfo recordInfo) {
		DaoJoinBuilder joinOrder = new DaoOrderveJoinOrder(MAIN_TABLE);		
		return joinOrder.build();
	}
	
	
		
	@Override protected DaoResultParser<OrderveInfo> getResultParserHook() {
		return new DaoResultParser<OrderveInfo>() {		
			@Override public List<OrderveInfo> parseResult(OrderveInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OrderveInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					OrderveInfo dataInfo = new OrderveInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoOrderveDbTableColumn.COL_COD_OWNER);
					dataInfo.codOrder = stmtResult.getLong(DaoOrderveDbTableColumn.COL_COD_ORDER);
					dataInfo.codCustomer = stmtResult.getLong(DaoOrderveDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codUser = stmtResult.getLong(DaoOrderveDbTableColumn.COL_COD_USER);
					dataInfo.codStore = stmtResult.getLong(DaoOrderveDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = stmtResult.getLong(DaoOrderveDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codMat = stmtResult.getLong(DaoOrderveDbTableColumn.COL_COD_MATERIAL);
					dataInfo.codOrderStatus = stmtResult.getString(DaoOrderveDbTableColumn.COL_COD_ORDER_STATUS);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, DaoOrderveDbTableColumn.COL_DATE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoOrderveDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoOrderveDbTableColumn.COL_END_TIME);		
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
