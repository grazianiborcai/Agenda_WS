package br.com.gda.business.personCustomer.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personCustomer.info.PersonCusInfo;
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
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class PersonCusSelectSingle implements DaoStmt<PersonCusInfo> {
	private final String LT_PERSON = DaoDbTable.PERSON_TABLE;
	private final String RT_CUS = DaoDbTable.CUS_TABLE;
	
	private DaoStmt<PersonCusInfo> stmtSql;
	private DaoStmtOption<PersonCusInfo> stmtOption;
	
	
	
	public PersonCusSelectSingle(Connection conn, PersonCusInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, PersonCusInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_PERSON;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.PERSON_CUS_VIEW);
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
		
		DaoStmtWhere whereClause = new PersonCusWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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
		oneColumn.leftColumnName = PersonCusDbTableColumn.COL_COD_OWNER;
		oneColumn.rightColumnName = PersonCusDbTableColumn.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_PERSON;
		oneColumn.leftColumnName = PersonCusDbTableColumn.COL_COD_PERSON;
		oneColumn.rightColumnName = PersonCusDbTableColumn.COL_COD_PERSON;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_CUS;
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

	
	
	@Override public List<PersonCusInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<PersonCusInfo> getNewInstance() {
		return new PersonCusSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements DaoResultParser<PersonCusInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final String COD_ENTITY_CATEG_COL = LT_PERSON + "." + PersonCusDbTableColumn.COL_COD_ENTITY_CATEG;
		private final String COD_OWNER_COL = LT_PERSON + "." + PersonCusDbTableColumn.COL_COD_OWNER;
		private final String COD_PERSON_COL = LT_PERSON + "." + PersonCusDbTableColumn.COL_COD_PERSON;
		private final String CPF_COL = LT_PERSON + "." + PersonCusDbTableColumn.COL_CPF;
		private final String EMAIL_COL = LT_PERSON + "." + PersonCusDbTableColumn.COL_EMAIL;
		private final String COD_CUSTOMER_COL = RT_CUS + "." + PersonCusDbTableColumn.COL_COD_CUSTOMER;
		private final String RECORD_MODE_COL = LT_PERSON + "." + PersonCusDbTableColumn.COL_RECORD_MODE;
		
		
		@Override public List<PersonCusInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PersonCusInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
		
			do {				
				PersonCusInfo dataInfo = new PersonCusInfo();
				dataInfo.codEntityCateg = stmtResult.getString(COD_ENTITY_CATEG_COL);
				dataInfo.codOwner = stmtResult.getLong(COD_OWNER_COL);
				dataInfo.codCustomer = stmtResult.getLong(COD_CUSTOMER_COL);
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
