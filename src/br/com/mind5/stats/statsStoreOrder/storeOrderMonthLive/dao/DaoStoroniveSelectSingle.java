package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;

public final class DaoStoroniveSelectSingle extends DaoStmtTemplate<StoroniveInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_ORDER_MONTH_LIVE_TABLE;
	
	
	public DaoStoroniveSelectSingle(Connection conn, StoroniveInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StoroniveInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoStoroniveWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StoroniveInfo> getResultParserHook() {
		return new DaoResultParser<StoroniveInfo>() {
			@Override public List<StoroniveInfo> parseResult(StoroniveInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StoroniveInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StoroniveInfo dataInfo = new StoroniveInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoStoroniveDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoStoroniveDbTableColumn.COL_COD_STORE);
					dataInfo.calmonth = stmtResult.getString(DaoStoroniveDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, DaoStoroniveDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, DaoStoroniveDbTableColumn.COL_MONTH);
					dataInfo.codCountry = stmtResult.getString(DaoStoroniveDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(DaoStoroniveDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(DaoStoroniveDbTableColumn.COL_CITY);
					dataInfo.countOrderCancelledMonth = DaoFormatter.sqlToInt(stmtResult, DaoStoroniveDbTableColumn.COL_COUNT_ORDER_CANCELLED_MONTH);
					dataInfo.countOrderWaitingMonth = DaoFormatter.sqlToInt(stmtResult, DaoStoroniveDbTableColumn.COL_COUNT_ORDER_WAITING_MONTH);
					dataInfo.countOrderTotalMonth = DaoFormatter.sqlToInt(stmtResult, DaoStoroniveDbTableColumn.COL_COUNT_ORDER_TOTAL_MONTH);
					dataInfo.countOrderPlacedMonth = DaoFormatter.sqlToInt(stmtResult, DaoStoroniveDbTableColumn.COL_COUNT_ORDER_PLACED_MONTH);
					dataInfo.countOrderCreatedMonth = DaoFormatter.sqlToInt(stmtResult, DaoStoroniveDbTableColumn.COL_COUNT_ORDER_CREATED_MONTH);
					dataInfo.countOrderPaidMonth = DaoFormatter.sqlToInt(stmtResult, DaoStoroniveDbTableColumn.COL_COUNT_ORDER_PAID_MONTH);					
					dataInfo.totalSaleMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_SALE_MONTH);
					dataInfo.totalSaleCreatedMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_SALE_CREATED_MONTH);
					dataInfo.totalSaleWaitingMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_SALE_WAITING_MONTH);
					dataInfo.totalSalePaidMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_SALE_PAID_MONTH);
					dataInfo.totalSalePlacedMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_SALE_PLACED_MONTH);
					dataInfo.totalSaleCancelledMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_SALE_CANCELLED_MONTH);					
					dataInfo.totalFeeMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_FEE_MONTH);
					dataInfo.totalFeeCreatedMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_FEE_CREATED_MONTH);
					dataInfo.totalFeeWaitingMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_FEE_WAITING_MONTH);
					dataInfo.totalFeePaidMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_FEE_PAID_MONTH);
					dataInfo.totalFeePlacedMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_FEE_PLACED_MONTH);
					dataInfo.totalFeeCancelledMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_FEE_CANCELLED_MONTH);
					dataInfo.countOrderCancelledLastYear = DaoFormatter.sqlToInt(stmtResult, DaoStoroniveDbTableColumn.COL_COUNT_ORDER_CANCELLED_MONTH_LAST_YEAR);
					dataInfo.countOrderWaitingLastYear = DaoFormatter.sqlToInt(stmtResult, DaoStoroniveDbTableColumn.COL_COUNT_ORDER_WAITING_MONTH_LAST_YEAR);
					dataInfo.countOrderTotalLastYear = DaoFormatter.sqlToInt(stmtResult, DaoStoroniveDbTableColumn.COL_COUNT_ORDER_TOTAL_MONTH_LAST_YEAR);
					dataInfo.countOrderPlacedLastYear = DaoFormatter.sqlToInt(stmtResult, DaoStoroniveDbTableColumn.COL_COUNT_ORDER_PLACED_MONTH_LAST_YEAR);
					dataInfo.countOrderCreatedLastYear = DaoFormatter.sqlToInt(stmtResult, DaoStoroniveDbTableColumn.COL_COUNT_ORDER_CREATED_MONTH_LAST_YEAR);
					dataInfo.countOrderPaidLastYear = DaoFormatter.sqlToInt(stmtResult, DaoStoroniveDbTableColumn.COL_COUNT_ORDER_PAID_MONTH_LAST_YEAR);					
					dataInfo.totalSaleLastYear = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_SALE_MONTH_LAST_YEAR);
					dataInfo.totalSaleCreatedLastYear = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_SALE_CREATED_MONTH_LAST_YEAR);
					dataInfo.totalSaleWaitingLastYear = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_SALE_WAITING_MONTH_LAST_YEAR);
					dataInfo.totalSalePaidLastYear = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_SALE_PAID_MONTH_LAST_YEAR);
					dataInfo.totalSalePlacedLastYear = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_SALE_PLACED_MONTH_LAST_YEAR);
					dataInfo.totalSaleCancelledLastYear = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_SALE_CANCELLED_MONTH_LAST_YEAR);					
					dataInfo.totalFeeLastYear = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_FEE_MONTH_LAST_YEAR);
					dataInfo.totalFeeCreatedLastYear = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_FEE_CREATED_MONTH_LAST_YEAR);
					dataInfo.totalFeeWaitingLastYear = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_FEE_WAITING_MONTH_LAST_YEAR);
					dataInfo.totalFeePaidLastYear = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_FEE_PAID_MONTH_LAST_YEAR);
					dataInfo.totalFeePlacedLastYear = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_FEE_PLACED_MONTH_LAST_YEAR);
					dataInfo.totalFeeCancelledLastYear = DaoFormatter.sqlToDouble(stmtResult, DaoStoroniveDbTableColumn.COL_TOTAL_FEE_CANCELLED_MONTH_LAST_YEAR);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
