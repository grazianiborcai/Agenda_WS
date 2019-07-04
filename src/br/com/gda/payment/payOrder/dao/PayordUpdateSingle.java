package br.com.gda.payment.payOrder.dao;

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
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class PayordUpdateSingle implements DaoStmt<PayordInfo> {
	private DaoStmt<PayordInfo> stmtSql;
	private DaoStmtOption<PayordInfo> stmtOption;
	
	
	public PayordUpdateSingle(Connection conn, PayordInfo recordInfo, String schemaName) {
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
		this.stmtOption.resultParser = null;
		this.stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoWhereBuilderOption.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new PayordWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.UPDATE, this.stmtOption);
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
	
	
	
	@Override public DaoStmt<PayordInfo> getNewInstance() {
		return new PayordUpdateSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<PayordInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PayordInfo recordInfo) throws SQLException {
			int i = 1;
			
			if (DaoFormatter.boxNumber(recordInfo.codPayPartner) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setInt(i++, recordInfo.codPayPartner);
			}
			
			
			if (DaoFormatter.boxNumber(recordInfo.codCustomer) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codCustomer);
			}
			
			
			if (DaoFormatter.boxNumber(recordInfo.codOrder) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codOrder);
			}
			
			
			if (DaoFormatter.boxNumber(recordInfo.codUser) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codUser);
			}
			
			
			stmt.setTimestamp(i++, DaoFormatter.localToSqlTimestamp(recordInfo.lastChanged));
			stmt.setTimestamp(i++, DaoFormatter.localToSqlTimestamp(recordInfo.createdOn));
			
			
			if (DaoFormatter.boxNumber(recordInfo.codPayCustomer) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codPayCustomer);
			}
			
			
			if (DaoFormatter.boxNumber(recordInfo.codAddressPay) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codAddressPay);
			}
			
						
			if (DaoFormatter.boxNumber(recordInfo.codAddressPaySnapshot) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codAddressPaySnapshot);
			}
						
			
			if (DaoFormatter.boxNumber(recordInfo.codPhonePay) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codPhonePay);
			}	
			
			
			if (DaoFormatter.boxNumber(recordInfo.codPhonePaySnapshot) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codPhonePaySnapshot);
			}			
			
			
			return stmt;
		}		
	}
}
