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
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

public final class OrderInsertSingle implements DaoStmt<OrderInfo> {
	private DaoStmt<OrderInfo> stmtSql;
	private DaoStmtOption<OrderInfo> stmtOption;
	
	
	
	public OrderInsertSingle(Connection conn, OrderInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, OrderInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.ORDER_HDR_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = new ResultParser(recordInfo);
		this.stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.INSERT, this.stmtOption, this.getClass());
	}
		
	
	
	@Override public void generateStmt() throws SQLException {
		stmtSql.generateStmt();		
	}

	
	
	@Override public boolean checkStmtGeneration() {
		return stmtSql.checkStmtGeneration();
	}

	
	
	@Override public void executeStmt() throws SQLException {
		stmtSql.executeStmt();
	}

	
	
	@Override public List<OrderInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<OrderInfo> {		
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

			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<OrderInfo> getNewInstance() {
		return new OrderInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<OrderInfo> {
		private OrderInfo recordInfo;
		
		public ResultParser(OrderInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<OrderInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<OrderInfo> finalResult = new ArrayList<>();
			recordInfo.codOrder = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
