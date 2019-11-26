package br.com.mind5.business.personSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.obsolete.DaoResultParser_;
import br.com.mind5.dao.obsolete.DaoStmtOption_;

public final class PersonapInsertSingle implements DaoStmt<PersonapInfo> {	
	private DaoStmt<PersonapInfo> stmtSql;
	private DaoStmtOption_<PersonapInfo> stmtOption;
	
	
	
	public PersonapInsertSingle(Connection conn, PersonapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
		
	}
	
	
	
	private void buildStmtOption(Connection conn, PersonapInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.PERSON_SNAPSHOT_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = new ResultParser(recordInfo);
		this.stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper_<>(DaoOperation.INSERT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<PersonapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<PersonapInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PersonapInfo recordInfo) throws SQLException {			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codPerson);
			stmt.setString(i++, recordInfo.cpf);
			stmt.setString(i++, recordInfo.name);			
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codGender);
			stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.birthDate);
			stmt.setString(i++, recordInfo.email);			
			stmt.setString(i++, recordInfo.recordMode);			
			stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
			stmt.setString(i++, recordInfo.codEntityCateg);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);			
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);	
			stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
			stmt.setString(i++, recordInfo.nameSearch);	
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<PersonapInfo> getNewInstance() {
		return new PersonapInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<PersonapInfo> {
		private PersonapInfo recordInfo;
		
		public ResultParser(PersonapInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<PersonapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PersonapInfo> finalResult = new ArrayList<>();
			recordInfo.codSnapshot = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}	
}
