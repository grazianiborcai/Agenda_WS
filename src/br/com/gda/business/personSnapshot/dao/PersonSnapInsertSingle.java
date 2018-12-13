package br.com.gda.business.personSnapshot.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;

public final class PersonSnapInsertSingle implements DaoStmt<PersonSnapInfo> {	
	private DaoStmt<PersonSnapInfo> stmtSql;
	private DaoStmtOption<PersonSnapInfo> stmtOption;
	
	
	
	public PersonSnapInsertSingle(Connection conn, PersonSnapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
		
	}
	
	
	
	private void buildStmtOption(Connection conn, PersonSnapInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
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

	
	
	@Override public List<PersonSnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<PersonSnapInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PersonSnapInfo recordInfo) throws SQLException {
			Date birthDate = DaoFormatter.localToSqlDate(recordInfo.birthDate);
			
			Timestamp lastChanged = null;
			if(recordInfo.lastChanged != null)
				lastChanged = Timestamp.valueOf((recordInfo.lastChanged));
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setLong(i++, recordInfo.codSnapshot);
			stmt.setLong(i++, recordInfo.codPerson);
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
			stmt.setString(i++, recordInfo.codEntityCateg);
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<PersonSnapInfo> getNewInstance() {
		return new PersonSnapInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<PersonSnapInfo> {
		private PersonSnapInfo recordInfo;
		
		public ResultParser(PersonSnapInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<PersonSnapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PersonSnapInfo> finalResult = new ArrayList<>();
			recordInfo.codPerson = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
