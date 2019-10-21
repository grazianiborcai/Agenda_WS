package br.com.mind5.payment.storePartner.dao;

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
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class StoparInsertSingle implements DaoStmt<StoparInfo> {
	private DaoStmt<StoparInfo> stmtSql;
	private DaoStmtOption<StoparInfo> stmtOption;
	
	
	
	public StoparInsertSingle(Connection conn, StoparInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, StoparInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.PAY_PARTNER_STORE_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = null;
		this.stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.INSERT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<StoparInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<StoparInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StoparInfo recordInfo) throws SQLException {
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPayPartner);
			stmt.setString(i++, recordInfo.recordMode);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
			stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
			stmt.setString(i++, recordInfo.codePayPartnerStore);
			stmt.setString(i++, recordInfo.idPayPartnerStore);			
			stmt.setString(i++, recordInfo.accessToken);
			stmt.setString(i++, recordInfo.refreshToken);
			stmt.setString(i++, recordInfo.scope);
			stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.tokenExpiresIn);
			
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<StoparInfo> getNewInstance() {
		return new StoparInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
}
