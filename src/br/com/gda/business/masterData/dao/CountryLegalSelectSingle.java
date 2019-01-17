package br.com.gda.business.masterData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.CountryLegalInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoDictionary;
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

public final class CountryLegalSelectSingle implements DaoStmt<CountryLegalInfo> {
	private final String LT_ATTR = DaoDbTable.COUNTRY_LEGAL_TABLE;
	private final String RT_TEXT = DaoDbTable.COUNTRY_TEXT_TABLE;
	
	private DaoStmt<CountryLegalInfo> stmtSql;
	private DaoStmtOption<CountryLegalInfo> stmtOption;
	
	
	
	public CountryLegalSelectSingle(Connection conn, CountryLegalInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, CountryLegalInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_ATTR;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();		
		joins.add(buildJoinText());
		return joins;
	}
	
	
	
	private DaoJoin buildJoinText() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_ATTR;
		oneColumn.leftColumnName = MasterDataDbTableColumn.COL_COD_COUNTRY;
		oneColumn.rightColumnName = MasterDataDbTableColumn.COL_COD_COUNTRY;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_TEXT;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RT_TEXT);
		
		return join;
	}
	
	
	//TODO: Mover para a super classe 
	private String buildJoinConstraintText(String rightTableName) {
		StringBuilder constrainClause = new StringBuilder(); 
		
		constrainClause.append(rightTableName);
		constrainClause.append(DaoDictionary.PERIOD);
		constrainClause.append(MasterDataDbTableColumn.COL_COD_LANGUAGE);
		constrainClause.append(DaoDictionary.SPACE);
		constrainClause.append(DaoDictionary.EQUAL);
		constrainClause.append(DaoDictionary.SPACE);
		constrainClause.append(DaoDictionary.QUOTE);
		constrainClause.append(this.stmtOption.recordInfo.codLanguage);
		constrainClause.append(DaoDictionary.QUOTE);
		
		return constrainClause.toString();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoWhereBuilderOption.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new CountryLegalWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<CountryLegalInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<CountryLegalInfo> getNewInstance() {
		return new CountryLegalSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements DaoResultParser<CountryLegalInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final String LANGU_COL = RT_TEXT + "." + MasterDataDbTableColumn.COL_COD_LANGUAGE;
		private final String TEXT_COL = RT_TEXT + "." + MasterDataDbTableColumn.COL_NAME;
		
		@Override public List<CountryLegalInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<CountryLegalInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
				return finalResult;
		
			do {				
				CountryLegalInfo dataInfo = new CountryLegalInfo();
				dataInfo.codCountry = stmtResult.getString(MasterDataDbTableColumn.COL_COD_COUNTRY);
				dataInfo.recordMode = stmtResult.getString(MasterDataDbTableColumn.COL_RECORD_MODE);
				dataInfo.txtCountry = stmtResult.getString(TEXT_COL);
				dataInfo.codLanguage = stmtResult.getString(LANGU_COL);	
				
				
				finalResult.add(dataInfo);				
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
