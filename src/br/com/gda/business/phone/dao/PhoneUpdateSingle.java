package br.com.gda.business.phone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
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
import br.com.gda.dao.common.DaoOptionValue;

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
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new PhoneWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.UPDATE, this.stmtOption, this.getClass());
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
			
			int i = 1;					
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployee);
			stmt.setInt(i++, recordInfo.codCountryPhone);
			stmt.setString(i++, recordInfo.fullNumber);
			stmt.setString(i++, recordInfo.recordMode);
			stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
			stmt.setString(i++, recordInfo.complement);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwnerRef);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
			stmt.setString(i++, recordInfo.number);
			stmt.setString(i++, recordInfo.codArea);					
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);	
			DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);	
			
			return stmt;
		}		
	}
}
