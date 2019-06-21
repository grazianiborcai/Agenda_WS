package br.com.gda.payment.payOrder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
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
		this.stmtOption.tableName = DaoDbTable.PAY_ORDER_TABLE;
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

	
	
	@Override public List<PayordInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<PayordInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PayordInfo recordInfo) throws SQLException {
			
			Timestamp lastChanged = null;
			if(recordInfo.lastChanged != null)
				lastChanged = Timestamp.valueOf((recordInfo.lastChanged));
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			
			
			if (DaoFormatter.boxNumber(recordInfo.codStore) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codStore);
			}
			
			
			if (DaoFormatter.boxNumber(recordInfo.codPayPartner) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codPayPartner);
			}
			
			
			stmt.setString(i++, recordInfo.recordMode);
			
			
			if (DaoFormatter.boxNumber(recordInfo.codSnapshot) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codSnapshot);
			}
			
			
			stmt.setTimestamp(i++, lastChanged);
			
			
			if (DaoFormatter.boxNumber(recordInfo.lastChangedBy) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.lastChangedBy);
			}
			
			
			stmt.setString(i++, recordInfo.idPayPartnerStore);
			
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<PayordInfo> getNewInstance() {
		return new PayordInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
