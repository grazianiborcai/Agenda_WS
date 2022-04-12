package br.com.mind5.business.personSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PersonapDaoSelectSingle extends DaoStmtTemplate<PersonapInfo> {
	private final String MAIN_TABLE = DaoDbTable.PERSON_SNAPSHOT_TABLE;
	
	
	public PersonapDaoSelectSingle(Connection conn, PersonapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PersonapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PersonapDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<PersonapInfo> getResultParserHook() {
		return new DaoResultParser<PersonapInfo>() {	
			@Override public List<PersonapInfo> parseResult(PersonapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PersonapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PersonapInfo dataInfo = new PersonapInfo();
					
					dataInfo.codOwner = stmtResult.getLong(PersonapDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codSnapshot = stmtResult.getLong(PersonapDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codPerson = stmtResult.getLong(PersonapDaoDbTableColumn.COL_COD_PERSON);
					dataInfo.codStore = stmtResult.getLong(PersonapDaoDbTableColumn.COL_COD_STORE);
					dataInfo.cpf = stmtResult.getString(PersonapDaoDbTableColumn.COL_CPF);
					dataInfo.name = stmtResult.getString(PersonapDaoDbTableColumn.COL_NAME);	
					dataInfo.nameSearch = stmtResult.getString(PersonapDaoDbTableColumn.COL_NAME_SEARCH);
					dataInfo.email = stmtResult.getString(PersonapDaoDbTableColumn.COL_EMAIL);						
					dataInfo.recordMode = stmtResult.getString(PersonapDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codEntityCateg = stmtResult.getString(PersonapDaoDbTableColumn.COL_COD_ENTITY_CATEG);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, PersonapDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, PersonapDaoDbTableColumn.COL_CREATED_BY);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, PersonapDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.codGender = DaoFormatter.sqlToInt(stmtResult, PersonapDaoDbTableColumn.COL_COD_GENDER);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, PersonapDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.birthDate = DaoFormatter.sqlToLocalDate(stmtResult, PersonapDaoDbTableColumn.COL_COD_BIRTH_DATE);
					dataInfo.birthYear = DaoFormatter.sqlToInt(stmtResult, PersonapDaoDbTableColumn.COL_BIRTH_YEAR);
					dataInfo.birthMonth = DaoFormatter.sqlToInt(stmtResult, PersonapDaoDbTableColumn.COL_BIRTH_MONTH);
					dataInfo.birthDay = DaoFormatter.sqlToInt(stmtResult, PersonapDaoDbTableColumn.COL_BIRTH_DAY);	
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
