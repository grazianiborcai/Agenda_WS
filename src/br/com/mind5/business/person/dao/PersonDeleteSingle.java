package br.com.mind5.business.person.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PersonDeleteSingle extends DaoStmtTemplate<PersonInfo> {
	private final String MAIN_TABLE = DaoDbTable.PERSON_TABLE;
	
	
	public PersonDeleteSingle(Connection conn, PersonInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PersonInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new PersonWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<PersonInfo> getResultParserHook() {
		return new DaoResultParserV2<PersonInfo>() {
			@Override public List<PersonInfo> parseResult(PersonInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PersonInfo> finalResult = new ArrayList<>();
				PersonInfo emptyInfo = new PersonInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
