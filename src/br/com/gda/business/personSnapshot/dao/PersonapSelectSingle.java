package br.com.gda.business.personSnapshot.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class PersonapSelectSingle implements DaoStmt<PersonapInfo> {
	private final String LT_PERSON = DaoDbTable.PERSON_SNAPSHOT_TABLE;
	
	private DaoStmt<PersonapInfo> stmtSql;
	private DaoStmtOption<PersonapInfo> stmtOption;
	
	
	
	public PersonapSelectSingle(Connection conn, PersonapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, PersonapInfo recordInfo, String schemaName) {
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
		whereOption.ignoreNull = DaoWhereBuilderOption.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PersonapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption);
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
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<PersonapInfo> {
		private final boolean NOT_NULL = false;
		
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
				dataInfo.email = stmtResult.getString(PersonapDbTableColumn.COL_EMAIL);						
				dataInfo.recordMode = stmtResult.getString(PersonapDbTableColumn.COL_RECORD_MODE);
				dataInfo.codEntityCateg = stmtResult.getString(PersonapDbTableColumn.COL_COD_ENTITY_CATEG);
				
				stmtResult.getLong(PersonapDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getInt(PersonapDbTableColumn.COL_LAST_CHANGED_BY);
				
				stmtResult.getInt(PersonapDbTableColumn.COL_COD_GENDER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codGender = stmtResult.getInt(PersonapDbTableColumn.COL_COD_GENDER);
				
				Timestamp lastChanged = stmtResult.getTimestamp(PersonapDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();	
				
				Date tempDate = stmtResult.getDate(PersonapDbTableColumn.COL_COD_BIRTH_DATE);
				if (tempDate != null)
					dataInfo.birthDate = tempDate.toLocalDate();
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
