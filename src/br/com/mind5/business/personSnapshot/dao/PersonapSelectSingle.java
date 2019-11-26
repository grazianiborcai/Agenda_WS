package br.com.mind5.business.personSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.dao.obsolete.DaoResultParser_;
import br.com.mind5.dao.obsolete.DaoStmtOption_;

public final class PersonapSelectSingle implements DaoStmt<PersonapInfo> {
	private final String LT_PERSON = DaoDbTable.PERSON_SNAPSHOT_TABLE;
	
	private DaoStmt<PersonapInfo> stmtSql;
	private DaoStmtOption_<PersonapInfo> stmtOption;
	
	
	
	public PersonapSelectSingle(Connection conn, PersonapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, PersonapInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
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
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PersonapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper_<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<PersonapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<PersonapInfo> getNewInstance() {
		return new PersonapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<PersonapInfo> {		
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<PersonapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PersonapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
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
	}
}
