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
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PersonSelectSingle implements DaoStmt<PersonInfo> {
	private final String LT_PERSON = DaoDbTable.PERSON_TABLE;
	
	private DaoStmt<PersonInfo> stmtSql;
	private DaoStmtOption<PersonInfo> stmtOption;
	
	
	
	public PersonSelectSingle(Connection conn, PersonInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, PersonInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_PERSON;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_PERSON);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PersonWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
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
	
	
	
	@Override public DaoStmt<PersonInfo> getNewInstance() {
		return new PersonSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<PersonInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<PersonInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PersonInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				PersonInfo dataInfo = new PersonInfo();
				dataInfo.codOwner = stmtResult.getLong(PersonDbTableColumn.COL_COD_OWNER);
				dataInfo.codPerson = stmtResult.getLong(PersonDbTableColumn.COL_COD_PERSON);
				dataInfo.cpf = stmtResult.getString(PersonDbTableColumn.COL_CPF);
				dataInfo.name = stmtResult.getString(PersonDbTableColumn.COL_NAME);			
				dataInfo.email = stmtResult.getString(PersonDbTableColumn.COL_EMAIL);						
				dataInfo.recordMode = stmtResult.getString(PersonDbTableColumn.COL_RECORD_MODE);
				dataInfo.codEntityCateg = stmtResult.getString(PersonDbTableColumn.COL_COD_ENTITY_CATEG);
				dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, PersonDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codGender = DaoFormatter.sqlToInt(stmtResult, PersonDbTableColumn.COL_COD_GENDER);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, PersonDbTableColumn.COL_LAST_CHANGED);
				dataInfo.lastChangedBy = DaoFormatter.sqlToInt(stmtResult, PersonDbTableColumn.COL_LAST_CHANGED_BY);
				dataInfo.birthDate = DaoFormatter.sqlToLocalDate(stmtResult, PersonDbTableColumn.COL_BIRTH_DATE);
				dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, PersonDbTableColumn.COL_CREATED_ON);
				dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, PersonDbTableColumn.COL_CREATED_BY);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
