package br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info.StefilonagrInfo;

public final class StefilonagrDaoInsertSingle extends DaoStmtTemplate<StefilonagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_STORE_PROFILE_MONTH_TABLE;
	
	
	public StefilonagrDaoInsertSingle(Connection conn, StefilonagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<StefilonagrInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<StefilonagrInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StefilonagrInfo recordInfo) throws SQLException {		
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt.setString(i++, recordInfo.calmonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.year);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.month);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countScheduleCancelled);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countScheduleWaiting);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countScheduleTotal);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countScheduleConfirmed);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countGoods);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countService);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countEmployee);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countCustomer);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
	
				return stmt;
			}		
		};
	}
}
