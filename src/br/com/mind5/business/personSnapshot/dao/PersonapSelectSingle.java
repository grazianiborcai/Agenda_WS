package br.com.mind5.business.personSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PersonapSelectSingle extends DaoStmtTemplate<PersonapInfo> {
	private final String MAIN_TABLE = DaoDbTable.PERSON_SNAPSHOT_TABLE;
	
	
	public PersonapSelectSingle(Connection conn, PersonapInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new PersonapWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<PersonapInfo> getResultParserHook() {
		return new DaoResultParserV2<PersonapInfo>() {	
			@Override public List<PersonapInfo> parseResult(PersonapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PersonapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PersonapInfo dataInfo = new PersonapInfo();
					dataInfo.codOwner = stmtResult.getLong(PersonapDbTableColumn.COL_COD_OWNER);
					dataInfo.codSnapshot = stmtResult.getLong(PersonapDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codPerson = stmtResult.getLong(PersonapDbTableColumn.COL_COD_PERSON);
					dataInfo.cpf = stmtResult.getString(PersonapDbTableColumn.COL_CPF);
					dataInfo.name = stmtResult.getString(PersonapDbTableColumn.COL_NAME);	
					dataInfo.nameSearch = stmtResult.getString(PersonapDbTableColumn.COL_NAME_SEARCH);
					dataInfo.email = stmtResult.getString(PersonapDbTableColumn.COL_EMAIL);						
					dataInfo.recordMode = stmtResult.getString(PersonapDbTableColumn.COL_RECORD_MODE);
					dataInfo.codEntityCateg = stmtResult.getString(PersonapDbTableColumn.COL_COD_ENTITY_CATEG);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, PersonapDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, PersonapDbTableColumn.COL_CREATED_BY);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, PersonapDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.codGender = DaoFormatter.sqlToInt(stmtResult, PersonapDbTableColumn.COL_COD_GENDER);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, PersonapDbTableColumn.COL_LAST_CHANGED);
					dataInfo.birthDate = DaoFormatter.sqlToLocalDate(stmtResult, PersonapDbTableColumn.COL_COD_BIRTH_DATE);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
