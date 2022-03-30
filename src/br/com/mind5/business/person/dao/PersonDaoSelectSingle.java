package br.com.mind5.business.person.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PersonDaoSelectSingle extends DaoStmtTemplate<PersonInfo> {
	private final String MAIN_TABLE = DaoDbTable.PERSON_TABLE;
	
	
	public PersonDaoSelectSingle(Connection conn, PersonInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PersonInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PersonDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<PersonInfo> getResultParserHook() {
		return new DaoResultParser<PersonInfo>() {		
			@Override public List<PersonInfo> parseResult(PersonInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PersonInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PersonInfo dataInfo = new PersonInfo();
					
					dataInfo.codOwner = stmtResult.getLong(PersonDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codPerson = stmtResult.getLong(PersonDaoDbTableColumn.COL_COD_PERSON);
					dataInfo.codStore = stmtResult.getLong(PersonDaoDbTableColumn.COL_COD_STORE);
					dataInfo.cpf = stmtResult.getString(PersonDaoDbTableColumn.COL_CPF);
					dataInfo.name = stmtResult.getString(PersonDaoDbTableColumn.COL_NAME);			
					dataInfo.nameDisplay = stmtResult.getString(PersonDaoDbTableColumn.COL_NAME_DISPLAY);
					dataInfo.nameSearch = stmtResult.getString(PersonDaoDbTableColumn.COL_NAME_SEARCH);	
					dataInfo.email = stmtResult.getString(PersonDaoDbTableColumn.COL_EMAIL);						
					dataInfo.recordMode = stmtResult.getString(PersonDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codEntityCateg = stmtResult.getString(PersonDaoDbTableColumn.COL_COD_ENTITY_CATEG);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, PersonDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codGender = DaoFormatter.sqlToInt(stmtResult, PersonDaoDbTableColumn.COL_COD_GENDER);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, PersonDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToInt(stmtResult, PersonDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.birthDate = DaoFormatter.sqlToLocalDate(stmtResult, PersonDaoDbTableColumn.COL_BIRTH_DATE);
					dataInfo.birthYear = DaoFormatter.sqlToInt(stmtResult, PersonDaoDbTableColumn.COL_BIRTH_YEAR);
					dataInfo.birthMonth = DaoFormatter.sqlToInt(stmtResult, PersonDaoDbTableColumn.COL_BIRTH_MONTH);
					dataInfo.birthDay = DaoFormatter.sqlToInt(stmtResult, PersonDaoDbTableColumn.COL_BIRTH_DAY);					
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, PersonDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, PersonDaoDbTableColumn.COL_CREATED_BY);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
