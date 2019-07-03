package br.com.gda.payment.payOrderItem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

public class OrderemInsertSingle implements DaoStmt<PayordemInfo> {
	private DaoStmt<PayordemInfo> stmtSql;
	private DaoStmtOption<PayordemInfo> stmtOption;
	
	
	
	public OrderemInsertSingle(Connection conn, PayordemInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, PayordemInfo recordInfo, String schemaName) {
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

	
	
	@Override public List<PayordemInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<PayordemInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PayordemInfo recordInfo) throws SQLException {			
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codPayOrder);
			
			
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
	
	
	
	@Override public DaoStmt<PayordemInfo> getNewInstance() {
		return new OrderemInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
