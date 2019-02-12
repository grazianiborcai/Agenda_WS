package br.com.gda.business.personSnapshot.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class PersonSnapSelectSingle implements DaoStmt<PersonSnapInfo> {
	private final String LT_PERSON = DaoDbTable.PERSON_SNAPSHOT_TABLE;
	
	private DaoStmt<PersonSnapInfo> stmtSql;
	private DaoStmtOption<PersonSnapInfo> stmtOption;
	
	
	
	public PersonSnapSelectSingle(Connection conn, PersonSnapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, PersonSnapInfo recordInfo, String schemaName) {
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
		final boolean DONT_IGNORE_NULL = false;
		final boolean IGNORE_RECORD_MODE = true;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PersonSnapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<PersonSnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<PersonSnapInfo> getNewInstance() {
		return new PersonSnapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<PersonSnapInfo> {
		private final boolean NOT_NULL = false;
		
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<PersonSnapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PersonSnapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				PersonSnapInfo dataInfo = new PersonSnapInfo();
				dataInfo.codOwner = stmtResult.getLong(PersonSnapDbTableColumn.COL_COD_OWNER);
				dataInfo.codSnapshot = stmtResult.getLong(PersonSnapDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codPerson = stmtResult.getLong(PersonSnapDbTableColumn.COL_COD_PERSON);
				dataInfo.cpf = stmtResult.getString(PersonSnapDbTableColumn.COL_CPF);
				dataInfo.name = stmtResult.getString(PersonSnapDbTableColumn.COL_NAME);			
				dataInfo.email = stmtResult.getString(PersonSnapDbTableColumn.COL_EMAIL);						
				dataInfo.recordMode = stmtResult.getString(PersonSnapDbTableColumn.COL_RECORD_MODE);
				dataInfo.codEntityCateg = stmtResult.getString(PersonSnapDbTableColumn.COL_COD_ENTITY_CATEG);
				
				stmtResult.getInt(PersonSnapDbTableColumn.COL_COD_GENDER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codGender = stmtResult.getInt(PersonSnapDbTableColumn.COL_COD_GENDER);
				
				Timestamp lastChanged = stmtResult.getTimestamp(PersonSnapDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();	
				
				Date tempDate = stmtResult.getDate(PersonSnapDbTableColumn.COL_COD_BIRTH_DATE);
				if (tempDate != null)
					dataInfo.birthDate = tempDate.toLocalDate();
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
