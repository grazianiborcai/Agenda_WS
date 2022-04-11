package br.com.mind5.business.orderSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class OrdnapDaoInsertSingle extends DaoStmtTemplate<OrdnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.ORDER_HDR_SNAPSHOT_TABLE;	
	
	
	public OrdnapDaoInsertSingle(Connection conn, OrdnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<OrdnapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<OrdnapInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, OrdnapInfo recordInfo) throws SQLException {	
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setLong(i++, recordInfo.codOrder);
				stmt.setLong(i++, recordInfo.codUser);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUserSnapshot);
				stmt.setString(i++, recordInfo.codOrderExt);
				stmt.setString(i++, recordInfo.codOrderStatus);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.itemTotal);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.feeService);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.grandTotal);
				stmt.setString(i++, recordInfo.codCurr);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codAddressShip);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codAddressShipSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codAddressInvoice);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codAddressInvoiceSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPhoneShip);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPhoneShipSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPhoneInvoice);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPhoneInvoiceSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPayOrder);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.postingDate);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.postingYear);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.postingYearMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codRefundPolicyGroup);
				
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParser<OrdnapInfo> getResultParserHook() {
		return new DaoResultParser<OrdnapInfo>() {		
			@Override public List<OrdnapInfo> parseResult(OrdnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OrdnapInfo> finalResult = new ArrayList<>();
				recordInfo.codSnapshot= lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
