package br.com.mind5.payment.payOrderItem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.obsolete.DaoStmtOption_;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public class PayordemInsertSingle implements DaoStmt<PayordemInfo> {
	private DaoStmt<PayordemInfo> stmtSql;
	private DaoStmtOption_<PayordemInfo> stmtOption;
	
	
	
	public PayordemInsertSingle(Connection conn, PayordemInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, PayordemInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption_<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = DaoDbTable.PAY_ORDER_ITM_TABLE;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(stmtOption.tableName);
		stmtOption.stmtParamTranslator = new ParamTranslator();
		stmtOption.resultParser = null;
		stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper_<>(DaoOperation.INSERT, stmtOption, this.getClass());
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
			stmt.setBoolean(i++, recordInfo.isSystemReceiver);
			stmt.setString(i++, recordInfo.idRefundPartner);
			stmt.setString(i++, recordInfo.statusRefundPartner);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOrder);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOrderItem);
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<PayordemInfo> getNewInstance() {
		return new PayordemInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
