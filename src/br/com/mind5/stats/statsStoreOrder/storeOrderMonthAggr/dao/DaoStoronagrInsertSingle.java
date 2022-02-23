package br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthAggr.info.StoronagrInfo;

public final class DaoStoronagrInsertSingle extends DaoStmtTemplate<StoronagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_ORDER_MONTH_TABLE;
	
	
	public DaoStoronagrInsertSingle(Connection conn, StoronagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<StoronagrInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<StoronagrInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StoronagrInfo recordInfo) throws SQLException {		
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt.setString(i++, recordInfo.calmonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.year);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.month);
				stmt.setString(i++, recordInfo.codCountry);
				stmt.setString(i++, recordInfo.codState);
				stmt.setString(i++, recordInfo.city);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countOrderCancelledMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countOrderWaitingMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countOrderTotalMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countOrderPlacedMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countOrderCreatedMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countOrderPaidMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSaleCancelledMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSaleCreatedMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSaleMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSalePaidMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSalePlacedMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSaleWaitingMonth);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFeeCancelledMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFeeCreatedMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFeeMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFeePaidMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFeePlacedMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFeeWaitingMonth);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
	
				return stmt;
			}		
		};
	}
}
