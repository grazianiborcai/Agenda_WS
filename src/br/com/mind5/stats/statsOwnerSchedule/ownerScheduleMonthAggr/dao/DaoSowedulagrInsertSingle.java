package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;

public final class DaoSowedulagrInsertSingle extends DaoStmtTemplate<SowedulagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_OWNER_SCHEDULE_MONTH_TABLE;
	
	
	public DaoSowedulagrInsertSingle(Connection conn, SowedulagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<SowedulagrInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<SowedulagrInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, SowedulagrInfo recordInfo) throws SQLException {		
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt.setString(i++, recordInfo.calmonth);
				stmt.setString(i++, recordInfo.codCountry);
				stmt.setString(i++, recordInfo.codState);
				stmt.setString(i++, recordInfo.city);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.year);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.month);
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
