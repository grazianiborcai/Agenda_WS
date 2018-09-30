package br.com.gda.business.order.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;

public final class OrderInsertItmSingle implements DaoStmt<OrderInfo> {
	private DaoStmt<OrderInfo> stmtSql;
	private DaoStmtOption<OrderInfo> stmtOption;
	
	
	
	public OrderInsertItmSingle(Connection conn, OrderInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, OrderInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.ORDER_ITM_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = null;
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
			
			Time beginTime = null;
			if (recordInfo.matBeginTime != null)		
				beginTime = Time.valueOf(recordInfo.matBeginTime);
			
			Time endTime = null;
			if (recordInfo.matEndTime != null)		
				endTime = Time.valueOf(recordInfo.matEndTime);
			
			Date date = null;
			if (recordInfo.matDate != null)		
				date = Date.valueOf(recordInfo.matDate);
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codOrder);
			stmt.setInt(i++, recordInfo.itemNumber);	
			stmt.setLong(i++, recordInfo.codEmployee);
			stmt.setLong(i++, recordInfo.codMat);
			stmt.setLong(i++, recordInfo.codStore);
			stmt.setString(i++, recordInfo.empCpf);
			stmt.setTime(i++, beginTime);
			stmt.setInt(i++, recordInfo.matCodCategory);
			stmt.setString(i++, recordInfo.matCodCurr);
			stmt.setInt(i++, recordInfo.matCodGroup);
			stmt.setInt(i++, recordInfo.matCodType);
			stmt.setString(i++, recordInfo.matUnit);
			stmt.setDate(i++, date);			
			stmt.setTime(i++, endTime);	
			stmt.setDouble(i++, recordInfo.matPrice);
			stmt.setInt(i++, recordInfo.matPriceUnit);
			stmt.setString(i++, recordInfo.storeCnpj);
			stmt.setString(i++, recordInfo.storeCodCurr);
			stmt.setString(i++, recordInfo.storeCodTimezone);
			stmt.setString(i++, recordInfo.storeCountry);
			stmt.setString(i++, recordInfo.storeInscEstadual);
			stmt.setString(i++, recordInfo.storeInscMunicipal);
			stmt.setString(i++, recordInfo.storeName);
			stmt.setString(i++, recordInfo.storeStateProvince);

			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<OrderInfo> getNewInstance() {
		return new OrderInsertHdrSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
