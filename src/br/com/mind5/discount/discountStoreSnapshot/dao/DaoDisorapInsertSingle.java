package br.com.mind5.discount.discountStoreSnapshot.dao;

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
import br.com.mind5.discount.discountStoreSnapshot.info.DisorapInfo;

public final class DaoDisorapInsertSingle extends DaoStmtTemplate<DisorapInfo> {
	private final String MAIN_TABLE = DaoDbTable.DISCOUNT_STORE_SNAPSHOT_TABLE;	
	
	
	public DaoDisorapInsertSingle(Connection conn, DisorapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}	
	
	
	
	@Override protected DaoStmtParamTranslator<DisorapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<DisorapInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, DisorapInfo recordInfo) throws SQLException {
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codDiscount);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
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
	
	
	
	@Override protected DaoResultParser<DisorapInfo> getResultParserHook() {
		return new DaoResultParser<DisorapInfo>() {		
			@Override public List<DisorapInfo> parseResult(DisorapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<DisorapInfo> finalResult = new ArrayList<>();
				recordInfo.codSnapshot = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
