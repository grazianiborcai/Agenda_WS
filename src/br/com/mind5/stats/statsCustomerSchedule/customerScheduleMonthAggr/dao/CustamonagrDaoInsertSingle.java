package br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.stats.statsCustomerSchedule.customerScheduleMonthAggr.info.CustamonagrInfo;

public final class CustamonagrDaoInsertSingle extends DaoStmtTemplate<CustamonagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_CUSTOMER_SCHEDULE_MONTH_TABLE;
	
	
	public CustamonagrDaoInsertSingle(Connection conn, CustamonagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<CustamonagrInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<CustamonagrInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CustamonagrInfo recordInfo) throws SQLException {		
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt.setString(i++, recordInfo.calmonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.year);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.month);
				stmt.setString(i++, recordInfo.codCountry);
				stmt.setString(i++, recordInfo.codState);
				stmt.setString(i++, recordInfo.city);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countScheduleCancelledMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countScheduleWaitingMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countScheduleTotalMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countScheduleConfirmedMonth);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countScheduleCancelledLastYear);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countScheduleWaitingLastYear);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countScheduleTotalLastYear);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countScheduleConfirmedLastYear);
	
				return stmt;
			}		
		};
	}
}
