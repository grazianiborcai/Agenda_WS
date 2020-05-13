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

public final class DaoOrderemSelectSingle extends DaoStmtTemplate<OrderemInfo> {	
	private final String MAIN_TABLE = DaoDbTable.ORDER_ITM_TABLE;
	
	
	public DaoOrderemSelectSingle(Connection conn, OrderemInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new DaoOrderemWhere(whereOption, tableName, recordInfo);
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
					
					dataInfo.codOwner = stmtResult.getLong(DaoOrderemDbTableColumn.COL_COD_OWNER);	
					dataInfo.codOrder = stmtResult.getLong(DaoOrderemDbTableColumn.COL_COD_ORDER);
					dataInfo.codOrderItem = DaoFormatter.sqlToInt(stmtResult, DaoOrderemDbTableColumn.COL_COD_ORDER_ITEM);
					dataInfo.quantity = stmtResult.getInt(DaoOrderemDbTableColumn.COL_QUANTITY);
					dataInfo.codCurr = stmtResult.getString(DaoOrderemDbTableColumn.COL_COD_CURRENCY);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoOrderemDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, DaoOrderemDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, DaoOrderemDbTableColumn.COL_COD_MATERIAL);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, DaoOrderemDbTableColumn.COL_DATE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoOrderemDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoOrderemDbTableColumn.COL_END_TIME);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoOrderemDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = stmtResult.getLong(DaoOrderemDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.price = DaoFormatter.sqlToDouble(stmtResult, DaoOrderemDbTableColumn.COL_PRICE);
					dataInfo.totitem = DaoFormatter.sqlToDouble(stmtResult, DaoOrderemDbTableColumn.COL_TOTAL_ITEM);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoOrderemDbTableColumn.COL_COD_SNAPSHOT);	
					dataInfo.codOrderStatus = stmtResult.getString(DaoOrderemDbTableColumn.COL_COD_ORDER_STATUS);
					dataInfo.codPayOrder = DaoFormatter.sqlToLong(stmtResult, DaoOrderemDbTableColumn.COL_COD_PAY_ORDER);
					dataInfo.codPayOrderItem = DaoFormatter.sqlToInt(stmtResult, DaoOrderemDbTableColumn.COL_COD_PAY_ORDER_ITEM);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
