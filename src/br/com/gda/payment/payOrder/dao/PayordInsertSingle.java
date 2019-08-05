package br.com.gda.payment.payOrder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class PayordInsertSingle implements DaoStmt<PayordInfo> {
	private DaoStmt<PayordInfo> stmtSql;
	private DaoStmtOption<PayordInfo> stmtOption;
	
	
	
	public PayordInsertSingle(Connection conn, PayordInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, PayordInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.PAY_ORDER_HDR_TABLE;
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

	
	
	@Override public List<PayordInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<PayordInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PayordInfo recordInfo) throws SQLException {			
			int i = 1;			
			stmt.setLong(i++, recordInfo.codOwner);
			
			
			if (DaoFormatter.boxNumber(recordInfo.codOrder) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codOrder);
			}
			
			
			stmt.setTimestamp(i++, DaoFormatter.localToSqlTimestamp(recordInfo.lastChanged));
			stmt.setTimestamp(i++, DaoFormatter.localToSqlTimestamp(recordInfo.createdOn));
			
			
			if (DaoFormatter.boxNumber(recordInfo.codPayCustomer) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codPayCustomer);
			}

			
			if (DaoFormatter.boxNumber(recordInfo.codCreditCard) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setDouble(i++, recordInfo.codCreditCard);
			}
			
			
			stmt.setString(i++, recordInfo.idOrderPartner);
			stmt.setString(i++, recordInfo.statusOrderPartner);
			stmt.setString(i++, recordInfo.amountTotalPartner);
			stmt.setString(i++, recordInfo.amountCurrencyPartner);
			stmt.setString(i++, recordInfo.idPaymentPartner);
			stmt.setString(i++, recordInfo.statusPaymentPartner);
			
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<PayordInfo> getNewInstance() {
		return new PayordInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<PayordInfo> {
		private PayordInfo recordInfo;
		
		public ResultParser(PayordInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<PayordInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PayordInfo> finalResult = new ArrayList<>();
			recordInfo.codPayOrder = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
