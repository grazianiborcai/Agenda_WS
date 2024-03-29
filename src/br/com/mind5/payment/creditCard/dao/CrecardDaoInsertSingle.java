package br.com.mind5.payment.creditCard.dao;

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
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardDaoInsertSingle extends DaoStmtTemplate<CrecardInfo> {
	private final String MAIN_TABLE = DaoDbTable.CREDIT_CARD_TABLE;
	
	
	public CrecardDaoInsertSingle(Connection conn, CrecardInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<CrecardInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<CrecardInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CrecardInfo recordInfo) throws SQLException {					
				int i = 1;
				
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPayCustomer);
				stmt.setString(i++, recordInfo.creditCardId);
				stmt.setString(i++, recordInfo.creditCardBrand);
				stmt.setString(i++, recordInfo.creditCardLast4);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codAddressHolder);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codAddressSnapshotHolder);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPhoneHolder);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPhoneSnapshotHolder);		
				stmt.setString(i++, recordInfo.expirationMonth);
				stmt.setString(i++, recordInfo.expirationYear);
				stmt.setString(i++, recordInfo.nameHolder);
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<CrecardInfo> getResultParserHook() {
		return new DaoResultParser<CrecardInfo>() {	
			@Override public List<CrecardInfo> parseResult(CrecardInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CrecardInfo> finalResult = new ArrayList<>();
				recordInfo.codCreditCard = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}	
}
