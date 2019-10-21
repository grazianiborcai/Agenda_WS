package br.com.mind5.payment.creditCard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardInsertSingle implements DaoStmt<CrecardInfo> {
	private DaoStmt<CrecardInfo> stmtSql;
	private DaoStmtOption<CrecardInfo> stmtOption;
	
	
	
	public CrecardInsertSingle(Connection conn, CrecardInfo recordInfo, String schemaName) {
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
		this.stmtOption.resultParser = new ResultParser(recordInfo);
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

	
	
	@Override public List<CrecardInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<CrecardInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CrecardInfo recordInfo) throws SQLException {
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codPayCustomer);
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
	
	
	
	@Override public DaoStmt<CrecardInfo> getNewInstance() {
		return new CrecardInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<CrecardInfo> {
		private CrecardInfo recordInfo;
		
		public ResultParser(CrecardInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<CrecardInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<CrecardInfo> finalResult = new ArrayList<>();
			recordInfo.codCreditCard = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}	
}
