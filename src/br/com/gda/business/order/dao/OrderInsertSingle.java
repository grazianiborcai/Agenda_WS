package br.com.gda.business.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

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
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.INSERT, this.stmtOption);
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
			
			Timestamp lastChanged = null;
			if(recordInfo.lastChanged != null)
				lastChanged = Timestamp.valueOf((recordInfo.lastChanged));
			
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codUser);
			
			
			if (recordInfo.codUserSnapshot >= 0) {
				stmt.setLong(i++, recordInfo.codUserSnapshot);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codCustomer >= 0) {
				stmt.setLong(i++, recordInfo.codCustomer);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codCustomerSnapshot >= 0) {
				stmt.setLong(i++, recordInfo.codCustomerSnapshot);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			stmt.setString(i++, recordInfo.codOrderExt);
			stmt.setString(i++, recordInfo.codOrderStatus);
			
			
			if (recordInfo.itemTotal >= 0) {
				stmt.setDouble(i++, recordInfo.itemTotal);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			if (recordInfo.feeService >= 0) {
				stmt.setDouble(i++, recordInfo.feeService);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			if (recordInfo.grandTotal >= 0) {
				stmt.setDouble(i++, recordInfo.grandTotal);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			stmt.setString(i++, recordInfo.codCurr);
			stmt.setTimestamp(i++, lastChanged);	
			
			if (recordInfo.codAddressShip >= 0) {
				stmt.setLong(i++, recordInfo.codAddressShip);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codAddressShipSnapshot >= 0) {
				stmt.setLong(i++, recordInfo.codAddressShipSnapshot);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codAddressInvoice >= 0) {
				stmt.setLong(i++, recordInfo.codAddressInvoice);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codAddressInvoiceSnapshot >= 0) {
				stmt.setLong(i++, recordInfo.codAddressInvoiceSnapshot);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codPhoneShip >= 0) {
				stmt.setLong(i++, recordInfo.codPhoneShip);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codPhoneShipSnapshot >= 0) {
				stmt.setLong(i++, recordInfo.codPhoneShipSnapshot);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codPhoneInvoice >= 0) {
				stmt.setLong(i++, recordInfo.codPhoneInvoice);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codPhoneInvoiceSnapshot >= 0) {
				stmt.setLong(i++, recordInfo.codPhoneInvoiceSnapshot);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codPayOrder >= 0) {
				stmt.setLong(i++, recordInfo.codPayOrder);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	

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
