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
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class PersonInsertSingle extends DaoStmtTemplate<PersonInfo> {	
	private final String LT_MAIN = DaoDbTable.PERSON_TABLE;
	
	
	public PersonInsertSingle(Connection conn, PersonInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return LT_MAIN;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<PersonInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<PersonInfo>() {	
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
				stmt.setString(i++, recordInfo.nameSearch);
				
				return stmt;
			}		
		};
	}	
	
	
	
	@Override protected DaoResultParserV2<PersonInfo> getResultParserHook() {
		return new DaoResultParserV2<PersonInfo>() {	
			@Override public List<PersonInfo> parseResult(PersonInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PersonInfo> finalResult = new ArrayList<>();
				recordInfo.codPerson = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
