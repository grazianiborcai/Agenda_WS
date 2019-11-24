package br.com.mind5.business.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.obsolete.DaoResultParser_;
import br.com.mind5.dao.obsolete.DaoStmtOption_;

public final class PersonInsertSingle implements DaoStmt<PersonInfo> {	
	private DaoStmt<PersonInfo> stmtSql;
	private DaoStmtOption_<PersonInfo> stmtOption;
	
	
	
	public PersonInsertSingle(Connection conn, PersonInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
		
	}
	
	
	
	private void buildStmtOption(Connection conn, PersonInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.PERSON_TABLE;
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

	
	
	@Override public List<PersonInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<PersonInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PersonInfo recordInfo) throws SQLException {
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setString(i++, recordInfo.cpf);
			stmt.setString(i++, recordInfo.name);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codGender);
			stmt = DaoFormatter.localDateToStmt(stmt, i++, recordInfo.birthDate);
			stmt.setString(i++, recordInfo.email);			
			stmt.setString(i++, recordInfo.recordMode);		
			stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
			stmt.setString(i++, recordInfo.codEntityCateg);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);	
			stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);	
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<PersonInfo> getNewInstance() {
		return new PersonInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<PersonInfo> {
		private PersonInfo recordInfo;
		
		public ResultParser(PersonInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<PersonInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PersonInfo> finalResult = new ArrayList<>();
			recordInfo.codPerson = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
