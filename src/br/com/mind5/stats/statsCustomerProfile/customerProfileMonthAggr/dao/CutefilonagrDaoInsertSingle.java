package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info.CutefilonagrInfo;

public final class CutefilonagrDaoInsertSingle extends DaoStmtTemplate<CutefilonagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_CUSTOMER_PROFILE_MONTH_TABLE;
	
	
	public CutefilonagrDaoInsertSingle(Connection conn, CutefilonagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<CutefilonagrInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<CutefilonagrInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CutefilonagrInfo recordInfo) throws SQLException {		
				int i = 1;				
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt.setString(i++, recordInfo.calmonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.year);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.month);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countScheduleCancelled);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countScheduleWaiting);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countScheduleTotal);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countScheduleConfirmed);	
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
	
				return stmt;
			}		
		};
	}
}
