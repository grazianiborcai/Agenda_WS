package br.com.mind5.discount.discountStore.dao;

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
import br.com.mind5.discount.discountStore.info.DisoreInfo;

public final class DaoDisoreInsertSingle extends DaoStmtTemplate<DisoreInfo> {
	private final String MAIN_TABLE = DaoDbTable.DISCOUNT_STORE_TABLE;	
	
	
	public DaoDisoreInsertSingle(Connection conn, DisoreInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}	
	
	
	
	@Override protected DaoStmtParamTranslator<DisoreInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<DisoreInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, DisoreInfo recordInfo) throws SQLException {
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
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<DisoreInfo> getResultParserHook() {
		return new DaoResultParser<DisoreInfo>() {		
			@Override public List<DisoreInfo> parseResult(DisoreInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<DisoreInfo> finalResult = new ArrayList<>();
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
