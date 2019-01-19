package br.com.gda.payService.payCustomer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;

import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

public final class PaycusUpdateSingle implements DaoStmt<PaycusInfo> {
	private DaoStmt<PaycusInfo> stmtSql;
	private DaoStmtOption<PaycusInfo> stmtOption;
	
	
	public PaycusUpdateSingle(Connection conn, PaycusInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, PaycusInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.PAY_CUS_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = null;
		this.stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		final boolean DONT_IGNORE_NULL = false;
		final boolean IGNORE_NON_PK = true;
		final boolean IGNORE_RECORD_MODE = true;		
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new PaycusWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<PaycusInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<PaycusInfo> getNewInstance() {
		return new PaycusUpdateSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<PaycusInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PaycusInfo recordInfo) throws SQLException {	
			
			Timestamp lastChanged = null;
			if(recordInfo.lastChanged != null)
				lastChanged = Timestamp.valueOf((recordInfo.lastChanged));
			
			int i = 1;
			stmt.setString(i++, recordInfo.recordMode);			
			stmt.setTimestamp(i++, lastChanged);
			
			
			if (recordInfo.codPerson >= 0) {
				stmt.setLong(i++, recordInfo.codPerson);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			if (recordInfo.codUser >= 0) {
				stmt.setLong(i++, recordInfo.codUser);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			stmt.setString(i++, recordInfo.codPayCustomerExt);
			
			
			if (recordInfo.codPayPartner >= 0) {
				stmt.setInt(i++, recordInfo.codPayPartner);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			if (recordInfo.codPersonRef >= 0) {
				stmt.setLong(i++, recordInfo.codPersonRef);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			if (recordInfo.codPhoneRef >= 0) {
				stmt.setLong(i++, recordInfo.codPhoneRef);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			if (recordInfo.codAddressRef >= 0) {
				stmt.setLong(i++, recordInfo.codAddressRef);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			return stmt;
		}		
	}
}
