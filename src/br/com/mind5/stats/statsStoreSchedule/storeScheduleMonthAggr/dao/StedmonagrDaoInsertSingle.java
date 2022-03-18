package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonthAggr.info.StedmonagrInfo;

public final class StedmonagrDaoInsertSingle extends DaoStmtTemplate<StedmonagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_SCHEDULE_MONTH_TABLE;
	
	
	public StedmonagrDaoInsertSingle(Connection conn, StedmonagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<StedmonagrInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<StedmonagrInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StedmonagrInfo recordInfo) throws SQLException {		
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
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
