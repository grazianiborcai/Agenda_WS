package br.com.mind5.business.phoneSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

public final class PhonapInsertSingle implements DaoStmt<PhonapInfo> {
	private DaoStmt<PhonapInfo> stmtSql;
	private DaoStmtOption<PhonapInfo> stmtOption;
	
	
	
	public PhonapInsertSingle(Connection conn, PhonapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, PhonapInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.PHONE_SNAPSHOT_TABLE;
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

	
	
	@Override public List<PhonapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<PhonapInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PhonapInfo recordInfo) throws SQLException {
			
			int i = 1;
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwner);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPhone);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployee);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCountryPhone);
			stmt.setString(i++, recordInfo.fullNumber);
			stmt.setString(i++, recordInfo.recordMode);
			DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
			stmt.setString(i++, recordInfo.complement);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwnerRef);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomerSnapshot);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployeeSnapshot);	
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStoreSnapshot);	
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUserSnapshot);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwnerRefSnapshot);
			stmt.setString(i++, recordInfo.number);
			stmt.setString(i++, recordInfo.codArea);
			DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);	
			DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);				

			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<PhonapInfo> getNewInstance() {
		return new PhonapInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<PhonapInfo> {
		private PhonapInfo recordInfo;
		
		public ResultParser(PhonapInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<PhonapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PhonapInfo> finalResult = new ArrayList<>();
			recordInfo.codSnapshot = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
