package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.dao;

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
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveInfo;

public final class DaoStordiveSelectSingle extends DaoStmtTemplate<StordiveInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_ORDER_DAY_LIVE_TABLE;
	
	
	public DaoStordiveSelectSingle(Connection conn, StordiveInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StordiveInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoStordiveWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StordiveInfo> getResultParserHook() {
		return new DaoResultParser<StordiveInfo>() {
			@Override public List<StordiveInfo> parseResult(StordiveInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StordiveInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StordiveInfo dataInfo = new StordiveInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoStordiveDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoStordiveDbTableColumn.COL_COD_STORE);
					dataInfo.calmonth = stmtResult.getString(DaoStordiveDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, DaoStordiveDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, DaoStordiveDbTableColumn.COL_MONTH);
					dataInfo.day = DaoFormatter.sqlToInt(stmtResult, DaoStordiveDbTableColumn.COL_DAY);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, DaoStordiveDbTableColumn.COL_DATE);
					dataInfo.codCountry = stmtResult.getString(DaoStordiveDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(DaoStordiveDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(DaoStordiveDbTableColumn.COL_CITY);
					dataInfo.countOrderCancelledDay = DaoFormatter.sqlToInt(stmtResult, DaoStordiveDbTableColumn.COL_COUNT_ORDER_CANCELLED_DAY);
					dataInfo.countOrderWaitingDay = DaoFormatter.sqlToInt(stmtResult, DaoStordiveDbTableColumn.COL_COUNT_ORDER_WAITING_DAY);
					dataInfo.countOrderTotalDay = DaoFormatter.sqlToInt(stmtResult, DaoStordiveDbTableColumn.COL_COUNT_ORDER_TOTAL_DAY);
					dataInfo.countOrderPlacedDay = DaoFormatter.sqlToInt(stmtResult, DaoStordiveDbTableColumn.COL_COUNT_ORDER_PLACED_DAY);
					dataInfo.countOrderCreatedDay = DaoFormatter.sqlToInt(stmtResult, DaoStordiveDbTableColumn.COL_COUNT_ORDER_CREATED_DAY);
					dataInfo.countOrderPaidDay = DaoFormatter.sqlToInt(stmtResult, DaoStordiveDbTableColumn.COL_COUNT_ORDER_PAID_DAY);					
					dataInfo.totalSaleDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordiveDbTableColumn.COL_TOTAL_SALE_DAY);
					dataInfo.totalSaleCreatedDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordiveDbTableColumn.COL_TOTAL_SALE_CREATED_DAY);
					dataInfo.totalSaleWaitingDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordiveDbTableColumn.COL_TOTAL_SALE_WAITING_DAY);
					dataInfo.totalSalePaidDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordiveDbTableColumn.COL_TOTAL_SALE_PAID_DAY);
					dataInfo.totalSalePlacedDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordiveDbTableColumn.COL_TOTAL_SALE_PLACED_DAY);
					dataInfo.totalSaleCancelledDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordiveDbTableColumn.COL_TOTAL_SALE_CANCELLED_DAY);					
					dataInfo.totalFeeDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordiveDbTableColumn.COL_TOTAL_FEE_DAY);
					dataInfo.totalFeeCreatedDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordiveDbTableColumn.COL_TOTAL_FEE_CREATED_DAY);
					dataInfo.totalFeeWaitingDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordiveDbTableColumn.COL_TOTAL_FEE_WAITING_DAY);
					dataInfo.totalFeePaidDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordiveDbTableColumn.COL_TOTAL_FEE_PAID_DAY);
					dataInfo.totalFeePlacedDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordiveDbTableColumn.COL_TOTAL_FEE_PLACED_DAY);
					dataInfo.totalFeeCancelledDay = DaoFormatter.sqlToDouble(stmtResult, DaoStordiveDbTableColumn.COL_TOTAL_FEE_CANCELLED_DAY);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
