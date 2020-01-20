package br.com.mind5.business.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class OrderUpdateSingle extends DaoStmtTemplate<OrderInfo> {
	private final String MAIN_TABLE = DaoDbTable.ORDER_HDR_TABLE;
	
	
	public OrderUpdateSingle(Connection conn, OrderInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OrderInfo recordInfo) {	
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new OrderWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<OrderInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<OrderInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, OrderInfo recordInfo) throws SQLException {	
				int i = 1;
				
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
}
