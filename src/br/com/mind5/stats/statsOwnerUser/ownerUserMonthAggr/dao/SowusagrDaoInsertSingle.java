package br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthAggr.info.SowusagrInfo;

public final class SowusagrDaoInsertSingle extends DaoStmtTemplate<SowusagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_OWNER_USER_MONTH_TABLE;
	
	
	public SowusagrDaoInsertSingle(Connection conn, SowusagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<SowusagrInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<SowusagrInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, SowusagrInfo recordInfo) throws SQLException {		
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt.setString(i++, recordInfo.calmonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.year);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.month);
				stmt.setString(i++, recordInfo.codCountry);
				stmt.setString(i++, recordInfo.codState);
				stmt.setString(i++, recordInfo.city);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countUserCreatedMonth);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countUserActiveMonth);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countUserInactiveMonth);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countUserActiveLastYear);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countUserCreatedLastYear);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countUserInactiveLastYear);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
	
				return stmt;
			}		
		};
	}
}
