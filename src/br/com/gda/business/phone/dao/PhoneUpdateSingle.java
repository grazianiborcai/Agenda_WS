package br.com.gda.business.phone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class PhoneUpdateSingle implements DaoStmt<PhoneInfo> {
	private DaoStmt<PhoneInfo> stmtSql;
	private DaoStmtOption<PhoneInfo> stmtOption;
	
	
	public PhoneUpdateSingle(Connection conn, PhoneInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, PhoneInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.PHONE_TABLE;
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
		
		DaoStmtWhere whereClause = new PhoneWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<PhoneInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<PhoneInfo> getNewInstance() {
		return new PhoneUpdateSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<PhoneInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PhoneInfo recordInfo) throws SQLException {
			
			Timestamp lastChanged = null;
			if(recordInfo.lastChanged != null)
				lastChanged = Timestamp.valueOf((recordInfo.lastChanged));
			
			
			int i = 1;		
			
			if (DaoFormatter.boxNumber(recordInfo.codStore) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codStore);
			}
			
			
			if (DaoFormatter.boxNumber(recordInfo.codCustomer) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codCustomer);
			}
			
			
			if (DaoFormatter.boxNumber(recordInfo.codEmployee) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codEmployee);
			}
			
			stmt.setInt(i++, recordInfo.codCountryPhone);
			stmt.setString(i++, recordInfo.fullNumber);
			stmt.setString(i++, recordInfo.recordMode);
			stmt.setTimestamp(i++, lastChanged);
			stmt.setString(i++, recordInfo.complement);
			
			
			if (DaoFormatter.boxNumber(recordInfo.codUser) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codUser);
			}	
			
			
			if (DaoFormatter.boxNumber(recordInfo.codPayCustomer) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codPayCustomer);
			}	
			
			
			return stmt;
		}		
	}
}
