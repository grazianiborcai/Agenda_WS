package br.com.mind5.discount.discountCouponItem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.discount.discountCouponItem.info.DisoupemInfo;

public final class DaoDisoupemInsertSingle extends DaoStmtTemplate<DisoupemInfo> {
	private final String MAIN_TABLE = DaoDbTable.DISCOUNT_COUPON_TABLE;	
	
	
	public DaoDisoupemInsertSingle(Connection conn, DisoupemInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}	
	
	
	
	@Override protected DaoStmtParamTranslator<DisoupemInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<DisoupemInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, DisoupemInfo recordInfo) throws SQLException {
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codDiscountStrategy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.discountPercent);
				stmt.setBoolean(i++, recordInfo.isActive);								
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);			
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.validFrom);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.validTo);
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<DisoupemInfo> getResultParserHook() {
		return new DaoResultParser<DisoupemInfo>() {		
			@Override public List<DisoupemInfo> parseResult(DisoupemInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<DisoupemInfo> finalResult = new ArrayList<>();
				recordInfo.codDiscount = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
