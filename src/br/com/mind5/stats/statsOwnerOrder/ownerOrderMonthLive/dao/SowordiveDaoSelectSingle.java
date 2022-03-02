package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.dao;

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
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.info.SowordiveInfo;

public final class SowordiveDaoSelectSingle extends DaoStmtTemplate<SowordiveInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_OWNER_ORDER_MONTH_LIVE_TABLE;	
	
	
	public SowordiveDaoSelectSingle(Connection conn, SowordiveInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SowordiveInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new SowordiveDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SowordiveInfo> getResultParserHook() {
		return new DaoResultParser<SowordiveInfo>() {
			@Override public List<SowordiveInfo> parseResult(SowordiveInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SowordiveInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SowordiveInfo dataInfo = new SowordiveInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, SowordiveDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.calmonth = stmtResult.getString(SowordiveDaoDbTableColumn.COL_CALMONTH);
					dataInfo.year = DaoFormatter.sqlToInt(stmtResult, SowordiveDaoDbTableColumn.COL_YEAR);
					dataInfo.month = DaoFormatter.sqlToInt(stmtResult, SowordiveDaoDbTableColumn.COL_MONTH);
					dataInfo.codCountry = stmtResult.getString(SowordiveDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(SowordiveDaoDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.city = stmtResult.getString(SowordiveDaoDbTableColumn.COL_CITY);
					dataInfo.countOrderCancelledMonth = DaoFormatter.sqlToInt(stmtResult, SowordiveDaoDbTableColumn.COL_COUNT_ORDER_CANCELLED_MONTH);
					dataInfo.countOrderWaitingMonth = DaoFormatter.sqlToInt(stmtResult, SowordiveDaoDbTableColumn.COL_COUNT_ORDER_WAITING_MONTH);
					dataInfo.countOrderTotalMonth = DaoFormatter.sqlToInt(stmtResult, SowordiveDaoDbTableColumn.COL_COUNT_ORDER_TOTAL_MONTH);
					dataInfo.countOrderPlacedMonth = DaoFormatter.sqlToInt(stmtResult, SowordiveDaoDbTableColumn.COL_COUNT_ORDER_PLACED_MONTH);
					dataInfo.countOrderCreatedMonth = DaoFormatter.sqlToInt(stmtResult, SowordiveDaoDbTableColumn.COL_COUNT_ORDER_CREATED_MONTH);
					dataInfo.countOrderPaidMonth = DaoFormatter.sqlToInt(stmtResult, SowordiveDaoDbTableColumn.COL_COUNT_ORDER_PAID_MONTH);					
					dataInfo.totalSaleMonth = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_SALE_MONTH);
					dataInfo.totalSaleCreatedMonth = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_SALE_CREATED_MONTH);
					dataInfo.totalSaleWaitingMonth = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_SALE_WAITING_MONTH);
					dataInfo.totalSalePaidMonth = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_SALE_PAID_MONTH);
					dataInfo.totalSalePlacedMonth = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_SALE_PLACED_MONTH);
					dataInfo.totalSaleCancelledMonth = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_SALE_CANCELLED_MONTH);					
					dataInfo.totalFeeMonth = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_FEE_MONTH);
					dataInfo.totalFeeCreatedMonth = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_FEE_CREATED_MONTH);
					dataInfo.totalFeeWaitingMonth = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_FEE_WAITING_MONTH);
					dataInfo.totalFeePaidMonth = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_FEE_PAID_MONTH);
					dataInfo.totalFeePlacedMonth = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_FEE_PLACED_MONTH);
					dataInfo.totalFeeCancelledMonth = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_FEE_CANCELLED_MONTH);
					dataInfo.countOrderCancelledLastYear = DaoFormatter.sqlToInt(stmtResult, SowordiveDaoDbTableColumn.COL_COUNT_ORDER_CANCELLED_MONTH_LAST_YEAR);
					dataInfo.countOrderWaitingLastYear = DaoFormatter.sqlToInt(stmtResult, SowordiveDaoDbTableColumn.COL_COUNT_ORDER_WAITING_MONTH_LAST_YEAR);
					dataInfo.countOrderTotalLastYear = DaoFormatter.sqlToInt(stmtResult, SowordiveDaoDbTableColumn.COL_COUNT_ORDER_TOTAL_MONTH_LAST_YEAR);
					dataInfo.countOrderPlacedLastYear = DaoFormatter.sqlToInt(stmtResult, SowordiveDaoDbTableColumn.COL_COUNT_ORDER_PLACED_MONTH_LAST_YEAR);
					dataInfo.countOrderCreatedLastYear = DaoFormatter.sqlToInt(stmtResult, SowordiveDaoDbTableColumn.COL_COUNT_ORDER_CREATED_MONTH_LAST_YEAR);
					dataInfo.countOrderPaidLastYear = DaoFormatter.sqlToInt(stmtResult, SowordiveDaoDbTableColumn.COL_COUNT_ORDER_PAID_MONTH_LAST_YEAR);					
					dataInfo.totalSaleLastYear = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_SALE_MONTH_LAST_YEAR);
					dataInfo.totalSaleCreatedLastYear = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_SALE_CREATED_MONTH_LAST_YEAR);
					dataInfo.totalSaleWaitingLastYear = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_SALE_WAITING_MONTH_LAST_YEAR);
					dataInfo.totalSalePaidLastYear = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_SALE_PAID_MONTH_LAST_YEAR);
					dataInfo.totalSalePlacedLastYear = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_SALE_PLACED_MONTH_LAST_YEAR);
					dataInfo.totalSaleCancelledLastYear = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_SALE_CANCELLED_MONTH_LAST_YEAR);					
					dataInfo.totalFeeLastYear = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_FEE_MONTH_LAST_YEAR);
					dataInfo.totalFeeCreatedLastYear = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_FEE_CREATED_MONTH_LAST_YEAR);
					dataInfo.totalFeeWaitingLastYear = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_FEE_WAITING_MONTH_LAST_YEAR);
					dataInfo.totalFeePaidLastYear = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_FEE_PAID_MONTH_LAST_YEAR);
					dataInfo.totalFeePlacedLastYear = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_FEE_PLACED_MONTH_LAST_YEAR);
					dataInfo.totalFeeCancelledLastYear = DaoFormatter.sqlToDouble(stmtResult, SowordiveDaoDbTableColumn.COL_TOTAL_FEE_CANCELLED_MONTH_LAST_YEAR);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
