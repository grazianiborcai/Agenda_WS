package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.dao;

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
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;

public final class DaoStoronagrSelectSingle extends DaoStmtTemplate<StoronagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_ORDER_MONTH_TABLE;
	
	
	public DaoStoronagrSelectSingle(Connection conn, StoronagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StoronagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoStoronagrWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StoronagrInfo> getResultParserHook() {
		return new DaoResultParser<StoronagrInfo>() {
			@Override public List<StoronagrInfo> parseResult(StoronagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StoronagrInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StoronagrInfo dataInfo = new StoronagrInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoStoronagrDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoStoronagrDbTableColumn.COL_COD_STORE);
					dataInfo.calmonth = stmtResult.getString(DaoStoronagrDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, DaoStoronagrDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, DaoStoronagrDbTableColumn.COL_MONTH);
					dataInfo.codCountry = stmtResult.getString(DaoStoronagrDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(DaoStoronagrDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(DaoStoronagrDbTableColumn.COL_CITY);
					dataInfo.countOrderCancelledMonth = DaoFormatter.sqlToInt(stmtResult, DaoStoronagrDbTableColumn.COL_COUNT_ORDER_CANCELLED_MONTH);
					dataInfo.countOrderWaitingMonth = DaoFormatter.sqlToInt(stmtResult, DaoStoronagrDbTableColumn.COL_COUNT_ORDER_WAITING_MONTH);
					dataInfo.countOrderTotalMonth = DaoFormatter.sqlToInt(stmtResult, DaoStoronagrDbTableColumn.COL_COUNT_ORDER_TOTAL_MONTH);
					dataInfo.countOrderPlacedMonth = DaoFormatter.sqlToInt(stmtResult, DaoStoronagrDbTableColumn.COL_COUNT_ORDER_PLACED_MONTH);
					dataInfo.countOrderCreatedMonth = DaoFormatter.sqlToInt(stmtResult, DaoStoronagrDbTableColumn.COL_COUNT_ORDER_CREATED_MONTH);
					dataInfo.countOrderPaidMonth = DaoFormatter.sqlToInt(stmtResult, DaoStoronagrDbTableColumn.COL_COUNT_ORDER_PAID_MONTH);					
					dataInfo.totalSaleMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoronagrDbTableColumn.COL_TOTAL_SALE_MONTH);
					dataInfo.totalSaleCreatedMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoronagrDbTableColumn.COL_TOTAL_SALE_CREATED_MONTH);
					dataInfo.totalSaleWaitingMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoronagrDbTableColumn.COL_TOTAL_SALE_WAITING_MONTH);
					dataInfo.totalSalePaidMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoronagrDbTableColumn.COL_TOTAL_SALE_PAID_MONTH);
					dataInfo.totalSalePlacedMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoronagrDbTableColumn.COL_TOTAL_SALE_PLACED_MONTH);
					dataInfo.totalSaleCancelledMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoronagrDbTableColumn.COL_TOTAL_SALE_CANCELLED_MONTH);					
					dataInfo.totalFeeMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoronagrDbTableColumn.COL_TOTAL_FEE_MONTH);
					dataInfo.totalFeeCreatedMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoronagrDbTableColumn.COL_TOTAL_FEE_CREATED_MONTH);
					dataInfo.totalFeeWaitingMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoronagrDbTableColumn.COL_TOTAL_FEE_WAITING_MONTH);
					dataInfo.totalFeePaidMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoronagrDbTableColumn.COL_TOTAL_FEE_PAID_MONTH);
					dataInfo.totalFeePlacedMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoronagrDbTableColumn.COL_TOTAL_FEE_PLACED_MONTH);
					dataInfo.totalFeeCancelledMonth = DaoFormatter.sqlToDouble(stmtResult, DaoStoronagrDbTableColumn.COL_TOTAL_FEE_CANCELLED_MONTH);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoStoronagrDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
