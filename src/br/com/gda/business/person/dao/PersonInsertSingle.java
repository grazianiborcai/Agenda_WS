package br.com.gda.business.person.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;

public final class PersonInsertSingle implements DaoStmt<PersonInfo> {	
	private DaoStmt<PersonInfo> stmtSql;
	private DaoStmtOption<PersonInfo> stmtOption;
	
	
	
	public PersonInsertSingle(Connection conn, PersonInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
		
	}
	
	
	
	private void buildStmtOption(Connection conn, PersonInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
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

	
	
	@Override public List<PersonInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<PersonInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PersonInfo recordInfo) throws SQLException {
			Date birthDate = DaoFormatter.localToSqlDate(recordInfo.birthDate);
			
			Timestamp lastChanged = null;
			if(recordInfo.lastChanged != null)
				lastChanged = Timestamp.valueOf((recordInfo.lastChanged));
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setString(i++, recordInfo.cpf);
			stmt.setString(i++, recordInfo.name);
			
			if (DaoFormatter.boxNumber(recordInfo.codGender) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setInt(i++, recordInfo.codGender);
			}
			
			stmt.setDate(i++, birthDate);
			stmt.setString(i++, recordInfo.email);			
			stmt.setString(i++, recordInfo.recordMode);
			
			stmt.setTimestamp(i++, lastChanged);
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<PersonInfo> getNewInstance() {
		return new PersonInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<PersonInfo> {
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
