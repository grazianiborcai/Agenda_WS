package br.com.mind5.payment.payOrderItem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public class DaoPayordemInsertSingle extends DaoStmtTemplate<PayordemInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_ORDER_ITM_TABLE;
	
	
	public DaoPayordemInsertSingle(Connection conn, PayordemInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<PayordemInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<PayordemInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PayordemInfo recordInfo) throws SQLException {							
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setLong(i++, recordInfo.codPayOrder);
				stmt.setInt(i++, recordInfo.codPayOrderItem);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codMat);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployee);
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.date);
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.beginTime);
				stmt.setInt(i++, recordInfo.quantity);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.price);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.totitem);
				stmt.setString(i++, recordInfo.codCurr);
				stmt.setString(i++, recordInfo.itemReceiver);
				stmt.setString(i++, recordInfo.ownId);
				stmt.setString(i++, recordInfo.idOrderPartner);
				stmt.setString(i++, recordInfo.statusOrderPartner);
				stmt = DaoFormatter.charToStmt(stmt, i++, recordInfo.codFeeCateg);
				stmt.setString(i++, recordInfo.idPaymentPartner);
				stmt.setString(i++, recordInfo.statusPaymentPartner);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt.setString(i++, recordInfo.idRefundPartner);
				stmt.setString(i++, recordInfo.statusRefundPartner);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOrder);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOrderItem);
				
				return stmt;
			}		
		};
	}
}
