package br.com.gda.business.cart.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;

public class CartInsertItmSingle implements DaoStmt<CartInfo> {
	private DaoStmt<CartInfo> stmtSql;
	private DaoStmtOption<CartInfo> stmtOption;
	
	
	
	public CartInsertItmSingle(Connection conn, CartInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, CartInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.CART_ITM_TABLE;
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

	
	
	@Override public List<CartInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<CartInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CartInfo recordInfo) throws SQLException {
			
			Time beginTime = null;
			if (recordInfo.beginTime != null)		
				beginTime = Time.valueOf(recordInfo.beginTime);
			
			Time endTime = null;
			if (recordInfo.endTime != null)		
				endTime = Time.valueOf(recordInfo.endTime);
			
			Date date = null;
			if (recordInfo.date != null)		
				date = Date.valueOf(recordInfo.date);
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codCustomer);
			stmt.setInt(i++, recordInfo.itemNumber);	
			stmt.setInt(i++, recordInfo.quantity);
			stmt.setLong(i++, recordInfo.codStore);
			stmt.setLong(i++, recordInfo.codMat);
			stmt.setString(i++, recordInfo.codUnit);
			stmt.setDouble(i++, recordInfo.price);
			stmt.setString(i++, recordInfo.codCurr);
			stmt.setTime(i++, beginTime);
			stmt.setTime(i++, endTime);
			stmt.setDate(i++, date);
			stmt.setLong(i++, recordInfo.codEmployee);

			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<CartInfo> getNewInstance() {
		return new CartInsertHdrSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
