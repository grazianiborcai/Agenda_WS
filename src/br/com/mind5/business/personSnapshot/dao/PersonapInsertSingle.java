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
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;

public final class PersonapInsertSingle extends DaoStmtTemplate<PersonapInfo> {	
	private final String MAIN_TABLE = DaoDbTable.PERSON_SNAPSHOT_TABLE;
	
	
	public PersonapInsertSingle(Connection conn, PersonapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<PersonapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<PersonapInfo>() {	
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
		};
	}
	
	
	
	@Override protected DaoResultParserV2<PersonapInfo> getResultParserHook() {
		return new DaoResultParserV2<PersonapInfo>() {	
			@Override public List<PersonapInfo> parseResult(PersonapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PersonapInfo> finalResult = new ArrayList<>();
				recordInfo.codSnapshot = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
