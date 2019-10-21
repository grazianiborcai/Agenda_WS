package br.com.mind5.payment.creditCard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardUpdateSingle implements DaoStmt<CrecardInfo> {
	private DaoStmt<CrecardInfo> stmtSql;
	private DaoStmtOption<CrecardInfo> stmtOption;
	
	
	public CrecardUpdateSingle(Connection conn, CrecardInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, CrecardInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.CREDIT_CARD_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = null;
		this.stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new CrecardWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<CrecardInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<CrecardInfo> getNewInstance() {
		return new CrecardUpdateSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<CrecardInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CrecardInfo recordInfo) throws SQLException {
			
			int i = 1;
			stmt.setString(i++, recordInfo.creditCardId);
			stmt.setString(i++, recordInfo.creditCardBrand);
			stmt.setString(i++, recordInfo.creditCardLast4);
			stmt.setString(i++, recordInfo.recordMode);
			stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codAddressHolder);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codAddressSnapshotHolder);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPhoneHolder);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPhoneSnapshotHolder);		
			
			return stmt;
		}		
	}
}
