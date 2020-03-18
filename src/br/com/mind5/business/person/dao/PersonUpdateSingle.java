package br.com.mind5.business.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PersonUpdateSingle extends DaoStmtTemplate<PersonInfo> {
	private final String MAIN_TABLE = DaoDbTable.PERSON_TABLE;
	
	
	public PersonUpdateSingle(Connection conn, PersonInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PersonInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new PersonWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<PersonInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<PersonInfo>() {	
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, PersonInfo recordInfo) throws SQLException {	
				
				int i = 1;
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
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.birthYear);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.birthMonth);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.birthDay);
				stmt.setString(i++, recordInfo.nameDisplay);
				
				return stmt;
			}		
		};
	}
}
