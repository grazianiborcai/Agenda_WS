package br.com.gda.business.personUser.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoJoin;
import br.com.gda.dao.DaoJoinColumn;
import br.com.gda.dao.DaoJoinType;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class PersonUserSelectSingle implements DaoStmt<PersonUserInfo> {
	private final String LT_PERSON = DaoDbTable.PERSON_TABLE;
	private final String RT_USER = DaoDbTable.USER_TABLE;
	
	private DaoStmt<PersonUserInfo> stmtSql;
	private DaoStmtOption<PersonUserInfo> stmtOption;
	
	
	
	public PersonUserSelectSingle(Connection conn, PersonUserInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, PersonUserInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_PERSON;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.PERSON_USER_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		final boolean DUMMY_CLAUSE_NOT_ALLOWED = false;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DUMMY_CLAUSE_NOT_ALLOWED;
		
		DaoStmtWhere whereClause = new PersonUserWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();		
		joins.add(buildJoinPersonUser());
		return joins;
	}
	
	
	
	private DaoJoin buildJoinPersonUser() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_PERSON;
		oneColumn.leftColumnName = PersonUserDbTableColumn.COL_COD_OWNER;
		oneColumn.rightColumnName = PersonUserDbTableColumn.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_PERSON;
		oneColumn.leftColumnName = PersonUserDbTableColumn.COL_COD_PERSON;
		oneColumn.rightColumnName = PersonUserDbTableColumn.COL_COD_PERSON;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_USER;
		join.joinType = DaoJoinType.INNER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
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

	
	
	@Override public List<PersonUserInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<PersonUserInfo> getNewInstance() {
		return new PersonUserSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements DaoResultParser<PersonUserInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final String COD_ENTITY_CATEG_COL = LT_PERSON + "." + PersonUserDbTableColumn.COL_COD_ENTITY_CATEG;
		private final String COD_OWNER_COL = LT_PERSON + "." + PersonUserDbTableColumn.COL_COD_OWNER;
		private final String COD_PERSON_COL = LT_PERSON + "." + PersonUserDbTableColumn.COL_COD_PERSON;
		private final String CPF_COL = LT_PERSON + "." + PersonUserDbTableColumn.COL_CPF;
		private final String EMAIL_COL = LT_PERSON + "." + PersonUserDbTableColumn.COL_EMAIL;
		private final String COD_USER_COL = RT_USER + "." + PersonUserDbTableColumn.COL_COD_USER;
		private final String RECORD_MODE_COL = LT_PERSON + "." + PersonUserDbTableColumn.COL_RECORD_MODE;
		
		
		@Override public List<PersonUserInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PersonUserInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
				return finalResult;
		
			do {				
				PersonUserInfo dataInfo = new PersonUserInfo();
				dataInfo.codEntityCateg = stmtResult.getString(COD_ENTITY_CATEG_COL);
				dataInfo.codOwner = stmtResult.getLong(COD_OWNER_COL);
				dataInfo.codUser = stmtResult.getLong(COD_USER_COL);
				dataInfo.codPerson = stmtResult.getLong(COD_PERSON_COL);
				dataInfo.cpf = stmtResult.getString(CPF_COL);
				dataInfo.email = stmtResult.getString(EMAIL_COL);
				dataInfo.recordMode = stmtResult.getString(RECORD_MODE_COL);
				
				finalResult.add(dataInfo);				
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
