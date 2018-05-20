package br.com.gda.business.masterData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.sql.DbTable;
import br.com.gda.sql.SqlDictionary;
import br.com.gda.sql.SqlJoin;
import br.com.gda.sql.SqlJoinColumn;
import br.com.gda.sql.SqlJoinType;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlResultParser;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtHelper;
import br.com.gda.sql.SqlStmtOption;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilderOption;

public final class MatGroupSelect implements SqlStmt<MatGroupInfo> {
	private final String LT_MAT_GROUP = DbTable.MATERIAL_GROUP_TABLE;
	private final String RT_MAT_GROUP_TEXT = DbTable.MATERIAL_GROUP_TEXT_TABLE;
	private final String RT_BUSINESS_TEXT = DbTable.BUSINESS_AREA_TEXT_TABLE;
	
	private SqlStmt<MatGroupInfo> stmtSql;
	private SqlStmtOption<MatGroupInfo> stmtOption;
	
	
	
	public MatGroupSelect(Connection conn, MatGroupInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, MatGroupInfo recordInfo, String schemaName) {
		this.stmtOption = new SqlStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_MAT_GROUP;
		this.stmtOption.columns = MasterDataDbTableColumn.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		final boolean IGNORE_NULL = true;
		final boolean IGNORE_RECORD_MODE = true;
		final boolean DUMMY_CLAUSE_ALLOWED = true;
		
		SqlWhereBuilderOption whereOption = new SqlWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DUMMY_CLAUSE_ALLOWED;
		
		SqlStmtWhere whereClause = new MatGroupWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<SqlJoin> buildJoins() {
		List<SqlJoin> joins = new ArrayList<>();		
		joins.add(buildJoinUnitText());
		joins.add(buildJoinBusinessText());
		return joins;
	}
	
	
	
	private SqlJoin buildJoinUnitText() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		
		SqlJoinColumn oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LT_MAT_GROUP;
		oneColumn.leftColumnName = "Cod_group";
		oneColumn.rightColumnName = "Cod_group";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		join.rightTableName = RT_MAT_GROUP_TEXT;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RT_MAT_GROUP_TEXT);
		
		return join;
	}
	
	
	
	private SqlJoin buildJoinBusinessText() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		
		SqlJoinColumn oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LT_MAT_GROUP;
		oneColumn.leftColumnName = "Cod_business";
		oneColumn.rightColumnName = "Cod_business";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		String rightTable = RT_BUSINESS_TEXT;
		join.rightTableName = rightTable;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(rightTable);
		
		return join;
	}
	
	
	
	private String buildJoinConstraintText(String rightTableName) {
		StringBuilder constrainClause = new StringBuilder(); 
		
		constrainClause.append(rightTableName);
		constrainClause.append(SqlDictionary.PERIOD);
		constrainClause.append("Language");
		constrainClause.append(SqlDictionary.SPACE);
		constrainClause.append(SqlDictionary.EQUAL);
		constrainClause.append(SqlDictionary.SPACE);
		constrainClause.append(SqlDictionary.QUOTE);
		constrainClause.append(this.stmtOption.recordInfo.codLanguage);
		constrainClause.append(SqlDictionary.QUOTE);
		
		return constrainClause.toString();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new SqlStmtHelper<>(SqlOperation.SELECT, this.stmtOption);
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

	
	
	@Override public List<MatGroupInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public SqlStmt<MatGroupInfo> getNewInstance() {
		return new MatGroupSelect(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements SqlResultParser<MatGroupInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final String GROUP_TEXT_COL = DbTable.MATERIAL_GROUP_TEXT_TABLE + "." + "Name";
		private final String BUSINESS_TEXT_COL = DbTable.BUSINESS_AREA_TEXT_TABLE + "." + "Name";
		private final String LANGU_COL = DbTable.MATERIAL_GROUP_TEXT_TABLE + "." + "Language";
		
		@Override public List<MatGroupInfo> parseResult(ResultSet stmtResult) throws SQLException {
			List<MatGroupInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
				return finalResult;
		
			do {				
				MatGroupInfo dataInfo = new MatGroupInfo();
				dataInfo.codGroup = stmtResult.getInt("Cod_group");				
				dataInfo.txtGroup = stmtResult.getString(GROUP_TEXT_COL);
				dataInfo.codBusiness = stmtResult.getInt("Cod_business");
				dataInfo.txtBusiness = stmtResult.getString(BUSINESS_TEXT_COL);
				dataInfo.codLanguage = stmtResult.getString(LANGU_COL);		
				
				finalResult.add(dataInfo);				
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
