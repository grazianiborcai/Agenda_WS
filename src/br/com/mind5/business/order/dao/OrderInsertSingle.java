package br.com.mind5.business.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class OrderInsertSingle extends DaoStmtTemplate<OrderInfo> {
	private final String MAIN_TABLE = DaoDbTable.ORDER_HDR_TABLE;	
	
	
	public OrderInsertSingle(Connection conn, OrderInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<OrderInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<OrderInfo>() {			
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, OrderInfo recordInfo) throws SQLException {	
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setLong(i++, recordInfo.codUser);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
				stmt.setString(i++, recordInfo.codOrderExt);
				stmt.setString(i++, recordInfo.codOrderStatus);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.itemTotal);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.feeService);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.grandTotal);
				stmt.setString(i++, recordInfo.codCurr);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codAddressShip);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codAddressInvoice);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPhoneShip);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPhoneInvoice);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPayOrder);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
				stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.postingDate);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.postingYear);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.postingYearMonth);
	
				return stmt;
			}		
		};
	}
	
	
	
	@Override protected DaoResultParserV2<OrderInfo> getResultParserHook() {
		return new DaoResultParserV2<OrderInfo>() {		
			@Override public List<OrderInfo> parseResult(OrderInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OrderInfo> finalResult = new ArrayList<>();
				recordInfo.codOrder = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
