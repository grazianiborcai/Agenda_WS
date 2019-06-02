package br.com.gda.business.orderItem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public class OrderemInsertSingle implements DaoStmt<OrderemInfo> {
	private DaoStmt<OrderemInfo> stmtSql;
	private DaoStmtOption<OrderemInfo> stmtOption;
	
	
	
	public OrderemInsertSingle(Connection conn, OrderemInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, OrderemInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = DaoDbTable.ORDER_ITM_TABLE;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(stmtOption.tableName);
		stmtOption.stmtParamTranslator = new ParamTranslator();
		stmtOption.resultParser = null;
		stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper<>(DaoOperation.INSERT, stmtOption);
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

	
	
	@Override public List<OrderemInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<OrderemInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, OrderemInfo recordInfo) throws SQLException {			
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codOrder);
			
			
			if (recordInfo.codStore >= 0) {
				stmt.setLong(i++, recordInfo.codStore);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codMat >= 0) {
				stmt.setLong(i++, recordInfo.codMat);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			if (recordInfo.codEmployee >= 0) {
				stmt.setLong(i++, recordInfo.codEmployee);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			stmt.setDate(i++, DaoFormatter.localToSqlDate(recordInfo.date));
			stmt.setTime(i++, DaoFormatter.localToSqlTime(recordInfo.beginTime));
			stmt.setTime(i++, DaoFormatter.localToSqlTime(recordInfo.endTime));
			stmt.setInt(i++, recordInfo.quantity);
			stmt.setTimestamp(i++, DaoFormatter.localToSqlTimestamp(recordInfo.createdOn));		
			
			
			if (recordInfo.codStoreSnapshot >= 0) {
				stmt.setLong(i++, recordInfo.codStoreSnapshot);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codMatSnapshot >= 0) {
				stmt.setLong(i++, recordInfo.codMatSnapshot);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codEmployeeSnapshot >= 0) {
				stmt.setLong(i++, recordInfo.codEmployeeSnapshot);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.price >= 0) {
				stmt.setDouble(i++, recordInfo.price);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.totitem >= 0) {
				stmt.setDouble(i++, recordInfo.totitem);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			stmt.setString(i++, recordInfo.codCurr);

			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<OrderemInfo> getNewInstance() {
		return new OrderemInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
