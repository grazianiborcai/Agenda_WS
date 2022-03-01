package br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info.SowalagrInfo;

public final class SowalagrDaoInsertSingle extends DaoStmtTemplate<SowalagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_OWNER_SALE_TABLE;
	
	
	public SowalagrDaoInsertSingle(Connection conn, SowalagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<SowalagrInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<SowalagrInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, SowalagrInfo recordInfo) throws SQLException {		
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt.setString(i++, recordInfo.codCountry);
				stmt.setString(i++, recordInfo.codState);
				stmt.setString(i++, recordInfo.city);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSaleCreated30d);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSalePaid12m);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSalePaid30d);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSaleWaiting12m);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSaleWaiting30d);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSalePlaced12m);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSale30d);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSale12m);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSaleCreated12m);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSalePlaced30d);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSaleCancelled12m);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalSaleCancelled30d);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFee12m);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFee30d);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFeeCancelled12m);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFeeCancelled30d);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFeePaid12m);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFeePaid30d);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFeePlaced12m);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFeePlaced30d);				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFeeWaiting12m);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totalFeeWaiting30d);				
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
	
				return stmt;
			}		
		};
	}
}
