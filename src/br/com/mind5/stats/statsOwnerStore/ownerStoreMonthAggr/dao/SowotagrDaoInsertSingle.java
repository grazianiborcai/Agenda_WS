package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthAggr.info.SowotagrInfo;

public final class SowotagrDaoInsertSingle extends DaoStmtTemplate<SowotagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_OWNER_STORE_MONTH_TABLE;
	
	
	public SowotagrDaoInsertSingle(Connection conn, SowotagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<SowotagrInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<SowotagrInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, SowotagrInfo recordInfo) throws SQLException {		
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt.setString(i++, recordInfo.calmonth);
				stmt.setString(i++, recordInfo.codCountry);
				stmt.setString(i++, recordInfo.codState);
				stmt.setString(i++, recordInfo.city);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.year);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.month);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countStoreCreatedMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countStoreCreatedLastYear);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countStoreTotalMonth);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countStoreCompletedMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countStorePendingMonth);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countStoreTotalLastYear);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countStoreCompletedLastYear);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.countStorePendingLastYear);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
	
				return stmt;
			}		
		};
	}
}
