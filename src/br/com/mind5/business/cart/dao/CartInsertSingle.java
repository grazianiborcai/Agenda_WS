package br.com.mind5.business.cart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

public final class CartInsertSingle implements DaoStmt<CartInfo> {
	private DaoStmt<CartInfo> stmtSql;
	private DaoStmtOption<CartInfo> stmtOption;
	
	
	
	public CartInsertSingle(Connection conn, CartInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, CartInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.CART_HDR_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = null;
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

	
	
	@Override public List<CartInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<CartInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CartInfo recordInfo) throws SQLException {			
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codUser);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
			stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);

			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<CartInfo> getNewInstance() {
		return new CartInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
