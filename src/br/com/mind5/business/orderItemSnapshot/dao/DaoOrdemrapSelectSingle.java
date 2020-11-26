package br.com.mind5.business.orderItemSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoOrdemrapSelectSingle extends DaoStmtTemplate<OrdemrapInfo> {	
	private final String MAIN_TABLE = DaoDbTable.ORDER_ITM_SNAPSHOT_TABLE;
	
	
	public DaoOrdemrapSelectSingle(Connection conn, OrdemrapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OrdemrapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoOrdemrapWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<OrdemrapInfo> getResultParserHook() {
		return new DaoResultParser<OrdemrapInfo>() {
			@Override public List<OrdemrapInfo> parseResult(OrdemrapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OrdemrapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					OrdemrapInfo dataInfo = new OrdemrapInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoOrdemrapDbTableColumn.COL_COD_OWNER);	
					dataInfo.codSnapshot = stmtResult.getLong(DaoOrdemrapDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codOrder = stmtResult.getLong(DaoOrdemrapDbTableColumn.COL_COD_ORDER);
					dataInfo.codOrderItem = DaoFormatter.sqlToInt(stmtResult, DaoOrdemrapDbTableColumn.COL_COD_ORDER_ITEM);
					dataInfo.quantity = stmtResult.getInt(DaoOrdemrapDbTableColumn.COL_QUANTITY);
					dataInfo.codCurr = stmtResult.getString(DaoOrdemrapDbTableColumn.COL_COD_CURRENCY);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoOrdemrapDbTableColumn.COL_COD_STORE);
					dataInfo.codStoreSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoOrdemrapDbTableColumn.COL_COD_STORE_SNAPSHOT);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, DaoOrdemrapDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codEmployeeSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoOrdemrapDbTableColumn.COL_COD_EMPLOYEE_SNAPSHOT);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, DaoOrdemrapDbTableColumn.COL_COD_MATERIAL);
					dataInfo.codMatSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoOrdemrapDbTableColumn.COL_COD_MATERIAL_SNAPSHOT);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, DaoOrdemrapDbTableColumn.COL_DATE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoOrdemrapDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, DaoOrdemrapDbTableColumn.COL_END_TIME);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoOrdemrapDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = stmtResult.getLong(DaoOrdemrapDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.price = DaoFormatter.sqlToDouble(stmtResult, DaoOrdemrapDbTableColumn.COL_PRICE);
					dataInfo.totitem = DaoFormatter.sqlToDouble(stmtResult, DaoOrdemrapDbTableColumn.COL_TOTAL_ITEM);	
					dataInfo.codOrderStatus = stmtResult.getString(DaoOrdemrapDbTableColumn.COL_COD_ORDER_STATUS);
					dataInfo.codPayOrder = DaoFormatter.sqlToLong(stmtResult, DaoOrdemrapDbTableColumn.COL_COD_PAY_ORDER);
					dataInfo.codPayOrderItem = DaoFormatter.sqlToInt(stmtResult, DaoOrdemrapDbTableColumn.COL_COD_PAY_ORDER_ITEM);
					dataInfo.codRefundPolicyGroup = DaoFormatter.sqlToInt(stmtResult, DaoOrdemrapDbTableColumn.COL_COD_REFUND_POLICY_GROUP);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, DaoOrdemrapDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codCustomerSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoOrdemrapDbTableColumn.COL_COD_CUSTOMER_SNAPSHOT);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
