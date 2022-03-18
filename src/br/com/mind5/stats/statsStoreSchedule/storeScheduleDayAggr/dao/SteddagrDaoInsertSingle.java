package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayAggr.info.SteddagrInfo;

public final class SteddagrDaoInsertSingle extends DaoStmtTemplate<SteddagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_SCHEDULE_DAY_TABLE;
	
	
	public SteddagrDaoInsertSingle(Connection conn, SteddagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<SteddagrInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<SteddagrInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, SteddagrInfo recordInfo) throws SQLException {		
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
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countScheduleCancelledDay);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countScheduleWaitingDay);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countScheduleTotalDay);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countScheduleConfirmedDay);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.day);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
	
				return stmt;
			}		
		};
	}
}
