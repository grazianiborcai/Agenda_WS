package br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayAggr.info.StordagrInfo;

public final class DaoStordagrInsertSingle extends DaoStmtTemplate<StordagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_ORDER_DAY_TABLE;
	
	
	public DaoStordagrInsertSingle(Connection conn, StordagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<StordagrInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<StordagrInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StordagrInfo recordInfo) throws SQLException {		
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.date);
				stmt.setString(i++, recordInfo.calmonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.year);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.month);
				stmt.setString(i++, recordInfo.codCountry);
				stmt.setString(i++, recordInfo.codState);
				stmt.setString(i++, recordInfo.city);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countOrderCancelledDay);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countOrderWaitingDay);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countOrderTotalDay);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countOrderPlacedDay);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countOrderCreatedDay);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countOrderPaidDay);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.day);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSaleCancelledDay);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSaleCreatedDay);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSaleDay);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSalePaidDay);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSalePlacedDay);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSaleWaitingDay);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFeeCancelledDay);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFeeCreatedDay);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFeeDay);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFeePaidDay);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFeePlacedDay);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFeeWaitingDay);
	
				return stmt;
			}		
		};
	}
}
