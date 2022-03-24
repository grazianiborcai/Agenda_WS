package br.com.mind5.business.orderItem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class OrderemDaoSelectSingle extends DaoStmtTemplate<OrderemInfo> {	
	private final String MAIN_TABLE = DaoDbTable.ORDER_ITM_TABLE;
	
	
	public OrderemDaoSelectSingle(Connection conn, OrderemInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OrderemInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new OrderemDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<OrderemInfo> getResultParserHook() {
		return new DaoResultParser<OrderemInfo>() {
			@Override public List<OrderemInfo> parseResult(OrderemInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {			
				List<OrderemInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					OrderemInfo dataInfo = new OrderemInfo();
					
					dataInfo.codOwner = stmtResult.getLong(OrderemDaoDbTableColumn.COL_COD_OWNER);	
					dataInfo.codOrder = stmtResult.getLong(OrderemDaoDbTableColumn.COL_COD_ORDER);
					dataInfo.codOrderItem = DaoFormatter.sqlToInt(stmtResult, OrderemDaoDbTableColumn.COL_COD_ORDER_ITEM);
					dataInfo.quantity = stmtResult.getInt(OrderemDaoDbTableColumn.COL_QUANTITY);
					dataInfo.codCurr = stmtResult.getString(OrderemDaoDbTableColumn.COL_COD_CURRENCY);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, OrderemDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, OrderemDaoDbTableColumn.COL_COD_CUSTOMER);					
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, OrderemDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, OrderemDaoDbTableColumn.COL_COD_MATERIAL);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, OrderemDaoDbTableColumn.COL_DATE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, OrderemDaoDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, OrderemDaoDbTableColumn.COL_END_TIME);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, OrderemDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = stmtResult.getLong(OrderemDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.price = DaoFormatter.sqlToDouble(stmtResult, OrderemDaoDbTableColumn.COL_PRICE);
					dataInfo.totitem = DaoFormatter.sqlToDouble(stmtResult, OrderemDaoDbTableColumn.COL_TOTAL_ITEM);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, OrderemDaoDbTableColumn.COL_COD_SNAPSHOT);	
					dataInfo.codOrderStatus = stmtResult.getString(OrderemDaoDbTableColumn.COL_COD_ORDER_STATUS);
					dataInfo.codPayOrder = DaoFormatter.sqlToLong(stmtResult, OrderemDaoDbTableColumn.COL_COD_PAY_ORDER);
					dataInfo.codPayOrderItem = DaoFormatter.sqlToInt(stmtResult, OrderemDaoDbTableColumn.COL_COD_PAY_ORDER_ITEM);
					dataInfo.codRefundPolicyGroup = DaoFormatter.sqlToInt(stmtResult, OrderemDaoDbTableColumn.COL_COD_REFUND_POLICY_GROUP);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
