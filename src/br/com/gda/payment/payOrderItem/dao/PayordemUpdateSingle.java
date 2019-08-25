package br.com.gda.payment.payOrderItem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

public class PayordemUpdateSingle implements DaoStmt<PayordemInfo> {
	private DaoStmt<PayordemInfo> stmtSql;
	private DaoStmtOption<PayordemInfo> stmtOption;
	
	
	
	public PayordemUpdateSingle(Connection conn, PayordemInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, PayordemInfo recordInfo, String schemaName) {
		stmtOption = new DaoStmtOption<>();
		stmtOption.conn = conn;
		stmtOption.recordInfo = recordInfo;
		stmtOption.schemaName = schemaName;
		stmtOption.tableName = DaoDbTable.PAY_ORDER_ITM_TABLE;
		stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(stmtOption.tableName);
		stmtOption.stmtParamTranslator = new ParamTranslator();
		stmtOption.resultParser = null;
		stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoWhereBuilderOption.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new PayordemWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	private void buildStmt() {
		stmtSql = new DaoStmtHelper<>(DaoOperation.UPDATE, stmtOption);
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
		return new PayordemUpdateSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
