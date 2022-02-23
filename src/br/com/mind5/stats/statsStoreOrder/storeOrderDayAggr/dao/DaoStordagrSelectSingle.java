package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.dao;

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
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;

public final class DaoStordagrSelectSingle extends DaoStmtTemplate<StordagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_ORDER_DAY_TABLE;
	
	
	public DaoStordagrSelectSingle(Connection conn, StordagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StordagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoStordagrWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StordagrInfo> getResultParserHook() {
		return new DaoResultParser<StordagrInfo>() {
			@Override public List<StordagrInfo> parseResult(StordagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StordagrInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StordagrInfo dataInfo = new StordagrInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoStordagrDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoStordagrDbTableColumn.COL_COD_STORE);
					dataInfo.calmonth = stmtResult.getString(DaoStordagrDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, DaoStordagrDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, DaoStordagrDbTableColumn.COL_MONTH);
					dataInfo.day = DaoFormatter.sqlToInt(stmtResult, DaoStordagrDbTableColumn.COL_DAY);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, DaoStordagrDbTableColumn.COL_DATE);
					dataInfo.codCountry = stmtResult.getString(DaoStordagrDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(DaoStordagrDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(DaoStordagrDbTableColumn.COL_CITY);
					dataInfo.countOrderCancelledDay = DaoFormatter.sqlToInt(stmtResult, DaoStordagrDbTableColumn.COL_COUNT_ORDER_CANCELLED_DAY);
					dataInfo.countOrderWaitingDay = DaoFormatter.sqlToInt(stmtResult, DaoStordagrDbTableColumn.COL_COUNT_ORDER_WAITING_DAY);
					dataInfo.countOrderTotalDay = DaoFormatter.sqlToInt(stmtResult, DaoStordagrDbTableColumn.COL_COUNT_ORDER_TOTAL_DAY);
					dataInfo.countOrderPlacedDay = DaoFormatter.sqlToInt(stmtResult, DaoStordagrDbTableColumn.COL_COUNT_ORDER_PLACED_DAY);
					dataInfo.countOrderCreatedDay = DaoFormatter.sqlToInt(stmtResult, DaoStordagrDbTableColumn.COL_COUNT_ORDER_CREATED_DAY);
					dataInfo.countOrderPaidDay = DaoFormatter.sqlToInt(stmtResult, DaoStordagrDbTableColumn.COL_COUNT_ORDER_PAID_DAY);					
					dataInfo.totalSaleDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordagrDbTableColumn.COL_TOTAL_SALE_DAY);
					dataInfo.totalSaleCreatedDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordagrDbTableColumn.COL_TOTAL_SALE_CREATED_DAY);
					dataInfo.totalSaleWaitingDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordagrDbTableColumn.COL_TOTAL_SALE_WAITING_DAY);
					dataInfo.totalSalePaidDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordagrDbTableColumn.COL_TOTAL_SALE_PAID_DAY);
					dataInfo.totalSalePlacedDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordagrDbTableColumn.COL_TOTAL_SALE_PLACED_DAY);
					dataInfo.totalSaleCancelledDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordagrDbTableColumn.COL_TOTAL_SALE_CANCELLED_DAY);					
					dataInfo.totalFeeDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordagrDbTableColumn.COL_TOTAL_FEE_DAY);
					dataInfo.totalFeeCreatedDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordagrDbTableColumn.COL_TOTAL_FEE_CREATED_DAY);
					dataInfo.totalFeeWaitingDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordagrDbTableColumn.COL_TOTAL_FEE_WAITING_DAY);
					dataInfo.totalFeePaidDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordagrDbTableColumn.COL_TOTAL_FEE_PAID_DAY);
					dataInfo.totalFeePlacedDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordagrDbTableColumn.COL_TOTAL_FEE_PLACED_DAY);
					dataInfo.totalFeeCancelledDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordagrDbTableColumn.COL_TOTAL_FEE_CANCELLED_DAY);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
